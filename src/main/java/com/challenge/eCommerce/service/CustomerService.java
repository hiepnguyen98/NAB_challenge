package com.challenge.eCommerce.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.eCommerce.entity.OrderDetailEntity;
import com.challenge.eCommerce.entity.OrderEntity;
import com.challenge.eCommerce.entity.ProductEntity;
import com.challenge.eCommerce.exception.ResourceNotFoundException;
import com.challenge.eCommerce.util.CommonUtil;

@Service
public class CustomerService {
	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderDetailService orderDetailService;
	@Autowired
	private ProductService productService;

	public Map<String, Boolean> getOder(List<OrderDetailEntity> orderDetails, OrderEntity order) throws ResourceNotFoundException {
		String msg = "";
		boolean isOrder = true;
		double totalPrice = 0;
		if(orderDetails.size() == 0) {
			msg = "You must choose at least one product to order";
			isOrder = false;
		}else if(CommonUtil.isNullEmpty(order.getCustomerName()) || CommonUtil.isNullEmpty(order.getOrderAddress())
				|| CommonUtil.isNullEmpty(order.getOrderEmail()) || CommonUtil.isNullEmpty(order.getOrderPhoneNumber())) {
			msg = "You must fill in all information to order";
			isOrder = false;
		}else {
			for(OrderDetailEntity oderDetail: orderDetails) {
				ProductEntity productOrder =  productService.getProductById(oderDetail.getProduct().getId());
				if(oderDetail.getQuantity() > productOrder.getQuantity()) {
					msg = "The quantity of "+ productOrder.getProductName() +" you oder exceeds the quantity in stock ";
					isOrder = false;
					break;
				}
			}
		}
		if(isOrder) {
			OrderEntity  orderEntity = orderService.addOrUpdate(order);
			for(OrderDetailEntity oderDetail: orderDetails) {
				ProductEntity productOrder =  productService.getProductById(oderDetail.getProduct().getId());
				int quantity = productOrder.getQuantity() - oderDetail.getQuantity();
				productOrder.setQuantity(quantity);
				productService.UpdateProduct(productOrder);
				oderDetail.setOrder(orderEntity);
				oderDetail.setUnitPrice(oderDetail.getQuantity()*productOrder.getPrice());
				orderDetailService.addOrUpdateOrderDetail(oderDetail);
				totalPrice+=oderDetail.getUnitPrice();
				msg = "success";
				isOrder = true;
			}
			order.setTotalPrice(totalPrice);
			orderService.addOrUpdate(orderEntity);
		}

		Map<String, Boolean> response = new HashMap<>();
        response.put(msg, isOrder);
        return response;
	}

}
