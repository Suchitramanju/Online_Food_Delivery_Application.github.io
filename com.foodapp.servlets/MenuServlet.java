package com.foodapp.servlets;

import java.io.IOException;
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
import javax.servlet.http.HttpSession;

import com.tap.pro.Menu;
import com.foodapp.DAO.MenuDAO;
import com.foodapp.DAOIMPL.MenuDAOImpl;

@WebServlet("/menu")
public class MenuServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session=request.getSession();
        int restaurantId;
        if(request.getParameter("restaurantid")!=null) {
        	restaurantId = Integer.parseInt(request.getParameter("restaurantid"));
        	session.setAttribute("restaurantid", restaurantId);
        }else{
        	restaurantId=(int)session.getAttribute("restaurantid");
        }
        
        MenuDAO menuDAO = new MenuDAOImpl();
        
        ArrayList<Menu> menuList = menuDAO.getAllMenusByRestaurantId(restaurantId);

        request.setAttribute("menuList", menuList);
        
        request.getRequestDispatcher("displayMenus.jsp").forward(request, response);
    }
}