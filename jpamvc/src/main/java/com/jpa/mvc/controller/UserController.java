package com.jpa.mvc.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jpa.mvc.domain.User;
import com.jpa.mvc.pojo.FavUser;
import com.jpa.mvc.service.UserService;

@RestController
public class UserController {
	
	 @Autowired  
	 private UserService userService;  
	 
	 
	 
	    @RequestMapping("/saveUser")
	    public FavUser getFavUserBody(@RequestBody String body){
	        ObjectMapper mapper = new ObjectMapper();
	        FavUser favUser = null;
	        try {
	            favUser = mapper.readValue(body,  FavUser.class);
	            
	            User user = new User();
	            user.setUsername(favUser.getUserName());
	            user.setPassword(favUser.getPassword());
	            userService.saveUser(user);
	            
	        } catch (JsonParseException e) {
	            e.printStackTrace();
	        } catch (JsonMappingException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return favUser;
	    }

}
