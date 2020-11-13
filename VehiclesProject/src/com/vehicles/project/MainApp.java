package com.vehicles.project;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/*
 ****************************************************************
 * BEST PRACTICES are implemented -at least tried to- in Fase-3 *
 ****************************************************************
 */

public class MainApp {
	
	

	public static void main(String[] args) throws Exception {

		Car userCar = new Car(null, null, null); // Instanciates an empty Car.

		/*
		 * Prompt user for car's plate, brand and color and store them in variables.
		 */

		Scanner user = new Scanner(System.in);
		System.out.println("Plate? (4 numbers and 2 or 3 letters)");

		int stopper = 0; // Set to 1 stops the while loop.
		while (stopper == 0) {
			try {
				userCar.plate = user.next().toUpperCase(); // Convert all characters of the answer to upper case to help
															// match the pattern

				// plate must be 4 numbers + 2 or 3 letters.
				if (!Pattern.matches("^[0-9]{4}([A-Z]{2}|[A-Z]{3})$", userCar.plate)) {
					throw new IllegalArgumentException(
							"plate must be 4 numbers + 2 or 3 letters. Please enter plate number.");
				}
				System.out.println("Brand?");
				userCar.brand = user.next();
				System.out.println("Color?");
				userCar.color = user.next();
				stopper = 1; // Finish the loop.
			} catch (IllegalArgumentException i) {
				System.out.println(i);
			}
		}

		/*
		 * Prompt user for brand and diameter of 4 wheels, 2 front and 2 back. First two
		 * empty lists are created, then each list is passed as parameter of the
		 * promptForWheels method.
		 */

		// Initializing 2 lists of wheels, front and back.
		List<Wheel> frontWheels = new ArrayList<Wheel>();
		List<Wheel> backWheels = new ArrayList<Wheel>();

		System.out.println("Front wheels:");
		promptForWheels(frontWheels);

		System.out.println("Back wheels:");
		promptForWheels(backWheels);

		// Add wheels to user's car and print.
		userCar.addWheels(frontWheels, backWheels);
		System.out.println(userCar.toString());
	}

	private static void promptForWheels(List<Wheel> wheelsList) {

		/*
		 * Method to prompt user for the wheels specs and add them to a list that will
		 * be a parameter of the method addWheels.
		 */

		// Wheels instantiated:
		Wheel left = new Wheel(null, 0);
		Wheel right = new Wheel(null, 0);

		Scanner user = new Scanner(System.in);
		System.out.println("Wheels diameter?");

		int stopper = 0; // Set to 1 stops the while loop.
		while (stopper == 0) {

			try {
				// -Right wheel, diameter + brand:
				Double rightWheelDiameter = user.nextDouble();
				if (rightWheelDiameter < 0.4 || rightWheelDiameter > 4.0) {
					throw new IllegalArgumentException(
							"Diameter permitted range between 0.4 and 4. Please enter again.");
				}
				right.setDiameter(rightWheelDiameter);
				System.out.println("Wheels brand?");
				right.setBrand(user.next());

				// Both wheels must be identical (... method addTwoWheels in class Car):
				left = right;

				// Add the 2 wheels to the List of front wheels.
				wheelsList.add(right);
				wheelsList.add(left);
				stopper = 1; // Finish the loop.

			} catch (IllegalArgumentException i) {
				System.out.println(i);
			} catch (InputMismatchException e) {
				user.next(); // To avoid infinite loop.
				System.out.println(e + ": Please enter a number between 0.4 and 4.");
			}
		}
	}

}
