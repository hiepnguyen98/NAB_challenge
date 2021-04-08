package com.challenge.eCommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.eCommerce.entity.StaffEntity;
import com.challenge.eCommerce.exception.ResourceNotFoundException;
import com.challenge.eCommerce.service.StaffService;

@RestController
@RequestMapping("/manage/")
public class StaffController {
	@Autowired
	private StaffService staffService;

	@PostMapping("/staff/add/")
	public ResponseEntity<StaffEntity> addStaff(@RequestBody StaffEntity staffEntity) throws ResourceNotFoundException{
		StaffEntity staff =  staffService.addOrUpdateStaff(staffEntity);
		return ResponseEntity.ok(staff);
	}

	@PutMapping("/staff/update/")
	public ResponseEntity<StaffEntity> updateStaff(@RequestBody StaffEntity staffEntity) throws ResourceNotFoundException{
		StaffEntity staff =  staffService.addOrUpdateStaff(staffEntity);
		return ResponseEntity.ok(staff);
	}

}
