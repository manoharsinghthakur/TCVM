package com.java.TCVM.service;

import java.io.IOException;

import com.java.TCVM.controller.ContainerInitializer;
import com.java.TCVM.controller.TCVMMenu;
import com.java.TCVM.data.Container;

public class RefillContainer {
	TCVMMenu tcvmMenu;// =new TCVMMenu();
	Container container = new Container();
	public Container getContainer() throws IOException{
		return new ContainerInitializer().getContainerInstance();
	}
	
	public void refillContainer(int input) throws IOException{ 
		switch(input){
		case 1:
			container.setTeaContainer(2000);
	 		System.out.println("tea container is filled\n");
		 	//new TCVMMenu().showMenu();
			break;
		case 2:
			container.setCoffeeContainer(2000);
			System.out.println("coffee container is filled\n");
			new TCVMMenu().showMenu();
			break;
		case 3:
			container.setSugerContaier(8000);
			System.out.println("sugar container is filled\n");
			new TCVMMenu().showMenu();
			break;
		case 4:
			container.setWaterContainer(15000);
			System.out.println("water container is filled\n");
			new TCVMMenu().showMenu();
			break;
		case 5:
			container.setMilkContainer(10000);
			System.out.println("milk container is filled\n");
			new TCVMMenu().showMenu();
			break;
		default:
			System.out.println("Exit from refilling");
			new TCVMMenu().showMenu();
		}
	}
}
