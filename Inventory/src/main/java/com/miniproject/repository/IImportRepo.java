package com.miniproject.repository;

import java.util.List;
import java.util.Optional;

import com.miniproject.model.Import;

public interface IImportRepo {
	int count();

    int save(Import imports);

    int update(Import imports);

    int deleteById(Long id);

    List<Import> findAll();
    
    Optional<Import> findById(Long id);
   
    List<Import> findByName(String name);
}
