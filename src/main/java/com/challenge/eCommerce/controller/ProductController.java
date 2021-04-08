package com.challenge.eCommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.eCommerce.entity.ProductEntity;
import com.challenge.eCommerce.exception.ResourceNotFoundException;
import com.challenge.eCommerce.service.ProductService;

@RestController
@RequestMapping(value ="/product/")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@DeleteMapping("/manage/delete/{id}")
	public void deleteProduct(@PathVariable(value = "id") Long productId) throws ResourceNotFoundException{
		productService.deleteProduct(productId);
	}
	
	@PutMapping("/manage/update")
	public ResponseEntity<ProductEntity> updateProduct(@RequestBody ProductEntity product) throws ResourceNotFoundException {
		final ProductEntity prodUpdate = productService.UpdateProduct(product);
		return ResponseEntity.ok(prodUpdate);
	}
	
	@PostMapping("/manage/add")
	public ProductEntity addProduct(@RequestBody ProductEntity product) throws ResourceNotFoundException {
		return productService.addProduct(product);
	}
	
	@GetMapping("/search/{searchKey}")
	public ResponseEntity<List<ProductEntity>> addProduct(@PathVariable(value = "searchKey") String input){
		return ResponseEntity.ok(productService.searchProduct(input));
	}
	
	@GetMapping("/all/")
	public ResponseEntity<List<ProductEntity>> getAllProduct() {
		return ResponseEntity.ok(productService.getAllProduct());
	}
	
	@GetMapping("/filter/category/{categoryId}")
	public ResponseEntity<List<ProductEntity>> filterByCategory(@PathVariable(value = "categoryId") long categoryId) {
		List<ProductEntity> products = productService.filterProductByCategory(categoryId);
		return ResponseEntity.ok(products);
	}
	@GetMapping("/filter/branch/{branchId}")
	public ResponseEntity<List<ProductEntity>> filterByBranch(@PathVariable(value = "branchId") long branchId) {
		List<ProductEntity> products = productService.filterProductByBranch(branchId);
		return ResponseEntity.ok(products);
	}
	@GetMapping("/sort/descending/")
	public ResponseEntity<List<ProductEntity>> sortProductDescending() {
		List<ProductEntity> products = productService.sortPoductByPriceDescending();
		return ResponseEntity.ok(products);
	}
	
	@GetMapping("/sort/ascending/")
	public ResponseEntity<List<ProductEntity>> sortProductAscending() {
		List<ProductEntity> products = productService.sortPoductByPriceAscending();
		return ResponseEntity.ok(products);
	}
}
