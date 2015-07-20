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
    		 request.setAttribute("error", "用户名不能为空!");
    		 return "login";
    	 }
    	 if(null==password||"".equals(password)){
    		 request.setAttribute("error", "密码不能为空!");
    		 return "login";
    	 }
	     UsernamePasswordToken token = new UsernamePasswordToken(userName, password);  
	     
	     try {  
	         SecurityUtils.getSubject().login(token);  
	         //登陆成功,查询出菜单列表
	         
	     } catch (AuthenticationException e) {  
	    	 e.printStackTrace();
	         request.setAttribute("error", "用户名或密码错误!");
	         return "login";  
	     }  
	     return "redirect";  
 }  
//注销  
	@RequestMapping(value="/loginOut.do")
	@RequiresPermissions(value="")
 public String loginout(){  
     SecurityUtils.getSubject().logout();  
     return "login";  
 } 
	

}
