<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.tap.pro.CartItem" %>
<%@ page import="com.tap.pro.Cart" %>
<%@ page import="java.util.Map" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Cart</title>
</head>
<body>
    <h1>Your Shopping Cart</h1>
    <% 
        Cart cart = (Cart) session.getAttribute("cart");
        if(cart != null) {
            Map<Integer, CartItem> cartItems = cart.getItems();
            if(cartItems.isEmpty()) {
    %>
                <p>Your cart is empty.</p>
    <% 
            } else {
                double total = 0.0;
                for(CartItem item : cartItems.values()) {
                    total += item.getPrice() * item.getQuantity();
    %>
                    <div>
                        <form action="addToCart" method="post">
                            <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
                            <p>Restaurant Id: <%= item.getRestaurantId() %></p>
                            <p>Name: <%= item.getName() %></p>
                            <p>Price: <%= item.getPrice() %></p>
                            <p>
                                Quantity: 
                                <input type="number" name="quantity" value="<%= item.getQuantity() %>" min="1">
                                <input type="submit" name="action" value="update">
                            </p>
                            <p>
                                <input type="submit" name="action" value="remove">
                            </p>
                        </form>
                    </div>
                    <hr>
    <% 
                }
    %>
                <p><strong>Total Price: <%= total %></strong></p>
                <form action="cart" method="post">
                    <input type="submit" name="action" value="clear" />
                </form>
                <form action="checkout" method="post">
                    <input type="submit" value="Checkout" />
                </form>
    <% 
            }
        } else {
    %>
            <p>Your cart is empty.</p>
    <% 
        } 
    %>
</body>
</html>