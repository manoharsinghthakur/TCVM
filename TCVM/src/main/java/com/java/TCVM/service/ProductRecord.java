package com.java.TCVM.service;

import java.util.ArrayList;
import java.util.List;

import com.java.TCVM.data.Product;

public class ProductRecord {
	List<Product> productList = new ArrayList();
	public void AddProductInList(Product product){
		productList.add(product);
	}
	
	public List<Product> getProductList(){
		return productList;
	}
}
