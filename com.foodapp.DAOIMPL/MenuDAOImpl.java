package com.foodapp.DAOIMPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.tap.pro.Menu;
import com.foodapp.DAO.MenuDAO;
import com.foodapps.DBUtills.DBUtills;

public class MenuDAOImpl implements MenuDAO {
    private Connection con;
    private PreparedStatement pstmt;
    private Statement stmt;
    private ResultSet resultSet;

    // SQL Queries
    private static final String ADD_MENU = "INSERT INTO menu (restaurantId, menuName, price, description, isActiveTable, imgPath) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_BY_RESTAURANT_ID = "SELECT * FROM menu WHERE restaurantId = ?";
    private static final String SELECT_BY_ID = "SELECT * FROM menu WHERE menuId = ?";
    private static final String UPDATE_MENU = "UPDATE menu SET menuName = ?, price = ?, description = ?, isActiveTable = ?, imgPath = ? WHERE menuId = ?";
    private static final String DELETE_MENU = "DELETE FROM menu WHERE menuId = ?";

    public MenuDAOImpl() {
        try {
            con = DBUtills.myconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int addMenu(Menu menu) {
        int status = 0;
        try {
            pstmt = con.prepareStatement(ADD_MENU);
            pstmt.setInt(1, menu.getRestaurantId());
            pstmt.setString(2, menu.getMenuName());
            pstmt.setFloat(3, menu.getPrice());
            pstmt.setString(4, menu.getDescription());
            pstmt.setBoolean(5, menu.isActiveTable());
            pstmt.setString(6, menu.getImgPath());

            status = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public ArrayList<Menu> getAllMenusByRestaurantId(int restaurantId) {
        ArrayList<Menu> menuList = new ArrayList<>();
        try {
            pstmt = con.prepareStatement(SELECT_ALL_BY_RESTAURANT_ID);
            pstmt.setInt(1, restaurantId);
            resultSet = pstmt.executeQuery();
            menuList = extractMenuFromResultSet(resultSet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return menuList;
    }

    @Override
    public Menu getMenuById(int menuId) {
        Menu menu = null;
        try {
            pstmt = con.prepareStatement(SELECT_BY_ID);
            pstmt.setInt(1, menuId);
            resultSet = pstmt.executeQuery();
            ArrayList<Menu> menuList = extractMenuFromResultSet(resultSet);
            if (!menuList.isEmpty()) {
                menu = menuList.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return menu;
    }

    @Override
    public int updateMenu(Menu menu) {
        int status = 0;
        try {
            pstmt = con.prepareStatement(UPDATE_MENU);
            pstmt.setString(1, menu.getMenuName());
            pstmt.setFloat(2, menu.getPrice());
            pstmt.setString(3, menu.getDescription());
            pstmt.setBoolean(4, menu.isActiveTable());
            pstmt.setString(5, menu.getImgPath());
            pstmt.setInt(6, menu.getMenuId());

            status = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public int deleteMenu(int menuId) {
        int status = 0;
        try {
            pstmt = con.prepareStatement(DELETE_MENU);
            pstmt.setInt(1, menuId);
            status = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    private ArrayList<Menu> extractMenuFromResultSet(ResultSet resultSet) {
        ArrayList<Menu> menuList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Menu menu = new Menu(
                    resultSet.getInt("menuId"),
                    resultSet.getInt("restaurantId"),
                    resultSet.getString("menuName"),
                    resultSet.getFloat("price"),
                    resultSet.getString("description"),
                    resultSet.getBoolean("isActiveTable"),
                    resultSet.getString("imgPath")
                );
                menuList.add(menu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return menuList;
    }
}