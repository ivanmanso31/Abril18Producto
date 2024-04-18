package com.softtek.Abril18Producto.servicio;

import com.softtek.Abril18Producto.modelo.Producto;

import java.sql.SQLException;
import java.util.List;

public interface IProductoServicio {

    List<Producto> obtenerTodos() throws SQLException, ClassNotFoundException;
    Producto obtenerUno(int id) throws SQLException, ClassNotFoundException;
    Producto insertar(Producto p) throws SQLException, ClassNotFoundException;
    Producto modificar(Producto p) throws SQLException, ClassNotFoundException;
    void borrar(int id) throws SQLException, ClassNotFoundException;
}
