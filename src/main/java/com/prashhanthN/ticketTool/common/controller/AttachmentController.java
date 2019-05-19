package com.prashhanthN.ticketTool.common.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prashhanthN.ticketTool.common.modal.UploadFile;
import com.prashhanthN.ticketTool.common.service.AttachmentService;

@RestController
@RequestMapping("/ays")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AttachmentController {

	@Autowired
	private AttachmentService attachmentService;

	@PostMapping("/attachments")
	public List<UploadFile> postAttachment(@RequestBody List<UploadFile> uploadFiles) {
		return attachmentService.postAttachments(uploadFiles);
	}

	@GetMapping("/attachments/changeControl/{documentType}")
	public List<UploadFile> getbyDocumentType(@PathVariable String documentType) {

		return attachmentService.getByDocumentType(documentType);

	}
}
