package com.java.TCVM.service;

import java.util.ArrayList;
import java.util.List;

import com.java.TCVM.data.Container;

public class WasteProductRecord {
	 List<Container> wasteProductList = new ArrayList();
	public void addWasteProductInList(Container container){
		wasteProductList.add(container);
	}
	
	
	public List<Container> getWasteProductList(){
		return wasteProductList;
	}

}
