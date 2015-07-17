package com.ch.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class Login {
	
	
	@RequestMapping(value="/login.do")
    public String login(HttpServletRequest request,HttpServletResponse response){
    	
    	
         String userName = request.getParameter("userName");
    	 String password = request.getParameter("password");
         
    	 System.out.println("userName==="+userName+"password==="+password);
         
	     UsernamePasswordToken token = new UsernamePasswordToken(userName, password);  
	     
	     try {  
	         SecurityUtils.getSubject().login(token);  
	               
	     } catch (AuthenticationException e) {  
	        
	         return "redirect";  
	     }  
	    
	     return "redirect";  
 }  
//×¢Ïú  
 public String loginout(){  
     SecurityUtils.getSubject().logout();  
     return "redirect";  
 } 
	

}
