package com.foodapp.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodapp.DAOIMPL.OrderhistoryDAOImpl;
import com.tap.pro.Orderhistory;
import com.tap.pro.User;

@WebServlet("/OrderHistory")
public class OrderHistoryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    OrderhistoryDAOImpl orderhistoryDAOImpl=new OrderhistoryDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session=request.getSession();
    	User user=(User)session.getAttribute("user");
        try {
            List<Orderhistory> orderHistoryList = orderhistoryDAOImpl.getAllOrderHistories(user.getUserId());
            request.setAttribute("orderHistoryList", orderHistoryList);

            request.getRequestDispatcher("orderhistory.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

}
