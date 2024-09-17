<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.tap.pro.Menu" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Menu List</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .card {
            margin-bottom: 20px;
        }
        .card img {
            max-height: 200px;
            object-fit: cover;
        }
    </style>
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
                	<a class="nav-link" href="OrderHistory">Order History</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="logout">Logout</a>
                </li>
            </ul>
        </div>
    </nav>

    <!-- Main content -->
    <div class="container">
        <h2 class="my-4">Menu List</h2>
        <div class="row">
            <% 
                ArrayList<Menu> menuList = (ArrayList<Menu>) request.getAttribute("menuList");
                
                if (menuList != null && !menuList.isEmpty()) {
                    for (Menu menu : menuList) {
            %>
            <div class="col-md-4">
                <div class="card">
                    <img src="images/menu<%=menu.getMenuId() %>.jpg" class="card-img-top" alt="<%= menu.getMenuName() %>">
                    <div class="card-body">
                        <h5 class="card-title"><%= menu.getMenuName() %></h5>
                        <p class="card-text"><strong>Description:</strong> <%= menu.getDescription() %></p>
                        <p class="card-text"><strong>Price:</strong> $<%= menu.getPrice() %></p>
                        <p class="card-text"><strong>Status:</strong> <%= menu.isActiveTable() ? "Available" : "Not Available" %></p>
                        <a href="addToCart?menuId=<%= menu.getMenuId() %>&action=add" class="btn btn-primary">Add to Cart</a>
                    </div>
                </div>
            </div>
            <% 
                    }
                } else {
            %>
            <div class="col-12">
                <p>No menu items available.</p>
            </div>
            <% 
                }
            %>
        </div>
    </div>

    <!-- Bootstrap JavaScript and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
