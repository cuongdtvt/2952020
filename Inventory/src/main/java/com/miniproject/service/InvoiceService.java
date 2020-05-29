package com.miniproject.service;

import java.util.List;
import java.util.Optional;

import com.miniproject.model.Invoice;

public interface InvoiceService {
	List<Invoice> findAll();

	Optional<Invoice> findById(Long id);

	void save(Invoice invoice);
	
	void update(Invoice invoice);
	
	void deleteById(Long id);
}
