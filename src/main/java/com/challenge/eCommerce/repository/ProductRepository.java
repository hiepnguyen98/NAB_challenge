package com.challenge.eCommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.challenge.eCommerce.entity.ProductEntity;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
	@Query("FROM ProductEntity p LEFT JOIN p.branch b"
			+ "    LEFT JOIN p.category c"
			+ " WHERE "
			+ "       p.color like %:key% OR p.decription like %:key% OR p.productName like %:key%"
			+ "		OR b.branchName like %:key% OR c.categoryName like %:key%")
	public List<ProductEntity> searchProduct(@Param("key") String key);

	@Query("FROM ProductEntity p"
			+ " ORDER BY price ASC")
	public List<ProductEntity> sortProductByPriceAsc();
	
	@Query("FROM ProductEntity p"
			+ " ORDER BY price DESC")
	public List<ProductEntity> sortProductByPriceDesc();
	
	public List<ProductEntity> findByBranchId(long branchId);
	public List<ProductEntity> findByCategoryId(long branchId);
}
