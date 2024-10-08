package com.prueba.ecommerce.dao;

public class ProductDAOFactory {
    public static ProductoDAO getProductDAO(String dbType) {
        if ("MySQL".equalsIgnoreCase(dbType)) {
            return new MySQLProductDAO();
        } else if ("Oracle".equalsIgnoreCase(dbType)) {
            return new OracleProductDAO();
        }
        throw new IllegalArgumentException("Database type not supported.");
    }
}
