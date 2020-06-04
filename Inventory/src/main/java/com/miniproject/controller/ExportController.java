package com.miniproject.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.miniproject.model.Export;
import com.miniproject.service.ExportService;
import com.miniproject.util.ExcelGenerator2;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ExportController {
	private ExportService exportService;
	
	@Autowired
	public ExportController (ExportService exportService) {
		this.exportService = exportService;
	}
	
	@RequestMapping(value = "/exports", method = RequestMethod.GET)
	public ResponseEntity<List<Export>> findAll() {
		List<Export> export = exportService.findAll();
		if (export.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(export, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/exports/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Export> getExportById(@PathVariable("id") Long id) {
		Optional<Export> export = exportService.findById(id);

		if (!export.isPresent()) {
			return new ResponseEntity<>(export.get(), HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(export.get(), HttpStatus.OK);

	}
	@RequestMapping(value = "/exports", method = RequestMethod.POST)
	public ResponseEntity<Export> createExports(@RequestBody Export export, UriComponentsBuilder builder) {
		exportService.save(export);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/exports/{id}").buildAndExpand(export.getId()).toUri());
		return new ResponseEntity<>(export, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/exports/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Export> updateExport(@PathVariable("id") Long id, @RequestBody Export export) {
		Optional<Export> currentexport = exportService.findById(id);

		if (!currentexport.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		currentexport.get().setProductID(export.getProductID());
		currentexport.get().setQty(export.getQty());
		currentexport.get().setDescription(export.getDescription());
		currentexport.get().setCreateDate(export.getCreateDate());

		exportService.update(currentexport.get());
		return new ResponseEntity<>(currentexport.get(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/exports/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Export> deleteExport(@PathVariable("id") Long id) {
		Optional<Export> export = exportService.findById(id);
		if (!export.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		exportService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(value = "/exports/report")
	 public ResponseEntity<InputStreamResource> excelCustomersReport() throws IOException {
       List<Export> exports = (List<Export>) exportService.findAll();
   
   ByteArrayInputStream in = ExcelGenerator2.customersToExcel(exports);
   // return IOUtils.toByteArray(in);
   
   HttpHeaders headers = new HttpHeaders();
       headers.add("Content-Disposition", "attachment; filename=customers.xlsx");
   
    return ResponseEntity
                 .ok()
                 .headers(headers)
                 .body(new InputStreamResource(in));
   }
	
}
