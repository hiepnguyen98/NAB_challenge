package com.challenge.eCommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.challenge.eCommerce.entity.BranchEntity;
@Repository
public interface BranchRepository extends JpaRepository<BranchEntity, Long> {

}
