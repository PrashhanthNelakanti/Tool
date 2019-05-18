package com.prashhanthN.ticketTool.common.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.prashhanthN.ticketTool.common.modal.RequestActivity;

public interface RequestActivityRepo extends JpaRepository<RequestActivity, Integer> {

	@Query(value = "select * from request_activity ra where ra.request_id= :reqID", nativeQuery = true)
	public List<RequestActivity> find(@Param("reqID") Integer reqID);

}
