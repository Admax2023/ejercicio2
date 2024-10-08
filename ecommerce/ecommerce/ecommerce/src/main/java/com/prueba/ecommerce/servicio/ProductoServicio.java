package com.prueba.ecommerce.servicio;

import com.prueba.ecommerce.modelo.Producto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoServicio {
    private final List<Producto> productos = new ArrayList<>();

    public void addProducto(Producto producto) {
        productos.add(producto);
    }

    public Producto getProducto(int id) {
        return productos.stream()
            .filter(p -> p.getId() == id)
            .findFirst()
            .orElse(null);
    }

    public void updateProducto(Producto producto) {
        int index = productos.indexOf(getProducto(producto.getId()));
        if (index != -1) {
            productos.set(index, producto);
        }
    }

    public void deleteProducto(int id) {
        productos.removeIf(p -> p.getId() == id);
    }

    public List<Producto> getAllProducts() {
        return new ArrayList<>(productos);
    }
}
