package com.prashhanthN.ticketTool.fkart;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
@RequestMapping("/ays")
public class ProductController {

	@Autowired
	private ProductsService productsService;

	@GetMapping("/getP")
	public List<Products> getProducts() {
		return productsService.getProducts();
	}

	@GetMapping("/getP/{pid}")
	public Optional<Products> getProduct(@PathVariable("pid") Integer pid) {
		return productsService.getProduct(pid);
	}

	@PostMapping("/postP")
	public Products postProducts(@RequestBody Products products) {
		return productsService.addProducts(products);
	}
}
