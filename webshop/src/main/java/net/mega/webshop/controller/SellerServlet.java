package net.mega.webshop.controller;

import net.mega.webshop.connection.Provider;
import net.mega.webshop.dao.SellerDao;
import net.mega.webshop.dao.jdbc.JdbcSellerDao;
import net.mega.webshop.model.Seller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/register")
public class SellerServlet extends HttpServlet {

    private Provider provider = new Provider();
    private SellerDao sellerDao = new JdbcSellerDao(provider);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/seller-servlet.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String username = request.getParameter("username");
        String pass = request.getParameter("pass");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");

        sellerDao.add(new Seller(name, surname, username, pass, address, Integer.parseInt(phone), email));

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/seller-info.jsp");
        dispatcher.forward(request,response);

    }
}
