package com.codegym.service;

import com.codegym.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private String jdbcURL="jdbc:mysql://localhost:3306/demo_user?useUnicode=yes&characterEncoding=UTF-8";
    private String jdbcUsername= "root";
    private String jdbcPassword= "123456";

    private static final String INSERT_USERS_SQL="INSERT INTO users"+"(name,email,country)VALUES"+"(?,?,?);";
    private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id=?;";
    private static final String SELECT_USER_BY_COUNTRY = "select id,name,email,country from users where country=?;";
    private static final String SELECT_ALL_USERS = "select * from users";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where id = ?;";

    public ProductDAO() {
    }

    protected Connection getConnection(){
        Connection  connection = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }


    public void insertUser(Product product) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getEmail());
            preparedStatement.setString(3, product.getCountry());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

//    public Product selectUser(int id) {
//        Product product = null;
//        // Step 1: Establishing a Connection
//        try (Connection connection = getConnection();
//             // Step 2:Create a statement using connection object
//             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
//            preparedStatement.setInt(1, id);
//            System.out.println(preparedStatement);
//            // Step 3: Execute the query or update query
//            ResultSet rs = preparedStatement.executeQuery();
//
//            // Step 4: Process the ResultSet object.
//            while (rs.next()) {
//                String name = rs.getString("name");
//                String email = rs.getString("email");
//                String country = rs.getString("country");
//                product = new Product(id, name, email, country);
//            }
//        } catch (SQLException e) {
//            printSQLException(e);
//        }
//        return product;
//    }
//    public List<Product> selectUserByCount(String countrys) {
//        List<Product> products = new ArrayList<>();
//
//        try (Connection connection = getConnection();
//
//             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_COUNTRY);) {
//            preparedStatement.setString(1, countrys);
//            System.out.println(preparedStatement);
//
//            ResultSet rs = preparedStatement.executeQuery();
//
//
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String name = rs.getString("name");
//                String email = rs.getString("email");
//                String country = rs.getString("country");
//                products.add(new Product(id, name, email, country));
//            }
//        } catch (SQLException e) {
//            printSQLException(e);
//        }
//        return products;
//    }
//
//    public List<Product> selectAllUsers() {
//
//        // using try-with-resources to avoid closing resources (boiler plate code)
//        List<Product> products = new ArrayList<>();
//        // Step 1: Establishing a Connection
//        try (Connection connection = getConnection();
//
//             // Step 2:Create a statement using connection object
//             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
//            System.out.println(preparedStatement);
//            // Step 3: Execute the query or update query
//            ResultSet rs = preparedStatement.executeQuery();
//
//            // Step 4: Process the ResultSet object.
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String name = rs.getString("name");
//                String email = rs.getString("email");
//                String country = rs.getString("country");
//                products.add(new Product(id, name, email, country));
//            }
//        } catch (SQLException e) {
//            printSQLException(e);
//        }
//        return products;
//    }
//
//    public boolean deleteUser(int id) throws SQLException {
//        boolean rowDeleted;
//        try (Connection connection = getConnection();
//             PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
//            statement.setInt(1, id);
//            rowDeleted = statement.executeUpdate() > 0;
//        }
//        return rowDeleted;
//    }
//
//    public boolean updateUser(Product product) throws SQLException {
//        boolean rowUpdated;
//        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
//            statement.setString(1, product.getName());
//            statement.setString(2, product.getEmail());
//            statement.setString(3, product.getCountry());
//            statement.setInt(4, product.getId());
//
//            rowUpdated = statement.executeUpdate() > 0;
//        }
//        return rowUpdated;
//    }
//
//    private void printSQLException(SQLException ex) {
//        for (Throwable e : ex) {
//            if (e instanceof SQLException) {
//                e.printStackTrace(System.err);
//                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
//                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
//                System.err.println("Message: " + e.getMessage());
//                Throwable t = ex.getCause();
//                while (t != null) {
//                    System.out.println("Cause: " + t);
//                    t = t.getCause();
//                }
//            }
//        }
//    }
//
//    private Product getUserById(int id) throws SQLException {
//        Product product = null;
//        String query = "{call get_user_by_id(?)}";
//        try(Connection connection = getConnection();
//            CallableStatement callableStatement = connection.prepareCall(query)){
//            callableStatement.setInt(1,id);
//            ResultSet rs = callableStatement.executeQuery();
//
//            while (rs.next()){
//                String name = rs.getString("name");
//
//                String email = rs.getString("email");
//
//                String country = rs.getString("country");
//
//                product = new Product(id, name, email, country);
//            }
//        } catch (SQLException e) {
//
//            printSQLException(e);
//        }
//        return product;
//    }
//
//    public void insertUserStore(Product product) throws SQLException {
//        String query = "{call insert_user(?,?,?)}";
//        try(Connection connection = getConnection()){
//            CallableStatement callableStatement = connection.prepareCall(query);
//            callableStatement.setString(1, product.getName());
//            callableStatement.setString(2, product.getEmail());
//            callableStatement.setString(3, product.getCountry());
//            System.out.println(callableStatement);
//            callableStatement.executeUpdate();
//
//        }
//    }
//
//}
//
