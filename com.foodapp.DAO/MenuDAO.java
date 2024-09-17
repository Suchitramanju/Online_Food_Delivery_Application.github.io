//package com.foodapp.DAO;
//	import com.tap.pro.Menu;
//	import java.util.ArrayList;
//
//	public interface MenuDAO {
//	    int addMenu(Menu menu);
//	    ArrayList<Menu> getAllMenusByRestaurantId(int restaurantId);
//	    Menu getMenuById(int menuId);
//	    int updateMenu(Menu menu);
//	    int deleteMenu(int menuId);
//	}

	package com.foodapp.DAO;

	import com.tap.pro.Menu;
	import java.util.ArrayList;

	public interface MenuDAO {
	    int addMenu(Menu menu);
	    ArrayList<Menu> getAllMenusByRestaurantId(int restaurantId);
	    Menu getMenuById(int menuId);
	    int updateMenu(Menu menu);
	    int deleteMenu(int menuId);
	}