package com.softtek.Abril18Producto.controlador;

import com.softtek.Abril18Producto.modelo.Producto;
import com.softtek.Abril18Producto.servicio.IProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/productos")
public class ControladorProducto {
    @Autowired
    private IProductoServicio servicio;

    @GetMapping
    public List<Producto> obternerTodos() throws SQLException, ClassNotFoundException {
        return servicio.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Producto obternerUno(@PathVariable int id) throws SQLException, ClassNotFoundException {
        return servicio.obtenerUno(id);
    }

    @PostMapping
    public Producto insertar(@RequestBody Producto p) throws SQLException, ClassNotFoundException {
        return servicio.insertar(p);
    }

    @PutMapping
    public Producto modificar(@RequestBody Producto p) throws SQLException, ClassNotFoundException {
        return servicio.modificar(p);
    }
    @DeleteMapping("/{id}")
    public void borrar(@PathVariable int id) throws SQLException, ClassNotFoundException {
        servicio.borrar(id);
    }
}
