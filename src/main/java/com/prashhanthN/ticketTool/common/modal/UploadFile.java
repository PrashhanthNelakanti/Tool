package com.prashhanthN.ticketTool.common.modal;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;


@Entity
@Component
public class UploadFile {

	@Id
	@GeneratedValue
	private int attachmentId;
	private String documentType;
	private int documentId;
	private String subDocumentType;
	private int subDocumentId;
	private String sectionName;
	private String uploadedFor;
	private String file;
	private String fileName;
	private Date uploadedDate;
	private boolean newFileAdded;
	private String storedFileName;

	public UploadFile() {
		super();
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getAttachmentId() {
		return attachmentId;
	}

	public void setAttachmentId(int attachmentId) {
		this.attachmentId = attachmentId;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public int getDocumentId() {
		return documentId;
	}

	public void setDocumentId(int documentId) {
		this.documentId = documentId;
	}

	public String getSubDocumentType() {
		return subDocumentType;
	}

	public void setSubDocumentType(String subDocumentType) {
		this.subDocumentType = subDocumentType;
	}

	public int getSubDocumentId() {
		return subDocumentId;
	}

	public void setSubDocumentId(int subDocumentId) {
		this.subDocumentId = subDocumentId;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public String getUploadedFor() {
		return uploadedFor;
	}

	public void setUploadedFor(String uploadedFor) {
		this.uploadedFor = uploadedFor;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public Date getUploadedDate() {
		return uploadedDate;
	}

	public void setUploadedDate(Date uploadedDate) {
		this.uploadedDate = uploadedDate;
	}

	public boolean isNewFileAdded() {
		return newFileAdded;
	}

	public void setNewFileAdded(boolean newFileAdded) {
		this.newFileAdded = newFileAdded;
	}

	public String getStoredFileName() {
		return storedFileName;
	}

	public void setStoredFileName(String storedFileName) {
		this.storedFileName = storedFileName;
	}
	
	

}
