package com.prashhanthN.ticketTool.common.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prashhanthN.ticketTool.common.modal.UploadFile;

@Repository
public interface AttachmentRepository extends JpaRepository<UploadFile, Integer> {

	List<UploadFile> getByDocumentType(String documentType);
}
