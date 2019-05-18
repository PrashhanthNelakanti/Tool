package com.prashhanthN.ticketTool.common.service;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prashhanthN.ticketTool.common.modal.Request;
import com.prashhanthN.ticketTool.common.modal.User;
import com.prashhanthN.ticketTool.common.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;

	// @Autowired
	private Logger log;

	private int lockAcc;

	public User createUser(User user) {
		userRepo.save(user);
		return user;
	}

	public Integer checkUser(String userName, String pwd) {
		User user = userRepo.getByUserName(userName);
		if (user != null && user.getLockAcc() < 3) {
			if (user.getUser_name().equals(userName) && user.getPassword().equals(pwd) && (user.getSuper_user() == 1)) {
				return 2;
			} else if (user.getUser_name().equals(userName) && user.getPassword().equals(pwd)
					&& user.getSuper_user() != 1) {
				return 1;
			}
			lockAcc++;
		}
		if (lockAcc > 3) {
			user.setLockAcc(lockAcc);
			userRepo.save(user);
			return -1;
		}
		return 0;
	}

	public List<User> allUserDetails() {
		return userRepo.findAll();
	}
	
	public boolean unlockAcc(String userName){
		User user = userRepo.getByUserName(userName);
		if(user!=null && user.getLockAcc()>3){
			user.setLockAcc(0);
			userRepo.save(user);
			return true;			
		}	
		return false;
	}

}
