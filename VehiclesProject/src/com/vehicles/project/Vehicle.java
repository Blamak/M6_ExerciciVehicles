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
	
	
}
