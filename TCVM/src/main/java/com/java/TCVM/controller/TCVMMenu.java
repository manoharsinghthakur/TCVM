package com.java.TCVM.controller;

import java.io.IOException;
import java.util.Scanner;

import com.java.TCVM.service.ContainerStatus;
import com.java.TCVM.service.InputScanner;
import com.java.TCVM.service.MakeDrink;
import com.java.TCVM.service.ProductRecord;
import com.java.TCVM.service.RefillContainer;
import com.java.TCVM.service.ResetContainer;
import com.java.TCVM.service.TotalSale;
import com.java.TCVM.service.WasteProductRecord;
import com.java.TCVM.service.availabilityImpl.TeaAvailability;
import com.java.TCVM.service.makeImpl.MakeBlackCoffee;
import com.java.TCVM.service.makeImpl.MakeBlackTea;
import com.java.TCVM.service.makeImpl.MakeCoffee;
import com.java.TCVM.service.makeImpl.MakeTea;

public class TCVMMenu {
	InputScanner inputScanner;
	MakeDrink makeDrink;
	public TCVMMenu() {
		// TODO Auto-generated constructor stub
	}
	
	
	public TCVMMenu(InputScanner inputScanner, MakeDrink makeDrink) {
		super();
		this.inputScanner = inputScanner;
		this.makeDrink = makeDrink;
	}


	public int getQuantity(){
		return inputScanner.nextInt();
	}
	
	public void showMenu() throws IOException{
		
		System.out.println("WELCOME TO TEA COFFEE VENDING MACHINE....");
		System.out.println("press 1 for TEA , 2 for COFFEE , 3 for BLACK TEA , 4 for BLACK COFFEE , 5 for REFILL CONTAINER, 6 for TOTAL SALE, 7 for CONTAINER STATUS, 8 for Reset Container , 9 for EXIT TCVM..");
		
		
		int choiceInput = inputScanner.nextInt();
		
		switch(choiceInput){
		case 1:
			System.out.println("You are selecting Tea");
			makeDrink = new MakeTea(new ContainerInitializer(), new ProductRecord(),new WasteProductRecord() , new TeaAvailability());
			System.out.println("Please Enter Quantity");
			makeDrink.makingDrink(getQuantity());
			System.out.println("Press 0 for main menu");
			int i = inputScanner.nextInt();
			if(i==0)
				showMenu();
			break;
			
		case 2:
			System.out.println("You are selecting Coffee");
			makeDrink = new MakeCoffee(); 
			System.out.println("Please Enter Quantity");
			makeDrink.makingDrink(getQuantity());
			break;
			
		case 3:
			System.out.println("You are selecting black Tea");
			makeDrink = new MakeBlackTea();
			System.out.println("Please Enter Quantity");
			makeDrink.makingDrink(getQuantity());
			break;
			
		case 4:
			System.out.println("You are selecting Black coffee");
			makeDrink = new MakeBlackCoffee();
			System.out.println("Please Enter Quantity");
			makeDrink.makingDrink(getQuantity());
			break;	
			
		case 5:
			System.out.println("you are selecting Refill container");
			System.out.println("Enter 1 for Tea, 2 for coffee, 3 for sugar, 4 for water , 5 for milk & press any key for main menu");
			new RefillContainer().refillContainer(getQuantity());
			break;	
		
		case 6:
			System.out.println("product total sale .....");
			new TotalSale().productTotalSale();	
			break;
		
		case 7:
			System.out.println("container status");
			new ContainerStatus().showContainerStatus();
			break;	
			
		case 8:
			new ResetContainer().resetingContainer();
			break;
			
		case 9:
			System.out.println("exit from TCVM");
			System.exit(0);
		}		
		
	}
}
