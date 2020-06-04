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

import com.miniproject.model.Category;
import com.miniproject.service.CategoryService;
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")

@RestController
public class CategoryController {

	private CategoryService categoryService;
	
	@Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	public ResponseEntity<List<Category>> findAll() {
		List<Category> categoryEntity = categoryService.findAll();
		if (categoryEntity.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(categoryEntity, HttpStatus.OK);
	}


	@RequestMapping(value = "/categories/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Category> getCategoryById(@PathVariable("id") Long id) {
		Optional<Category> categoryEntity = categoryService.findById(id);

		if (!categoryEntity.isPresent()) {
			return new ResponseEntity<>(categoryEntity.get(), HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(categoryEntity.get(), HttpStatus.OK);

	}
	
	@RequestMapping(value = "/categories",
            method = RequestMethod.POST)
    public ResponseEntity<Category> createCategory(
            @RequestBody Category categoryEntity,
            UriComponentsBuilder builder) {
		categoryService.save(categoryEntity);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/categories/{id}")
                .buildAndExpand(categoryEntity.getId()).toUri());
        return new ResponseEntity<>(categoryEntity, HttpStatus.CREATED);
    }
	
	
	 @RequestMapping(value = "/categories/{id}",
	            method = RequestMethod.PUT)
	    public ResponseEntity<Category> updateCategory(
	            @PathVariable("id") Long id,
	            @RequestBody Category categoryEntity) {
			Optional<Category> currentCategory = categoryService.findById(id);

	        if (!currentCategory.isPresent()) {
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        }

	        currentCategory.get().setName(categoryEntity.getName());
	 
	        currentCategory.get().setDescription(categoryEntity.getDescription());

	        categoryService.update(currentCategory.get());
	        return new ResponseEntity<>(currentCategory.get(), HttpStatus.OK);
	    }
	 
	 @RequestMapping(value = "/categories/{id}",
	            method = RequestMethod.DELETE)
	    public ResponseEntity<Category> deleteCategory(
	            @PathVariable("id") Long id) {
	        Optional<Category> category = categoryService.findById(id);
	        if (!category.isPresent()) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	        categoryService.deleteById(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
}
