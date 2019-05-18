package com.prashhanthN.ticketTool.test.polling;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Polling {
	@Id
	private int id;
	@GeneratedValue(strategy = GenerationType.TABLE)
	private String party;
	private int polls;
	@Override
	public String toString() {
		return "Polling [id=" + id + ", party=" + party + ", polls=" + polls + "]";
	}
	
	public Polling() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getParty() {
		return party;
	}

	public void setParty(String party) {
		this.party = party;
	}

	public int getPolls() {
		return polls;
	}

	public void setPolls(int polls) {
		this.polls = polls;
	}


	

}
