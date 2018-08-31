package com.java.TCVM.service;

import java.util.ArrayList;
import java.util.List;

import com.java.TCVM.data.Product;

public class ProductRecord { 

	private static List<Product> list ;
	private List<Product> getProductArrayList(){
		if(list == null){
			list = new ArrayList<Product>();
			list.add(new Product("tea", 0, 0));
			list.add(new Product("coffee", 0, 0));
			list.add(new Product("black tea", 0, 0));
			list.add(new Product("black coffee", 0, 0));
		}
		return list;
	}
	
	public void AddProductInList(Product product){
		
		getProductArrayList().add(product);
	}
	
	public List<Product> getProductList(){
		return getProductArrayList();
	}
}
