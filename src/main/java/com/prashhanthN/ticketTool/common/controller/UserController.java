package com.prashhanthN.ticketTool.common.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prashhanthN.ticketTool.common.modal.User;
import com.prashhanthN.ticketTool.common.repo.UserRepo;
import com.prashhanthN.ticketTool.common.service.UserService;



@CrossOrigin(origins="*",allowedHeaders="*")
@RequestMapping ("/ays")
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepo userRepo;
	 
	@PostMapping("/addUser")
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	
	@PutMapping("/updateUser")
	public User updateUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	@PostMapping("/unlockUser")
	public boolean unlockAcc(@RequestBody User user) {
		return userService.unlockAcc(user.getUser_name());
	}
	
	@GetMapping("/allUsers")
	public List<User> allUserDetails(){
		return userService.allUserDetails();	
	}
	
	@GetMapping("/user/{name}")
	public User userDetails(@PathVariable("name") String name){
		return userRepo.getByUserName(name);	
	}
	
	@GetMapping("/team/{team}")
	public List<User> getUserByTeam(@PathVariable("team") String team){
		return userRepo.getByTeam(team);	
	}
	
	@PostMapping("/auth") 
	public Integer auth(@RequestBody User auth) {
		System.out.println(auth.getUser_name());
		System.out.println(auth.getPassword());
		return userService.checkUser(auth.getUser_name(),auth.getPassword());
	}
}
