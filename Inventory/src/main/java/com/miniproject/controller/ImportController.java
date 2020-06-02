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

import com.miniproject.model.Import;
import com.miniproject.service.ImportService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ImportController {

	private ImportService importService;

	@Autowired
	public ImportController(ImportService importService) {
		this.importService = importService;
	}

	@RequestMapping(value = "/imports", method = RequestMethod.GET)
	public ResponseEntity<List<Import>> findAll() {
		List<Import> imports = importService.findAll();
		if (imports.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(imports, HttpStatus.OK);
	}

	@RequestMapping(value = "/imports/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Import> getImportById(@PathVariable("id") Long id) {
		Optional<Import> imports = importService.findById(id);

		if (!imports.isPresent()) {
			return new ResponseEntity<>(imports.get(), HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(imports.get(), HttpStatus.OK);

	}

	@RequestMapping(value = "/imports", method = RequestMethod.POST)
	public ResponseEntity<Import> createImport(@RequestBody Import imports, UriComponentsBuilder builder) {
		importService.save(imports);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/imports/{id}").buildAndExpand(imports.getId()).toUri());
		return new ResponseEntity<>(imports, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/imports/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Import> updateImport(@PathVariable("id") Long id, @RequestBody Import imports) {
		Optional<Import> currentImport = importService.findById(id);

		if (!currentImport.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		currentImport.get().setProductID(imports.getProductID());
		currentImport.get().setQty(imports.getQty());
		currentImport.get().setDescription(imports.getDescription());
		currentImport.get().setCreateDate(imports.getCreateDate());

		importService.update(currentImport.get());
		return new ResponseEntity<>(currentImport.get(), HttpStatus.OK);
	}

	@RequestMapping(value = "/imports/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Import> deleteImport(@PathVariable("id") Long id) {
		Optional<Import> imports = importService.findById(id);
		if (!imports.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		importService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
