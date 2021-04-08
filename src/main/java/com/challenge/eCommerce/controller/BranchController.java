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

import com.challenge.eCommerce.entity.BranchEntity;
import com.challenge.eCommerce.exception.ResourceNotFoundException;
import com.challenge.eCommerce.service.BranchService;

@RestController
@RequestMapping("/branch/")
public class BranchController {

	@Autowired
	private BranchService branchService;

	@PostMapping("/add/")
	public ResponseEntity<BranchEntity> addBranch(@RequestBody BranchEntity branch){
		BranchEntity addBranch = branchService.addBranch(branch);
		return ResponseEntity.ok(addBranch);

	}

	@PutMapping("/update/")
	public ResponseEntity<BranchEntity> updateBranch(@RequestBody BranchEntity branch) throws ResourceNotFoundException{
		BranchEntity addBranch = branchService.updateBranch(branch);
		return ResponseEntity.ok(addBranch);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteBranch(@PathVariable(value = "id") Long id){
		String message = branchService.deleteBranchById(id);
        return message;
	}

}
