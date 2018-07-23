package com.globant.services;

import com.globant.models.User;

/**
 * This stub class implements a web communication mechanism.
 * 
 * @author Yael Salim
 *
 */

public class UserWebServiceClient implements UserService {

	UserService webService;

	public UserWebServiceClient() {
		webService = new UserServiceImpl();
	}

	/**
	 * This method creates a new user in the database
	 * 
	 * @param user
	 */
	public void create(User user) {
		webService.create(user);

	}

	/**
	 * This method deletes a user from the database.
	 * 
	 * @param username
	 */
	public void delete(String username) {
		webService.delete(username);

	}

	/**
	 * This method updates a user's name.
	 * 
	 * @param oldName
	 * @param newName
	 */
	public void update(String oldName, String newName) {
		webService.update(oldName, newName);

	}

}
