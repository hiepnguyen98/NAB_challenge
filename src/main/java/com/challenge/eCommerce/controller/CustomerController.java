package com.challenge.eCommerce.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.eCommerce.entity.CustomerOrder;
import com.challenge.eCommerce.exception.ResourceNotFoundException;
import com.challenge.eCommerce.service.CustomerService;

@RestController
@RequestMapping(value ="/")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/order/")
	public ResponseEntity<?>oder(@RequestBody CustomerOrder customerOrder) throws ResourceNotFoundException{
		Map<String, Boolean> response = customerService.getOder(customerOrder.getOrderDetails(), customerOrder.getOrder());
		return new ResponseEntity(response, HttpStatus.OK);
	}

}
