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
import com.supplychainmanagementsystem.entity.Supplier;
import com.supplychainmanagementsystem.service.SupplierService;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {

	@Autowired
	private SupplierService supplierservice;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Supplier>> saveSupplierRecord(@RequestBody Supplier supplier)
	{
		return supplierservice.saveSupplier(supplier);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Supplier>> updateSupplierRecord(@RequestBody Supplier supplier)
	{
		return supplierservice.updateSupplier(supplier);
	}
	
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Supplier>>> getAllSupplierRecords()
	{
		return supplierservice.getAllSuppliers();
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<ResponseStructure<Supplier>> getSupplierRecordById(@PathVariable int id)
	{
		return supplierservice.getSupplierById(id);
	}
	
	@DeleteMapping("/id/{id}")
	public ResponseEntity<ResponseStructure<Supplier>> deleteSupplierRecordById(@PathVariable int id)
	{
		return supplierservice.deleteSupplierById(id);
	}
}
