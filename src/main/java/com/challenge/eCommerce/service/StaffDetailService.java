package com.challenge.eCommerce.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.challenge.eCommerce.entity.StaffEntity;
import com.challenge.eCommerce.repository.StaffRepository;

@Service
public class StaffDetailService implements UserDetailsService {
	@Autowired
	private StaffRepository repository;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		StaffEntity staff = repository.findByEmail(email);
		if(staff == null) {
			throw new UsernameNotFoundException("Email"+email+"not found");
		}
		// TODO Auto-generated method stub
		return new org.springframework.security.core.userdetails.User(staff.getEmail(), staff.getPassword(), getGranteAuthority(staff));
	}
	
	private Collection<GrantedAuthority> getGranteAuthority(StaffEntity staff) {
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		if(staff.getRole().getName().equalsIgnoreCase("admin")) {
			authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		}else {
			authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		}
		return authorities;
	}
}
