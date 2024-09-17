package com.foodapp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodapp.DAOIMPL.UserDAOImpl;
import com.tap.pro.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		HttpSession session=request.getSession();
		
		UserDAOImpl userDAO= new UserDAOImpl();
		User user= userDAO.getUser(email);
		
		if(user!=null && password.equals(user.getPassword())) {
			session.setAttribute("user", user);
			session.removeAttribute("error");
			response.sendRedirect("FetchRestaurantsServlet");
		}else {
			session.setAttribute("error", "User Not Found, Please try again!");
			response.sendRedirect("login.jsp");
			
		}
		
	}

}


