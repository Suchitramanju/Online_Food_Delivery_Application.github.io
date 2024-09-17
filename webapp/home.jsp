<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.tap.pro.Restaurant" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Restaurant List</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h2>Restaurant List</h2>
    <table>
        <thead>
            <tr>
                <th>Restaurant ID</th>
                <th>Name</th>
                <th>Delivery Time (min)</th>
                <th>Cuisine Type</th>
                <th>Address</th>
                <th>Ratings</th>
                <th>Active</th>
                <th>Admin ID</th>
            </tr>
        </thead>
        <tbody>
            <% 
                // Retrieve the list of restaurants from the request
                ArrayList<Restaurant> restaurantList = (ArrayList<Restaurant>) request.getAttribute("restaurantList");
                
                // Iterate over the list and display each restaurant
                if (restaurantList != null) {
                    for (Restaurant restaurant : restaurantList) {
            %>
                <tr>
                    <td><%= restaurant.getRestaurantId() %></td>
                    <td><%= restaurant.getRestaurantName() %></td>
                    <td><%= restaurant.getDelivaryTime() %></td>
                    <td><%= restaurant.getCuisineType() %></td>
                    <td><%= restaurant.getAddress() %></td>
                    <td><%= restaurant.getRatings() %></td>
                    <td><%= restaurant.isActive() %></td>
                    <td><%= restaurant.getAdminId() %></td>
                </tr>
            <% 
                    }
                } else {
            %>
                <tr>
                    <td colspan="8">No restaurants found</td>
                </tr>
            <% 
                }
            %>
        </tbody>
    </table>
</body>
</html>