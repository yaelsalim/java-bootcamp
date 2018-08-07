package com.globant.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.globant.models.Product;

/**
 * This interface represents product repository.
 * 
 * @author Yael Salim
 *
 */
public interface ProductRepository extends MongoRepository<Product, Long> {

	/**
	 * Finds a product by category
	 * 
	 * @param category
	 * @return
	 */
	List<Product> findByCategory(String category);

	/**
	 * Finds a product by name
	 * 
	 * @param name
	 * @return
	 */
	Product findByName(String name);

}
