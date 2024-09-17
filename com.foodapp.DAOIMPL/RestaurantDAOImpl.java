package com.foodapp.DAOIMPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.tap.pro.Restaurant;
import com.foodapp.DAO.RestaurantDAO;
import com.foodapps.DBUtills.DBUtills;

public class RestaurantDAOImpl implements RestaurantDAO {
    private Connection con;

    private static final String ADD_RESTAURANT = "INSERT INTO restaurant (restaurantName, deliveryTime, cuisineType, address, ratings, isActive, adminId) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_ALL = "SELECT * FROM restaurant";
    private static final String SELECT_BY_ID = "SELECT * FROM restaurant WHERE restaurantId = ?";
    private static final String UPDATE_RESTAURANT = "UPDATE restaurant SET restaurantName=?, delivaryTime=?, cuisineType=?, address=?, ratings=?, isActive=?, adminId=? WHERE restaurantId=?";
    private static final String DELETE_RESTAURANT = "DELETE FROM restaurant WHERE restaurantId=?";

    public RestaurantDAOImpl() {
        try {
            con = DBUtills.myconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int addRestaurant(Restaurant restaurant) {
        int status = 0;
        try (PreparedStatement pstmt = con.prepareStatement(ADD_RESTAURANT)) {
            pstmt.setString(1, restaurant.getRestaurantName());
            pstmt.setInt(2, restaurant.getDelivaryTime());
            pstmt.setString(3, restaurant.getCuisineType());
            pstmt.setString(4, restaurant.getAddress());
            pstmt.setFloat(5, restaurant.getRatings());
            pstmt.setBoolean(6, restaurant.isActive());
            pstmt.setInt(7, restaurant.getAdminId());
            status = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public ArrayList<Restaurant> getAllRestaurants() {
        ArrayList<Restaurant> restaurantList = new ArrayList<>();
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(SELECT_ALL)) {
            while (rs.next()) {
                Restaurant restaurant = new Restaurant(
                    rs.getInt("restaurantId"),
                    rs.getString("restaurantName"),
                    rs.getInt("deliveryTime"),
                    rs.getString("cuisineType"),
                    rs.getString("address"),
                    rs.getFloat("ratings"),
                    rs.getBoolean("isActive"),
                    rs.getInt("adminId")
                );
                restaurantList.add(restaurant);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return restaurantList;
    }

    @Override
    public Restaurant getRestaurant(int restaurantId) {
        Restaurant restaurant = null;
        try (PreparedStatement pstmt = con.prepareStatement(SELECT_BY_ID)) {
            pstmt.setInt(1, restaurantId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    restaurant = new Restaurant(
                        rs.getInt("restaurantId"),
                        rs.getString("restaurantName"),
                        rs.getInt("delivaryTime"),
                        rs.getString("cuisineType"),
                        rs.getString("address"),
                        rs.getFloat("ratings"),
                        rs.getBoolean("isActive"),
                        rs.getInt("adminId")
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return restaurant;
    }

    @Override
    public int updateRestaurant(Restaurant restaurant) {
        int status = 0;
        try (PreparedStatement pstmt = con.prepareStatement(UPDATE_RESTAURANT)) {
            pstmt.setString(1, restaurant.getRestaurantName());
            pstmt.setInt(2, restaurant.getDelivaryTime());
            pstmt.setString(3, restaurant.getCuisineType());
            pstmt.setString(4, restaurant.getAddress());
            pstmt.setFloat(5, restaurant.getRatings());
            pstmt.setBoolean(6, restaurant.isActive());
            pstmt.setInt(7, restaurant.getAdminId());
            pstmt.setInt(8, restaurant.getRestaurantId());
            status = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public int deleteRestaurant(int restaurantId) {
        int status = 0;
        try (PreparedStatement pstmt = con.prepareStatement(DELETE_RESTAURANT)) {
            pstmt.setInt(1, restaurantId);
            status = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
}