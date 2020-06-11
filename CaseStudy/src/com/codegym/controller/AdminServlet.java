package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.model.User;
import com.codegym.service.ProductDAO;
import com.codegym.service.UserDAO;
import com.codegym.utils.DBConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AdminServlet",urlPatterns = "/admin")
public class AdminServlet extends HttpServlet {
    private ProductDAO productDAO;
    private UserDAO userDAO;
    private DBConnection dbConnection=DBConnection.getInstance();
    public void init() {
        productDAO = new ProductDAO(dbConnection);
        userDAO = new UserDAO(dbConnection);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
//        try {
//            switch (action) {
//                case "reg":
////                    insertUser(request,response);
//            }
//        }catch(SQLException throwables) {
//            throwables.printStackTrace();
//        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action){
                case "product":
                    listProduct(request, response);
                    break;
                case "user":
                    listUser(request,response);
                    break;
                case  "delete":
                    deleteUser(request,response);
                    break;
                case "reg":
                    getReg(request,response);
                    break;
                default:
                    listProduct(request,response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }



    }
    private void listProduct(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Product> listProduct = productDAO.selectAllProduct();
        request.setAttribute("listProduct", listProduct);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/list_data.jsp");
        dispatcher.forward(request, response);
    }
    private void listUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<User> listUsers = userDAO.getUser();
        request.setAttribute("listUser", listUsers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/user/user_data.jsp");
        dispatcher.forward(request, response);
    }
    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        userDAO.deleteById(id);
        List<User> listUsers = userDAO.getUser();
        request.setAttribute("listUser", listUsers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/user_data.jsp");
        dispatcher.forward(request, response);
    }

    private void getReg(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/user/reg.jsp");
        dispatcher.forward(request, response);
    }

}
