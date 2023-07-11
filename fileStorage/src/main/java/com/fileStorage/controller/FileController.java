package com.fileStorage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fileStorage.service.FileService;

@RestController
public class FileController {
	
	@Autowired
	private FileService service;

	@PostMapping("/saveFile")
	public void saveFile(@RequestParam MultipartFile file) {
		service.saveFile(file);
	}
}
