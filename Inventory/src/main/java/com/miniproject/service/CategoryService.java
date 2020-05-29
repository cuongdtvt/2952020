package com.miniproject.service;

import java.util.List;
import java.util.Optional;

import com.miniproject.model.Category;

public interface CategoryService {
	List<Category> findAll();

	Optional<Category> findById(Long id);

	void save(Category category);
	
	void update(Category category);
	
	void deleteById(Long id);
}
