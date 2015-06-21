package com.jpa.mvc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jpa.mvc.pojo.FavUser;
import com.jpa.mvc.pojo.UserDetails;
import com.jpa.mvc.pojo.UsrPackage;


@RestController
public class FavRestfulController {
	
	
	@RequestMapping(value = "/users/{id}")
	public FavUser getUserBySimplePathWithPathVariable(@PathVariable("id") long id) {
        FavUser userVO = new FavUser();
        userVO.setVin("vin_test1");
		userVO.setFirstName("Jian1");
		userVO.setLastName("Li");
		userVO.setFullName("Jian1, Li");
		userVO.setMobile("13765878990");
		userVO.setEmail("test2@covisint.com");
        return userVO;
	}
     
    @RequestMapping(value="/getUserName",method=RequestMethod.POST)
    public String getUserName(@RequestParam(value="name") String name){
        return name+"666";
    }
    
    
    @RequestMapping("/getXmlUser")
    public UserDetails getXmlUser(@RequestParam("userName") String userName){
    	UserDetails userDetail = new UserDetails();
    	userDetail.setUserName(userName);
    	userDetail.setEmailId(userName+"@163.com");
        return userDetail;
    }
    
    @RequestMapping(value="/info/{proId}",method=RequestMethod.GET)
    public String getProductInfo(@PathVariable String proId, HttpServletRequest request,HttpServletResponse response) throws Exception {
   
          request.setAttribute("name", proId);
           
          return "list";
    }
    
    @RequestMapping("/getVinUser")
    public FavUser getVinUser(@RequestParam("vin") String vin){
        FavUser userVO = new FavUser();
        userVO.setVin(vin);
		userVO.setFirstName("Jian");
		userVO.setLastName("Li");
		userVO.setFullName("Jian, Li");
		userVO.setMobile("13765878990");
		userVO.setEmail("test2@covisint.com");
        return userVO;
    }
     
    @RequestMapping("/getUser")
    public FavUser getFavUser(@RequestParam("userName") String userName,String userId,@RequestParam("userAge")int userAge){
        FavUser favUser = new FavUser();
        favUser.setUserId(userId);
        favUser.setUserName(userName);
        favUser.setUserAge(userAge);
        return favUser;
    }
     
    @RequestMapping("/getUserBody")
    public FavUser getFavUserBody(@RequestBody String body){
        ObjectMapper mapper = new ObjectMapper();
        FavUser favUser = null;
        try {
            favUser = mapper.readValue(body,  FavUser.class);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return favUser;
    }
    
    
    ///////////
    @RequestMapping(value="/bindPackages")
    public String bindPackages(@RequestParam(value="clientId") String clientId, @RequestParam(value="packageId") long packageId){
    	if (packageId>100) {
    		return "true";
    	}else {
    		return "false";
    	}
    }
    
    @RequestMapping(value="/packages")
    public List<UsrPackage> packages(){
    	List<UsrPackage> packagesList = new ArrayList<UsrPackage>(); 
    	UsrPackage up1 = new UsrPackage();
    	up1.setId(1);
    	up1.setIseffective("1");
    	up1.setLength(10);
    	up1.setName("套餐1");
    	up1.setPredefined("11");
    	packagesList.add(up1);
    	
    	UsrPackage up2 = new UsrPackage();
    	up2.setId(2);
    	up2.setIseffective("1");
    	up2.setLength(20);
    	up2.setName("套餐2");
    	up2.setPredefined("12");
    	packagesList.add(up2);
    	
    	UsrPackage up3 = new UsrPackage();
    	up3.setId(3);
    	up3.setIseffective("3");
    	up3.setLength(30);
    	up3.setName("套餐3");
    	up3.setPredefined("13");
    	packagesList.add(up3);
    	
    	return packagesList;
    	
    }
    
    
    

}
