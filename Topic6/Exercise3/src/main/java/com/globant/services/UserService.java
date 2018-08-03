package com.globant.services;

import java.util.ArrayList;
import java.util.List;

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
	public void update(String nickName, String newName);

	/**
	 * Finds users that have a given name
	 * 
	 * @param name
	 * @return
	 */
	public List<User> findByName(String name);

	/**
	 * Finds a user by username
	 * 
	 * @param username
	 * @return
	 */
	public User findByUserName(String username);

	/**
	 * Checks if a user exists in the database
	 * 
	 * @param userName
	 * @return
	 */
	public boolean checkForUser(String userName);

	/**
	 * Returns all users from the database
	 * 
	 * @param userName
	 * @return
	 */
	public ArrayList<User> getUsers();

}
