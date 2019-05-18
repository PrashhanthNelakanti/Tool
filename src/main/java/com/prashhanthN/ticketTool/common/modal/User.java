package com.prashhanthN.ticketTool.common.modal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Integer user_id;
	@Column(unique=true)
	private String userName;
	private String password;
	private String team;
	private Integer super_user;
	private Integer lockAcc;
	
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return userName;
	}
	public void setUser_name(String user_name) {
		this.userName = user_name;
	}
	public Integer getSuper_user() {
		return super_user;
	}
	public void setSuper_user(Integer super_user) {
		this.super_user = super_user;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
		
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	
	public Integer getLockAcc() {
		return lockAcc;
	}
	public void setLockAcc(Integer lockAcc) {
		this.lockAcc = lockAcc;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", userName=" + userName + ", password=" + password + ", team=" + team
				+ ", super_user=" + super_user + ", lockAcc=" + lockAcc + "]";
	}
	
}
