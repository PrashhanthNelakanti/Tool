package com.prashhanthN.ticketTool.common.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prashhanthN.ticketTool.common.modal.Request;
@Repository
public interface RequestRepo extends JpaRepository<Request, Integer>{
	
	List<Request> findByRequestedBy(String user);
	List<Request> findByAssignedGrp(String grp);
	List<Request> findByAssignedGrpAndAssignedTo(String grp,String user);

}
