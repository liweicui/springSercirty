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
//	              //  info.addStringPermissions( role.getPermissions() );//����������˶�Ȩ�޵ı����򿪴�ע�ͣ����ӽ�ɫ���е�Ȩ��  
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
	         //���ò������ݿ�ķ�����ѯuser��Ϣ  
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