package com.foodapp.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.pro.User;
import com.foodapp.DAO.UserDAO;
import com.foodapp.DAOIMPL.UserDAOImpl;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form parameters
        String userName = request.getParameter("userName");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        String password = request.getParameter("password");
        String address = request.getParameter("address");

        // Create a new User object
        User user = new User(userName, email, phoneNumber, password, address);

        // Get DAO instance and add user
        UserDAO userDAO = new UserDAOImpl();
        int status = userDAO.adduser(user);

        if (status > 0) {
            // Registration successful
            response.sendRedirect("index.html");
        } else {
            // Registration failed
            response.sendRedirect("registration.jsp");
        }
    }
}