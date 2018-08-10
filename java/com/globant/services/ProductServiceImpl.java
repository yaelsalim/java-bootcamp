package com.globant.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globant.models.Product;
import com.globant.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repository;

	@Override
	public void create( String name, String category, Integer quantity, Float unitPrice) {
		repository.insert(new Product(name, category, quantity, unitPrice));
	}

	@Override
	public Optional<Product> getProduct(Long id) {
		return repository.findById(id);
	}

	@Override
	public List<Product> listProducts() {
		return repository.findAll();
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

	@Override
	public Product findByName(String name) {
		return repository.findByName(name);
	}

	@Override
	public List<Product> findByCategory(String category) {
		return repository.findByCategory(category);
	}

}
