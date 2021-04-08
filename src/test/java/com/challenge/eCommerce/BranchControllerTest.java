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

import com.challenge.eCommerce.controller.BranchController;
import com.challenge.eCommerce.entity.BranchEntity;
import com.challenge.eCommerce.service.BranchService;
import com.challenge.eCommerce.service.StaffDetailService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(BranchController.class)
public class BranchControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper mapper;
	@MockBean
	private StaffDetailService staffDetailService;
	@MockBean
	private AuthenticationEntryPoint entryPoint;
	@MockBean
	private BranchService branchService;

	@Test
	public void testAddNewBranch() throws Exception {
		BranchEntity branch = new BranchEntity(1l,"Apple");
		String json = mapper.writeValueAsString(branch);
		MvcResult result = mockMvc.perform(post("/branch/add/").content(json).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk()).andReturn();
		assertEquals(200,result.getResponse().getStatus());
	}

	@Test
	public void testUpdateBranch() throws Exception {
		BranchEntity branch = new BranchEntity(1l,"Apple");
		String json = mapper.writeValueAsString(branch);
		MvcResult result = mockMvc.perform(put("/branch/update/").content(json).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk()).andReturn();
		assertEquals(200,result.getResponse().getStatus());
	}

	@Test
	public void testDeleteBranch() throws Exception {
		BranchEntity branch = new BranchEntity(1l,"Apple");
		long branchId = branch.getId();
		String url = "/branch/delete/"+branchId;
		MvcResult result = mockMvc.perform(delete(url).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk()).andReturn();
		assertEquals(200,result.getResponse().getStatus());
	}
}
