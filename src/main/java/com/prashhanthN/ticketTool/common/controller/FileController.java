package com.prashhanthN.ticketTool.common.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/ays")
public class FileController {

	private static final Logger logger = LoggerFactory.getLogger(FileController.class);

	@Autowired
	private com.prashhanthN.ticketTool.common.service.FileStorageService fileStorageService;

	@PostMapping("/uploadFile")
	public String uploadFile(@RequestParam("file") MultipartFile file) {
		String fileName = fileStorageService.storeFile(file);

		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
				.path(fileName).toUriString();

		return fileName;
	}

	@PostMapping("/uploadFile1")
	public String uploadFile1(@RequestParam("file") MultipartFile file) {
		System.out.println(file);
		String fileName = fileStorageService.storeFile1(file);
		System.out.println("log");
		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
				.path(fileName).toUriString();
		return fileName;
	}

	@PostMapping("/uploadMultipleFiles")
	public String uploadMultipleFiles(@RequestParam("files") MultipartFile files) {
		ArrayList<MultipartFile> uploadFileResponseList = new ArrayList<>();
		// String content = new String(files.getBytes(), "UTF-8");
		// uploadFileResponseList.add(file);
		return uploadFile(files);
	}

	@PostMapping("/uploadMultipleFiles1")
	public String uploadMultipleFiles1(@RequestParam("files") MultipartFile files) {
		ArrayList<MultipartFile> uploadFileResponseList = new ArrayList<>();
		System.out.println("holla");
		// String content = new String(files.getBytes(), "UTF-8");
		// uploadFileResponseList.add(file);
		return uploadFile1(files);
	}

	@GetMapping("/downloadFile/{fileName:.+}")
	public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
		// Load file as Resource
		Resource resource = fileStorageService.loadFileAsResource(fileName);

		// Try to determine file's content type
		String contentType = null;
		try {
			contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
		} catch (IOException ex) {
			logger.info("Could not determine file type.");
		}

		// Fallback to the default content type if type could not be determined
		if (contentType == null) {
			contentType = "application/octet-stream";
		}

		return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);
	}

}
