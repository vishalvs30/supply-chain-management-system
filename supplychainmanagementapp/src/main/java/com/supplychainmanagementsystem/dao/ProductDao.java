package com.supplychainmanagementsystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.supplychainmanagementsystem.entity.Product;
import com.supplychainmanagementsystem.entity.Supplier;
import com.supplychainmanagementsystem.exceptionpackage.IdNotFoundException;
import com.supplychainmanagementsystem.exceptionpackage.NoRecordFoundException;
import com.supplychainmanagementsystem.repository.ProductRepository;
import com.supplychainmanagementsystem.repository.SupplierRepository;

@Repository
public class ProductDao {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private SupplierRepository supplierRepository;
	
	//add a product
	public Product addProduct(Product product) {
		productRepository.save(product);
		return product;
	}
	
	//update a product
	public Product updateProduct(Product product) {
		productRepository.save(product);
		return product;
	}
	
	//fetch all products
	public List<Product> getAllProducts(){
		return  productRepository.findAll();
	}
	
	public Optional<Product> getProductById(int id) {
		return productRepository.findById(id);
	}
	
	public Optional<Product> deleteProductById(int id){
		Optional<Product> opt=productRepository.findById(id);
		if(opt.isPresent()) {
			productRepository.delete(opt.get());
			return opt;
		}else {
			throw new IdNotFoundException();
		}
	}
	//get products by supplier id
	public List<Product> getProductBySupplierId(int id) {
		Optional<Supplier> opt= supplierRepository.findById(id);
		
		if(opt.isPresent()) {
			return opt.get().getProducts();
		}else {
			throw new NoRecordFoundException();
		}
		
	}
}
