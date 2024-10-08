package com.prueba.ecommerce.dao;

import com.prueba.ecommerce.modelo.Producto;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OracleProductDAO implements ProductoDAO {
    private Map<Integer, Producto> products = new HashMap<>();

    public OracleProductDAO() {
        // Datos de ejemplo
        products.put(1, new Producto(1, "Product A", 10.0));
        products.put(2, new Producto(2, "Product B", 20.0));
    }

    @Override
    public void create(Producto producto) {
        products.put(producto.getId(), producto);
    }

    @Override
    public Producto read(int id) {
        return products.get(id);
    }

    @Override
    public void update(Producto producto) {
        products.put(producto.getId(), producto);
    }

    @Override
    public void delete(int id) {
        products.remove(id);
    }

    @Override
    public List<Producto> getAllProducts() {
        return products.values().stream().collect(Collectors.toList());
    }
}
