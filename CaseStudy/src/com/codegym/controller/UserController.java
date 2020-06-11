package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.model.User;
import com.codegym.service.UserDAO;
import com.codegym.utils.DBConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/login")
public class UserController extends HttpServlet {

    DBConnection dbConnection = DBConnection.getInstance();
    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO(dbConnection);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("./user/login.jsp");
        dispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = userDAO.getByUsername(username);
        if(user == null){
            req.setAttribute("message_erro", "Đăng nhập không thành công");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/user/login.jsp");
            dispatcher.forward(req, resp);
        }

        if (user.getPassword().equals(password)) {

            HttpSession session = req.getSession();
            session.setAttribute("IS_LOGGINED", true);
            session.setAttribute("name_display",user.getUsername());
            session.setAttribute("ROLE", user.getRole());

            resp.sendRedirect("/products");

        } else {

            // thong bao loi dang nhap

            req.setAttribute("message_erro", "Đăng nhập không thành công");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/user/login.jsp");
            dispatcher.forward(req, resp);
        }
    }
}

//        try {
//            this.listProductById(req,resp);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }
//    private void listProductById(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException, ServletException {
//        String username = request.getParameter("username");
//        User user = userDAO.getByUsername(username);
//        request.setAttribute("us",user);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/products?action=list_customer");
//        dispatcher.forward(request, response);
//    }
//}