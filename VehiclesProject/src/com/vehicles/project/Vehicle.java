package com.vehicles.project;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {

	protected String plate;
	protected String brand;
	protected String color;
	protected List<Wheel> wheels = new ArrayList<Wheel>();

	public Vehicle(String plate, String brand, String color) {
		this.plate = plate;
		this.brand = brand;
		this.color = color;
	}
	
	public String stringOfWheels() { 
		/* 
		 * Method to create a string with all the wheels specs.
		 */
		
		String stringWheels = " ";
		// Loop over every wheel.
		for (Wheel wheel : wheels) {
			stringWheels += wheel.getBrand(); // Adding brand to string
			stringWheels += "/" + wheel.getDiameter() + " "; // Adding diameter
			
		}
		return stringWheels;
	}

	@Override
	public String toString() {
		return "Vehicle [ plate=" + plate + ", brand=" + brand + ", color=" + color + ", wheels=" + stringOfWheels() + "]";
	}
	
	
}
