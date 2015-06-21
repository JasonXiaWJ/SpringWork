package com.jpa.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.mvc.dao.AccountRepository;
import com.jpa.mvc.domain.account.Account;

@Service
public class AccountService {
	

	
    @Autowired  
    private AccountRepository accountRepository;  
      
    @Transactional(readOnly=true)  
    public Account findByUsername(String username){  
    	Account account = accountRepository.findByUsername(username);
        System.out.println("account Id:"+account.getId());
        return account;
    } 
    
    @Transactional(readOnly=false)  
    public Account saveAccount(Account account){  
    	Account accountNew = accountRepository.saveAndFlush(account);
        System.out.println("account:"+accountNew.getId());
        return accountNew;
    } 



}
