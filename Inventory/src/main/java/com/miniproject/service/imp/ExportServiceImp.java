package com.miniproject.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniproject.model.Export;
import com.miniproject.repository.IExportRepo;
import com.miniproject.service.ExportService;
@Service
public class ExportServiceImp implements ExportService{
	private IExportRepo iExportRepo;
	
	@Autowired
	public ExportServiceImp (IExportRepo iExportRepo) {
		this.iExportRepo = iExportRepo;
	}
	
	@Override
	public List<Export> findAll() {
		return (List<Export>) iExportRepo.findAll();
	}

	@Override
	public Optional<Export> findById(Long id) {
		return iExportRepo.findById(id);
	}

	@Override
	public void save(Export goodsReceipt) {
		iExportRepo.save(goodsReceipt);
		
	}

	@Override
	public void update(Export goodsReceipt) {
		iExportRepo.update(goodsReceipt);

	}

	@Override
	public void deleteById(Long id) {
		iExportRepo.deleteById(id);		
	}

}
