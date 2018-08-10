package com.globant.services;

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
	public void create(String userName, String name, String password);

	/**
	 * This method deletes a user from the database.
	 * 
	 * @param username
	 */
	public void delete(String userName);

	/**
	 * This method saves the current state of a user.
	 * 
	 * @param user
	 */
	public void save(User user);

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
	 * Returns all users from the database
	 * 
	 * @param userName
	 * @return
	 */
	public List<User> getUsers();

}
