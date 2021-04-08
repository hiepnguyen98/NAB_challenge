package com.challenge.eCommerce;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.challenge.eCommerce.controller.CategoryController;
import com.challenge.eCommerce.entity.CategoryEntity;
import com.challenge.eCommerce.service.CategoryService;
import com.challenge.eCommerce.service.StaffDetailService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(CategoryController.class)
public class CategoryControllerUnitTest {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper mapper;
	@MockBean
	private StaffDetailService staffDetailService;
	@MockBean
	private AuthenticationEntryPoint entryPoint;
	@MockBean
	private CategoryService categoryService;

	@Test
	public void testAddNewCategory() throws Exception {
		CategoryEntity category = new CategoryEntity(1l,"Phone");
		String json = mapper.writeValueAsString(category);
		MvcResult result = mockMvc.perform(post("/category/add/").content(json).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk()).andReturn();
		assertEquals(200,result.getResponse().getStatus());
	}

	@Test
	public void testUpdateCategory() throws Exception {
		CategoryEntity category = new CategoryEntity(1l,"Phone");
		String json = mapper.writeValueAsString(category);
		MvcResult result = mockMvc.perform(put("/category/update/").content(json).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk()).andReturn();
		assertEquals(200,result.getResponse().getStatus());
	}

	@Test
	public void testDeleteCategory() throws Exception {
		CategoryEntity category = new CategoryEntity(1l,"Phone");
		long categoryId = category.getId();
		String url = "/category/delete/"+categoryId;
		MvcResult result = mockMvc.perform(delete(url).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk()).andReturn();
		assertEquals(200,result.getResponse().getStatus());
	}
}
