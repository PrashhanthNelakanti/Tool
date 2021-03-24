package com.prashhanthN.ticketTool.jpaClasses;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface AuthorRepo extends JpaRepository<Author,Integer> {
}
