package com.java.TCVM.controller;

import java.io.IOException;
import java.util.Scanner;

import com.java.TCVM.service.MakeDrink;
import com.java.TCVM.service.makeImpl.MakeBlackCoffee;
import com.java.TCVM.service.makeImpl.MakeBlackTea;
import com.java.TCVM.service.makeImpl.MakeCoffee;
import com.java.TCVM.service.makeImpl.MakeTea;

public class TCVMMenu {
	private int getQuantity(){
		Scanner scanner1 = new Scanner(System.in);
		System.out.println("Please Enter Quantity");
		return scanner1.nextInt();
	}
	
	public void showMenu() throws IOException{
		MakeDrink makeDrink;
		System.out.println("WELCOME TO TEA COFFEE VENDING MACHINE....");
		System.out.println("press 1 for TEA , 2 for COFFEE , 3 for BLACK TEA , 4 for BLACK COFFEE , 5 for REFILL CONTAINER, 6 for TOTAL SALE, 7 for CONTAINER STATUS, 8 for EXIT TCVM..");
		
		Scanner scanner = new Scanner(System.in);
		int choiceInput = scanner.nextInt();
		
		switch(choiceInput){
		case 1:
			System.out.println("You are selecting Tea");
			makeDrink = new MakeTea();
			makeDrink.makingDrink(getQuantity());
			break;
			
		case 2:
			makeDrink = new MakeCoffee();
			makeDrink.makingDrink(getQuantity());
			break;
			
		case 3:
			makeDrink = new MakeBlackTea();
			makeDrink.makingDrink(getQuantity());
			break;
			
		case 4:
			makeDrink = new MakeBlackCoffee();
			makeDrink.makingDrink(getQuantity());
			break;	
			
		case 5:
			
			break;	
		}
		
	}
}
