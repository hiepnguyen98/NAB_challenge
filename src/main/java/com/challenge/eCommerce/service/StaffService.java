package com.challenge.eCommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.challenge.eCommerce.entity.StaffEntity;
import com.challenge.eCommerce.exception.ResourceNotFoundException;
import com.challenge.eCommerce.repository.StaffRepository;

@Service
public class StaffService {
	
	@Autowired
	private StaffRepository repository;
	
	public StaffEntity addOrUpdateStaff(StaffEntity staff) {
		staff.setPassword(encodePassword(staff.getPassword()));
		return repository.save(staff);
	}
	public List<StaffEntity> findAllStaff(){
		return repository.findAll();
	}
	 
	public StaffEntity findStaffById(long id) throws ResourceNotFoundException {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("staff not found for this id :: " + id));
	}
	 
	public String encodePassword(String pass) {
		BCryptPasswordEncoder bCryptEncode = new BCryptPasswordEncoder();
		return bCryptEncode.encode(pass);
	}
}
