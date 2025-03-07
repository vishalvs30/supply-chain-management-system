package com.supplychainmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.supplychainmanagementsystem.dao.SupplierDao;
import com.supplychainmanagementsystem.dto.ResponseStructure;
import com.supplychainmanagementsystem.entity.Supplier;
import com.supplychainmanagementsystem.exceptionpackage.IdNotFoundException;
import com.supplychainmanagementsystem.exceptionpackage.NoRecordFoundException;

@Service
public class SupplierService {

	@Autowired
	private SupplierDao supplierdao;
	
	//save supplier
	public ResponseEntity<ResponseStructure<Supplier>> saveSupplier(Supplier supplier)
	{
		Supplier recievesupplier= supplierdao.saveSupplier(supplier);
		ResponseStructure<Supplier> structure=new ResponseStructure<Supplier>();
		structure.setStatuscode(HttpStatus.CREATED.value());
		structure.setMessage("Supplier record saved successfully");
		structure.setData(recievesupplier);
		
		return new ResponseEntity<ResponseStructure<Supplier>>(structure,HttpStatus.CREATED);
	}
	//update supplier
	public ResponseEntity<ResponseStructure<Supplier>> updateSupplier(Supplier supplier)
	{
		Supplier recievesupplier= supplierdao.updateSupplier(supplier);
		ResponseStructure<Supplier> structure=new ResponseStructure<Supplier>();
		structure.setStatuscode(HttpStatus.CREATED.value());
		structure.setMessage("Supplier record updated successfully");
		structure.setData(recievesupplier);
		
		return new ResponseEntity<ResponseStructure<Supplier>>(structure,HttpStatus.CREATED);
	}
	
	
	//find all suppliers
	public ResponseEntity<ResponseStructure<List<Supplier>>> getAllSuppliers()
	{
		List<Supplier> supplierList=supplierdao.getAllSuppliers();
		ResponseStructure<List<Supplier>> structure=new ResponseStructure<List<Supplier>>();
		if(!supplierList.isEmpty()) {
		structure.setStatuscode(HttpStatus.CREATED.value());
		structure.setMessage("Fetched All Supplier records successfully");
		structure.setData(supplierList);
			return new ResponseEntity<ResponseStructure<List<Supplier>>>(structure,HttpStatus.CREATED);
		}
		else {
			throw new NoRecordFoundException();
		}
	}
	
	//find by id
	public ResponseEntity<ResponseStructure<Supplier>> getSupplierById(int id)
	{
		Optional<Supplier> opt=supplierdao.getSupplierById(id);
		ResponseStructure<Supplier> structure=new ResponseStructure<Supplier>();
		if(opt.isPresent()) {
			structure.setStatuscode(HttpStatus.ACCEPTED.value());
			structure.setMessage("Fetched Supplier record with id successfully");
			structure.setData(opt.get());
			return new ResponseEntity<ResponseStructure<Supplier>>(structure,HttpStatus.CREATED);
		}else {
			throw new IdNotFoundException();
		}
	}
	
	//delete by id
		public ResponseEntity<ResponseStructure<Supplier>> deleteSupplierById(int id)
		{
			Optional<Supplier> opt=supplierdao.deleteSupplier(id);
			ResponseStructure<Supplier> structure=new ResponseStructure<Supplier>();
			if(opt.isPresent()) {
				structure.setStatuscode(HttpStatus.OK.value());
				structure.setMessage("Deleted Supplier record with id successfully");
				structure.setData(opt.get());
				return new ResponseEntity<ResponseStructure<Supplier>>(structure,HttpStatus.CREATED);
			}else {
				throw new IdNotFoundException();
			}
		}
	
}
