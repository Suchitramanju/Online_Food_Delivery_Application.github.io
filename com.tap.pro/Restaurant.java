package com.tap.pro;

public class Restaurant {
	private int restaurantId;
	private String restaurantName;
	private int delivaryTime;
	private String cuisineType;
	private String address;
	private float ratings;
	private boolean isActive;
	private int adminId;
	
	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Restaurant(int restaurantId, String restaurantName, int delivaryTime, String cuisineType, String address,
			float ratings, boolean isActive, int adminId) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.delivaryTime = delivaryTime;
		this.cuisineType = cuisineType;
		this.address = address;
		this.ratings = ratings;
		this.isActive = isActive;
		this.adminId = adminId;
	}
	public Restaurant( String restaurantName, int delivaryTime, String cuisineType, String address,
			float ratings, boolean isActive, int adminId) {
		super();
		
		this.restaurantName = restaurantName;
		this.delivaryTime = delivaryTime;
		this.cuisineType = cuisineType;
		this.address = address;
		this.ratings = ratings;
		this.isActive = isActive;
		this.adminId = adminId;
	}


	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public int getDelivaryTime() {
		return delivaryTime;
	}

	public void setDelivaryTime(int delivaryTime) {
		this.delivaryTime = delivaryTime;
	}

	public String getCuisineType() {
		return cuisineType;
	}

	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public float getRatings() {
		return ratings;
	}

	public void setRatings(float ratings) {
		this.ratings = ratings;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	
	
	
	
	
	

}
