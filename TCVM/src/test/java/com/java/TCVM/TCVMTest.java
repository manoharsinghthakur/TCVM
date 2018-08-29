package com.java.TCVM;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.java.TCVM.controller.ContainerInitializer;
import com.java.TCVM.data.Container;
import com.java.TCVM.data.Product;
import com.java.TCVM.service.DrinkAvailability;
import com.java.TCVM.service.MakeDrink;
import com.java.TCVM.service.ProductRecord;
import com.java.TCVM.service.RefillContainer;
import com.java.TCVM.service.TotalSale;
import com.java.TCVM.service.availabilityImpl.BlackCoffeeAvailability;
import com.java.TCVM.service.availabilityImpl.BlackTeaAvailability;
import com.java.TCVM.service.availabilityImpl.CoffeeAvailability;
import com.java.TCVM.service.availabilityImpl.TeaAvailability;
import com.java.TCVM.service.makeImpl.MakeCoffee;
import com.java.TCVM.service.makeImpl.MakeTea;;

@RunWith(MockitoJUnitRunner.class)
public class TCVMTest {

	@InjectMocks
	ContainerInitializer containerInitializer;
	
	@Mock
	MakeDrink makeTea;
	
	@Mock
	MakeCoffee makeCoffee;
	
	@Mock
	MakeCoffee makeBlackCoffee;
	
	@Mock
	MakeDrink makeBlackTea;
	
	@Mock
	TotalSale totalSale;
	
	@Mock
	RefillContainer refillContainer;
		
	public static DrinkAvailability getInstanceTeaAvailability(){
		return new TeaAvailability();
	}
	public static DrinkAvailability getInstanceCoffeeAvailability(){
		return new CoffeeAvailability();
	}
	public static DrinkAvailability getInstanceBlackTeaAvailability(){
		return new BlackTeaAvailability();
	}
	public static DrinkAvailability getInstanceBlackCoffeeAvailability(){
		return new BlackCoffeeAvailability();
	}
	@Ignore
	@Test
	public void shouldHaveContainerWithMaximumCapicity() throws IOException{
		
		Assert.assertEquals(2000, containerInitializer.getContainerInstance().getCoffeeContainer());
		Assert.assertEquals(15000, containerInitializer.getContainerInstance().getWaterContainer());
	}
	
	@Test
	public void shouldContainersFilledWithNeededMaterialForMakingDrink() throws IOException{
		DrinkAvailability teaAvailability = getInstanceTeaAvailability();
		DrinkAvailability coffeeAvailability = getInstanceTeaAvailability();
		DrinkAvailability blackteaAvailability = getInstanceTeaAvailability();
		DrinkAvailability blackCoffeeAvailability = getInstanceTeaAvailability();

		Assert.assertTrue(teaAvailability.checkAvailabilityNeededForDrink(2));
		Assert.assertTrue(coffeeAvailability.checkAvailabilityNeededForDrink(2));
		Assert.assertTrue(blackteaAvailability.checkAvailabilityNeededForDrink(4));
		Assert.assertTrue(blackCoffeeAvailability.checkAvailabilityNeededForDrink(1));
		Assert.assertFalse(teaAvailability.checkAvailabilityNeededForDrink(200000));
	}
	
	@Test
	public void shouldSystemSupportToMakeTea() throws IOException{
		
		makeTea.makingDrink(2);
		Mockito.verify(makeTea).makingDrink(2);
	}

	@Test
	public void shouldSystemSupportToMakeCoffee() throws IOException{
		makeCoffee.makingDrink(2);
		Mockito.verify(makeCoffee).makingDrink(2);
	}

	@Test
	public void shouldSystemSupportToMakeBlackTea() throws IOException{
		makeBlackTea.makingDrink(2);
		Mockito.verify(makeBlackTea).makingDrink(2);
	}
	
	@Test
	public void shouldSystemSupportToMakeBlackCoffee() throws IOException{
		makeBlackCoffee.makingDrink(2);
		Mockito.verify(makeBlackCoffee).makingDrink(2);
	}
	
	@Test
	public void shouldSystemSupportRefillContainer() throws IOException{
		//RefillContainer refillContainer = new RefillContainer();
		
		refillContainer.refillContainer(1);
		Assert.assertEquals(2000, new ContainerInitializer().getContainerInstance().getTeaContainer());
	}
	
	@Test
	public void shouldSystemCheckTotalSale(){
		TotalSale totalSale = new TotalSale();
		ProductRecord productRecord = new ProductRecord();
		productRecord.AddProductInList(new Product("tea",1,10));
		
		totalSale.productTotalSale();
		//Mockito.verify(totalSale).productTotalSale();
	}
}
