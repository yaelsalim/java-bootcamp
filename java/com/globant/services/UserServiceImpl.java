package com.globant.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globant.models.User;
import com.globant.repositories.UserRepository;

/**
 * This is the implementation of the user service.
 * 
 * @author Yael Salim
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository usersRepo;

	public void create(String userName, String name, String password) {
		usersRepo.insert(new User(userName, name, password));
	}

	public void delete(String userName) {
		usersRepo.delete(usersRepo.findByUserName(userName));
	}

	public void save(User user) {
		usersRepo.save(user);
	}

	public void update(String userName, String newName) {

		User update = usersRepo.findByUserName(userName);
		update.setName(newName);
		usersRepo.save(update);
	}

	public User findByUserName(String username) {
		return usersRepo.findByUserName(username);
	}

	public List<User> findByName(String name) {
		return usersRepo.findByName(name);
	}

	public List<User> getUsers() {
		return usersRepo.findAll();
	}

}
