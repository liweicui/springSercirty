package com.ch.security;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;

import com.ch.model.User;


public class ShiroDbRealm extends AuthorizingRealm{

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		  
		Integer userId = (Integer) principals.fromRealm(getName()).iterator().next();  
	       // User user = userOperator.getById(userId);
		    User user = null;
		    if(null!=userId&&userId!=0){
		       user = new User(2,"xiaocui","password");
		    }
	        if( user != null ) {  
//	            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();  
//	           Role role = userOperator.getByRoleId(user.getRoleId());  
//	                info.addRole(role.getRoleName());  
//	              //  info.addStringPermissions( role.getPermissions() );//如果你添加了对权限的表，打开此注释，添加角色具有的权限  
//	              
//	            return info;  
	        	
	        	
	        	 SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();  
	        	 info.addRole("admin");
	        	 info.addStringPermission("view");
	        	 return info;
	        } else {  
	            return null;  
	        }
	        
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken principals) throws AuthenticationException {
		
		
	        
           UsernamePasswordToken token = (UsernamePasswordToken) principals;  
	        
	        String  password = String.valueOf(token.getPassword());  
	         //调用操作数据库的方法查询user信息  
	       // User user = userOperator.login( token.getUsername());
	        User user = new User(2,"xiaocui","password");
	        if( user != null ) {  
	            if(password.equals(user.getPassword())){  
	                  Session session= SecurityUtils.getSubject().getSession();  
	                  session.setAttribute("username", user.getLoginName());  
	             return new SimpleAuthenticationInfo(user.getUserId(), user.getPassword(), getName());  
	            }else{  
	                return null;  
	            }  
	        } else {  
	            return null;  
	        }  
	        
	        
	}

	
}
