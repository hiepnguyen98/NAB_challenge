package com.challenge.eCommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.challenge.eCommerce.entity.BranchEntity;
import com.challenge.eCommerce.entity.CategoryEntity;
import com.challenge.eCommerce.entity.RoleEntity;
import com.challenge.eCommerce.entity.StaffEntity;
import com.challenge.eCommerce.service.BranchService;
import com.challenge.eCommerce.service.CategoryService;
import com.challenge.eCommerce.service.RoleService;
import com.challenge.eCommerce.service.StaffService;

@SpringBootApplication
public class ChallengeInteviewApplication implements CommandLineRunner{
//	@Autowired
//	private RoleService roleService;
//	@Autowired
//	private StaffService staffService;
//	
//	@Autowired
//	private CategoryService categoryService;
//	
//	@Autowired
//	private BranchService branchService;
	public static void main(String[] args) {
		SpringApplication.run(ChallengeInteviewApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception{
//		BranchEntity branch = new BranchEntity();
//		branch.setBranchName("Samsung");
//		branchService.addBranch(branch);
//		BranchEntity branch1 = new BranchEntity();
//		branch1.setBranchName("laptop");
//		branchService.addBranch(branch1);
//		
//		CategoryEntity cate = new CategoryEntity();
//		cate.setCategoryName("phone");
//		categoryService.addCategory(cate);
//		CategoryEntity cate1 = new CategoryEntity();
//		cate1.setCategoryName("laptop");
//		categoryService.addCategory(cate1);
		
		
		
	}

}
