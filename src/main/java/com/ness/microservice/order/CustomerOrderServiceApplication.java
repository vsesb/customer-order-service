package com.ness.microservice.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.feign.EnableFeignClients;


@SpringBootApplication
public class CustomerOrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerOrderServiceApplication.class, args);
	}

}
