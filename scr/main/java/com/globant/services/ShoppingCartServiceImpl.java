package com.globant.services;

import com.globant.models.Product;
import com.globant.models.ShoppingCart;
import com.globant.repositories.CartRepository;

/**
 * This class implements the ShoppingCartService interface
 * 
 * @author Yael Salim
 *
 */
public class ShoppingCartServiceImpl implements ShoppingCartService {

	CartRepository shoppingCarts = new CartRepository();

	/**
	 * Creates a new shopping cart for a user
	 * 
	 * @param userName
	 */
	public void create(String userName) {
		shoppingCarts.saveCart(new ShoppingCart(userName));

	}

	/**
	 * Calculates the total cost of the order
	 * 
	 * @param userName
	 */
	public void payOrder(String userName) {
		System.out.println("The total cost of the order is: " + shoppingCarts.getCart(userName).buyProducts());
	}

	/**
	 * Saves the current cart.
	 * 
	 * @param newCart
	 */
	public void saveCart(ShoppingCart cart) {
		shoppingCarts.saveCart(cart);
	}

	/**
	 * Deletes a cart.
	 * 
	 * @param userName
	 */
	public void deleteCart(String userName) {
		shoppingCarts.deleteCart(userName);
	}

	/**
	 * This method adds a product in a cart
	 * 
	 * @param newProduct
	 * @param userName
	 */
	public void addProductToCart(Product newProduct, String userName) {
		shoppingCarts.getCart(userName).addItemToCart(newProduct);

	}

	/**
	 * This method deletes a product from a cart
	 * 
	 * @param selectedProduct
	 * @param userName
	 */
	public void deleteProductFromCart(Product newProduct, String userName) {
		shoppingCarts.getCart(userName).deleteItemFromCart(newProduct);

	}

	/**
	 * This method returns a user's cart
	 */
	public ShoppingCart getCart(String userName) {
		return shoppingCarts.getCart(userName);
	}

}
