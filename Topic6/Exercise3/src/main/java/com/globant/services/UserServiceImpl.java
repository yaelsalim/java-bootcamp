package com.globant.services;

import java.util.ArrayList;
import java.util.List;

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

	public void create(User user) {
		usersList.addUser(user);
	}

	public void delete(String userName) {
		usersList.deleteUser(userName);
	}

	public void update(String nickName, String newName) {
		usersList.updateUser(nickName, newName);
	}

	public boolean checkForUser(String userName) {
		for (User user : usersList.getAllUsers()) {
			if (user.getUsername().equals(userName)) {
				return true;
			}
		}
		return false;
	}

	public User findByUserName(String username) {
		for (User user : usersList.getAllUsers()) {
			if (user.getName().equals(username))
				return user;
		}
		return null;
	}

	public List<User> findByName(String name) {
		List<User> usersFound = new ArrayList<User>();
		for (User user : usersList.getAllUsers()) {
			if (user.getName().equals(name))
				usersFound.add(user);
		}
		return usersFound;
	}

	public ArrayList<User> getUsers() {
		return usersList.getAllUsers();
	}
}
