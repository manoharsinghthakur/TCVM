package com.java.TCVM.service;

import java.io.IOException;

public interface DrinkAvailability {
	public boolean checkAvailabilityNeededForDrink(int quantity) throws IOException;
}
