package com.jpa.mvc.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jpa.mvc.dao.AccountRepository;
import com.jpa.mvc.domain.account.Account;
import com.jpa.mvc.pojo.FavUser;
import com.jpa.mvc.service.AccountService;

@RestController
public class AccountController {
	 @Autowired  
	 private AccountService accountService;  
	 
	 @Autowired  
	 private AccountRepository accountRepository;
	 
	    @RequestMapping("/account/saveAccount")
	    public FavUser saveAccount(@RequestBody String body){
	        ObjectMapper mapper = new ObjectMapper();
	        FavUser favUser = null;
	        try {
	            favUser = mapper.readValue(body,  FavUser.class);
	            
	            Account account = new Account();
	            account.setUsername(favUser.getUserName());
	            account.setPassword(favUser.getPassword());
	            account.setName(favUser.getFullName());
	            accountService.saveAccount(account);
	            System.out.println("save account succefuly");
	            
	        } catch (JsonParseException e) {
	            e.printStackTrace();
	        } catch (JsonMappingException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return favUser;
	    }
	    
	    
	    @RequestMapping("/account/findByName/{username}")
	    public FavUser findIdAndNames(@PathVariable String username){
	    	Account acount = accountService.findByUsername(username);
	        System.out.println("acount name:"+acount.getName());
	        FavUser favUser = new FavUser();
	        favUser.setUserId(acount.getId()+"");
	        favUser.setUserName(acount.getUsername());
	        favUser.setPassword(acount.getPassword());
	        return favUser;
	        
	    }
	    
	    @RequestMapping("/account/findByUsernameAndPassword")
	    public FavUser findByUsernameAndPassword(@RequestParam(value="username") String username,@RequestParam(value="password") String password){
	    	Account acount = accountRepository.findByUsernameAndPassword(username, password);
	        System.out.println("acount name:"+acount.getName());
	        FavUser favUser = new FavUser();
	        favUser.setUserId(acount.getId()+"");
	        favUser.setUserName(acount.getUsername());
	        favUser.setPassword(acount.getPassword());
	        return favUser;
	        
	    }
	    
	    @RequestMapping("/account/findBySelfDefine/{username}")
	    public FavUser findBySelfDefine(@PathVariable String username){
	    	Account acount = accountRepository.findBySelfDefine(username);
	        System.out.println("acount name:"+acount.getName());
	        FavUser favUser = new FavUser();
	        favUser.setUserId(acount.getId()+"");
	        favUser.setUserName(acount.getUsername());
	        favUser.setPassword(acount.getPassword());
	        return favUser;
	        
	    }
}
