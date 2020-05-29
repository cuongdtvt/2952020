package com.miniprojecttest.controller;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.miniprojecttest.Entity.PrimeMinisterOfIndia;
import com.miniprojecttest.Repository.FileUploadRepository;

@RestController
@RequestMapping("/upload/file")
public class FileUploadController {

	@Autowired
	private FileUploadRepository fileUploadRepository;

	private static final String DIR_TO_UPLOAD = "C:\\Users\\cuongttc\\Desktop\\anh\\";
	@PostMapping(value = "/database")
	public String uploadToDatabase(@RequestParam String name, @RequestParam MultipartFile file)
			throws IOException {

		// Set the form data into entity
		PrimeMinisterOfIndia pmOfIndia = new PrimeMinisterOfIndia();
		pmOfIndia.setName(name);
		pmOfIndia.setPhoto(file.getBytes());

		// Save the records into the database
		fileUploadRepository.save(pmOfIndia);

		return "Records saved into database.";
	}

	@PostMapping("/directory")
	public String uploadToDirectory(@RequestParam MultipartFile file) throws IOException {

		byte[] bytes = file.getBytes();
		Path path = Paths.get(DIR_TO_UPLOAD + file.getOriginalFilename());
		Files.write(path, bytes);

		return "File uploaded";
	}
}