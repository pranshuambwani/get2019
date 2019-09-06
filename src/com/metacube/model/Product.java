package com.metacube.model;

public class Product {
	String productCode, type, name;
	int price;

	public Product(String productCode, String type, String name, int price) {
		this.productCode = productCode;
		this.name = name;
		this.price = price;
		this.type = type;
	}

	public String getProductCode() {
		return productCode;
	}

	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}
}