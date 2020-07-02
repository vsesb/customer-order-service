package com.ness.microservice.order.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ness.microservice.order.domain.OrderItem;



@FeignClient(url="http://localhost:8081",name = "customer-order-item-service")
public interface OrderItemProxy {
	
	@GetMapping("/orders/{oid}/items")
	public List<OrderItem> listAllOrderItems(@PathVariable int oid);
}
