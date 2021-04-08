package com.challenge.eCommerce;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.challenge.eCommerce.controller.ProductController;
import com.challenge.eCommerce.entity.BranchEntity;
import com.challenge.eCommerce.entity.CategoryEntity;
import com.challenge.eCommerce.entity.ProductEntity;
import com.challenge.eCommerce.service.ProductService;
import com.challenge.eCommerce.service.StaffDetailService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(ProductController.class)
public class ProductControllerUnitTest {
	private BranchEntity branch = new BranchEntity(1,"Apple");

	private CategoryEntity category = new CategoryEntity(1,"phone");;
	List<ProductEntity> products;
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper mapper;
	@MockBean
	private ProductService productService;
	@MockBean
	private StaffDetailService staffDetailService;
	@MockBean
	private AuthenticationEntryPoint entryPoint;

	@Test
	public void testGetAllProduct() throws Exception {
		products = Arrays.asList(
                new ProductEntity(1, "Iphone 6", 7000000, 20, "Beautifull","red",
            			"demo.jpg", branch, category),
                new ProductEntity(1, "Iphone 7", 9000000, 20, "Beautifull","pink",
            			"demo.jpg", branch, category));
		when(productService.getAllProduct()).thenReturn(products);
		mockMvc.perform(get("/product/all/").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
		verify(productService, times(1)).getAllProduct();
        verifyNoMoreInteractions(productService);
	}
	//add product
	@WithMockUser(value = "hiepnguyen29011998@gmai.com", roles = "ADMIN")
	@Test
	public void testAddNewProductPass() throws Exception {

		ProductEntity product = new ProductEntity(3, "Iphone 6", 7000000, 20, "Beautifull","red",
            			"demo.jpg", branch, category);
		String json = mapper.writeValueAsString(product);
		MvcResult result = mockMvc.perform(post("/product/manage/add/").content(json).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk()).andReturn();
		assertEquals(200,result.getResponse().getStatus());
	}

	@WithMockUser(value = "hiepnguyen29011998@gmai.com", roles = "USER")
	@Test
	public void testAddNewProductFail() throws Exception {

		ProductEntity product = new ProductEntity(3, "Iphone 6", 7000000, 20, "Beautifull","red",
            			"demo.jpg", branch, category);
		String json = mapper.writeValueAsString(product);
		MvcResult result = mockMvc.perform(post("/product/manage/add/").content(json).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isForbidden()).andReturn();
		assertEquals(403,result.getResponse().getStatus());
	}
	//update product
	@WithMockUser(value = "hiepnguyen29011998@gmai.com", roles = "ADMIN")
	@Test
	public void testUpdateProduct() throws Exception {

		ProductEntity product = new ProductEntity(3, "Iphone 6", 7000000, 20, "sweat","red",
            			"demo.jpg", branch, category);
		String json = mapper.writeValueAsString(product);
		MvcResult result = mockMvc.perform(put("/product/manage/update/").content(json).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk()).andReturn();
		assertEquals(200,result.getResponse().getStatus());
	}

	//delete product
	@WithMockUser(value = "hiepnguyen29011998@gmai.com", roles = "ADMIN")
	@Test
	public void testDeleteProduct() throws Exception {
		ProductEntity product = new ProductEntity(4, "Iphone 6", 7000000, 20, "Beautifull","red",
    			"demo.jpg", branch, category);
		String url = "/product/manage/delete/" + product.getId();
		MvcResult result = mockMvc.perform(delete(url).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk()).andReturn();
		assertEquals(200,result.getResponse().getStatus());
	}

	@Test
	public void testSearchProduct() throws Exception{
		String searchKey = "red";
		when(productService.searchProduct(searchKey)).thenReturn(products);
		String url = "/product/search/" + searchKey;
		mockMvc.perform(get(url).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
		verify(productService, times(1)).searchProduct(searchKey);
        verifyNoMoreInteractions(productService);
	}

	@Test
	public void testProductFilterByBranch() throws Exception{
		products = Arrays.asList(
                new ProductEntity(1, "Iphone 6", 7000000, 20, "Beautifull","red",
            			"demo.jpg", branch, category),
                new ProductEntity(1, "Iphone 7", 9000000, 20, "Beautifull","pink",
            			"demo.jpg", branch, category));
		long branchId =branch.getId();
		when(productService.filterProductByBranch(branchId)).thenReturn(products);
		String url = "/product/filter/branch/" + branchId;
		mockMvc.perform(get(url).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
		verify(productService, times(1)).filterProductByBranch(branchId);
        verifyNoMoreInteractions(productService);
	}

	@Test
	public void testProductFilterByCategory() throws Exception{
		products = Arrays.asList(
                new ProductEntity(1, "Iphone 6", 7000000, 20, "Beautifull","red",
            			"demo.jpg", branch, category),
                new ProductEntity(1, "Iphone 7", 9000000, 20, "Beautifull","pink",
            			"demo.jpg", branch, category));
		long categoryId =category.getId();
		when(productService.filterProductByCategory(categoryId)).thenReturn(products);
		String url = "/product/filter/category/" + categoryId;
		mockMvc.perform(get(url).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
		verify(productService, times(1)).filterProductByCategory(categoryId);
        verifyNoMoreInteractions(productService);
	}

	@Test
	public void testSortProductByPriceDescending() throws Exception{
		products = Arrays.asList(
                new ProductEntity(1, "Iphone 6", 7000000, 20, "Beautifull","red",
            			"demo.jpg", branch, category),
                new ProductEntity(1, "Iphone 7", 9000000, 20, "Beautifull","pink",
            			"demo.jpg", branch, category));
		when(productService.sortPoductByPriceAscending()).thenReturn(products);
		String url = "/product/sort/ascending/";
		mockMvc.perform(get(url).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
		verify(productService, times(1)).sortPoductByPriceAscending();
        verifyNoMoreInteractions(productService);
	}

	@Test
	public void testSortProductByPriceAscending() throws Exception{
		products = Arrays.asList(
				new ProductEntity(1, "Iphone 7", 9000000, 20, "Beautifull","pink",
            			"demo.jpg", branch, category),
                new ProductEntity(1, "Iphone 6", 7000000, 20, "Beautifull","red",
            			"demo.jpg", branch, category)
                );
		when(productService.sortPoductByPriceDescending()).thenReturn(products);
		String url = "/product/sort/descending/";
		mockMvc.perform(get(url).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
		verify(productService, times(1)).sortPoductByPriceDescending();
        verifyNoMoreInteractions(productService);
	}


}
