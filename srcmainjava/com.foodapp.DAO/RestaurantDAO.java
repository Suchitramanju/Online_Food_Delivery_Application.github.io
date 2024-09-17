package com.foodapp.DAO;

import java.util.ArrayList;
import com.tap.pro.Restaurant;

public interface RestaurantDAO {
    int addRestaurant(Restaurant restaurant);
    ArrayList<Restaurant> getAllRestaurants();
    Restaurant getRestaurant(int restaurantId);
    int updateRestaurant(Restaurant restaurant);
    int deleteRestaurant(int restaurantId);
}