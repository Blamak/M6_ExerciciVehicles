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
		
		// Prompt user for car's plate, brand and color and store them in variables.
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
		 * Prompt user for brand and diameter of 4 wheels, 2 front and 2 back.    
		*/
		
		// Initializing 2 lists of wheels, front and back.
		List<Wheel> frontWheels = new ArrayList<Wheel>();
		List<Wheel> backWheels = new ArrayList<Wheel>();
		
		// Front wheels instantiated:
		Wheel leftFront= new Wheel(null, 0);
		Wheel rightFront = new Wheel(null, 0);
		
		   // -Right front wheel, brand + diameter:
		System.out.println("Front wheels brand?");
		rightFront.setBrand(user.next());
		System.out.println("Front wheels diameter?");
		rightFront.setDiameter(user.nextInt());
		
		// Front wheels must be identical (... method addTwoWheels in class Car):
		leftFront = rightFront;
		
				
		// Add the 2 wheels to the List of front wheels.
		frontWheels.add(rightFront);
		frontWheels.add(leftFront);
		
		// Back wheels instantiated:
		Wheel leftBack = new Wheel(null, 0);
		Wheel rightBack = new Wheel(null, 0);
		
		   // -Right back wheel, brand + diameter:
		System.out.println("Back wheels brand?");
		rightBack.setBrand(user.next());
		System.out.println("Back wheels diameter?");
		rightBack.setDiameter(user.nextInt());
		
		// Back wheels must be identical.
		leftBack = rightBack;
		
		// Add the 2 wheels to the List of back wheels
		backWheels.add(rightBack);
		backWheels.add(leftBack);
		
		
		// Add all the 4 wheels to the user's car.
		userCar.addWheels(frontWheels, backWheels);
		
		
		System.out.println(userCar.toString());
		
	}

}
