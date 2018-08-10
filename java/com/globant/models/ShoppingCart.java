package com.globant.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Shopping cart for a given user.
 * 
 * @author Yael Salim
 *
 */
@Document(collection = "shoppingCart")
public class ShoppingCart {

	@Id
	private String id;

	private List<Product> productList;

	@Indexed(unique = true)
	private String userName;

	public ShoppingCart(String userName) {

		this.userName = userName;
		this.productList = new ArrayList<Product>();
	}

	public String getUserName() {
		return userName;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	/**
	 * Adds an item to the cart
	 * 
	 * @param productItem
	 */
	public void addItemToCart(Product productItem) {

		if (!productList.contains(productItem)) {

			productList.add(productItem);

		}
	}

	/**
	 * Deletes an item from the cart
	 * 
	 * @param productItem
	 */
	public void deleteItemFromCart(Product productItem) {

		if (productList.contains(productItem)) {

			productList.remove(productItem);

		} else {

			System.out.println("The selected product does not exists in the cart.");

		}

	}

	/**
	 * Returns the total cost of the items from the
	 * shopping-cart.
	 * 
	 * @return cost
	 */

	public Float buyProducts() {
		Float cost = (float) 0.0;
		for (Product product : productList) {
			cost += product.getUnitPrice()* product.getQuantity();
		}
		return cost;
	}

	/**
	 * Returns the size of the shopping-cart.
	 * 
	 * @return integer
	 */

	public int getCartSize() {
		return productList.size();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
