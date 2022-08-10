package com.dao;

import java.util.ArrayList;

import com.vo.Product;

public class ProductRepository {
	private ArrayList<Product> listOfProducts = new ArrayList<>();
	private static  ProductRepository instance = new ProductRepository();
	
	private ProductRepository() {
		Product phone = new Product("P1234","iPhone 6s", 800000);
		phone.setDescription("4.7-inch 1334x750 Retina HD Display//8-MegaPixel iSight Camera");
		phone.setCondition("Smart Phome");
		phone.setMenufacturer("Apple");
		phone.setUnitsInStock(1000L);
		phone.setCondition("new");
		phone.setFilename("P1234.png");
		
		Product notebook = new Product("P1235","LG PC 그램", 1500000);
		notebook.setDescription("13.3-inch, IPS LED Display//5rd Generation Intel Core Processor");
		notebook.setCondition("Notebook");
		notebook.setMenufacturer("LG");
		notebook.setUnitsInStock(1000L);
		notebook.setCondition("Refurbished");
		notebook.setFilename("P1235.png");
		
		Product tablet = new Product("P1236","Galaxy Tab5", 600000);
		tablet.setDescription("212.8*125.6*6.6mm//SuperAMOLED Display//Octa-Core Processor");
		tablet.setCondition("Tablet");
		tablet.setMenufacturer("Samsung");
		tablet.setUnitsInStock(1000L);
		tablet.setCondition("Old");
		tablet.setFilename("P1236.png");
		
		listOfProducts.add(phone);
		listOfProducts.add(notebook);
		listOfProducts.add(tablet);
	}
	
	private static class Holder {
		public static final ProductRepository INSTANCE = new ProductRepository();
	}
	
	public static ProductRepository getInstance() {
		return Holder.INSTANCE;
	}
	
	public void addProduct(Product product) {
		listOfProducts.add(product);
	}
	
	public ArrayList<Product> getAllProducts() {
		return listOfProducts;
	}
	
	public Product getProductById(String productId) {
		Product product = null;
		for(Product listProduct:listOfProducts) {
			if(listProduct.getpName().equals(productId)) {
				product = listProduct;
				break;
			}
		}
		return product;
	}
}
