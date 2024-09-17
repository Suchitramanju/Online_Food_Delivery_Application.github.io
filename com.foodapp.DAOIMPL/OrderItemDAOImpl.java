package com.foodapp.DAOIMPL;

import com.foodapp.DAO.OrderItemDAO;



import java.sql.Connection;
import java.sql.PreparedStatement;

import com.tap.pro.OrderItem;
import com.foodapp.DAO.OrderItemDAO;
import com.foodapps.DBUtills.DBUtills;

public class OrderItemDAOImpl implements OrderItemDAO {
	 public void saveOrderItem(OrderItem orderItem) {
	        try {
	            Connection con =  DBUtills.myconnect();
	            String query = "INSERT INTO OrderItem (orderId, menuId, quantity, subTotal) VALUES (?, ?, ?, ?)";
	            PreparedStatement pst = con.prepareStatement(query);
	            pst.setInt(1, orderItem.getOrderId());
	            pst.setInt(2, orderItem.getMenuId());
	            pst.setInt(3, orderItem.getQuantity());
	            pst.setDouble(4, orderItem.getSubTotal());

	            pst.executeUpdate();
	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

}
