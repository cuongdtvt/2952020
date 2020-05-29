package com.miniproject.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniproject.model.Category;
import com.miniproject.repository.ICategoryRepo;
import com.miniproject.service.CategoryService;
@Service
public class CategoryServiceImp implements CategoryService{
	private ICategoryRepo iCategoryRepo;
	
	@Autowired
	public CategoryServiceImp (ICategoryRepo iCategoryRepo){
        this.iCategoryRepo = iCategoryRepo;
    }
	
	@Override
	public List<Category> findAll() {

        return (List<Category>) iCategoryRepo.findAll();
	}

	@Override
	public Optional<Category> findById(Long id) {
		return iCategoryRepo.findById(id);
	}

	@Override
	public void save(Category category) {
		iCategoryRepo.save(category);		
	}

	@Override
	public void update(Category category) {
		iCategoryRepo.update(category);
	}

	@Override
	public void deleteById(Long id) {
		iCategoryRepo.deleteById(id);
		
	}

}
