<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.tap.pro.Orderhistory" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order History List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        h2 {
            text-align: center;
            color: #343a40;
            margin-bottom: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            background-color: #ffffff;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            overflow: hidden;
        }
        th, td {
            padding: 12px 15px;
            text-align: left;
        }
        th {
            background-color: #007bff;
            color: white;
            font-weight: bold;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #e9ecef;
        }
        td {
            color: #343a40;
        }
        .no-data {
            text-align: center;
            padding: 20px;
            color: #6c757d;
        }
    </style>
</head>
<body>
    <h2>Order History List</h2>
    <table>
        <thead>
            <tr>
                <th>Order History ID</th>
                <th>Order ID</th>
                <th>User ID</th>
                <th>Order Date</th>
                <th>Total Amount</th>
                <th>Status</th>
            </tr>
        </thead>
        <tbody>
            <% 
                List<Orderhistory> orderHistoryList = (List<Orderhistory>) request.getAttribute("orderHistoryList");

                if (orderHistoryList != null && !orderHistoryList.isEmpty()) {
                    for (Orderhistory orderHistory : orderHistoryList) {
            %>
                <tr>
                    <td><%= orderHistory.getOrderHistoryId() %></td>
                    <td><%= orderHistory.getOrderId() %></td>
                    <td><%= orderHistory.getUserId() %></td>
                    <td><%= orderHistory.getOrderDate() %></td>
                    <td><%= orderHistory.getTotalAmount() %></td>
                    <td><%= orderHistory.getStatus() %></td>
                </tr>
            <% 
                    }
                } else {
            %>
                <tr>
                    <td colspan="6" class="no-data">No order histories found</td>
                </tr>
            <% 
                }
            %>
        </tbody>
    </table>
</body>
</html>