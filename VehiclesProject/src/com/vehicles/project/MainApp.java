package com.vehicles.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MainApp {

	public static void main(String[] args) throws Exception {
		
		// Initializing 2 lists of wheels, front and back.
		List<Wheel> frontWheels = new ArrayList<Wheel>();
		List<Wheel> backWheels = new ArrayList<Wheel>();
		
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
					Car userCar = new Car(null, null, null); // Instanciates an empty Car.
					
					promptForVehicle(userCar); // Call function to prompt for and create the car.
					
					// Prompt for and create the front and back wheels.
					System.out.println("Front wheels:");
					promptForWheels(frontWheels, userCar);
					System.out.println("Back wheels:");
					promptForWheels(backWheels, userCar);
					
					// Add wheels to the car and print all its specs.
					userCar.addWheels(frontWheels, backWheels);
					System.out.println(userCar.toString());
					
					stopper = 1; // stop the loop
				}
				
				// Case bike chosen:
				if (userChoice.equals("bike")) {
					Bike userBike = new Bike(null, null, null); // Instanciates empty Bike.
					
					promptForVehicle(userBike); // Call to prompt and create the bike.

					// Prompt for and create the front and back wheels.
					System.out.println("Front wheel:");
					promptForWheels(frontWheels, userBike);
					System.out.println("Back wheel:");
					promptForWheels(backWheels, userBike);
					
					// Add wheels to the bike and print all its specs.
					userBike.addWheels(frontWheels, backWheels);
					System.out.println(userBike.toString());
					stopper = 1;
				}
				
			} catch (IllegalArgumentException i) {
				System.out.println(i);
			}
			
		}
		
	}
	
	
	//   -----------------------  METHODS  ------------------------------ //
	
	private static void promptForVehicle(Vehicle vehicle) {
		/*
		 * Prompt user for vehicle's plate, brand and color and store them in variables.
		 */

		Scanner user = new Scanner(System.in);
		System.out.println("Plate? (4 numbers and 2 or 3 letters)");

		int stopper = 0; // Set to 1 stops the while loop.
		while (stopper == 0) {
			try {
				// Add vehicle's number plate. Repeat question if number plate is not valid.
				vehicle.plate = user.next().toUpperCase(); // Convert all characters of the answer to upper case 
														   // to help the user to match the pattern above.

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

	}
	

	private static void promptForWheels(List<Wheel> wheelsList, Vehicle vehicle) {
		
		/*
		 * Method to prompt user for the wheels specs and add them to a list;
		 * this list will be one of the parameters of the instance method addWheels.
		 * If vehicle is a car, two wheels are created. One for a bike.
		 */

		Wheel oneWheel = new Wheel(null, 0); // new Wheel instantiated.

		// Prompt for wheel specs.
		Scanner user = new Scanner(System.in);
		System.out.println("Diameter?");

		int stopper = 0; // Set to 1 stops the while loop.
		while (stopper == 0) {

			try {
				// Set diameter, range from 0.4 to 4.
				Double oneWheelDiameter = user.nextDouble();
				if (oneWheelDiameter < 0.4 || oneWheelDiameter > 4.0) {
					throw new IllegalArgumentException("Diameter permitted range between 0.4 and 4. Please enter again.");
				}
				oneWheel.setDiameter(oneWheelDiameter);
				
				// Set brand.
				System.out.println("Brand?");
				oneWheel.setBrand(user.next());

				// Add the wheel to the parameter list.
				wheelsList.add(oneWheel);

				// If Car, clone the wheel and add it also.
				if (vehicle instanceof Car) {
					Wheel clonedWheel= new Wheel(null, 0);
					clonedWheel = oneWheel;
					wheelsList.add(clonedWheel);				
				}
				
				stopper = 1; // Finish the loop.
				
			} catch (IllegalArgumentException i) {
				System.out.println(i);
			}
		}
	}

}
