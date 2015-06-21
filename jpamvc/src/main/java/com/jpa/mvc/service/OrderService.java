package com.jpa.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.mvc.dao.OrderRepository;
import com.jpa.mvc.domain.order.BaseOrder;

@Service
public class OrderService {
	
    @Autowired  
    private OrderRepository orderRepository;  
      
    @Transactional(readOnly=true)  
    public BaseOrder findByNo(String orderNo){  
    	BaseOrder order = orderRepository.findByNo(orderNo) ;
        System.out.println("order.getRemark"+order.getRemark());
        return order;
    } 

}
