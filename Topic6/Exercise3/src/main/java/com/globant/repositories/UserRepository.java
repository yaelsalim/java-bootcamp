package com.globant.repositories;

import java.util.ArrayList;

import com.globant.models.User;

/**
 * This class allows to keep in-memory data of the users.
 * 
 * @author Yael Salim
 *
 */

public class UserRepository {

	ArrayList<User> userList;

	public UserRepository() {

		this.userList = new ArrayList<User>();
	}

	/**
	 * Adds a new user to the database
	 * 
	 * @param newUser
	 */
	public void addUser(User newUser) {

		this.userList.add(newUser);
	}

	/**
	 * Deletes a user from the database
	 * 
	 * @param userName
	 */
	public void deleteUser(String userName) {

		for (User actualUser : userList) {
			if (userName.equals(actualUser.getName())) {
				userList.remove(actualUser);
				break;
			}
		}
	}

	/**
	 * Updates user's name
	 * 
	 * @param nickName
	 * @param newName
	 */
	public void updateUser(String nickName, String newName) {

		for (User actualUser : userList) {
			if (nickName.equals(actualUser.getUsername())) {
				userList.get(userList.indexOf(actualUser)).setName(newName);
				break;
			}
		}
	}

	/**
	 * Lists all users from the database
	 * 
	 * @return
	 */
	public ArrayList<User> getAllUsers() {
		return this.userList;
	}
}
