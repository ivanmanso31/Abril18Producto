package com.softtek.Abril18Producto.repo;

import com.softtek.Abril18Producto.modelo.Producto;

import java.sql.SQLException;
import java.util.List;

public interface IProductoRepo {

    List<Producto> obtenerTodos() throws  ClassNotFoundException, SQLException;
    Producto obtenerUno(int id) throws  ClassNotFoundException, SQLException;
    Producto insertar(Producto p) throws  ClassNotFoundException, SQLException;
    Producto modificar(Producto p) throws  ClassNotFoundException, SQLException;
    void borrar(int id) throws  ClassNotFoundException, SQLException;
}
