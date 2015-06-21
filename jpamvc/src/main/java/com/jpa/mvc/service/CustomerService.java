package com.jpa.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.mvc.dao.CustomerRepository;
import com.jpa.mvc.web.SelectOption;

@Service
public class CustomerService {
	
    @Autowired  
    private CustomerRepository customerRepository;  
      
    @Transactional(readOnly=true)  
    public List<SelectOption> findIdAndNames(){  
    	List<SelectOption> options = customerRepository.findIdAndNames();
        System.out.println("options.length"+options.size());
        return options;
    } 

}
