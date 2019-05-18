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

import com.prashhanthN.ticketTool.common.modal.Request;
import com.prashhanthN.ticketTool.common.modal.RequestActivity;
import com.prashhanthN.ticketTool.common.repo.RequestActivityRepo;
import com.prashhanthN.ticketTool.common.repo.RequestRepo;

@CrossOrigin(origins="*",allowedHeaders="*")
@RequestMapping ("/ays")
@RestController
public class RequestActivityController {
	
	@Autowired
	private RequestActivityRepo requestActivityRepo;
	
	@Autowired
	private RequestRepo requestRepo;

	@PostMapping("/addRActivity")
	public RequestActivity createRequest(@RequestBody RequestActivity request) {
		Request req= requestRepo.getOne(request.getRequestId());
		req.setAssignedGrp(request.getAssignedGrp());
		req.setAssignedTo(request.getAssignedTo());
		if(request.getStatus().equals("R")){
			req.setResolvedBy(request.getAssignedTo());
			req.setResolvedByGrp(request.getAssignedGrp());
		}
		requestRepo.save(req);
		return requestActivityRepo.save(request);
	}
	
	@GetMapping("/RActivityDetail/{id}")
	public List<RequestActivity> getRequest(@PathVariable("id") Integer reqID) {
		return requestActivityRepo.find(reqID);
	}
}
