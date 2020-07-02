package com.ness.microservice.order.service;

import java.util.List;
import java.util.Optional;

import com.ness.microservice.order.domain.CustomerOrder;

public interface CustomerOrderService {
	public CustomerOrder createCustomerOrder(CustomerOrder customerOrder);
	public List<CustomerOrder> getAllCustomerOrder();
	public Optional<CustomerOrder> getCustomerOrder(int id);
}
