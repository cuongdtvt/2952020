package com.miniproject.service.imp;

import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
@Service
public class StorageService {
	
	private static final String DIR_TO_UPLOAD = "C:\\Users\\cuongttc\\Desktop\\anh\\";
	
	Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	private final Path rootLocation = Paths.get(DIR_TO_UPLOAD );

	public void store(MultipartFile file) {
		
		//Create custom filename 
		String filename = StringUtils.cleanPath(file.getOriginalFilename());
		//remove spaces and make lowercase    
		filename = filename.toLowerCase().replaceAll(" ", "-");
	    try {
	    	Files.copy(file.getInputStream(), this.rootLocation.resolve(filename),
	                StandardCopyOption.REPLACE_EXISTING);
	    	
	    } catch (Exception e) {
	        throw new RuntimeException("FAIL!");
	    }
	 }

	public Resource loadFile(String filename) {
	    try {
	        Path file = rootLocation.resolve(filename);
	        Resource resource = new UrlResource(file.toUri());
	        if (resource.exists() || resource.isReadable()) {
	            return resource;
	        } else {
	            throw new RuntimeException("FAIL!");
	        }
	    } catch (MalformedURLException e) {
	        throw new RuntimeException("FAIL!");
	    }
	 }

	public void deleteAll() {
	    FileSystemUtils.deleteRecursively(rootLocation.toFile());
	 }
	}

