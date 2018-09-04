package com.java.TCVM.data;

import java.util.ArrayList;
import java.util.List;

public class WasteProductRecord {
	 List<Container> wasteProductList = new ArrayList();
	public void addWasteProductInList(Container container){
		wasteProductList.add(container);
	}
	
	
	public List<Container> getWasteProductList(){
		return wasteProductList;
	}

}
