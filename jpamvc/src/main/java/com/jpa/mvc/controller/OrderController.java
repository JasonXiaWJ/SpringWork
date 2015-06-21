package com.jpa.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.mvc.domain.order.BaseOrder;
import com.jpa.mvc.pojo.OrderDetail;
import com.jpa.mvc.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired  
	private OrderService orderService;  
	 
    @RequestMapping("/order/findByNo/{orderNo}")
    public OrderDetail findByNo(@PathVariable String orderNo){
    	BaseOrder baseOrder = orderService.findByNo(orderNo);
        System.out.println("baseOrder:"+baseOrder.getRemark());
        
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setId(baseOrder.getId());
        orderDetail.setNo(baseOrder.getNo());
        orderDetail.setRemark(baseOrder.getRemark());
        orderDetail.setCustomer(baseOrder.getCreator().getName());
        
        return orderDetail;
        
    }

}
