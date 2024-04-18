package com.softtek.Abril18Producto.servicio;

import com.softtek.Abril18Producto.modelo.Producto;
import com.softtek.Abril18Producto.repo.IProductoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ProductoServicio implements IProductoServicio{
    @Autowired
    private IProductoRepo repo;
    @Override
    public List<Producto> obtenerTodos() throws SQLException, ClassNotFoundException {
        return repo.obtenerTodos();
    }

    @Override
    public Producto obtenerUno(int id) throws SQLException, ClassNotFoundException {
        return repo.obtenerUno(id);
    }

    @Override
    public Producto insertar(Producto p) throws SQLException, ClassNotFoundException {
        return repo.insertar(p);
    }

    @Override
    public Producto modificar(Producto p) throws SQLException, ClassNotFoundException {
        return repo.modificar(p);
    }

    @Override
    public void borrar(int id) throws SQLException, ClassNotFoundException {
        repo.borrar(id);
    }
}
