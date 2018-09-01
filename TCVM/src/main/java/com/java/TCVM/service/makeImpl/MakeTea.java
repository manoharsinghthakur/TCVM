package com.java.TCVM.service.makeImpl;

import java.io.IOException;

import com.java.TCVM.controller.ContainerInitializer;
import com.java.TCVM.data.Container;
import com.java.TCVM.data.Product;
import com.java.TCVM.service.DrinkAvailability;
import com.java.TCVM.service.MakeDrink;
import com.java.TCVM.service.ProductRecord;
import com.java.TCVM.service.WasteProductRecord;

public class MakeTea implements MakeDrink {
	final static int TEA_PRICE = 10;
	final static int TEA = 5;
	final static int WATER = 60;
	final static int MILK = 40;
	final static int SUGAR = 15;
	
	final static int WASTE_TEA = 1;
	final static int WASTE_WATER = 5;
	final static int WASTE_MILK = 4;
	final static int WASTE_SUGAR = 2;
	
	public ContainerInitializer containerInitializer;
	public ProductRecord productRecord;
 	public WasteProductRecord wasteproductRecord;
	public DrinkAvailability drinkAvailability;
	
	
	public MakeTea(ContainerInitializer containerInitializer, ProductRecord productRecord,
			WasteProductRecord wasteproductRecord) {
		super();
		this.containerInitializer = containerInitializer;
		this.productRecord = productRecord;
		this.wasteproductRecord = wasteproductRecord;
	}
	
	@Override
	public void makingDrink(int quantity) throws IOException {
			
			int teaAvailableQuantity = containerInitializer.getContainerInstance().getTeaContainer();
	 		int waterAvailableQuantity = containerInitializer.getContainerInstance().getWaterContainer();
			int milkAvailableQuantity = containerInitializer.getContainerInstance().getMilkContainer();
			int sugarAvailableQuantity = containerInitializer.getContainerInstance().getSugerContaier();
		  
			UpdateQuantity( quantity, teaAvailableQuantity, waterAvailableQuantity, milkAvailableQuantity, sugarAvailableQuantity);
			productRecord.addProductInList(new Product("tea",quantity,quantity*TEA_PRICE));
			wasteproductRecord.addWasteProductInList(new Container(WASTE_TEA*quantity, 0, WASTE_SUGAR*quantity, WASTE_WATER*quantity, WASTE_MILK*quantity));
			
			System.out.println("Your bill is..");
			System.out.println(quantity+" cup tea "+ quantity+"*"+TEA_PRICE+" = "+quantity*TEA_PRICE);
			System.out.println("tea is ready\n");
		}
	
	private void UpdateQuantity(int quantity, int teaAvailableQuantity, int waterAvailableQuantity, int milkAvailableQuantity, int sugarAvailableQuantity) throws IOException{
		
		int remainingTeaQuantity = substractQuantity(teaAvailableQuantity, TEA * quantity);
		int remainingWaterQuantity = substractQuantity(waterAvailableQuantity, WATER * quantity);
		int remainingMilkQuantity = substractQuantity(milkAvailableQuantity, MILK * quantity);
		int remainingSugarQuantity = substractQuantity(sugarAvailableQuantity, SUGAR * quantity);
	
		containerInitializer.getContainerInstance().setTeaContainer(remainingTeaQuantity);
		containerInitializer.getContainerInstance().setWaterContainer(remainingWaterQuantity);
		containerInitializer.getContainerInstance().setMilkContainer(remainingMilkQuantity);
		containerInitializer.getContainerInstance().setSugerContaier(remainingSugarQuantity);
	}
	
	private  int substractQuantity(int availableQuantity, int usedQuantity){
		return availableQuantity-usedQuantity;
	}
}
