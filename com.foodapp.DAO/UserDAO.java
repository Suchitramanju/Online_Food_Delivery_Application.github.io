
package com.foodapp.DAO;

import java.util.ArrayList;

import com.tap.pro.User;


public interface UserDAO {
	int adduser (User u);
	ArrayList<User> getAllUser();
	User getUser(String email);
	int  updateUser(User u);
	int deleteUser(String email);
	
	

}
