package com.miniproject.service;

import java.util.List;
import java.util.Optional;

import com.miniproject.model.Product;

public interface ProductService {

	List<Product> findAll();

	Optional<Product> findById(Long id);

	void save(Product product);
	
	void update(Product product);
	
	void deleteById(Long id);

}
