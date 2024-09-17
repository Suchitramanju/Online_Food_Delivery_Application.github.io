package com.tap.pro;

public class Menu {
	private int menuId;
	private int restaurantId;
	private String menuName;
	private float price;
	private String description;
	//private boolean isAvaliable;
	private String imgPath;
	private boolean isActiveTable;
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Menu(int menuId, int restaurantId, String menuName, float price, String description, boolean isActiveTable,
			String imgPath) {
		super();
		this.menuId = menuId;
		this.restaurantId = restaurantId;
		this.menuName = menuName;
		this.price = price;
		this.description = description;
		this.isActiveTable = isActiveTable;
		this.imgPath = imgPath;
	}
	public Menu( int restaurantId, String menuName, float price, String description, boolean isActiveTable,
			String imgPath) {
		super();
		this.restaurantId = restaurantId;
		this.menuName = menuName;
		this.price = price;
		this.description = description;
		this.isActiveTable = isActiveTable;
		this.imgPath = imgPath;
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isActiveTable() {
		return isActiveTable;
	}
	public void setisActiveTable(boolean isActiveTable) {
		this.isActiveTable = isActiveTable;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	
	

}