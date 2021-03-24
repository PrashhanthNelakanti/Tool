package com.prashhanthN.ticketTool.common.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prashhanthN.ticketTool.common.modal.Request;
import com.prashhanthN.ticketTool.common.modal.User;
import com.prashhanthN.ticketTool.common.repo.RequestRepo;
import com.prashhanthN.ticketTool.common.service.RequestService;
import com.prashhanthN.ticketTool.common.service.UserService;

@CrossOrigin(origins="*",allowedHeaders="*")
@RequestMapping ("/ays")
@RestController
public class RequestController {
	
	@Autowired
	private RequestService requestService;
	@Autowired
	private RequestRepo requestRepo;
	 
	@PostMapping("/addRequest")
	public Request createRequest(@RequestBody Request request) {
		if(request.getAssignedTo()==null)
			request.setAssignedTo("empty");
		return requestService.createRequest(request);
	}
	
	@PutMapping("/updateRequest")
	public Request updateRequest(@RequestBody Request request) {
		System.out.println(request);
		return requestService.createRequest(request);
	}
	
	@PutMapping("/updateRequest2/{id}")
	public Request updateRequest2(@PathVariable("id") Integer id,@RequestBody Request request) {
		Optional<Request> reqOptional = requestRepo.findById(id);
		if(reqOptional!=null) {
			return requestRepo.save(request);
		}
		return request;
	}
	
	@DeleteMapping("/deleteRequest/{id}")
	public String removeRequest(@PathVariable int id) {
		Request r=requestRepo.getOne(id);
		requestRepo.delete(r);
		return "deleted Successfully!";
	}
	
	@GetMapping("/getReqByName/{user}")
	public List<Request> requestByName(@PathVariable("user") String user) {
		System.out.println(user);
		return requestService.requestByName(user);
	}
	
	@GetMapping("/getReqById/{id}")
	public Optional<Request> requestById(@PathVariable("id") Integer id) {
		return requestRepo.findById(id);
	}
	
	@GetMapping("/allRequests")
	public List<Request> allRequestDetails(){
		return requestService.allRequestDetails();	
	}
	
	@GetMapping("/requestByGrp/{grp}")
	public Map<String,Integer> requestByGrp(@PathVariable("grp") String grp) {
		return requestService.requestByGrp(grp);
	}
	
	@GetMapping("/requestByGrp/{grp}/{user}")
	public List<Request> findByAssignedGrpAndAssignedTo(@PathVariable("grp") String grp,@PathVariable("user") String user) {
		return requestRepo.findByAssignedGrpAndAssignedTo(grp,user);
	}
	
	
	@GetMapping("/reqCountByGrpnUser/{grp}/{user}")
	public int getCountRequestByGrpnUser(@PathVariable("grp") String grp,@PathVariable("user") String user) {
		List l= findByAssignedGrpAndAssignedTo(grp,user);
		return l.size();
	}
}
