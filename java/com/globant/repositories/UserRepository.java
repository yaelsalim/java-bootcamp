package com.globant.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.globant.models.User;

/**
 * This interface represents a user repository
 * 
 * @author Yael Salim
 *
 */
public interface UserRepository extends MongoRepository<User, Long> {

	/**
	 * Finds a user by name
	 * 
	 * @param name
	 * @return
	 */
	List<User> findByName(String name);

	/**
	 * Finds a user by userName
	 * 
	 * @param userName
	 * @return
	 */
	User findByUserName(String userName);

}
