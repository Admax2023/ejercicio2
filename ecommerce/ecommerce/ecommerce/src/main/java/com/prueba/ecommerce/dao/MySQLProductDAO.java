package com.prueba.ecommerce.dao;

import com.prueba.ecommerce.modelo.Producto;
import java.util.ArrayList;
import java.util.List;

public class MySQLProductDAO implements ProductoDAO {
    private List<Producto> products = new ArrayList<>();

    public MySQLProductDAO() {
        // Datos de ejemplo
        products.add(new Producto(1, "Product A", 10.0));
        products.add(new Producto(2, "Product B", 20.0));
    }

    @Override
    public void create(Producto producto) {
        products.add(producto);
    }

    @Override
    public Producto read(int id) {
        return products.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void update(Producto product) {
        Producto existingProduct = read(product.getId());
        if (existingProduct != null) {
            existingProduct.setDescripcion(product.getDescripcion());
            existingProduct.setPrecio(product.getPrecio());
        }
    }

    @Override
    public void delete(int id) {
        products.removeIf(p -> p.getId() == id);
    }

    @Override
    public List<Producto> getAllProducts() {
        return new ArrayList<>(products);
    }
}
