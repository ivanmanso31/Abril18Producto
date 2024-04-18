package com.softtek.Abril18Producto.repo;

import com.softtek.Abril18Producto.modelo.Producto;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductoRepo extends Conexion implements IProductoRepo{

    @Override
    public List<Producto> obtenerTodos() throws ClassNotFoundException, SQLException {
        PreparedStatement sentencia;
        ResultSet resultado;
        String sql = "Select product_id, product_name, unit_price, discontinued from products;";
        List<Producto> productos = new ArrayList<>();
        abrirConexion();
        sentencia = miConexion.prepareStatement(sql);
        resultado = sentencia.executeQuery();
        while (resultado.next()){
            productos.add(
                    new Producto(
                            resultado.getInt("product_id"),
                            resultado.getString("product_name"),
                            resultado.getDouble("unit_price"),
                            resultado.getInt("discontinued")
                    )
            );
        }
        return productos;
    }

    @Override
    public Producto obtenerUno(int id) throws ClassNotFoundException, SQLException {
        PreparedStatement sentencia;
        ResultSet resultado;
        String sql = "Select product_id, product_name, unit_price, discontinued from products WHERE product_id = ?";
        Producto producto = null;
        abrirConexion();
        sentencia = miConexion.prepareStatement(sql);
        sentencia.setInt(1, id);
        resultado = sentencia.executeQuery();
        if (resultado.next()) {
            producto = new Producto(
                    resultado.getInt("product_id"),
                    resultado.getString("product_name"),
                    resultado.getDouble("unit_price"),
                    resultado.getInt("discontinued")
            );
        }
        return producto;
    }

    @Override
    public Producto insertar(Producto p) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO products (product_id, product_name, unit_price, discontinued)\n" +
                "\t\t\t\tVALUES (?, ?, ?, ?)";
        abrirConexion();
        PreparedStatement sentencia = miConexion.prepareStatement(sql);
        sentencia.setInt(1,p.getIdProducto());
        sentencia.setString(2,p.getNombreProducto());
        sentencia.setDouble(3,p.getPrecioUnitario());
        sentencia.setInt(4,p.getDiscontinued());
        if(sentencia.executeUpdate() >0){
            return p;
        }else{
            return null;
        }

    }

    @Override
    public Producto modificar(Producto p) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE products SET product_name = ?, unit_price = ?, discontinued = ? WHERE product_id = ?";
        abrirConexion();
        PreparedStatement sentencia = miConexion.prepareStatement(sql);
        sentencia.setString(1, p.getNombreProducto());
        sentencia.setDouble(2, p.getPrecioUnitario());
        sentencia.setInt(3, p.getDiscontinued());
        sentencia.setInt(4, p.getIdProducto());
        if(sentencia.executeUpdate() >0){
            return p;
        }else{
            return null;
        }
    }

    @Override
    public void borrar(int id) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM products WHERE product_id = ?";
        abrirConexion();
        PreparedStatement sentencia = miConexion.prepareStatement(sql);
        sentencia.setInt(1, id);
        sentencia.executeUpdate();
    }
}
