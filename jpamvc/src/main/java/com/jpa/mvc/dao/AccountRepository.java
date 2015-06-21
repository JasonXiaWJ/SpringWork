package com.jpa.mvc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jpa.mvc.domain.account.Account;
import com.jpa.mvc.domain.customer.Customer;


/**
 * Account repository which provides Account entity manipulation methods.
 * 
 * @author Wensheng.Ding
 * 
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long>, JpaSpecificationExecutor<Account> {

    Account findByUsername(String username); 

    Account findByUsernameAndActived(String username, boolean actived); 
    
    @Query("select a from Account a where a.username=?1")
    Account findBySelfDefine(String username); 
    
    Account findByUsernameAndPassword(String username, String password); 

    @Query("select a.customers from Account a where a.id=?1")
    List<Customer> findByUserId(Long accountId);

       
}
