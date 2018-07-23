package com.globant.repositories;

import java.util.ArrayList;

import com.globant.models.ShoppingCart;

/**
 * This class keeps in-memory data of the shopping carts.
 * 
 * @author Yael Salim
 *
 */

public class CartRepository {

	ArrayList<ShoppingCart> userCarts;

	public CartRepository() {

		this.userCarts = new ArrayList<ShoppingCart>();
	}

	/**
	 * This method saves a user's cart into the database.
	 * 
	 * @param cart
	 */

	public void saveCart(ShoppingCart cart) {
		if (userCarts.contains(cart)){
			userCarts.get(userCarts.indexOf(cart)).setProductList(cart.getProductList());
		}
		userCarts.add(cart);
	}

	/**
	 * Lists all shopping carts in the database.
	 * 
	 * @return ArrayList<ShoppingCart>
	 */
	public ArrayList<ShoppingCart> listCarts() {

		return this.userCarts;

	}

	/**
	 * Deletes a cart for a given username.
	 * 
	 * @param username
	 */
	public void deleteCart(String userName) {
		for (ShoppingCart cart : userCarts) {
			if (userName.equals(cart.getUserName())) {
				userCarts.remove(cart);
			}
		}

	}

	/**
	 * Returns a user's cart
	 * 
	 * @param userName
	 * @return
	 */

	public ShoppingCart getCart(String userName) {
		for (ShoppingCart cart : userCarts) {
			if (userName.equals(cart.getUserName())) {
				return cart;
			}
		}
		return null;
	}

}
