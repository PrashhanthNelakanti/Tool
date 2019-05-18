package com.prashhanthN.ticketTool.test.polling;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import antlr.collections.List;

@Repository
public interface PollingRepo extends JpaRepository<Polling, Integer> {
	public java.util.List<Polling> findAllByOrderByPollsDesc();
}
