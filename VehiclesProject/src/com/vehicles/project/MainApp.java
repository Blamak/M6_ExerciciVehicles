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
		
		   // -Right, brand + diameter:
		System.out.println("Left front wheel brand?");
		leftFront.setBrand(user.next());
		System.out.println("Left front wheel diameter?");
		rightFront.setDiameter(user.nextInt());
		leftFront = rightFront;
		
//		   // -Left, brand + diameter:
//		System.out.println("Right front wheel brand?");
//		leftFront.setBrand(user.next());
//		System.out.println("Right front wheel diameter?");
//		rightFront.setDiameter(user.nextInt());
		
		// Add the 2 wheels to the List of front wheels.
		frontWheels.add(rightFront);
		frontWheels.add(leftFront);
		
		// Back wheels instantiated:
		Wheel leftBack = new Wheel(null, 0);
		Wheel rightBack = new Wheel(null, 0);
		
		   // -Right, brand + diameter:
		System.out.println("Right back wheel brand?");
		rightBack.setBrand(user.next());
		System.out.println("Right back wheel diameter?");
		rightBack.setDiameter(user.nextInt());
		leftBack = rightBack;

//		   // -Left, brand + diameter:
//		System.out.println("Left back wheel brand?");
//		leftBack.setBrand(user.next());
//		System.out.println("Left back wheel diameter?");
//		leftBack.setDiameter(user.nextInt());
		
		// Add the 2 wheels to the List of back wheels
		backWheels.add(rightBack);
		backWheels.add(leftBack);
		
		
		// Add all the 4 wheels to the user's car.
		userCar.addWheels(frontWheels, backWheels);
		
		
		System.out.println(userCar.toString());
		
	}

}
