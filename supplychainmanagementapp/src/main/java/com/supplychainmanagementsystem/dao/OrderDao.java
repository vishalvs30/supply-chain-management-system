package com.supplychainmanagementsystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.supplychainmanagementsystem.entity.Order;
import com.supplychainmanagementsystem.exceptionpackage.IdNotFoundException;
import com.supplychainmanagementsystem.repository.OrderRepository;

@Repository
public class OrderDao {

	@Autowired
	private OrderRepository orderRepository;
	
		//create a Order
		public Order createOrder(Order order) {
			orderRepository.save(order);
			return order;
		}
		
		//fetch all orders
		public List<Order> getAllOrders(){
			return  orderRepository.findAll();
		}
		
		//fetch order by id
		public Optional<Order> getOrderById(int id) {
			return orderRepository.findById(id);
		}
		
		//delete order by id
		public Optional<Order> deleteOrderById(int id){
			Optional<Order> opt=orderRepository.findById(id);
			if(opt.isPresent()) {
				orderRepository.delete(opt.get());
				return opt;
			}else {
				throw new IdNotFoundException();
			}
		}
		
		//fetch order by Tracking number
		public Optional<Order> getOrderByTrackingNumber(String tracking_number) {
			return orderRepository.findByTrackingNumber(tracking_number);
		}
		
		//get orders by customer id //check it by adding order and cutomr id wirh it 
		public List<Order> getOrdersByCustomerId(int id){
			return orderRepository.findByCustomerId(id);
		}
		
}
