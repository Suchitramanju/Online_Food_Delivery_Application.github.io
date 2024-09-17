package com.foodapp.DAOIMPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.foodapp.DAO.OrderhistoryDAO;
import com.foodapps.DBUtills.DBUtills;
import com.tap.pro.Orderhistory;

public class OrderhistoryDAOImpl implements OrderhistoryDAO {
	Connection con;
	public OrderhistoryDAOImpl() {
		con=DBUtills.myconnect();
	}
	 public void saveOrderHistory(Orderhistory orderHistory) {
	        try {
	            
	            String query = "INSERT INTO Orderhistory (orderId, userId, orderDate, totalAmount, status) VALUES (?, ?, now(), ?, ?)";
	            PreparedStatement pst = con.prepareStatement(query);
	            pst.setInt(1, orderHistory.getOrderId());
	            pst.setInt(2, orderHistory.getUserId());
	            pst.setFloat(3, orderHistory.getTotalAmount());
	            pst.setString(4, orderHistory.getStatus());

	            pst.executeUpdate();
	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	 public List<Orderhistory> getAllOrderHistories(int userId) throws SQLException {
	        String query = "SELECT * FROM orderhistory where userId=?";
	        List<Orderhistory> orderHistories = new ArrayList<>();
	        try{
	        	PreparedStatement preparedStatement = con.prepareStatement(query);
     		preparedStatement.setInt(1, userId);
     		ResultSet resultSet = preparedStatement.executeQuery();
	            while (resultSet.next()) {
	                Orderhistory orderHistory = new Orderhistory(
	                    resultSet.getInt("orderHistoryId"),
	                    resultSet.getInt("orderId"),
	                    resultSet.getInt("userId"),
	                    resultSet.getDate("orderDate").toLocalDate(),
	                    resultSet.getFloat("totalAmount"),
	                    resultSet.getString("status")
	                );
	                orderHistories.add(orderHistory);
	            }
	        }catch (Exception e) {
				e.printStackTrace();
			}
	        return orderHistories;
	    }
}