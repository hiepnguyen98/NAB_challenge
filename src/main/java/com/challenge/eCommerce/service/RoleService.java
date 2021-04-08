package com.challenge.eCommerce.service;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.eCommerce.entity.RoleEntity;
import com.challenge.eCommerce.exception.ResourceNotFoundException;
import com.challenge.eCommerce.repository.RoleRepository;

@Service
public class RoleService {
	@Autowired
	private RoleRepository repository;
	
	public RoleEntity addOrUpdateRole(RoleEntity role) {
		return repository.save(role);
	}
	
	public RoleEntity findbyId(long id) throws ResourceNotFoundException {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("role not found for this id :: " + id));
	}
	public String deleteRoleById(long id) {
		JSONObject jsonObject = new JSONObject();
		try {
			repository.deleteById(id);
			jsonObject.put("message", "role deleted successfully");
		}catch(JSONException e) {
			e.printStackTrace();
		}
		return jsonObject.toString();
	}
}
