package com.foodapp.DAOIMPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.foodapp.DAO.UserDAO;
import com.foodapps.DBUtills.DBUtills;
import com.tap.pro.User;

public class UserDAOImpl implements UserDAO 
{
	Connection con;

	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet resultSet;
	
	ArrayList<User> userList=new ArrayList<User>();
	User user;
	private static final String ADD_USER="insert into`user`(username,email,phoneNumber,password,address) values(?,?,?,?,?)";
	private static final String SELECT_ALL="select * from user";
	private static final String SELECT_ON_EMAIL="select * from user where email=?";
	private static final String UPDATE_ON_EMAIL="update user set username=?,phoneNumber=?,password=?,address=? where email=?";
	private static final String DELETE_ON_EMAIL="delete * from user where email=? ";
	int status=0;

	public UserDAOImpl() {
		try 
		{
			con=DBUtills.myconnect();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Override
	public int adduser(User u) {
		try 
		{
		pstmt=con.prepareStatement(ADD_USER);
		pstmt.setString(1, u.getUserName());
		pstmt.setString(2, u.getEmail());
		pstmt.setString(3, u.getPhoneNumber());
		pstmt.setString(4, u.getPassword());
		pstmt.setString(5, u.getAddress());
		
		status = pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return status;
	}
	@Override
	public ArrayList<User> getAllUser() {
		try
		{
			stmt=con.createStatement();
			resultSet=stmt.executeQuery(SELECT_ALL);
			userList=extractUserFromResultSet(resultSet);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return userList;
	}
	@Override
	public User getUser(String email) {
		try
		{
			pstmt=con.prepareStatement(SELECT_ON_EMAIL);
			
			pstmt.setString(1, email);
			resultSet=pstmt.executeQuery();
			userList=extractUserFromResultSet(resultSet);
			if(!userList.isEmpty())
				user=userList.get(0);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return user;	
	}
	@Override
	public int updateUser(User u) {
		try
		{
			pstmt=con.prepareStatement(UPDATE_ON_EMAIL);
			pstmt.setString(1, u.getUserName());
			pstmt.setString(2, u.getPhoneNumber());
			pstmt.setString(3, u.getPassword());
			pstmt.setString(4, u.getAddress());
			pstmt.setString(5, u.getEmail());
			
			status=pstmt.executeUpdate();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
		
	}

	@Override
	public int deleteUser(String email) {
		try
		{
			pstmt=con.prepareStatement(DELETE_ON_EMAIL);
			pstmt.setString(1,email);
			status=pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
		
	}
	
	ArrayList<User>extractUserFromResultSet(ResultSet resultSet)
	{
		try
		{
			while(resultSet.next())
			{
				userList.add(new User(resultSet.getInt("userId"),
				resultSet.getString("username"),
				resultSet.getString("email"),
				resultSet.getString("phoneNumber"),
				resultSet.getString("password"),
				resultSet.getString("address")));
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return userList;
	}
	
}
