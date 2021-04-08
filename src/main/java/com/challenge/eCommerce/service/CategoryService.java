package com.challenge.eCommerce.service;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.eCommerce.entity.CategoryEntity;
import com.challenge.eCommerce.exception.ResourceNotFoundException;
import com.challenge.eCommerce.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository repository;
	
	public CategoryEntity addCategory(CategoryEntity category) {
		return repository.save(category);
	} 
	
	public CategoryEntity updateCategory(CategoryEntity category) throws ResourceNotFoundException {
		CategoryEntity categoryupdate = getBrandById(category.getId());
		categoryupdate.setCategoryName(category.getCategoryName());
		return repository.save(category);
	} 
	
	public CategoryEntity getBrandById(long id) throws ResourceNotFoundException {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Branch not found for this id :: " + id));
	}
	
	public String deleteCategorybyId(long id) {
		JSONObject jsonObject = new JSONObject();
		try {
			repository.deleteById(id);
			jsonObject.put("message", "category deleted successfully");
		}catch(JSONException e) {
			e.printStackTrace();
		}
		return jsonObject.toString();
	}
}
