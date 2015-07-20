package com.ch.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class Login {
	
	
	@RequestMapping(value="/login.do")
    public String login(HttpServletRequest request,HttpServletResponse response){
    	
    	
         String userName = request.getParameter("userName");
    	 String password = request.getParameter("password");
         
    	 if(null==userName||"".equals(userName)){
    		 request.setAttribute("error", "�û�������Ϊ��!");
    		 return "login";
    	 }
    	 if(null==password||"".equals(password)){
    		 request.setAttribute("error", "���벻��Ϊ��!");
    		 return "login";
    	 }
	     UsernamePasswordToken token = new UsernamePasswordToken(userName, password);  
	     
	     try {  
	         SecurityUtils.getSubject().login(token);  
	         //��½�ɹ�,��ѯ���˵��б�
	         
	     } catch (AuthenticationException e) {  
	    	 e.printStackTrace();
	         request.setAttribute("error", "�û������������!");
	         return "login";  
	     }  
	     return "redirect";  
 }  
//ע��  
	@RequestMapping(value="/loginOut.do")
	@RequiresPermissions(value="")
 public String loginout(){  
     SecurityUtils.getSubject().logout();  
     return "login";  
 } 
	

}
