package com.challenge.eCommerce.service;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.eCommerce.entity.OrderDetailEntity;
import com.challenge.eCommerce.repository.OrderDetailRepository;

@Service
public class OrderDetailService {
	@Autowired
	private OrderDetailRepository repository;
	
	public OrderDetailEntity addOrUpdateOrderDetail(OrderDetailEntity orderDetail) {
		return repository.save(orderDetail);
	}
	public String deleteOrderDetailByID(long id) {
		JSONObject jsonObject = new JSONObject();
		try {
			repository.deleteById(id);
			jsonObject.put("message", "order detail deleted successfully");
		}catch(JSONException e) {
			e.printStackTrace();
		}
		return jsonObject.toString();
	}
}
