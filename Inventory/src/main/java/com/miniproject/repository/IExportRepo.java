package com.miniproject.repository;

import java.util.List;
import java.util.Optional;

import com.miniproject.model.Export;

public interface IExportRepo {
	int count();

    int save(Export export);

    int update(Export export);

    int deleteById(Long id);

    List<Export> findAll();
    
    Optional<Export> findById(Long id);
   
    List<Export> findByName(String name);
}
