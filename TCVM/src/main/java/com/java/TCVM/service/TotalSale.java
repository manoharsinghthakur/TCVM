package com.java.TCVM.service;

public class TotalSale {
		ProductRecord	productRecord = new ProductRecord(); 
		public void productTotalSale(){
			int totalTeaSaleQuantity = productRecord.getProductList().stream().filter(product->product.getProductName().equals("tea")).map(product->product.getQuantity()).reduce(Integer::sum).get();
			int totalCoffeeSaleQuantity = productRecord.getProductList().stream().filter(product->product.getProductName().equals("coffee")).map(product->product.getQuantity()).reduce(Integer::sum).get();
			int totalBlackTeaSaleQuantity = productRecord.getProductList().stream().filter(product->product.getProductName().equals("black tea")).map(product->product.getQuantity()).reduce(Integer::sum).get();
			int totalBlackCoffeeSaleQuantity = productRecord.getProductList().stream().filter(product->product.getProductName().equals("black coffee")).map(product->product.getQuantity()).reduce(Integer::sum).get();
			int totalTeaSalePrice= productRecord.getProductList().stream().filter(product->product.getProductName().equals("tea")).map(product->product.getPrice()).reduce(Integer::sum).get();
		 	int totalCoffeeSalePrice= productRecord.getProductList().stream().filter(product->product.getProductName().equals("coffee")).map(product->product.getPrice()).reduce(Integer::sum).get();
			int totalBlackTeaSalePrice= productRecord.getProductList().stream().filter(product->product.getProductName().equals("black tea")).map(product->product.getPrice()).reduce(Integer::sum).get();
			int totalBlackCoffeeSalePrice= productRecord.getProductList().stream().filter(product->product.getProductName().equals("black coffee")).map(product->product.getPrice()).reduce(Integer::sum).get();
			int totalSalePrice = productRecord.getProductList().stream().map(product->product.getPrice()).reduce(Integer::sum).get();
			
			System.out.println("Total Tea quantity = "+totalTeaSaleQuantity+", price = "+totalTeaSaleQuantity);
			System.out.println("Total coffee quantity = "+totalCoffeeSaleQuantity+", price = "+totalCoffeeSalePrice);
			System.out.println("Total black Tea quantity = "+totalBlackTeaSaleQuantity+", price = "+totalBlackTeaSalePrice);
			System.out.println("Total black coffee quantity = "+totalBlackCoffeeSaleQuantity+", price = "+totalBlackCoffeeSalePrice);
			System.out.println("Total All Product Sell price = "+totalSalePrice);

		//	productRecord.getProductList().forEach(System.out::println);
			
		}
}
