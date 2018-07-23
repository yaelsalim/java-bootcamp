package com.globant.services;

import com.globant.models.User;

/**
 * This class makes the service look as local to the client.
 * 
 * @author Yael Salim
 *
 */
public class UserServiceProxy implements UserService {

	UserService implementation;

	public UserServiceProxy(UserService implementation) {

		this.implementation = implementation;

	}

	/**
	 * This method creates a new user in the database
	 * 
	 * @param user
	 */
	public void create(User user) {
		implementation.create(user);

	}

	/**
	 * This method deletes a user from the database.
	 * 
	 * @param username
	 */
	public void delete(String username) {
		implementation.delete(username);

	}

	/**
	 * This method updates a user's name.
	 * 
	 * @param oldName
	 * @param newName
	 */
	public void update(String oldName, String newName) {
		implementation.update(oldName, newName);
	}

}
