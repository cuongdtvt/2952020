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

import com.miniproject.model.Product;
import com.miniproject.service.ProductService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")

public class ProductController {
//	private static final String DIR_TO_UPLOAD = "C:\\Users\\cuongttc\\Desktop\\anh\\";
	private ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> findAll() {
		List<Product> products = productService.findAll();
		if (products.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	@RequestMapping(value = "/products/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) {
		Optional<Product> products = productService.findById(id);

		if (!products.isPresent()) {
			return new ResponseEntity<>(products.get(), HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(products.get(), HttpStatus.OK);

	}

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public ResponseEntity<Product> createProduct (@RequestBody Product products, UriComponentsBuilder builder){
		
		
//		byte[] bytes = file.getBytes();
//
//		String fileName = System.currentTimeMillis() + file.getOriginalFilename();
//		Path path = Paths.get(DIR_TO_UPLOAD + fileName);
//		Files.write(path, bytes);
//		
//		products.setImageUrl(path.toString());
		productService.save(products);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/products/{id}").buildAndExpand(products.getId()).toUri());
		return new ResponseEntity<>(products, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id, @RequestBody Product products) {
		Optional<Product> currentProducts = productService.findById(id);

		if (!currentProducts.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		currentProducts.get().setCateID(products.getCateID());
		currentProducts.get().setName(products.getName());
		currentProducts.get().setDescription(products.getDescription());
		currentProducts.get().setQty(products.getQty());
		currentProducts.get().setImageUrl(products.getImageUrl());
		productService.update(currentProducts.get());
		return new ResponseEntity<>(currentProducts.get(), HttpStatus.OK);
	}

	@RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Product> deleteProduct(@PathVariable("id") Long id) {
		Optional<Product> products = productService.findById(id);
		if (!products.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		productService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

//	private void processUploadFile(MultipartFile multipartFile, String fileName)
//			throws IllegalStateException, IOException {
//		if (!multipartFile.getOriginalFilename().isEmpty()) {
//			File dir = new File(ConfigLoader.getInstance().getValue("DIR_TO_UPLOAD"));
//			if (!dir.exists()) {
//				dir.mkdirs();
//			}
//			File file = new File(ConfigLoader.getInstance().getValue("DIR_TO_UPLOAD"), fileName);
//			multipartFile.transferTo(file);
//		}
//	}
}
