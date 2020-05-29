package com.miniproject.service;

import java.util.List;
import java.util.Optional;

import com.miniproject.model.Export;

public interface ExportService {
	List<Export> findAll();

	Optional<Export> findById(Long id);

	void save(Export export);
	
	void update(Export export);
	
	void deleteById(Long id);
}
