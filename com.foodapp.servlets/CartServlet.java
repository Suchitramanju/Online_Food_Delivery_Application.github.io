package com.foodapp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodapp.DAOIMPL.MenuDAOImpl;
import com.tap.pro.Cart;
import com.tap.pro.CartItem;
import com.tap.pro.Menu;
//import com.foodapp.DAOImpl.MenuDAOImpl;

@WebServlet("/addToCart")
public class CartServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		Cart cart =(Cart) session.getAttribute("cart");
		
		if(cart == null) {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		String action = request.getParameter("action");
		if("add".equals(action)) {
			addItemToCart(request, cart);
		} else if("update".equals(action)) {
			updateCartItem(request, cart);
		} else if("remove".equals(action)) {
			removeItemFromCart(request, cart);
		}
		
		session.setAttribute("cart", cart);
		response.sendRedirect("menu");
	}

	private void addItemToCart(HttpServletRequest request, Cart cart) {
		int menuId = Integer.parseInt(request.getParameter("menuId"));
		MenuDAOImpl menuDAO = new MenuDAOImpl();
		Menu menu = menuDAO.getMenuById(menuId);
		int itemId = menu.getMenuId();
		int restaurantId = menu.getRestaurantId();
		String name = menu.getMenuName();
		int quantity = 1;
		double price = menu.getPrice();
		
		CartItem cartItem = new CartItem(itemId, restaurantId, name, quantity, price);
		cart.addItem(cartItem);
	}

	private void updateCartItem(HttpServletRequest request, Cart cart) {
		int itemId = Integer.parseInt(request.getParameter("itemId"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		cart.updateItem(itemId, quantity);
	}

	private void removeItemFromCart(HttpServletRequest request, Cart cart) {
		int itemId = Integer.parseInt(request.getParameter("itemId"));
		cart.removeItem(itemId);
	}
}