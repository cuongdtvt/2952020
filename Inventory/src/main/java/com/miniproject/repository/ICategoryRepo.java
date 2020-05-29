package com.miniproject.repository;

import java.util.List;
import java.util.Optional;

import com.miniproject.model.Category;
public interface ICategoryRepo {
	int count();

    int save(Category categoryEntity);

    int update(Category categoryEntity);

    int deleteById(Long id);

    List<Category> findAll();
    
    Optional<Category> findById(Long id);
   
    List<Category> findByName(String name);
}
