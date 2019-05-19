package com.prashhanthN.ticketTool.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prashhanthN.ticketTool.common.modal.UploadFile;
import com.prashhanthN.ticketTool.common.repo.AttachmentRepository;

@Service
public class AttachmentService {

	@Autowired
	private AttachmentRepository attachmentRepository;

	public List<UploadFile> postAttachments(List<UploadFile> uploadFiles) {
		return attachmentRepository.saveAll(uploadFiles);

	}

	public UploadFile postAttachment(UploadFile uploadFiles) {
		return attachmentRepository.save(uploadFiles);

	}

	public List<UploadFile> getByDocumentType(String documentType) {
		return attachmentRepository.getByDocumentType(documentType);
	}

}
