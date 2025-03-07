package com.supplychainmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supplychainmanagementsystem.dto.ResponseStructure;
import com.supplychainmanagementsystem.entity.Order;
import com.supplychainmanagementsystem.service.OrderService;


@RestController
@RequestMapping("/api/order")
public class OrderController {

	@Autowired
	private OrderService orderservice;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Order>> createOrder(@RequestBody Order order)
	{
		return orderservice.createOrder(order);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Order>>> getAllOrders(){
		return orderservice.getAllOrders();
	}
	
	@DeleteMapping("/id/{id}")
	public ResponseEntity<ResponseStructure<Order>> deleteOrderById(@PathVariable int id)
	{
		return orderservice.deleteOrderById(id);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<ResponseStructure<Order>> getOrderById(@PathVariable int id)
	{
		return orderservice.getOrderById(id);
	}
	
	@GetMapping("/tracking/{tracking_number}")
	public ResponseEntity<ResponseStructure<Order>> getOrderByTrackingNumber(@PathVariable String tracking_number)
	{
		return orderservice.getOrderByTrackingNumber(tracking_number);
	}
	
	@GetMapping("/c_id/{id}")
	public ResponseEntity<ResponseStructure<List<Order>>> getOrdersByCustomerId(@PathVariable int id)
	{
		return orderservice.getOrdersByCustomerId(id);
	}
	
}
