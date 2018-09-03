package com.java.TCVM.controller;

import java.io.IOException;

import com.java.TCVM.service.ContainerStatus;
import com.java.TCVM.service.InputScanner;
import com.java.TCVM.service.RefillContainer;
import com.java.TCVM.service.ResetContainer;
import com.java.TCVM.service.TotalSale;
import com.java.TCVM.service.availabilityImpl.BlackCoffeeAvailability;
import com.java.TCVM.service.availabilityImpl.BlackTeaAvailability;
import com.java.TCVM.service.availabilityImpl.CoffeeAvailability;
import com.java.TCVM.service.availabilityImpl.TeaAvailability;
import com.java.TCVM.service.makeImpl.MakeBlackCoffee;
import com.java.TCVM.service.makeImpl.MakeBlackTea;
import com.java.TCVM.service.makeImpl.MakeCoffee;
import com.java.TCVM.service.makeImpl.MakeTea;

public class TCVMMenu {
	
	private InputScanner inputScanner;
	private MakeTea makeTea;
	private MakeCoffee makeCoffee;
	private MakeBlackTea makeBlackTea;
	private MakeBlackCoffee makeBlackCoffee;
	private TeaAvailability teaAvailability;
	private CoffeeAvailability coffeeAvailability;
	private BlackTeaAvailability blackTeaAvailability;
	private BlackCoffeeAvailability blackCoffeeAvailability;
	private RefillContainer refillContainer;
	private ContainerStatus containerStatus;
	private ResetContainer resetContainer;
	private TotalSale totalSale;


	public TCVMMenu(InputScanner inputScanner, MakeTea makeTea, MakeCoffee makeCoffee, MakeBlackTea makeBlackTea,
			MakeBlackCoffee makeBlackCoffee, TeaAvailability teaAvailability, CoffeeAvailability coffeeAvailability,
			BlackTeaAvailability blackTeaAvailability, BlackCoffeeAvailability blackCoffeeAvailability,
			RefillContainer refillContainer, ContainerStatus containerStatus, ResetContainer resetContainer,
			TotalSale totalSale) {
		super();
		this.inputScanner = inputScanner;
		this.makeTea = makeTea;
		this.makeCoffee = makeCoffee;
		this.makeBlackTea = makeBlackTea;
		this.makeBlackCoffee = makeBlackCoffee;
		this.teaAvailability = teaAvailability;
		this.coffeeAvailability = coffeeAvailability;
		this.blackTeaAvailability = blackTeaAvailability;
		this.blackCoffeeAvailability = blackCoffeeAvailability;
		this.refillContainer = refillContainer;
		this.containerStatus = containerStatus;
		this.resetContainer = resetContainer;
		this.totalSale = totalSale;
	}


	public int getQuantity(){
		return inputScanner.nextInt();
	}
	
	
	private void viewMenu() throws IOException{
		if(getQuantity()==0)
			showMenu();
	}
	
	public void showMenu() throws IOException{
		
		System.out.println("WELCOME TO TEA COFFEE VENDING MACHINE....");
	  	System.out.println("press 1 for TEA , 2 for COFFEE , 3 for BLACK TEA , 4 for BLACK COFFEE , 5 for REFILL CONTAINER, 6 for TOTAL SALE, 7 for CONTAINER STATUS, 8 for Reset Container , 9 for EXIT TCVM..");
		
		
		Integer choiceInput = inputScanner.nextInt();
		
		switch(choiceInput){ 
		case 1:
			System.out.println("You are selecting Tea");
			System.out.println("Please Enter Quantity");
			Integer quantity1= inputScanner.nextInt();//getQuantity();
			if(!teaAvailability.checkAvailabilityNeededForDrink(quantity1)){
				System.out.println("NO ENOUGH MATERIAL AVAILABLE..");
				System.out.println("Press 0 for main menu");
				viewMenu();
			}
			else{
				makeTea.makingDrink(quantity1);
				System.out.println("Press 0 for main menu");
				viewMenu();
				}
			break;
		
		case 2:
			System.out.println("You are selecting Coffee");
			System.out.println("Please Enter Quantity");
			Integer quantity2= getQuantity();
			if(!coffeeAvailability.checkAvailabilityNeededForDrink(quantity2)){
				System.out.println("NO ENOUGH MATERIAL AVAILABLE..");
				System.out.println("Press 0 for main menu");
				viewMenu();
	 		}
			else{
				makeCoffee.makingDrink(quantity2);
				System.out.println("Press 0 for main menu");
				viewMenu();
				}
			break;			
		case 3:
			System.out.println("You are selecting black Tea");
			System.out.println("Please Enter Quantity");
			Integer quantity3= getQuantity();
			if(!blackTeaAvailability.checkAvailabilityNeededForDrink(quantity3)){
				System.out.println("NO ENOUGH MATERIAL AVAILABLE..");
				System.out.println("Press 0 for main menu");
				viewMenu();
			}
			else{
				makeBlackTea.makingDrink(quantity3);
				System.out.println("Press 0 for main menu");
				viewMenu();
				}
			break;
		case 4:
			System.out.println("You are selecting Black coffee");
			System.out.println("Please Enter Quantity");
			Integer quantity4= getQuantity();
			if(!blackCoffeeAvailability.checkAvailabilityNeededForDrink(quantity4)){
				System.out.println("NO ENOUGH MATERIAL AVAILABLE..");
				System.out.println("Press 0 for main menu");
				viewMenu();
			}
			else{
				makeBlackCoffee.makingDrink(quantity4);
				System.out.println("Press 0 for main menu");
				viewMenu();
				}
			break;	
			
		case 5:
			System.out.println("you are selecting Refill container");
			System.out.println("Enter 1 for Tea, 2 for coffee, 3 for sugar, 4 for water , 5 for milk & press any key for main menu");
			refillContainer.refillContainer(getQuantity());
			System.out.println("Press 0 for main menu");
			viewMenu();
			break;	
		
		case 6:
			System.out.println("product total sale .....");
			totalSale.productTotalSale();	
			System.out.println("Press 0 for main menu");
			viewMenu();
			break;
		
		case 7:
			System.out.println("container status");
			containerStatus.showContainerStatus();
			System.out.println("Press 0 for main menu");
			viewMenu();
			break;	
			
		case 8:
			resetContainer.resetingContainer();
			System.out.println("Press 0 for main menu");
			viewMenu();
			break;
			
		default:
			System.out.println("exit from TCVM");
			System.exit(0);
		}		
	}
}
