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
	
	public String stringListWheels() {
		/* 
		 * Method to create and return a string with the specs of the wheels.
		 */
		
		String stringWheels = " ";
		for (Wheel wheel : wheels) {
			stringWheels += wheel.getBrand();
			stringWheels += "/" + wheel.getDiameter() + " ";
			
		}
		return stringWheels;
	}

	@Override
	public String toString() {
		return "Vehicle [ plate=" + plate + ", brand=" + brand + ", color=" + color + ", wheels=" + stringListWheels() + "]";
	}
	

	// Method turned into abstract to force all child classes to implement it.
	public abstract void addWheels(List<Wheel> frontWheels, List<Wheel> backWheels) throws Exception;
}
