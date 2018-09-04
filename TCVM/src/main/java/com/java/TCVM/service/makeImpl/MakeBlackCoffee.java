package com.java.TCVM.service.makeImpl;

import java.io.IOException;

import com.java.TCVM.controller.ContainerInitializer;
import com.java.TCVM.data.Container;
import com.java.TCVM.data.Product;
import com.java.TCVM.data.ProductRecord;
import com.java.TCVM.data.WasteProductRecord;
import com.java.TCVM.service.MakeDrink;

public class MakeBlackCoffee implements MakeDrink{
	final static  int BLACK_COFFEE_PRICE = 10;
	final static int COFFEE = 3;
	final static int WATER = 100;
	final static int SUGAR = 15;
	final static int WASTE_COFFEE = 0;
	final static int WASTE_WATER = 12;
	final static int WASTE_SUGAR = 2;
	
	private ContainerInitializer containerInitializer;
	private ProductRecord productRecord;
	private WasteProductRecord wasteproductRecord;
	
	public MakeBlackCoffee(ContainerInitializer containerInitializer, ProductRecord productRecord,
			WasteProductRecord wasteproductRecord) {
		super();
		this.containerInitializer = containerInitializer;
		this.productRecord = productRecord;
		this.wasteproductRecord = wasteproductRecord;
	}


	@Override
	public void makingDrink(int quantity) throws IOException {
		int coffeeAvailableQuantity = containerInitializer.getContainerInstance().getCoffeeContainer();
		int waterAvailableQuantity = containerInitializer.getContainerInstance().getWaterContainer();
		int sugarAvailableQuantity = containerInitializer.getContainerInstance().getSugerContaier();
		
		UpdateQuantity(quantity, coffeeAvailableQuantity, waterAvailableQuantity, sugarAvailableQuantity);
		productRecord.addProductInList(new Product("black coffee",quantity,quantity*BLACK_COFFEE_PRICE));
		wasteproductRecord.addWasteProductInList(new Container( 0,WASTE_COFFEE*quantity, WASTE_SUGAR*quantity, WASTE_WATER*quantity,0));
	 	System.out.println("Your Bill is...");
		System.out.println(quantity+" cup tea "+ quantity+"*"+BLACK_COFFEE_PRICE+" = "+quantity*BLACK_COFFEE_PRICE);
		System.out.println("Black coffee is ready\n");
	}
	public void UpdateQuantity(int quantity, int coffeeAvailableQuantity, int waterAvailableQuantity, int sugarAvailableQuantity) throws IOException{
		
		int remainingCoffeeQuantity = substractQuantity(coffeeAvailableQuantity, COFFEE*quantity);
	 	int remainingWaterQuantity = substractQuantity(waterAvailableQuantity,WATER*quantity);
		int remainingSugarQuantity = substractQuantity(sugarAvailableQuantity,SUGAR*quantity);
	
		containerInitializer.getContainerInstance().setCoffeeContainer(remainingCoffeeQuantity);
		containerInitializer.getContainerInstance().setWaterContainer(remainingWaterQuantity);
		containerInitializer.getContainerInstance().setSugerContaier(remainingSugarQuantity);
	}
	
	public static  int substractQuantity(int availableQuantity, int usedQuantity){
	 	return availableQuantity-usedQuantity;
	}

}
