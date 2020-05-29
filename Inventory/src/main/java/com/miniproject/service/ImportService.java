package com.miniproject.service;

import java.util.List;
import java.util.Optional;

import com.miniproject.model.Import;

public interface ImportService {
	List<Import> findAll();

	Optional<Import> findById(Long id);

	void save(Import imports);
	
	void update(Import imports);
	
	void deleteById(Long id);
}
