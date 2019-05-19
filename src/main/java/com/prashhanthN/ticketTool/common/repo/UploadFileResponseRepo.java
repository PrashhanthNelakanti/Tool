package com.prashhanthN.ticketTool.common.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UploadFileResponseRepo extends JpaRepository<com.prashhanthN.ticketTool.common.modal.UploadFileResponse, Integer> {

}
