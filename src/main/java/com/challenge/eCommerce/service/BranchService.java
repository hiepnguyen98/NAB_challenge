package com.challenge.eCommerce.service;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.eCommerce.entity.BranchEntity;
import com.challenge.eCommerce.exception.ResourceNotFoundException;
import com.challenge.eCommerce.repository.BranchRepository;


@Service
public class BranchService {
	
	@Autowired
	private BranchRepository repository;
	
	public BranchEntity addBranch(BranchEntity branch) {
		return repository.save(branch);
	}
	
	public BranchEntity updateBranch(BranchEntity branch) throws ResourceNotFoundException {
		BranchEntity updateBranch = getBrandById(branch.getId());
		updateBranch.setBranchName(branch.getBranchName());
		return repository.save(updateBranch);
	}
	
	public BranchEntity getBrandById(long id) throws ResourceNotFoundException {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Branch not found for this id :: " + id));
	}
	
	public String deleteBranchById(long id) {
		JSONObject jsonObject = new JSONObject();
		try {
			repository.deleteById(id);
			jsonObject.put("message", "branch deleted successfully");
		}catch(JSONException e) {
			e.printStackTrace();
		}
		
		return jsonObject.toString();
	}
	
}
