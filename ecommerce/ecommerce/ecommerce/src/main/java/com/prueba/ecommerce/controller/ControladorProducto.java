package com.prueba.ecommerce.controller;

import com.prueba.ecommerce.modelo.Producto;
import com.prueba.ecommerce.servicio.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos") // Define la base URL para este controlador
public class ControladorProducto {

    private final ProductoServicio productoServicio;

    @Autowired // Inyección de dependencia
    public ControladorProducto(ProductoServicio productoServicio) {
        this.productoServicio = productoServicio;
    }

    @PostMapping // Para agregar un producto
    public ResponseEntity<Void> addProducto(@RequestBody Producto producto) {
        productoServicio.addProducto(producto);
        return ResponseEntity.ok().build(); // Devuelve 200 OK
    }

    @GetMapping("/{id}") // Para obtener un producto por ID
    public ResponseEntity<Producto> getProducto(@PathVariable int id) {
        Producto producto = productoServicio.getProducto(id);
        if (producto != null) {
            return ResponseEntity.ok(producto); // Devuelve el producto encontrado
        } else {
            return ResponseEntity.notFound().build(); // Devuelve 404 Not Found si no se encuentra
        }
    }

    @PutMapping // Para actualizar un producto
    public ResponseEntity<Void> updateProducto(@RequestBody Producto producto) {
        productoServicio.updateProducto(producto);
        return ResponseEntity.ok().build(); // Devuelve 200 OK
    }

    @DeleteMapping("/{id}") // Para eliminar un producto por ID
    public ResponseEntity<Void> deleteProducto(@PathVariable int id) {
        productoServicio.deleteProducto(id);
        return ResponseEntity.ok().build(); // Devuelve 200 OK
    }

    @GetMapping // Para obtener todos los productos
    public ResponseEntity<List<Producto>> getAllProducts() {
        List<Producto> productos = productoServicio.getAllProducts();
        return ResponseEntity.ok(productos); // Devuelve la lista de productos
    }
}
