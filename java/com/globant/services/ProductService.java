package com.globant.services;

import java.util.List;
import java.util.Optional;

import com.globant.models.Product;

public interface ProductService {

	/**
	 * Creates a new product.
	 * 
	 * @param id
	 * @param name
	 * @param category
	 * @param quantity
	 * @param unitPrice
	 */
	void create(String name, String category, Integer quantity, Float unitPrice);

	/**
	 * Returns a product for a given id.
	 * 
	 * @param id
	 * @return
	 */
	Optional<Product> getProduct(Long id);

	/**
	 * Lists all products in the database
	 * 
	 * @return
	 */
	List<Product> listProducts();

	/**
	 * Deletes a product for a given id.
	 * 
	 * @param id
	 */
	void delete(Long id);

	/**
	 * Finds a product for a given name
	 * 
	 * @param name
	 * @return
	 */
	Product findByName(String name);

	/**
	 * Finds a product for a given category
	 * 
	 * @param category
	 * @return
	 */
	List<Product> findByCategory(String category);

}