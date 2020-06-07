package com.codegym.service;

import com.codegym.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductDAO {
    public void insertUser(Product product) throws SQLException;

    public Product selectUser(int id);

    public List<Product> selectAllUsers();

    public boolean deleteUser(int id) throws SQLException;

    public boolean updateUser(Product product) throws SQLException;
}
