package com.ness.microservice.order.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ness.microservice.order.domain.CustomerOrder;
import com.ness.microservice.order.exception.CustomerOrderNotFoundException;
import com.ness.microservice.order.repository.CustomerOrderRepository;


@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

	@Autowired
	private CustomerOrderRepository customerOrderRepository;
	@Override
	public CustomerOrder createCustomerOrder(CustomerOrder customerOrder) {
		CustomerOrder custOrder = customerOrderRepository.save(customerOrder);
		return custOrder;
		
	}

	@Override
	public List<CustomerOrder> getAllCustomerOrder() {
		// TODO Auto-generated method stub
		List<CustomerOrder> orderItems = customerOrderRepository.findAll();
		return orderItems;
	}

	@Override
	public Optional<CustomerOrder> getCustomerOrder(int id) {
		Optional<CustomerOrder> customerOrder =  customerOrderRepository.findById(id);
		if (customerOrder.isPresent()) {
			return customerOrder;
		}else {
			throw new CustomerOrderNotFoundException(" id " +id);
		}
		
	}

}
