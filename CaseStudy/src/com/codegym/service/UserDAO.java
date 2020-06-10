package com.codegym.service;

import com.codegym.model.User;
import com.codegym.utils.DBConnection;

import java.sql.*;

public class UserDAO {
    DBConnection connection;

    public UserDAO(DBConnection connection) {
        this.connection = connection;
    }

    public User getByUsername(String username) {
        String sql = "SELECT name, password, role FROM account WHERE name = ?";
        try {
            PreparedStatement ps = this.connection.getConnection().prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String u = rs.getString(1);
                String p = rs.getString(2);
                String role = rs.getString(3);

                return new User(u, p, role);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Lỗi thực thi lệnh SQL SELECT");
        }
        return null;
    }
}

//    public List<Customer> getCustomers() {
//
//        List<Customer> customers = new ArrayList<>();
//        String sql = "SELECT username, password FROM users";
//
//        try {
//            Statement statement = this.connection.getConnection().createStatement();
//            ResultSet rs = statement.executeQuery(sql);
//
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String name = rs.getString(2);
//
//                Customer customer = new Customer(id, name);
//                customers.add(customer);
//            }
//
//        } catch (SQLException e) {
//            throw new RuntimeException("Lỗi thực thi câu lệnh SQL");
//        }
//
//        return customers;
//    }

//    public void save(String customerName) {
//
//        String sql = "INSERT INTO customers (name) VALUES (?)";
//
//        try {
//            PreparedStatement ps = this.connection.getConnection().prepareStatement(sql);
//            ps.setString(1, customerName);
//            ps.execute();
//        } catch (SQLException e) {
//            throw new RuntimeException("Lỗi thực thi lệnh SQL Insert Into");
//        }
//
//    }
//
//    public void deleteById(int id) {
//        String sql = "DELETE FROM customers WHERE id = ?";
//        try {
//            PreparedStatement ps = this.connection.getConnection().prepareStatement(sql);
//            ps.setInt(1, id);
//            ps.execute();
//        } catch (SQLException e) {
//            throw new RuntimeException("Lỗi thực thi lệnh SQL DELETE");
//        }
//    }