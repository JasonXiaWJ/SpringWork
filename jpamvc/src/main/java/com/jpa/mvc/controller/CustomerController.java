package com.jpa.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.mvc.service.CustomerService;
import com.jpa.mvc.web.SelectOption;

@RestController
public class CustomerController {
	
	@Autowired  
	private CustomerService customerService;  
	 
    @RequestMapping("/customer/findIdAndNames")
    public List<SelectOption> findIdAndNames(){
    	List<SelectOption> options = customerService.findIdAndNames();
        System.out.println("options.length"+options.size());
        return options;
        
    }

}
