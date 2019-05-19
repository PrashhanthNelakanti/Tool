package com.prashhanthN.ticketTool.common.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.prashhanthN.ticketTool.Exceptions.FileStorageException;
import com.prashhanthN.ticketTool.Exceptions.MyFileNotFoundException;
import com.prashhanthN.ticketTool.common.modal.UploadFileResponse;
import com.prashhanthN.ticketTool.common.repo.UploadFileResponseRepo;

@Service
public class FileStorageService {

	private final Path fileStorageLocation;
	@Autowired
	private UploadFileResponseRepo uploadFileResponseRepo;
	@Autowired
	private UploadFileResponse uploadFileResponse;
	static Date date = new Date();
	SimpleDateFormat ft = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

	@Autowired
	public FileStorageService(FileStorageProperties fileStorageProperties) {
		this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir()).toAbsolutePath().normalize();
		try {
			Files.createDirectories(this.fileStorageLocation);
		} catch (Exception ex) {
			throw new FileStorageException("Could not create the directory where the uploaded files will be stored.",
					ex);
		}
	}

	public String storeFile(MultipartFile file) {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		System.out.println(ft.format(date));
		try {
			String targetLocation = "E:\\ticketTool\\uploads\\";
			byte[] bytes = file.getBytes();
			uploadFileResponse.setFileDownloadUri(targetLocation);
			int lastDot = fileName.lastIndexOf('.');
			String reNamedFile = fileName.substring(0, lastDot) + ft.format(date) + fileName.substring(lastDot);
			Path path = Paths.get(targetLocation + reNamedFile);
			Files.write(path, bytes);
			uploadFileResponse.setFileName(reNamedFile);
			uploadFileResponseRepo.save(uploadFileResponse);
			return reNamedFile;
		} catch (IOException ex) {
			throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
		}
	}

	public String storeFile1(MultipartFile file) {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		System.out.println(ft.format(date));
		try {
			String targetLocation = "E:\\Angular\\tickettool\\src\\assets\\showcase\\images\\demo\\fkart\\";
			byte[] bytes = file.getBytes();
			uploadFileResponse.setFileDownloadUri(targetLocation);
			// int lastDot = fileName.lastIndexOf('.');
			// String reNamedFile =fileName.substring(0,lastDot)
			// +ft.format(date)+ fileName.substring(lastDot);
			Path path = Paths.get(targetLocation + fileName);
			Files.write(path, bytes);
			uploadFileResponse.setFileName(fileName);
			uploadFileResponseRepo.save(uploadFileResponse);
			System.out.println(fileName);
			return fileName;
		} catch (IOException ex) {
			throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
		}
	}

	public Resource loadFileAsResource(String fileName) {
		try {
			Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
			Resource resource = new UrlResource(filePath.toUri());
			if (resource.exists()) {
				return resource;
			} else {
				throw new MyFileNotFoundException("File not found " + fileName);
			}
		} catch (MalformedURLException ex) {
			throw new MyFileNotFoundException("File not found " + fileName, ex);
		}
	}

}
