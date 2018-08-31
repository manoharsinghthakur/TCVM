package com.java.TCVM;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.*;

import com.java.TCVM.controller.ContainerInitializer;
import com.java.TCVM.service.DrinkAvailability;
import com.java.TCVM.service.availabilityImpl.BlackCoffeeAvailability;
import com.java.TCVM.service.availabilityImpl.BlackTeaAvailability;
import com.java.TCVM.service.availabilityImpl.CoffeeAvailability;
import com.java.TCVM.service.availabilityImpl.TeaAvailability;
import com.java.TCVM.service.makeImpl.MakeTea;;


@RunWith(MockitoJUnitRunner.class)
public class TCVMTest {

	@InjectMocks
	ContainerInitializer containerInitializer;
	
	@Mock
	DrinkAvailability drinkAvailability; 
	
	@Test
	public void shouldHaveContainerWithMaximumCapicity() throws IOException{
		
		Assert.assertNotNull(containerInitializer.getContainerInstance().getTeaContainer());
		Assert.assertNotNull( containerInitializer.getContainerInstance().getCoffeeContainer());
		Assert.assertNotNull(containerInitializer.getContainerInstance().getSugerContaier());
		Assert.assertNotNull( containerInitializer.getContainerInstance().getWaterContainer());
		Assert.assertNotNull( containerInitializer.getContainerInstance().getMilkContainer());
	}

	@Test
	public void shouldContainersFilledWithNeededMaterialForMakingDrink() throws IOException{
		DrinkAvailability teaAvailability = new TeaAvailability();
		DrinkAvailability coffeeAvailability = new CoffeeAvailability();
		DrinkAvailability blackteaAvailability =  new BlackTeaAvailability();
		DrinkAvailability blackCoffeeAvailability = new BlackCoffeeAvailability();

		Assert.assertTrue(teaAvailability.checkAvailabilityNeededForDrink(2));
		Assert.assertTrue(coffeeAvailability.checkAvailabilityNeededForDrink(2));
		Assert.assertTrue(blackteaAvailability.checkAvailabilityNeededForDrink(4));
		Assert.assertTrue(blackCoffeeAvailability.checkAvailabilityNeededForDrink(1));
		Assert.assertFalse(teaAvailability.checkAvailabilityNeededForDrink(200000));
		Assert.assertFalse(coffeeAvailability.checkAvailabilityNeededForDrink(200000));
		Assert.assertFalse(blackteaAvailability.checkAvailabilityNeededForDrink(200000));
		Assert.assertFalse(blackCoffeeAvailability.checkAvailabilityNeededForDrink(200000));

	}
	
}
