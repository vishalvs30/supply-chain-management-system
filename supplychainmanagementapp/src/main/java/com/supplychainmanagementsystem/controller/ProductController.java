package com.supplychainmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supplychainmanagementsystem.dto.ResponseStructure;
import com.supplychainmanagementsystem.entity.Product;
import com.supplychainmanagementsystem.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	private ProductService productservice;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Product>> addProducts(@RequestBody Product product)
	{
		return productservice.addProduct(product);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Product>> updateProduct(@RequestBody Product product)
	{
		return productservice.updateProduct(product);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Product>>> getAllProducts(){
		return productservice.getAllProducts();
	}
	
	@DeleteMapping("/id/{id}")
	public ResponseEntity<ResponseStructure<Product>> deleteProductById(@PathVariable int id)
	{
		return productservice.deleteProductById(id);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<ResponseStructure<Product>> getProductById(@PathVariable int id)
	{
		return productservice.getProductById(id);
	}
	
	@GetMapping("/supplierid/{id}")
	public ResponseEntity<ResponseStructure<List<Product>>> getProductBySupplierId(@PathVariable int id){
		return productservice.getProductBySupplierId(id);
	}
}
