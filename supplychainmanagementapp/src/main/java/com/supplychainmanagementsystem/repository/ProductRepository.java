package com.supplychainmanagementsystem.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.supplychainmanagementsystem.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

//	List<Product> findBySupplierId(int supplierid);
}
