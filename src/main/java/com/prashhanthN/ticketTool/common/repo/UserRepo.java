package com.prashhanthN.ticketTool.common.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prashhanthN.ticketTool.common.modal.User;
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
      User getByUserName(String userName);
      List<User> getByTeam(String team);
}
