package com.miniproject.repository;

import java.util.List;
import java.util.Optional;

import com.miniproject.model.Invoice;

public interface IInvoiceRepo {
	int count();

    int save(Invoice invoiceEntity);

    int update(Invoice invoiceEntity);

    int deleteById(Long id);

    List<Invoice> findAll();
    
    Optional<Invoice> findById(Long id);
   
    List<Invoice> findByName(String name);
}
