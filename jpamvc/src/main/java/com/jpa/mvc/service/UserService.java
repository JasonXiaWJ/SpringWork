package com.jpa.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.mvc.dao.UserDao;
import com.jpa.mvc.domain.User;

@Service
public class UserService {  
	
    @Autowired  
    private UserDao userDao;  
      
    @Transactional(readOnly=false)  
    public void saveUser(User user){  
        userDao.saveOrUpdate(user);  
        System.out.println("保存成功");
    }  
}  
