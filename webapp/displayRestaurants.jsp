<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.tap.pro.Restaurant" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Restaurant List</title>
    <link rel="stylesheet" href="restaurant.css">
   
       
</head>
<body>
	    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">TapFood</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="FetchRestaurantsServlet">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="cart.jsp">Cart</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="logout">Logout</a>
                </li>
                <li class="nav-item">
                	<a class="nav-link" href="OrderHistory">Order History</a>
                </li>
            </ul>
        </div>
    </nav>
    <h2>Restaurant List</h2>
    <div class="container">
        <% 
            ArrayList<Restaurant> restaurantList = (ArrayList<Restaurant>) request.getAttribute("restaurantList");
            
            if (restaurantList != null && !restaurantList.isEmpty()) {
                for (Restaurant restaurant : restaurantList) {
        %>
			<a href="menu?restaurantid=<%= restaurant.getRestaurantId()%>">
				<div class="card">
					<img alt="<%=restaurant.getRestaurantName() %>" src="restuarants/rest<%= restaurant.getRestaurantId()%>.jpg">
		            <h3><%= restaurant.getRestaurantName() %></h3>
		            <p><strong>Delivery Time:</strong> <%= restaurant.getDelivaryTime() %> minutes</p>
		            <p><strong>Cuisine Type:</strong> <%= restaurant.getCuisineType() %></p>
		            <p><strong>Address:</strong> <%= restaurant.getAddress() %></p>
		            <p><strong>Ratings:</strong> <%= restaurant.getRatings() %></p>
		            <p><strong>Status:</strong> 
		                <span class="<%= restaurant.isActive() ? "active" : "inactive" %>">
		                    <%= restaurant.isActive() ? "Active" : "Inactive" %>
		                </span>
		            </p>
		            <p><strong>Admin ID:</strong> <%= restaurant.getAdminId() %></p>
	        	</div>
			</a>
        <% 
                }
            } else {
        %>
        <p>No restaurants found.</p>
        <% 
            }
        %>
    </div>
</body>
</html>