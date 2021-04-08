package com.challenge.eCommerce.service;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.eCommerce.entity.OrderEntity;
import com.challenge.eCommerce.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository repository;
	
	public OrderEntity addOrUpdate(OrderEntity order) {
		return repository.save(order);
	}
	public String deleteOderById(long id) {
		JSONObject jsonObject = new JSONObject();
		try {
			repository.deleteById(id);
			jsonObject.put("message", "order deleted successfully");
		}catch(JSONException e) {
			e.printStackTrace();
		}
		return jsonObject.toString();
	}
}
