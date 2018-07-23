package com.globant.models;

/**
 * This class models a product.
 * 
 * @author Yael Salim
 *
 */

public class Product {

	private String name;
	private Integer quantity;
	private Double unitPrice;

	public Product(String name, Integer quantity, Double unitPrice) {

		this.name = name;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

}
