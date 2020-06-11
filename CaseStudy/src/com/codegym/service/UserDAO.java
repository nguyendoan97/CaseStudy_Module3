package com.codegym.service;

import com.codegym.model.User;
import com.codegym.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    DBConnection connection;

    public UserDAO(DBConnection connection) {
        this.connection = connection;
    }

    public User getByUsername(String username) {
        String sql = "SELECT * FROM account WHERE name = ?";
        try {
            PreparedStatement ps = this.connection.getConnection().prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String u = rs.getString(2);
                String p = rs.getString(3);
                String role = rs.getString(4);

                return new User(id,u, p, role);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Lỗi thực thi lệnh SQL SELECT");
        }
        return null;
    }

    public List<User> getUser() {

        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM account;";
        try {
            Statement statement = this.connection.getConnection().createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString("name");
                String passworrd = rs.getString("password");
                String role = rs.getString("role");

                User user = new User(id,name,passworrd,role);
                users.add(user);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Lỗi thực thi câu lệnh SQL");
        }

        return users;
    }

    public void save(User user){

        String sql = "INSERT INTO account (name,password) VALUES (?,?)";

        try {
            PreparedStatement preparedStatement = connection.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Lỗi thực thi lệnh SQL Insert Into");
        }

    }

    public void deleteById(int id) {
        String sql = "DELETE FROM account WHERE id = ?";
        try {
            PreparedStatement ps = this.connection.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Lỗi thực thi lệnh SQL DELETE");
        }
    }
}