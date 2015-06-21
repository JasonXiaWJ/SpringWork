package com.jpa.mvc.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.jpa.mvc.dao.UserDao;
import com.jpa.mvc.domain.User;

@Repository  
public class UserDaoImpl implements UserDao {  
      
    @PersistenceContext  
    private EntityManager em;  
  
    public User findByName(String name) {   
        return null;  
    }  
  
    public User findByLoginName(String loginName) {  
        return null;  
    }  
  
    public void saveOrUpdate(User user) {  
        em.persist(user);  
    }  
  
}  
