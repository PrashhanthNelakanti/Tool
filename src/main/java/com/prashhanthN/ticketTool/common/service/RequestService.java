package com.prashhanthN.ticketTool.common.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prashhanthN.ticketTool.common.modal.Request;
import com.prashhanthN.ticketTool.common.modal.User;
import com.prashhanthN.ticketTool.common.repo.RequestRepo;

@Service
public class RequestService {
	
	@Autowired
	private RequestRepo requestRepo;
	
	public Request  createRequest(Request request) {
		request.setRequested_on(new Date());
		requestRepo.save(request);
		return request;
	}
	
	public List<Request> allRequestDetails() {	
		return requestRepo.findAll();
	}
	
	public List<Request> requestByName(String user) {	
		return requestRepo.findByRequestedBy(user);
	}

	public Map<String,Integer> requestByGrp(String grp) {	
		ArrayList<Request> reqs= new ArrayList<>();
		HashMap<String, Integer> hm= new HashMap<>();
		reqs=(ArrayList<Request>) requestRepo.findByAssignedGrp(grp);
		for(Request req:reqs){
			if(hm.get(req.getAssignedTo())!=null){
				hm.put(req.getAssignedTo(), hm.get(req.getAssignedTo())+1);
			}
			else
			hm.put(req.getAssignedTo(), 1);
		}
		System.out.println(hm);
		return hm;
	}


}
