package com.miniproject.repository;

import java.util.List;
import java.util.Optional;

import com.miniproject.model.Product;

public interface IProductRepo {
	int count();

    int save(Product productInfoEntity);

    int update(Product productInfoEntity);

    int deleteById(Long id);

    List<Product> findAll();
    
//    List<Product> afindAll();
//    
    Optional<Product> findById(Long id);
   
    List<Product> findByName(String name);
}
