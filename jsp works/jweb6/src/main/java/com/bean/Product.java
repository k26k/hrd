package com.bean;

import java.io.Serializable;

public class Product implements Serializable{
	private static final long serialVersionUID = 1L;
	private String[] productList = new String[] {"수박","참외","포도","토마토"}; 
	private int num1 = 10;
	private int num2 = 20;
	
	public String[] getProductList() {
		return productList;
	}
	public int getNum1() {
		return num1;
	}
	public int getNum2() {
		return num2;
	}
}
