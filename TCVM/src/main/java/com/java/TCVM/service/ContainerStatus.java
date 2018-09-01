package com.java.TCVM.service;

import java.io.IOException;

import com.java.TCVM.controller.ContainerInitializer;
import com.java.TCVM.data.Container;

public class ContainerStatus {
	
	public Boolean showContainerStatus() throws IOException{
		Container container = new ContainerInitializer().getContainerInstance();
		System.out.println("Container Status......");
		System.out.println("Tea = "+container.getTeaContainer()+"\nCoffee = "+container.getCoffeeContainer()+"\nWater = "+container.getWaterContainer()+"\nMilk = "+container.getMilkContainer()+"\nSugar = "+container.getSugerContaier()+"\n");
		return true;
	} 
}
 
