package com.java.TCVM.service;

import com.java.TCVM.data.Container;

public class RefillContainer {
	Container container = new Container();
	public void refillContainer(int input){
		switch(input){
		case 1:
			container.setTeaContainer(2000);
			break;
		case 2:
			container.setCoffeeContainer(2000);
			break;
		case 3:
			container.setSugerContaier(8000);
			break;
		case 4:
			container.setWaterContainer(15000);
			break;
		case 5:
			container.setMilkContainer(10000);
			break;
		default:
			System.out.println(input+" is wrong choice");
		}
	}
}
