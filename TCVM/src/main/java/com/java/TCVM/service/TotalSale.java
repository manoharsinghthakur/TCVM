package com.java.TCVM.service;

import java.io.IOException;
import java.util.logging.Logger;

import com.java.TCVM.controller.TCVMMenu;

public class TotalSale {
	
		 ProductRecord productRecord;
		 Logger logger;
		
		
		public TotalSale(ProductRecord productRecord,Logger logger) {
			super();
			this.productRecord = productRecord;
			this.logger = logger;
		}

		public TotalSale() {
			super();
			productRecord =new  ProductRecord();
		}
		
		public void productTotalSale() throws IOException{
			
			int totalTeaSaleQuantity = productRecord.getProductList().stream().filter(product->product.getProductName().equals("tea")).map(product->product.getQuantity()).reduce(Integer::sum).get();
			int totalCoffeeSaleQuantity = productRecord.getProductList().stream().filter(product->product.getProductName().equals("coffee")).map(product->product.getQuantity()).reduce(Integer::sum).get();
			int totalBlackTeaSaleQuantity = productRecord.getProductList().stream().filter(product->product.getProductName().equals("black tea")).map(product->product.getQuantity()).reduce(Integer::sum).get();
	 		int totalBlackCoffeeSaleQuantity = productRecord.getProductList().stream().filter(product->product.getProductName().equals("black coffee")).map(product->product.getQuantity()).reduce(Integer::sum).get();
			int totalTeaSalePrice= productRecord.getProductList().stream().filter(product->product.getProductName().equals("tea")).map(product->product.getPrice()).reduce(Integer::sum).get();
		 	int totalCoffeeSalePrice= productRecord.getProductList().stream().filter(product->product.getProductName().equals("coffee")).map(product->product.getPrice()).reduce(Integer::sum).get();
			int totalBlackTeaSalePrice= productRecord.getProductList().stream().filter(product->product.getProductName().equals("black tea")).map(product->product.getPrice()).reduce(Integer::sum).get();
	 		int totalBlackCoffeeSalePrice= productRecord.getProductList().stream().filter(product->product.getProductName().equals("black coffee")).map(product->product.getPrice()).reduce(Integer::sum).get();
			int totalSalePrice = productRecord.getProductList().stream().map(product->product.getPrice()).reduce(Integer::sum).get();
			
			logger.info("Total Tea quantity = "+totalTeaSaleQuantity+", price = "+totalTeaSalePrice);
			logger.info("Total coffee quantity = "+totalCoffeeSaleQuantity+", price = "+totalCoffeeSalePrice);
			logger.info("Total black Tea quantity = "+totalBlackTeaSaleQuantity+", price = "+totalBlackTeaSalePrice);
			logger.info("Total black coffee quantity = "+totalBlackCoffeeSaleQuantity+", price = "+totalBlackCoffeeSalePrice);
			logger.info("Total All Product Sell price = "+totalSalePrice);

		//	productRecord.getProductList().forEach(System.out::println);
			
		}
}
