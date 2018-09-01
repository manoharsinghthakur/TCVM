package com.java.TCVM.service;

import java.io.IOException;

import com.java.TCVM.controller.ContainerInitializer;
import com.java.TCVM.data.Container;

public class ResetContainer {
	public boolean resetingContainer() throws IOException{
		Container container = new ContainerInitializer().getContainerInstance();
		container.setTeaContainer(2000);
		container.setCoffeeContainer(2000);
		container.setSugerContaier(8000);
		container.setWaterContainer(15000);
		container.setMilkContainer(10000);
		System.out.println("container is reset");
		return true;
	}
}
