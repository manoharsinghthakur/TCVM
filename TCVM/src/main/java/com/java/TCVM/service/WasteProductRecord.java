package com.java.TCVM.service;

import java.util.ArrayList;
import java.util.List;

import com.java.TCVM.data.Container;

public class WasteProductRecord {
	List<Container> wasteProductList = new ArrayList();
	public void AddWasteProductInList(Container product){
		wasteProductList.add(product);
	}
	
	
	public List<Container> getWasteProductList(){
		return wasteProductList;
	}

}
