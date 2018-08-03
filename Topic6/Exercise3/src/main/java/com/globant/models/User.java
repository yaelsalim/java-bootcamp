package com.globant.models;

public class User {

	private String username;

	private String password;

	private String name;

	private boolean logged;

	private ShoppingCart shoppingCart;

	public User(String username, String name, String password) {

		this.username = username;
		this.password = password;
		this.name = name;
		this.logged = false;
		this.shoppingCart = new ShoppingCart(username);
	}

	/**
	 * Getter method for username parameter.
	 * 
	 * @return
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Setter method for username parameter.
	 * 
	 * @return
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Getter method for password parameter.
	 * 
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Setter method for password parameter.
	 * 
	 * @return
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Getter method for name parameter.
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Getter method for logged parameter.
	 * 
	 * @return
	 */
	public boolean isLogged() {
		return logged;
	}

	/**
	 * Setter method for name parameter.
	 * 
	 * @return
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method sets logged parameter to true .
	 * 
	 * @return
	 */
	public void logIn() {
		logged = true;
	}

	/**
	 * This method sets logged parameter to false .
	 * 
	 * @return
	 */
	public void logOut() {
		logged = false;
	}

	/**
	 * Getter method for shoppingcart parameter.
	 * 
	 * @return
	 */
	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

}
