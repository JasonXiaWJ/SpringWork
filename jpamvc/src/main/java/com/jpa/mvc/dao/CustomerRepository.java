package com.jpa.mvc.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jpa.mvc.domain.customer.CountryCode;
import com.jpa.mvc.domain.customer.Customer;
import com.jpa.mvc.web.SelectOption;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {
    @Query(value = "SELECT NEW com.jpa.mvc.web.SelectOption (cts.id, cts.name) FROM Customer cts WHERE cts.actived=true")
    List<SelectOption> findIdAndNames();
    @Query(value = "SELECT cts.countryCode FROM Customer cts")
    Set<CountryCode> findAllCountryCode();

    /**
     * Find by customer sap code
     */
    Customer findBySapCode(String sapCode);

    /**
     * Find customers by active flag
     * 
     * @param actived
     * @return
     */
    List<Customer> findByActived(boolean actived);

    /**
     * Find by customer name
     */
    Customer findByName(String name);
    
    @Query(value = "SELECT cts.sapCode FROM Customer cts")
    List<String> findSapCodes();
    

}
