package com.anteastra.DAO;

import java.sql.SQLException;
import java.util.List;

import com.anteastra.model.Product;


public interface ProductDAO {
    public void addProduct(Product product) throws SQLException;   //�������� ��������
    public void updateProduct(Product product) throws SQLException;//�������� ��������
    public Product getProductById(Long id) throws SQLException;    //�������� �������� �� id
    public List<?> getAllProducts() throws SQLException;              //�������� ���� ���������
    public void deleteProduct(Product product) throws SQLException;//������� ��������
}