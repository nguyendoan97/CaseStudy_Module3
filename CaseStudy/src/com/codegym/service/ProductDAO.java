package com.codegym.service;

import com.codegym.model.Product;
import com.codegym.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
//    private String jdbcURL="jdbc:mysql://localhost:3306/demo_user?useUnicode=yes&characterEncoding=UTF-8";
//    private String jdbcUsername= "root";
//    private String jdbcPassword= "123456";

    private static final String INSERT_PRODUCT_SQL ="INSERT INTO product(name,image,prince,classify)VALUES(?,?,?,?);";
    private static final String SELECT_PRODUCT_BY_ID = "select id,name,image,prince,classify from product where id=?;";
    private static final String SELECT_PRODUCT_BY_CLASSIFY = "select id,name,image,prince,classify from product where classify=?;";
    private static final String SELECT_ALL_PRODUCT = "select * from product";
    private static final String DELETE_PRODUCT_SQL = "delete from product where id = ?;";
    private static final String UPDATE_PRODUCT_SQL = "update product set name = ?,image= ?, prince =? ,classify=? where id = ?;";
    DBConnection dbConnection;
    public ProductDAO(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

//    protected Connection getConnection(){
//        Connection  connection = null;
//        try{
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            connection = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return connection;
//    }


    public void insertProduct(Product product) throws SQLException {
        System.out.println(INSERT_PRODUCT_SQL);
        try{PreparedStatement preparedStatement = dbConnection.getConnection().prepareStatement(INSERT_PRODUCT_SQL);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getImage());
            preparedStatement.setInt(3,product.getPrince());
            preparedStatement.setString(4, product.getClassify());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public Product selectProduct(int id) {
        Product product = null;
        PreparedStatement statement = null;
        try { statement = dbConnection.getConnection().prepareStatement(SELECT_PRODUCT_BY_ID);
        statement.setInt(1,id );
        ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String image = rs.getString("image");
                int prince =rs.getInt("prince");
                String classify = rs.getString("classify");
                product = new Product(id, name, image,prince, classify);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return product;
    }
    public List<Product> selectUserByClassify(String countrys) {
        List<Product> products = new ArrayList<>();

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_CLASSIFY);) {
            preparedStatement.setString(1, countrys);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();


            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String image = rs.getString("image");
                int prince =rs.getInt("prince");
                String classify = rs.getString("classify");
                products.add(new Product(id,name,image,prince,classify));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return products;
    }

    public List<Product> selectAllProduct() {
        List<Product> products = new ArrayList<>();
        // Step 1: Establishing a Connection
        try {
            Statement statement = dbConnection.getConnection().createStatement();
            ResultSet rs = statement.executeQuery(SELECT_ALL_PRODUCT);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String image = rs.getString("image");
                int prince =rs.getInt("prince");
                String classify = rs.getString("classify");
                products.add(new Product(id,name,image,prince,classify));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return products;
    }

    public void deleteProduct(int id) throws SQLException {
        boolean rowDeleted;
        try {
            PreparedStatement statement = dbConnection.getConnection().prepareStatement(DELETE_PRODUCT_SQL);
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

        public void updateProduct(Product product) throws SQLException {
        boolean rowUpdated;
        try {PreparedStatement statement = dbConnection.getConnection().prepareStatement(UPDATE_PRODUCT_SQL);
            statement.setString(1, product.getName());
            statement.setString(2, product.getImage());
            statement.setInt(3,product.getPrince());
            statement.setString(4, product.getClassify());
            statement.setInt(5, product.getId());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

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
//            callableStatement.setString(2, product.getImage());
//            callableStatement.setString(3, product.getClassify());
//            System.out.println(callableStatement);
//            callableStatement.executeUpdate();
//
//        }
//    }

}

