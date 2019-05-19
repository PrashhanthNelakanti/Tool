package com.prashhanthN.ticketTool.fkart;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductsService {

	@Autowired
	private ProductRepo productRepo;
	
	public Products addProducts(Products products) {		
		return productRepo.save(products);
	}
	
	public Optional<Products> getProduct(Integer pid) {		
		return productRepo.findById(pid);
	}
	
	public List<Products> getProducts() {
		return productRepo.findAll();
				
	}

}
