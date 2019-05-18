package com.prashhanthN.ticketTool.common.modal;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RequestActivity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer requestActivityId;
	private Date activityDate;
	private String status;
	private String assignedTo;
	private String assignedGrp;
	private String notes;
	private Integer requestId;
	
	public Integer getRequestActivityId() {
		return requestActivityId;
	}

	public void setRequestActivityId(Integer requestActivityId) {
		this.requestActivityId = requestActivityId;
	}

	public Date getActivityDate() {
		return activityDate;
	}

	public void setActivityDate(Date activityDate) {
		this.activityDate = activityDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public Integer getRequestId() {
		return requestId;
	}

	public void setRequestId(Integer requestId) {
		this.requestId = requestId;
	}
	
	
	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	public String getAssignedGrp() {
		return assignedGrp;
	}

	public void setAssignedGrp(String assignedGrp) {
		this.assignedGrp = assignedGrp;
	}

	@Override
	public String toString() {
		return "RequestActivity [requestActivityId=" + requestActivityId + ", activityDate=" + activityDate
				+ ", status=" + status + ", assignedTo=" + assignedTo + ", assignedGrp=" + assignedGrp + ", notes="
				+ notes + ", requestId=" + requestId + "]";
	}

}
