package com.jpa.mvc.dao;

import com.jpa.mvc.domain.User;

public interface UserDao {  
	  
    User findByName(String name);  
  
    User findByLoginName(String loginName);  
      
    void saveOrUpdate(User user);  
}  
