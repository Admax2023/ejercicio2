package com.prueba.ecommerce.dao;

import com.prueba.ecommerce.modelo.Producto;
import java.util.List;

public interface ProductoDAO {
    void create(Producto product);
    Producto read(int id);
    void update(Producto product);
    void delete(int id);
    List<Producto> getAllProducts();
}
