package com.challenge.eCommerce.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.eCommerce.entity.CategoryEntity;
import com.challenge.eCommerce.exception.ResourceNotFoundException;
import com.challenge.eCommerce.service.CategoryService;

@RestController
@RequestMapping("/category/")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;

	@PostMapping("/add/")
	public ResponseEntity<?> addCategory(@RequestBody CategoryEntity category){
		CategoryEntity cate = categoryService.addCategory(category);
		return ResponseEntity.ok(cate);
	}
	@PutMapping("/update/")
	public ResponseEntity<?> updateCategory(@RequestBody CategoryEntity category) throws ResourceNotFoundException{
		CategoryEntity cate = categoryService.updateCategory(category);
		return ResponseEntity.ok(cate);
	}
	@DeleteMapping("/delete/{id}")
	public String deleteCategory(@PathVariable(value = "id") long id) throws ResourceNotFoundException{
		String message = categoryService.deleteCategorybyId(id);
        return message;
	}
}
