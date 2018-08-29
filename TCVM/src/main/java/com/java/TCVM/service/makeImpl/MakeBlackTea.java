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
import com.java.TCVM.service.availabilityImpl.BlackTeaAvailability;
import com.java.TCVM.service.availabilityImpl.CoffeeAvailability;

public class MakeBlackTea implements MakeDrink {

	final static int BLACK_TEA_PRICE = 5;
	final static int TEA = 3;
	final static int WATER = 100;
	final static int SUGAR = 15;
	final static int WASTE_TEA = 0;
	final static int WASTE_WATER = 12;
	final static int WASTE_SUGAR = 2;
	
	static ContainerInitializer containerInitializer = new ContainerInitializer();
	private ProductRecord productRecord = new ProductRecord();
	private WasteProductRecord wasteproductRecord = new WasteProductRecord();
	private DrinkAvailability drinkAvailability = new BlackTeaAvailability();


	@Override
	public void makingDrink(int quantity) throws IOException {
		if(!drinkAvailability.checkAvailabilityNeededForDrink(quantity)){
			throw new RuntimeException("No Enough Material Available");
		}
		else{
		int teaAvailableQuantity = containerInitializer.getContainerInstance().getTeaContainer();
		int waterAvailableQuantity = containerInitializer.getContainerInstance().getWaterContainer();
		int sugarAvailableQuantity = containerInitializer.getContainerInstance().getSugerContaier();
		
		UpdateQuantity(quantity, teaAvailableQuantity, waterAvailableQuantity, sugarAvailableQuantity);
		productRecord.AddProductInList(new Product("black tea",quantity,quantity*BLACK_TEA_PRICE));
		wasteproductRecord.AddWasteProductInList(new Container( WASTE_TEA*quantity,0, WASTE_SUGAR*quantity, WASTE_WATER*quantity,0));

		System.out.println(quantity+" cup blak tea "+ quantity+"*"+BLACK_TEA_PRICE+" = "+quantity*BLACK_TEA_PRICE);
		}
	}
	public static void UpdateQuantity(int quantity, int teaAvailableQuantity, int waterAvailableQuantity, int sugarAvailableQuantity) throws IOException{
		
		int remainingCoffeeQuantity = substractQuantity(teaAvailableQuantity, TEA*quantity);
		int remainingWaterQuantity = substractQuantity(waterAvailableQuantity,WATER*quantity);
		int remainingSugarQuantity = substractQuantity(sugarAvailableQuantity,SUGAR*quantity);
	
		containerInitializer.getContainerInstance().setTeaContainer(teaAvailableQuantity);;
		containerInitializer.getContainerInstance().setWaterContainer(remainingWaterQuantity);
		containerInitializer.getContainerInstance().setSugerContaier(remainingSugarQuantity);
	}
	
	public static  int substractQuantity(int availableQuantity, int usedQuantity){
		return availableQuantity-usedQuantity;
	}

}
