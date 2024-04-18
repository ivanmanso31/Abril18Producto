package com.softtek.Abril18Producto.repo;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class Conexion {
    protected Connection miConexion;

    public void abrirConexion() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        miConexion = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/northwind",
                "postgres","123456");
        System.out.println("Conexion exitosa");
    }
}
