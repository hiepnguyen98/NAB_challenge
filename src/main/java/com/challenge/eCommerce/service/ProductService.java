package com.challenge.eCommerce.service;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.eCommerce.entity.ProductEntity;
import com.challenge.eCommerce.exception.ResourceNotFoundException;
import com.challenge.eCommerce.repository.ProductRepository;
@Service
public class ProductService{
	@Autowired
	private ProductRepository repository;

	public ProductEntity UpdateProduct(ProductEntity product) throws ResourceNotFoundException {
		ProductEntity Existingprod = getProductById(product.getId());
		Existingprod.setBranch(product.getBranch());
		Existingprod.setCategory(product.getCategory());
		Existingprod.setColor(product.getColor());
		Existingprod.setDecription(product.getDecription());
		Existingprod.setImage(product.getImage());
		Existingprod.setPrice(product.getPrice());
		Existingprod.setProductName(product.getProductName());
		Existingprod.setQuantity(product.getQuantity());
		return repository.save(product);
	}

	public ProductEntity addProduct(ProductEntity product) throws ResourceNotFoundException {
		return repository.save(product);
	}

	public String deleteProduct(long id) throws ResourceNotFoundException{
		ProductEntity product = getProductById(id);
		JSONObject jsonObject = new JSONObject();
		try {
			repository.delete(product);
			jsonObject.put("message", "product deleted successfully");
		}catch(JSONException e) {
			e.printStackTrace();
		}
		return jsonObject.toString();
	}

	public List<ProductEntity> getAllProduct(){
		return repository.findAll();
	}

	public ProductEntity getProductById(long id) throws ResourceNotFoundException{
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("product not found for this id :: " + id));
	}

	public List<ProductEntity> searchProduct(String search){
		return repository.searchProduct(search);
	}

	public List<ProductEntity> filterProductByCategory(long category){
		return repository.findByCategoryId(category);
	}

	public List<ProductEntity> filterProductByBranch(long branch){
		return repository.findByBranchId(branch);
	}

	public List<ProductEntity> sortPoductByPriceAscending(){
		return repository.sortProductByPriceAsc();
	}

	public List<ProductEntity> sortPoductByPriceDescending(){
		return repository.sortProductByPriceDesc();
	}

}
