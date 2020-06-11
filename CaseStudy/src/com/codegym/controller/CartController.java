package com.codegym.controller;

import com.codegym.model.Cart;
import com.codegym.model.CartItem;
import com.codegym.model.Product;
import com.codegym.model.*;
import com.codegym.service.ProductDAO;
import com.codegym.utils.DBConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/cart")
public class CartController extends HttpServlet {

    private DBConnection dbConnection = DBConnection.getInstance();
    private ProductDAO productDAO;

    @Override
    public void init() throws ServletException {
        productDAO = new ProductDAO(this.dbConnection);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "cart":
                addCart(req,resp);
                break;
            default:
                getCartList(req, resp);
                break;

        }
    }

    private void getCartList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Object o = session.getAttribute("cart");
        // List<Product> cart;
        Cart cart;
        if (o == null) {
            cart = new Cart();
        } else {
            cart = (Cart) o;
        }

        req.setAttribute("cart", cart.getCartItemList());
        RequestDispatcher dispatcher = req.getRequestDispatcher("list_cart.jsp");
        dispatcher.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    private void addCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        HttpSession session = req.getSession();

        Object o = session.getAttribute("cart");

        Cart cart;

        if (o == null) {
            cart = new Cart();
        } else {
            cart = (Cart) o;
        }

        int id = Integer.parseInt(req.getParameter("id"));

        Product product = productDAO.selectProduct(id);

        CartItem item = new CartItem();
        item.setProduct(product);
        item.setQuantity(item.getQuantity()+1);
        int amount = (item.getQuantity()*item.getProduct().getPrince());
        item.setAmount(amount);
        cart.addItem(item);
        session.setAttribute("cart", cart);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/list_cart.jsp");
        dispatcher.forward(req, resp);
    }
}