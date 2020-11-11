package com.vehicles.project;

import java.util.List;

public class Bike extends Vehicle {

	public Bike(String plate, String brand, String color) {
		super(plate, brand, color);
	}
	
	public void addWheels(List<Wheel> frontWheels, List<Wheel> backWheels) throws Exception {
		// For bikes there is only one wheel in each list.
		if (frontWheels.size() != 1 || backWheels.size() != 1) {
			throw new Exception();
		}

		Wheel frontWheel = frontWheels.get(0);
		Wheel backWheel = backWheels.get(0);

		this.wheels.add(frontWheel);
		this.wheels.add(backWheel);
	}

}
