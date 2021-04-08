package com.challenge.eCommerce;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.challenge.eCommerce.controller.CustomerController;
import com.challenge.eCommerce.entity.BranchEntity;
import com.challenge.eCommerce.entity.CategoryEntity;
import com.challenge.eCommerce.entity.CustomerOrder;
import com.challenge.eCommerce.entity.OrderDetailEntity;
import com.challenge.eCommerce.entity.OrderEntity;
import com.challenge.eCommerce.entity.ProductEntity;
import com.challenge.eCommerce.service.CustomerService;
import com.challenge.eCommerce.service.StaffDetailService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(CustomerController.class)
public class CustomerControllerUnitTest {
	private BranchEntity branch = new BranchEntity(1,"Apple");

	private CategoryEntity category = new CategoryEntity(1,"phone");;
	private List<ProductEntity> products;
	private List<OrderDetailEntity> orderDetails;
	private OrderEntity order;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper mapper;
	@MockBean
	private CustomerService customerService;
	@MockBean
	private AuthenticationEntryPoint entryPoint;
	@MockBean
	private StaffDetailService staffDetailService;

	@Test
	public void testOder() throws Exception {
		order = new OrderEntity(1,0, "Hiep", "Test@gmail.com", "",
				"demo/123/123");
		products = Arrays.asList(
                new ProductEntity(1, "Iphone 6", 7000000, 20, "Beautifull","red",
            			"demo.jpg", branch, category),
                new ProductEntity(1, "Iphone 7", 9000000, 20, "Beautifull","pink",
            			"demo.jpg", branch, category));
		orderDetails = Arrays.asList(
				new OrderDetailEntity(1,order, products.get(0), 0, 2),
				new OrderDetailEntity(2,order, products.get(1), 0, 2)
				);
		CustomerOrder customerOrder = new CustomerOrder(order, orderDetails);
		String json = mapper.writeValueAsString(customerOrder);
		//when(customerService.getOder(orderDetails, order)).thenReturn(products);
		MvcResult result =  mockMvc.perform(post("/order/").content(json).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk()).andReturn();
		assertEquals(200,result.getResponse().getStatus());
	}
}
