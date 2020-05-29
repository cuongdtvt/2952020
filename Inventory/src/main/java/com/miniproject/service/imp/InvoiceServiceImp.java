package com.miniproject.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniproject.model.Invoice;
import com.miniproject.repository.IInvoiceRepo;
import com.miniproject.service.InvoiceService;

@Service
public class InvoiceServiceImp implements InvoiceService{
	
	private IInvoiceRepo iInvoiceRepo;
	
	@Autowired
	public InvoiceServiceImp (IInvoiceRepo iInvoiceRepo) {
		this.iInvoiceRepo = iInvoiceRepo;
	}
	@Override
	public List<Invoice> findAll() {
		   return (List<Invoice>) iInvoiceRepo.findAll();
	}

	@Override
	public Optional<Invoice> findById(Long id) {
		return iInvoiceRepo.findById(id);
	}

	@Override
	public void save(Invoice invoice) {
		iInvoiceRepo.save(invoice);
		
	}

	@Override
	public void update(Invoice invoice) {
		iInvoiceRepo.update(invoice);
		
	}

	@Override
	public void deleteById(Long id) {
		iInvoiceRepo.deleteById(id);
		
	}
	

}
