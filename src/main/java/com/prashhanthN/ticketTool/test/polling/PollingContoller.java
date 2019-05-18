package com.prashhanthN.ticketTool.test.polling;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prashhanthN.ticketTool.common.modal.User;

@CrossOrigin(origins="*",allowedHeaders="*")
@RequestMapping ("/ays/polling")
@RestController
public class PollingContoller {
	
	@Autowired
	private PollingRepo polling;
	
	@PostMapping("/addParty")
	public Polling addParty(@RequestBody Polling polling){
		this.polling.save(polling);
		return polling;
	}
	
	@GetMapping("/party")
	public List<Polling> getParty(){
		return this.polling.findAllByOrderByPollsDesc();
	}
	
	@GetMapping("/getTime")
	public Date getTime(){
		return new Date();
	}
	
	//@GetMapping("/party")
	public HashMap<String,HashMap<HashMap<String,Date>,List<Polling>>> getPartyTest(){
		HashMap<HashMap<String,Date>,List<Polling>> hm= new HashMap<>();
		HashMap<String,HashMap<HashMap<String,Date>,List<Polling>>> data= new HashMap<>();
		HashMap hm1=new HashMap<>();
		hm1.put("date",new Date());
		hm.put(hm1,this.polling.findAllByOrderByPollsDesc());
		data.put("Data", hm);
		return data;
	}
	
	@GetMapping("/vote/{id}")
	public Polling castVote(@PathVariable("id") Integer id){
		Polling partyObj=this.polling.getOne(id);
		int currPoll=partyObj.getPolls()+1;
		partyObj.setPolls(currPoll);
		return this.polling.save(partyObj);
	}

}
