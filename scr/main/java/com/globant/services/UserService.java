package com.globant.services;

import com.globant.models.User;

/**
 * This service allows CRUD operations for users.
 * 
 * @author Yael Salim
 *
 */

public interface UserService {

	/**
	 * This method creates a new user in the database
	 * 
	 * @param user
	 */
	public void create(User user);

	/**
	 * This method deletes a user from the database.
	 * 
	 * @param username
	 */
	public void delete(String username);

	/**
	 * This method updates a user's name.
	 * 
	 * @param oldName
	 * @param newName
	 */
	public void update(String oldName, String newName);

}
