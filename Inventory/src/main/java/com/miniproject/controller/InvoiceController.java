package com.miniproject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.miniproject.model.Invoice;
import com.miniproject.service.InvoiceService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class InvoiceController {

	private InvoiceService invoiceService;

	@Autowired
	public InvoiceController(InvoiceService invoiceService) {
		this.invoiceService = invoiceService;
	}

	@RequestMapping(value = "/invoices", method = RequestMethod.GET)
	public ResponseEntity<List<Invoice>> findAll() {
		List<Invoice> invoices = invoiceService.findAll();
		if (invoices.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(invoices, HttpStatus.OK);
	}

	@RequestMapping(value = "/invoices/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Invoice> getInvoiceById(@PathVariable("id") Long id) {
		Optional<Invoice> invoices = invoiceService.findById(id);

		if (!invoices.isPresent()) {
			return new ResponseEntity<>(invoices.get(), HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(invoices.get(), HttpStatus.OK);

	}

	@RequestMapping(value = "/invoices", method = RequestMethod.POST)
	public ResponseEntity<Invoice> createInvoice(@RequestBody Invoice invoices, UriComponentsBuilder builder) {
		invoiceService.save(invoices);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/invoices/{id}").buildAndExpand(invoices.getId()).toUri());
		return new ResponseEntity<>(invoices, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/invoices/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Invoice> updateInvoice(@PathVariable("id") Long id, @RequestBody Invoice invoices) {
		Optional<Invoice> currentInvoice = invoiceService.findById(id);

		if (!currentInvoice.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		currentInvoice.get().setProductID(invoices.getProductID());

		currentInvoice.get().setType(invoices.isType());
		currentInvoice.get().setQty(invoices.getQty());

		invoiceService.update(currentInvoice.get());
		return new ResponseEntity<>(currentInvoice.get(), HttpStatus.OK);
	}

	@RequestMapping(value = "/invoices/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Invoice> deleteInvoice(@PathVariable("id") Long id) {
		Optional<Invoice> invoices = invoiceService.findById(id);
		if (!invoices.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		invoiceService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
