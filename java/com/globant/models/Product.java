package com.globant.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * This class models a product.
 * 
 * @author Yael Salim
 *
 */
@Document(collection = "product")
public class Product {
	@Id
	private String id;

	@Indexed(unique = true)
	private String name;

	private String category;

	private Integer quantity;

	private Double unitPrice;

	public Product() {
	}

	public Product(String name, String category, Integer quantity, Double unitPrice) {

		this.name = name;
		this.category = category;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		final Product other = (Product) obj;
		if (this.id == null ? other.id != null : !this.id.equals(other.id)) {
			return false;
		}
		return true;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
