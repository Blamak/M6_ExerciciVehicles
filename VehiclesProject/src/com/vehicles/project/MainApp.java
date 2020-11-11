package com.vehicles.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) throws Exception {

		// Car attributes.
		String plate;
		String brand;
		String color;

	/* 
	 *  Prompt user for car's plate, brand and color and store them in variables.
	 */
		Scanner user = new Scanner(System.in);

		System.out.println("Plate?");
		plate = user.next();
		System.out.println("Brand?");
		brand = user.next();
		System.out.println("Color?");
		color = user.next();

		// Create a new car with the user's answers.
		Car userCar = new Car(plate, brand, color);

		
	/*
	 *  Prompt user for brand and diameter of 4 wheels, 2 front and 2 back.
	 */
		// Initializing 2 lists of wheels, front and back.
		List<Wheel> frontWheels = new ArrayList<Wheel>();
		List<Wheel> backWheels = new ArrayList<Wheel>();
		
		// Call method with each list to prompt for and create the wheels.
		System.out.println("Front wheels: ");
		promptForWheels(frontWheels);
		
		System.out.println("Back wheels: ");
		promptForWheels(backWheels);
	
		// Add all the 4 wheels to the user's car and print.
		userCar.addWheels(frontWheels, backWheels);

		System.out.println(userCar.toString());

	}

	private static void promptForWheels(List<Wheel> wheelsList) {
		
		// Wheels instantiated:
		Wheel left = new Wheel(null, 0);
		Wheel right = new Wheel(null, 0);

		Scanner user = new Scanner(System.in);

		// -Right front wheel, brand + diameter:
		System.out.println("Wheels brand?");
		right.setBrand(user.next());
		System.out.println("Wheels diameter?");
		right.setDiameter(user.nextDouble());

		// Front wheels must be identical (... method addTwoWheels in class Car):
		left = right;

		// Add the 2 wheels to the List of front wheels.
		wheelsList.add(right);
		wheelsList.add(left);

	}

}
