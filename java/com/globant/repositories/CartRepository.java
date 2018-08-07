package com.globant.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.globant.models.ShoppingCart;

/**
 * This interface represents a cart repository
 * 
 * @author Yael Salim
 *
 */
public interface CartRepository extends MongoRepository<ShoppingCart, Long> {
	/**
	 * Finds a shopping cart by userName
	 * 
	 * @param userName
	 * @return
	 */
	ShoppingCart findByUserName(String userName);

}