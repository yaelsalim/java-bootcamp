package com.globant.services;

import com.globant.models.Product;
import com.globant.models.ShoppingCart;

/**
 * This interface represents a shopping cart service
 * 
 * @author Yael Salim
 *
 */

public interface ShoppingCartService {

	/**
	 * Creates a new shopping cart for a user
	 * 
	 * @param userName
	 */
	public void create(String userName);

	/**
	 * Calculates the total cost of the order
	 * 
	 * @param userName
	 */

	public void payOrder(String userName);

	/**
	 * Saves the current cart.
	 * 
	 * @param newCart
	 */
	public void saveCart(ShoppingCart cart);

	/**
	 * Deletes a cart.
	 * 
	 * @param userName
	 */
	public void deleteCart(String userName);

	/**
	 * This method adds a product in a cart
	 * 
	 * @param newProduct
	 * @param userName
	 */
	public void addProductToCart(Product newProduct, String userName);

	/**
	 * This method deletes a product from a cart
	 * 
	 * @param selectedProduct
	 * @param userName
	 */
	public void deleteProductFromCart(Product selectedProduct, String userName);

	/**
	 * This method returns a user's cart
	 */
	public ShoppingCart getCart(String userName);
}
