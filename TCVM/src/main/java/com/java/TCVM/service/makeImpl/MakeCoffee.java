package com.java.TCVM.service.makeImpl;

import java.io.IOException;
import java.util.Scanner;

import com.java.TCVM.controller.ContainerInitializer;
import com.java.TCVM.data.Container;
import com.java.TCVM.data.Product;
import com.java.TCVM.service.DrinkAvailability;
import com.java.TCVM.service.MakeDrink;
import com.java.TCVM.service.ProductRecord;
import com.java.TCVM.service.WasteProductRecord;
import com.java.TCVM.service.availabilityImpl.CoffeeAvailability;

public class MakeCoffee implements MakeDrink{
	final static int COFFEE_PRICE = 15;
	final static int COFFEE = 4;
	final static int WATER = 20;
	final static int MILK = 80;
	final static int SUGAR = 15;
	final static int WASTE_COFFEE = 1;
	final static int WASTE_WATER = 3;
	final static int WASTE_MILK = 8;
	final static int WASTE_SUGAR = 2;
	
	static ContainerInitializer containerInitializer = new ContainerInitializer();
	private ProductRecord productRecord = new ProductRecord();
	private WasteProductRecord wasteproductRecord = new WasteProductRecord();
	private DrinkAvailability drinkAvailability = new CoffeeAvailability();

	@Override
	public void makingDrink(int quantity) throws IOException {
		if(!drinkAvailability.checkAvailabilityNeededForDrink(quantity)){
			throw new RuntimeException("No Enough Material Available");
		}
		else{
		int coffeeAvailableQuantity = containerInitializer.getContainerInstance().getCoffeeContainer();
		int waterAvailableQuantity = containerInitializer.getContainerInstance().getWaterContainer();
		int milkAvailableQuantity = containerInitializer.getContainerInstance().getMilkContainer();
		int sugarAvailableQuantity = containerInitializer.getContainerInstance().getSugerContaier();
		
		UpdateQuantity(quantity, coffeeAvailableQuantity, waterAvailableQuantity, milkAvailableQuantity, sugarAvailableQuantity);
		productRecord.AddProductInList(new Product("coffee",quantity,quantity*COFFEE_PRICE));
		wasteproductRecord.AddWasteProductInList(new Container( 0,WASTE_COFFEE*quantity, WASTE_SUGAR*quantity, WASTE_WATER*quantity, WASTE_MILK*quantity));

		System.out.println(quantity+" cup tea "+ quantity+"*"+COFFEE_PRICE+" = "+quantity*COFFEE_PRICE);
		}
	}
	public void UpdateQuantity(int quantity, int coffeeAvailableQuantity, int waterAvailableQuantity, int milkAvailableQuantity, int sugarAvailableQuantity) throws IOException{
		
		int remainingCoffeeQuantity = substractQuantity(coffeeAvailableQuantity, COFFEE*quantity);
		int remainingWaterQuantity = substractQuantity(waterAvailableQuantity,WATER*quantity);
		int remainingMilkQuantity = substractQuantity(milkAvailableQuantity,MILK*quantity);
		int remainingSugarQuantity = substractQuantity(sugarAvailableQuantity,SUGAR*quantity);
	
		containerInitializer.getContainerInstance().setCoffeeContainer(remainingCoffeeQuantity);
		containerInitializer.getContainerInstance().setWaterContainer(remainingWaterQuantity);
		containerInitializer.getContainerInstance().setMilkContainer(remainingMilkQuantity);
		containerInitializer.getContainerInstance().setSugerContaier(remainingSugarQuantity);
	}
	
	public int substractQuantity(int availableQuantity, int usedQuantity){
		return availableQuantity-usedQuantity;
	}

}
