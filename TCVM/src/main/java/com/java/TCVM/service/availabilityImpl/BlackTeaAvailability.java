package com.java.TCVM.service.availabilityImpl;

import java.io.IOException;

import com.java.TCVM.controller.ContainerInitializer;
import com.java.TCVM.service.DrinkAvailability;

public class BlackTeaAvailability implements DrinkAvailability {

	@Override
	public boolean checkAvailabilityNeededForDrink(int quantity) throws IOException {
		final int TEA = 3;
		final int WATER = 100;
		final int SUGAR = 2;
		ContainerInitializer containerInitializer = new ContainerInitializer();
		int teaQuantity = containerInitializer.getContainerInstance().getTeaContainer();
		int waterQuantity = containerInitializer.getContainerInstance().getWaterContainer();
		int sugarQuantity = containerInitializer.getContainerInstance().getSugerContaier();
		
		if(quantity*TEA < teaQuantity && quantity*WATER < waterQuantity && quantity*SUGAR < sugarQuantity)
		return true;
		
		return false;
	}

}
