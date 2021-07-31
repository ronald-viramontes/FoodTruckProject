package com.skilldistillery.foodtruck.app;

import java.util.Scanner;

public class FoodTruckApp {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		FoodTruckApp app = new FoodTruckApp();
		FoodTruck[] foodTrucks = app.createFoodTrucks(kb);
		app.menu2Choices(foodTrucks, kb);
		System.out.println("Thank you for using Food Truck App!  Goodbye!");
	}

	public FoodTruck[] createFoodTrucks(Scanner kb) {
		FoodTruck[] foodTrucks = new FoodTruck[5];
		FoodTruckApp app = new FoodTruckApp();

		System.out.println("***--------Welcome to Ron's Food Truck App--------***");
		System.out.println("--> Where you can enter & rate local Food Trucks <--");
		System.out.println();
		for (int i = 0; i < 5; i++) {
			System.out.println("Enter a food truck name: ");
			String truckName = kb.nextLine();
			if (truckName.equals("quit")) {
				return foodTrucks;
			}
			System.out.println("Enter the food type: ");
			String foodType = kb.nextLine();
			System.out.println("Enter food rating --> 1 - worst  5 - best: ");
			Double truckRating = kb.nextDouble();
			kb.nextLine();
			FoodTruck foodTruck = new FoodTruck(truckName, foodType, truckRating);
			foodTrucks[i] = foodTruck;
		}
		return foodTrucks;
	}
	public void menu2Choices(FoodTruck[] foodTrucks, Scanner kb) {
		boolean done = false;
		do {
			System.out.println("----**** MENU ****----");
			System.out.println("1 -- List all existing food trucks.");
			System.out.println("2 -- Average food truck rating.");
			System.out.println("3 -- Highest rated food truck.");
			System.out.println("4 -- TYPE quit -- to exit.");
			String userSelection = kb.nextLine();
			if (userSelection.equals("1")) {
				displayTrucks(foodTrucks);
			}
			if (userSelection.equals("2")) {
				System.out.println("Average Food Truck Rating: " + avgTruckRating(foodTrucks));
			}
			if (userSelection.equals("3")) {
				System.out.println("Highest Food Truck Rating: " + highestRating(foodTrucks));
			}
			if (userSelection.equals("quit")) {
				done = true;
			}
		} while (!done);
		kb.close();
	}
	public double highestRating(FoodTruck[] foodTruck) {
		int i = 0;
		double highestRating = 0;
		double truckRatingCopy = 0;
		for (i = 0; i < foodTruck.length; i++) {
			if (foodTruck[i] != null && truckRatingCopy < foodTruck[i].getTruckRating()) {
				truckRatingCopy = foodTruck[i].getTruckRating();
				highestRating = truckRatingCopy;
			}
		}
		return highestRating;
	}
	public double avgTruckRating(FoodTruck[] foodTruck) {
		double sum = 0;
		int count = 0;
		for (int i = 0; i < foodTruck.length; i++) {
			if (foodTruck[i] != null) {
				sum += foodTruck[i].getTruckRating();
				count++;
			}
		}
		return Math.round(sum/count);
	}
	public void displayTrucks(FoodTruck[] foodTrucks) {
		for (int i = 0; i < foodTrucks.length; i++) {
			if (foodTrucks[i] != null)
				System.out.println(foodTrucks[i]);
		}
	}
}
