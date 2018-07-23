package com.globant.services;

import com.globant.models.User;
import com.globant.repositories.UserRepository;

/**
 * This is the implementation of the user service.
 * 
 * @author Yael Salim
 *
 */

public class UserServiceImpl implements UserService {

	private UserRepository usersList;

	public UserServiceImpl() {

		usersList = new UserRepository();
	}

	/**
	 * This method creates a new user in the database
	 * 
	 * @param user
	 */
	public void create(User user) {
		usersList.addUser(user);
	}

	/**
	 * This method deletes a user from the database.
	 * 
	 * @param username
	 */
	public void delete(String userName) {
		usersList.deleteUser(userName);
	}

	/**
	 * This method updates a user's name.
	 * 
	 * @param oldName
	 * @param newName
	 */
	public void update(String oldName, String newName) {
		usersList.updateUser(oldName, newName);
	}

}
