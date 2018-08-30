package com.java.TCVM.service;

import java.io.IOException;

import com.java.TCVM.controller.ContainerInitializer;
import com.java.TCVM.controller.TCVMMenu;
import com.java.TCVM.data.Container;

public class ContainerStatus {
	InputScanner scanner;
	
	public ContainerStatus() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public ContainerStatus(InputScanner scanner) {
		super();
		this.scanner = scanner;
	}



	public void showContainerStatus() throws IOException{
		//InputScanner scanner;// = new InputScanner();
		
		Container container = new ContainerInitializer().getContainerInstance();
		System.out.println("Container Status......");
		System.out.println("Tea = "+container.getTeaContainer()+"\nCoffee = "+container.getCoffeeContainer()+"\nWater = "+container.getWaterContainer()+"\nMilk = "+container.getMilkContainer()+"\nSugar = "+container.getSugerContaier()+"\n");
		Integer number = scanner.nextInt();
		if(number==0){
			new  TCVMMenu().showMenu();
		}
		
	}
}
 
