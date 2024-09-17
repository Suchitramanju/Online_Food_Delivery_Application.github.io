package com.foodapp.servlets;

//import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.pro.Restaurant;
import com.foodapp.DAO.RestaurantDAO;
import com.foodapp.DAOIMPL.RestaurantDAOImpl;

@WebServlet("/FetchRestaurantsServlet")
public class FetchRestaurantsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Create DAO instance
        RestaurantDAO restaurantDAO = new RestaurantDAOImpl();

        // Fetch all restaurants
        ArrayList<Restaurant> restaurantList = restaurantDAO.getAllRestaurants();

        // Set the restaurant list as a request attribute
        request.setAttribute("restaurantList", restaurantList);

        request.getRequestDispatcher("displayRestaurants.jsp").forward(request, response);
    }
}