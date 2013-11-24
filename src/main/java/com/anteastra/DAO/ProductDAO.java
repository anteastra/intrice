package com.anteastra.DAO;

import java.sql.SQLException;
import java.util.List;

import com.anteastra.model.Product;


public interface ProductDAO {
    public void addProduct(Product product) throws SQLException;   //добавить студента
    public void updateProduct(Product product) throws SQLException;//обновить студента
    public Product getProductById(Long id) throws SQLException;    //получить стедента по id
    public List<?> getAllProducts() throws SQLException;              //получить всех студентов
    public void deleteProduct(Product product) throws SQLException;//удалить студента
}