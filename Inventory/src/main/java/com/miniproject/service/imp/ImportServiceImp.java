package com.miniproject.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniproject.model.Import;
import com.miniproject.repository.IImportRepo;
import com.miniproject.service.ImportService;
@Service
public class ImportServiceImp implements ImportService {
private IImportRepo iImportRepo;
	
	@Autowired
	public ImportServiceImp (IImportRepo iImportRepo) {
		this.iImportRepo = iImportRepo;
	}
	
	@Override
	public List<Import> findAll() {
		return (List<Import>) iImportRepo.findAll();
	}

	@Override
	public Optional<Import> findById(Long id) {
		return iImportRepo.findById(id);
	}

	@Override
	public void save(Import imports) {
		iImportRepo.save(imports);
		
	}

	@Override
	public void update(Import imports) {
		iImportRepo.update(imports);

	}

	@Override
	public void deleteById(Long id) {
		iImportRepo.deleteById(id);	
}
}
