package com.foodapp.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.pro.Cart;
import com.tap.pro.CartItem;
import com.tap.pro.OrderItem;
import com.tap.pro.Orderhistory;
import com.tap.pro.Ordertable;
import com.tap.pro.User;
import com.foodapp.DAOIMPL.OrderItemDAOImpl;
import com.foodapp.DAOIMPL.OrderhistoryDAOImpl;
import com.foodapp.DAOIMPL.OrdertableDAOImpl;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        User user = (User) session.getAttribute("user");
        int userId=user.getUserId();
        int restaurantId = 0;  // Assuming all items are from the same restaurant
        LocalDateTime dateTime = LocalDateTime.now();
        float totalAmount = 0.0f;

        if (cart != null) {
            Map<Integer, CartItem> cartItems = cart.getItems();

            if (!cartItems.isEmpty()) {
                for (CartItem item : cartItems.values()) {
                    totalAmount += item.getPrice() * item.getQuantity();
                    restaurantId = item.getRestaurantId();  // Assuming one restaurant
                }

                // Create Ordertable entry
                Ordertable order = new Ordertable(restaurantId, userId, dateTime, totalAmount, "Placed", "Card");
                OrdertableDAOImpl dao=new OrdertableDAOImpl();
                int orderId = dao.saveOrder(order);
                
                // Create OrderItem entries
                for (CartItem item : cartItems.values()) {
                    OrderItem orderItem = new OrderItem(orderId, item.getItemId(), item.getQuantity(), item.getPrice() * item.getQuantity());
                    OrderItemDAOImpl dao2=new OrderItemDAOImpl();
                    dao2.saveOrderItem(orderItem);
                }

                // Create OrderHistory entry
                LocalDate date=LocalDate.now(); 
                Orderhistory orderHistory = new Orderhistory(orderId, userId, date, totalAmount, "Placed");
                OrderhistoryDAOImpl dao3=new OrderhistoryDAOImpl();
                dao3.saveOrderHistory(orderHistory);
                
                session.removeAttribute("cart");
            }
        }
        
        response.sendRedirect("confirmation.jsp");
    }
}