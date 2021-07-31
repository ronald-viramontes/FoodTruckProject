package com.skilldistillery.foodtruck.app;

public class FoodTruck {
	private int truckId;
	private String truckName;
	private String foodType;
	private double truckRating;	
	private static int numOfTrucks = 1000;
	
	public FoodTruck(String truckName, String foodType, double truckRating) {
		numOfTrucks ++;
		this.truckId = numOfTrucks;
		this.truckName = truckName;
		this.foodType = foodType;
		this.truckRating = truckRating;
	}

	public int getTruckId() {
		return truckId;
	}

	public void setTruckId(int truckId) {
		this.truckId = truckId;
	}

	public String getTruckName() {
		return truckName;
	}

	public void setTruckName(String truckName) {
		this.truckName = truckName;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public double getTruckRating() {
		return truckRating;
	}

	public void setTruckRating(double truckRating) {
		this.truckRating = truckRating;
	}

	public static int getNumOfTrucks() {
		return numOfTrucks;
	}

	public static void setNumOfTrucks(int numOfTrucks) {
		FoodTruck.numOfTrucks = numOfTrucks;
	}

	@Override
	public String toString() {
		return "FoodTruck: Truck ID: " + truckId + ", Truck Name: " + truckName + ", Food Type: " + foodType
				+ ", Truck Rating: " + truckRating;
	}
	
	
}