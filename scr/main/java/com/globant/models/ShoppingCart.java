package com.globant.models;

import java.util.HashMap;
import java.util.Map;

/**
 * This class models a shopping cart for a given user.
 * 
 * @author Yael Salim
 *
 */
public class ShoppingCart {

	private Map<Product, Integer> productList;
	private String userName;

	public ShoppingCart(String userName) {

		this.userName = userName;
		this.productList = new HashMap<Product, Integer>();
	}

	public String getUserName() {
		return userName;
	}

	public Map<Product, Integer> getProductList() {
		return productList;
	}

	public void setProductList(Map<Product, Integer> productList) {
		this.productList = productList;
	}

	/**
	 * This method adds an item to the cart
	 * 
	 * @param productItem
	 */
	public void addItemToCart(Product productItem) {

		if (productList.containsKey(productItem)) {

			productList.put(productItem, productList.get(productItem) + 1);

		} else {

			productList.put(productItem, 1);

		}

	}

	/**
	 * This method deletes an item from the cart
	 * 
	 * @param productItem
	 */
	public void deleteItemFromCart(Product productItem) {

		if (productList.containsKey(productItem)) {

			productList.remove(productItem);

		} else {

			System.out.println("The selected product does not exists in the cart.");

		}

	}

	/**
	 * The buyProducts method returns the total cost of the items from the
	 * shopping-cart.
	 * 
	 * @return totalcost
	 */

	public Double buyProducts() {
		Double cost = 0.0;
		for (Product product : productList.keySet()) {
			cost += product.getUnitPrice() * productList.get(product);
		}
		return cost;
	}

	/**
	 * The cartSize method returns the size of the shopping-cart.
	 * 
	 * @return integer
	 */

	public int getCartSize() {
		return productList.size();
	}

}
