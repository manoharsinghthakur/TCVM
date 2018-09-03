package com.java.TCVM.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.java.TCVM.data.Container;

public class ContainerInitializer {
	
	private static Container containerInstance;
	
	public Container getContainerInstance() throws IOException {
		Map<String, Integer> containerData = createContainerData();
		if(containerInstance==null){
		containerInstance = new Container(containerData.get("teaContainer"), containerData.get("coffeeContainer"),
				containerData.get("sugerContaier"), containerData.get("waterContainer"),containerData.get("milkContainer"));
		}
		return containerInstance;
	}

	public Map<String, Integer> createContainerData() {
		Map<String, Integer> containerData = new HashMap<String, Integer>();
		containerData.put("teaContainer", 2000);
		containerData.put("coffeeContainer", 2000);
		containerData.put("sugerContaier", 8000);
		containerData.put("waterContainer", 15000);
		containerData.put("milkContainer", 10000);
		return containerData;
	}

}
