package com.vehicles.project;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MainApp {

	public static void main(String[] args) throws Exception {

		// Initializing 2 lists of wheels, front and back.
		List<Wheel> frontWheels = new ArrayList<Wheel>();
		List<Wheel> backWheels = new ArrayList<Wheel>();
		
		String typeOfVehicle = ""; // to store if the vehicle is a car;
								   // variable created to avoid the use of instanceof -best practice-,
								   // in method promptForWheels().
		
		// Avoid initializing inside a loop -best practice-.
		Car userCar = new Car(null, null, null); // Instanciates an empty Car.
		Bike userBike = new Bike(null, null, null); // Instanciates empty Bike.

		Scanner user = new Scanner(System.in);
		System.out.println("Are you creating a car or a bike?");

		int stopper = 0; // Set to 1 stops the while loop
		while (stopper == 0) {
			try {
				// Question repeats until user writes "bike" or "car".
				String userChoice = user.next().toLowerCase();
				if (!userChoice.equals("car") && !userChoice.equals("bike")) {
					throw new IllegalArgumentException("Please enter 'car' or 'bike'.");
				}

				// Case car chosen:
				if (userChoice.equals("car")) {
					typeOfVehicle = "car";

					promptForVehicle(userCar); // Call function to prompt for and create the car.

					// Prompt for and create the front and back wheels.
					System.out.println("Front wheels:");
					promptForWheels(frontWheels, typeOfVehicle);
					System.out.println("Back wheels:");
					promptForWheels(backWheels, typeOfVehicle);

					// Add wheels to the car and print all its specs.
					userCar.addWheels(frontWheels, backWheels);
					System.out.println(userCar.toString());

					stopper = 1; // stop the loop
				}

				// Case bike chosen:
				if (userChoice.equals("bike")) {
					// typeOfVehicle = "bike"; NO NEED

					promptForVehicle(userBike); // Call to prompt and create the bike.

					// Prompt for and create the front and back wheels.
					System.out.println("Front wheel:");
					promptForWheels(frontWheels, typeOfVehicle);
					System.out.println("Back wheel:");
					promptForWheels(backWheels, typeOfVehicle);

					// Add wheels to the bike and print all its specs.
					userBike.addWheels(frontWheels, backWheels);
					System.out.println(userBike.toString());
					stopper = 1;
				}

			} catch (IllegalArgumentException i) {
				System.out.println(i);
			}

		}
		
		user.close(); // Close Scanner object avoiding resource leak.

	}

	// ----------------------- METHODS ------------------------------ //

	private static void promptForVehicle(Vehicle vehicle) {
		/*
		 * Prompt user for vehicle's plate, brand and color and store them in variables.
		 */

		Scanner user = new Scanner(System.in);
		System.out.println("Plate? (4 numbers and 2 or 3 letters)");

		int stopper = 0; // Set to 1 stops the while loop.
		while (stopper == 0) {
			// Ask for and add vehicle's number plate. 
			// Repeat question (IllegalArgumentException) if number plate is not valid.
			try {
				vehicle.plate = user.next().toUpperCase(); // Convert all characters of the answer to upper case,
														   // to help the user match the pattern above.

				// plate necessarily consists of 4 numbers + 2 or 3 letters.
				if (!Pattern.matches("^[0-9]{4}([A-Z]{2}|[A-Z]{3})$", vehicle.plate)) {
					throw new IllegalArgumentException(
							"plate must be 4 numbers + 2 or 3 letters. Please enter plate number.");
				}

				// Prompt for and add the specs, brand and color.
				System.out.println("Brand?");
				vehicle.brand = user.next();
				System.out.println("Color?");
				vehicle.color = user.next();

				stopper = 1; // Finish the loop.
				
			} catch (IllegalArgumentException i) {
				System.out.println(i);
			}
		}
		
		user.close(); // Close Scanner object avoiding resource leak.

	}

	private static void promptForWheels(List<Wheel> wheelsList, String typeOfVehicle) {

		/*
		 * Method to prompt user for the wheels' specs and add them to a list; this list
		 * will be one of the parameters of the instance method addWheels. If vehicle is
		 * a car, two wheels are created. One for a bike.
		 */

		Wheel oneWheel = new Wheel(null, 0); // new Wheel instantiated.
		
		// Variables initialized here to avoid doing it inside a loop -best pratice-.
		Wheel clonedWheel = new Wheel(null, 0);
		Double oneWheelDiameter; // variable to store the diameter of the first wheel entered;
								 // if vehicle is a car, this variable will be cloned.

		// Prompt for wheel specs.
		Scanner user = new Scanner(System.in);
		System.out.println("Diameter?");

		int stopper = 0; // Set to 1 stops the while loop.
		while (stopper == 0) {
			/* An InputMismatchException is triggered in case user enters a non numeric value for the diameter.
			 * IllegalArgumentException if the entered diameter is out of range, 0.4-4.
			 * Both exceptions resume the loop.
			 */
			try {
				// Set diameter, if value entered is within the valid range, from 0.4 to 4.
				oneWheelDiameter = user.nextDouble();
				
				// BEST PRACTICE: avoid initializing variables inside a loop.
//				Double rightWheelDiameter = user.nextDouble();
				
				if (oneWheelDiameter < 0.4 || oneWheelDiameter > 4.0) {
					throw new IllegalArgumentException(
							"Diameter permitted range between 0.4 and 4. Please enter again.");
				} else {
					oneWheel.setDiameter(oneWheelDiameter);

					// Set brand.
					System.out.println("Brand?");
					oneWheel.setBrand(user.next());

					// Add the wheel to the parameter list.
					wheelsList.add(oneWheel);

					// If Car, clone the wheel and add it.
					if (typeOfVehicle.equals("car")) {						
						clonedWheel = oneWheel;
						wheelsList.add(clonedWheel);
						
						// BEST PRATICE, not initialize here. 
//						Wheel clonedWheel = new Wheel(null, 0);
					}
					
					// BEST PRACTICE: avoid using instanceof
//					if (vehicle instanceof Car) {
//						Wheel clonedWheel = new Wheel(null, 0);
//						clonedWheel = oneWheel;
//						wheelsList.add(clonedWheel);
//					}
					
					stopper = 1; // Finish the loop.
				}
			} catch (IllegalArgumentException i) {
				System.out.println(i);
			} catch (InputMismatchException e) {
				user.next(); // To avoid infinite loop.
				System.out.println(e + ": Please enter a number between 0.4 and 4.");
			}
		}
		
		user.close(); // Close Scanner object avoiding resource leak.
	}

}
