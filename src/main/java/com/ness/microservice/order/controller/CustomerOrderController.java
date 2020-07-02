package com.ness.microservice.order.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.http.ResponseEntity;
//import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ness.microservice.order.domain.CustomerOrder;
import com.ness.microservice.order.domain.OrderItem;
import com.ness.microservice.order.service.CustomerOrderServiceImpl;

@RestController
@EnableFeignClients("com.ness.microservice.order.controller")
public class CustomerOrderController {

	@Autowired
	private CustomerOrderServiceImpl customerOrderServiceImpl;

	
	@Autowired
	private OrderItemProxy proxy;

	// feign proxy call - inter service call
	@GetMapping("/customer-order/{oid}/items") 
	public List<OrderItem> listAllOrderItems(int oid){
		List<OrderItem> itemsList = proxy.listAllOrderItems(oid); 
		return itemsList;
	}
	
	
	@GetMapping("/customer-order")
	public List<CustomerOrder> getAllOrderItem() {
		return customerOrderServiceImpl.getAllCustomerOrder();
	}
	
	@GetMapping("/customer-order/{oid}")
	public Optional<CustomerOrder> getOrderItem(@PathVariable int id) {
		return customerOrderServiceImpl.getCustomerOrder(id);
	}

	@PostMapping("/customer-order")
	public ResponseEntity<CustomerOrder> createOrder(@RequestBody CustomerOrder customerOrder) {
		CustomerOrder custOrder = customerOrderServiceImpl.createCustomerOrder(customerOrder);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{oid}")
				.buildAndExpand(custOrder.getOrderId())
				.toUri();
		return ResponseEntity.created(uri).build();			
	}
}
