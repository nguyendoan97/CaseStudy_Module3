package model;

import utils.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    DBConnection dbConnection;
    public ProductDAO(DBConnection dbConnection){
        this.dbConnection = dbConnection;
    }
    public void insert(Product product){
        String sql = "INSERT INTO product(name,price,quantity,color,category) VALUES (?,?,?,?,?)";
        try{
            PreparedStatement preparedStatement = dbConnection.getConnection().prepareStatement(sql);
            preparedStatement.setString(1,product.getName());
            preparedStatement.setInt(2,product.getPrice());
            preparedStatement.setInt(3,product.getQuantity());
            preparedStatement.setString(4,product.getColor());
            preparedStatement.setString(5,product.getCategory());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Product> selectAllProduct() throws SQLException {
        String sql = "SELECT * FROM product;";
        List<Product> productList =new ArrayList<>();
        try{
            Statement statement =dbConnection.getConnection().createStatement();
            ResultSet rs =statement.executeQuery(sql);
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                int quantity =rs.getInt("quantity");
                String color = rs.getString("color");
                String category = rs.getString("category");
                productList.add(new Product(id,name,price,quantity,color,category));
            }
        }catch (SQLException e){
            printSQLException(e);
        }
        return productList;

    }
    public void edit(Product product){
        String sql = "update product set name = ?,price= ?, quantity =? ,color=?,category=? where id = ?;";
        try {PreparedStatement statement = dbConnection.getConnection().prepareStatement(sql);
            statement.setString(1, product.getName());
            statement.setInt(2, product.getPrice());
            statement.setInt(3,product.getQuantity());
            statement.setString(4, product.getColor());
            statement.setString(5, product.getCategory());
            statement.setInt(6,product.getId());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public Product selectById(int id){
        String sql = "SELECT * FROM product WHERE id=?;";
        Product product = null;
        PreparedStatement statement = null;
        try { statement = dbConnection.getConnection().prepareStatement(sql);
            statement.setInt(1,id );
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                int price = rs.getInt("price");
                int quantity =rs.getInt("quantity");
                String color = rs.getString("color");
                String category = rs.getString("category");
                product = new Product(id, name, price,quantity, color,category);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return product;
    }
    public List<Product> selectByCategory(String category_search){
        String sql = "SELECT * FROM product WHERE category=?;";
        List<Product> products = new ArrayList<>();
        PreparedStatement statement = null;
        try { statement = dbConnection.getConnection().prepareStatement(sql);
            statement.setString(1,category_search );
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                int quantity =rs.getInt("quantity");
                String color = rs.getString("color");
                String category = rs.getString("category");
                products.add(new Product(id, name, price,quantity, color,category)) ;
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return products;
    }

    public void delete(int id){
        String sql = "Delete from product where id=?";
        try {
            PreparedStatement statement = dbConnection.getConnection().prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
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
}
