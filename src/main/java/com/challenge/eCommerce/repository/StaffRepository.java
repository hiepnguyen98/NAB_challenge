package com.challenge.eCommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.challenge.eCommerce.entity.StaffEntity;

@Repository
public interface StaffRepository extends JpaRepository<StaffEntity, Long> {
	
	@Query("FROM StaffEntity WHERE email=:email")
	StaffEntity findByEmail(@Param("email") String email);
	
}
