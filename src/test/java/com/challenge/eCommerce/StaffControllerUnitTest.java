package com.challenge.eCommerce;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.challenge.eCommerce.controller.StaffController;
import com.challenge.eCommerce.entity.RoleEntity;
import com.challenge.eCommerce.entity.StaffEntity;
import com.challenge.eCommerce.service.StaffDetailService;
import com.challenge.eCommerce.service.StaffService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(StaffController.class)
public class StaffControllerUnitTest {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper mapper;
	@MockBean
	private StaffService staffService;
	@MockBean
	private StaffDetailService staffDetailService;
	@MockBean
	private AuthenticationEntryPoint entryPoint;

	@WithMockUser(value = "hiepnguyen29011998@gmai.com", roles = "ADMIN")
	@Test
	public void testAddNewStaff() throws Exception {
		RoleEntity role = new RoleEntity(1l,"admin");
		StaffEntity staff = new StaffEntity(1l, "demo test", "demotest@gmail.com", "test name", "1234", role);
		String json = mapper.writeValueAsString(staff);
		MvcResult result = mockMvc.perform(post("/manage/staff/add/").content(json).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk()).andReturn();
		assertEquals(200,result.getResponse().getStatus());
	}

	@WithMockUser(value = "hiepnguyen29011998@gmai.com", roles = "ADMIN")
	@Test
	public void testUpdateStaff() throws Exception {
		RoleEntity role = new RoleEntity(1l,"admin");
		StaffEntity staff = new StaffEntity(1l, "demo test", "demotest@gmail.com", "test name", "1234", role);
		String json = mapper.writeValueAsString(staff);
		MvcResult result = mockMvc.perform(put("/manage/staff/update/").content(json).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk()).andReturn();
		assertEquals(200,result.getResponse().getStatus());
	}


}
