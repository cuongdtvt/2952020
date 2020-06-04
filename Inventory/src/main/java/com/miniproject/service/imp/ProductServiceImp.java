package com.miniproject.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniproject.model.Product;
import com.miniproject.repository.IProductRepo;
import com.miniproject.service.ProductService;
@Service
public class ProductServiceImp implements ProductService{
	private IProductRepo iProductRepo;
	
	@Autowired
	public ProductServiceImp (IProductRepo iProductRepo){
        this.iProductRepo = iProductRepo;
    	}
	@Override
	public List<Product> findAll() {
		return (List<Product>) iProductRepo.findAll();
	}

	@Override
	public Optional<Product> findById(Long id) {
		return iProductRepo.findById(id);
	}

	@Override
	public void save(Product product) {
		iProductRepo.save(product);		
		
	}

	@Override
	public void update(Product product) {
		iProductRepo.update(product);		
	}

	@Override
	public void deleteById(Long id) {
		iProductRepo.deleteById(id);
		
	}
	
	
	

}
