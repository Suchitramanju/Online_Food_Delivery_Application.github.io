package com.foodapp.DAO;

import java.sql.SQLException;
import java.util.List;

import com.tap.pro.Orderhistory;

public interface OrderhistoryDAO {
	public void saveOrderHistory(Orderhistory orderHistory);
	List<Orderhistory> getAllOrderHistories(int userId) throws SQLException;

}