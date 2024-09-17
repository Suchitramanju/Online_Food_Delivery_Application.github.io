package com.foodapp.DAOIMPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.foodapp.DAO.OrdertableDAO;
import com.foodapps.DBUtills.DBUtills;
import com.tap.pro.Ordertable;

public class OrdertableDAOImpl implements OrdertableDAO {
	public int saveOrder(Ordertable order) {
        int orderId = 0;
        try {
            Connection con = DBUtills.myconnect();
            String query = "INSERT INTO ordertable (orderId,restaurantId, userId, dateTime, totalAmount, status, paymentMethode) VALUES (?, ?,?, now(), ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, order.getOrderId());
            pst.setInt(2, order.getRestaurantId());
            pst.setInt(3, order.getUserId());
            pst.setFloat(4, order.getTotalAmount());
            pst.setString(5, order.getStatus());
            pst.setString(6, order.getPaymentMode());

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
            	
                var rs = pst.getGeneratedKeys();
                if (rs.next()) {
                    orderId = rs.getInt(1);
                }
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderId;
    }

	@Override
	public int saveOrder(OrdertableDAO order) {
		// TODO Auto-generated method stub
		return 0;
	}

}
