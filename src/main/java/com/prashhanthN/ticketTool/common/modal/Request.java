package com.prashhanthN.ticketTool.common.modal;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Request implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer request_id;
	private String requestedBy;
	private String request;
	private Date requested_on;
	private String status;
	private String assignedTo;
	private String assignedGrp;
	private String resolvedBy;
	private String resolvedByGrp;
	private Boolean isResolved;
	
	public Integer getRequest_id() {
		return request_id;
	}

	public void setRequest_id(Integer request_id) {
		this.request_id = request_id;
	}

	public String getRequestedBy() {
		return requestedBy;
	}

	public void setRequestedBy(String requestedBy) {
		this.requestedBy = requestedBy;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public Date getRequested_on() {
		return requested_on;
	}

	public void setRequested_on(Date requested_on) {
		this.requested_on = requested_on;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getResolvedBy() {
		return resolvedBy;
	}

	public void setResolvedBy(String resolvedBy) {
		this.resolvedBy = resolvedBy;
	}

	public String getResolvedByGrp() {
		return resolvedByGrp;
	}

	public void setResolvedByGrp(String resolvedByGrp) {
		this.resolvedByGrp = resolvedByGrp;
	}

	public Boolean getIsResolved() {
		return isResolved;
	}

	public void setIsResolved(Boolean isResolved) {
		this.isResolved = isResolved;
	}
	
	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public String getAssignedGrp() {
		return assignedGrp;
	}

	public void setAssignedGrp(String assignedGrp) {
		this.assignedGrp = assignedGrp;
	}

	@Override
	public String toString() {
		return "Request [request_id=" + request_id + ", requestedBy=" + requestedBy + ", request=" + request
				+ ", requested_on=" + requested_on + ", status=" + status + ", resolvedBy=" + resolvedBy
				+ ", resolvedByGrp=" + resolvedByGrp + ", isResolved=" + isResolved + "]";
	}

}
