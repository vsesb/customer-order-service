package com.ness.microservice.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ness.microservice.order.domain.CustomerOrder;


@Repository
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Integer> {


}
