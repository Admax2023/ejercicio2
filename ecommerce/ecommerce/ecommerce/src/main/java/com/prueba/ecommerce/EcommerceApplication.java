package com.prueba.ecommerce;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.prueba.ecommerce.controller.ControladorProducto;
import com.prueba.ecommerce.modelo.Producto;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootApplication
public class EcommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcommerceApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(ControladorProducto controladorProducto) {
        return args -> {
            // Agregar productos
            controladorProducto.addProducto(new Producto(3, "Producto C", 30.0));
            controladorProducto.addProducto(new Producto(4, "Producto D", 40.0));

            // Leer un producto
            ResponseEntity<Producto> response = controladorProducto.getProducto(3);
            if (response.getStatusCode().is2xxSuccessful()) {
                Producto producto = response.getBody(); // Obtener el cuerpo del ResponseEntity
                if (producto != null) {
                    System.out.println("Producto recuperado: " + producto.getDescripcion());
                }
            } else {
                System.out.println("Producto no encontrado.");
            }

            // Actualizar un producto
            if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                Producto producto = response.getBody();
                producto.setPrecio(35.0);
                controladorProducto.updateProducto(producto);
                ResponseEntity<Producto> updatedResponse = controladorProducto.getProducto(3);
                System.out.println("Precio actualizado: " + updatedResponse.getBody().getPrecio());
            }

            // Listar todos los productos
            System.out.println("Todos los productos:");
            ResponseEntity<List<Producto>> productosResponse = controladorProducto.getAllProducts();
            if (productosResponse.getStatusCode().is2xxSuccessful() && productosResponse.getBody() != null) {
                productosResponse.getBody().forEach(p -> 
                    System.out.println("ID del producto: " + p.getId() + ", Descripción: " + p.getDescripcion()));
            } else {
                System.out.println("No hay productos disponibles.");
            }

            // Eliminar un producto
            controladorProducto.deleteProducto(4);
            System.out.println("Producto 4 eliminado.");
            
            // Listar productos después de la eliminación
            System.out.println("Todos los productos después de la eliminación:");
            productosResponse = controladorProducto.getAllProducts();
            if (productosResponse.getStatusCode().is2xxSuccessful() && productosResponse.getBody() != null) {
                productosResponse.getBody().forEach(p -> 
                    System.out.println("ID del producto: " + p.getId() + ", Descripción: " + p.getDescripcion()));
            } else {
                System.out.println("No hay productos disponibles.");
            }
        }; 
    } 
} 