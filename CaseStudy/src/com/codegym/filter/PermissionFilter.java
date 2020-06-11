package com.codegym.filter;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "PermissionFilter", urlPatterns = "/admin")
public class PermissionFilter implements Filter {

    public static final String ROLE_ADMIN = "admin";

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();
        Object o = session.getAttribute("ROLE");
        if (o != null) {
            String role = o.toString();

            if (role.equals(ROLE_ADMIN)) {
                chain.doFilter(req, resp);
            } else {
                PrintWriter writer = resp.getWriter();
                writer.write("Quyền truy cập chỉ dành cho Admin!");
                writer.write("<a href=\"/products?action=list_customer\">Quay lại</a>");
            }
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/user/login.jsp");
            dispatcher.forward(request, response);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}