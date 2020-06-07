package com.codegym.controller;

import com.codegym.service.ProductDAO;
import com.codegym.model.Product;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UserServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductDAO productDAO;

    public void init() {
        productDAO = new ProductDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertUser(request, response);
                    break;
                case "edit":
                    updateUser(request, response);
                    break;
                case "listbycountry":
                    listUserByCountry(request,response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        String action = request.getParameter("action");
//        if (action == null) {
//            action = "";
//        }
//
//        try {
//            switch (action) {
//                case "index":
//                    showIndex(request,response);
//                case "create":
//                    showNewForm(request, response);
//                    break;
//                case "edit":
//                    showEditForm(request, response);
//                    break;
//                case "delete":
//                    deleteUser(request, response);
//                    break;
//                case "listbycountry":
//                    showSearchForm(request,response);
//                    break;
//                default:
//                    listUser(request, response);
//                    break;
//            }
//        } catch (SQLException ex) {
//            throw new ServletException(ex);
//        }
//    }
//
//    private void showIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Product> listProduct = productDAO.selectAllUsers();
//        request.setAttribute("listProduct", listProduct);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/list.jsp");
//        dispatcher.forward(request, response);
//    }
//
//    private void listUser(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException, ServletException {
//        List<Product> listProduct = productDAO.selectAllUsers();
//        request.setAttribute("listProduct", listProduct);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/list_data.jsp");
//        dispatcher.forward(request, response);
//    }
//    private void listUserByCountry(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException, ServletException {
//        String country = request.getParameter("country");
//        List<Product> listCountry = productDAO.selectUserByCount(country);
//        request.setAttribute("listCountry", listCountry);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/listbycountry.jsp");
//        System.out.println(dispatcher);
//        dispatcher.forward(request, response);
//    }
//    private void showSearchForm(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/formsearch.jsp");
//        dispatcher.forward(request, response);
//    }
//
//
//    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/create.jsp");
//        dispatcher.forward(request, response);
//    }
//
//    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, ServletException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        Product existingProduct = productDAO.selectUser(id);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("product/edit.jsp");
//        request.setAttribute("product", existingProduct);
//        dispatcher.forward(request, response);
//
//    }
//
//    private void insertUser(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException, ServletException {
//        String name = request.getParameter("name");
//        String email = request.getParameter("email");
//        String country = request.getParameter("country");
//        Product newProduct = new Product(name, email, country);
//        productDAO.insertUser(newProduct);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/create.jsp");
//        dispatcher.forward(request, response);
//    }
//
//    private void updateUser(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException, ServletException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        String name = request.getParameter("name");
//        String email = request.getParameter("email");
//        String country = request.getParameter("country");
//
//        Product book = new Product(id, name, email, country);
//        productDAO.updateUser(book);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("product/edit.jsp");
//        dispatcher.forward(request, response);
//    }
//
//    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException, ServletException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        productDAO.deleteUser(id);
//
//        List<Product> listProduct = productDAO.selectAllUsers();
//        request.setAttribute("listProduct", listProduct);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("product/list_data.jsp");
//        dispatcher.forward(request, response);
//    }
//}