package com.ssh_partical.action;

import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ssh_partical.model.Users;
import com.ssh_partical.service.UserService;

public class UserAction extends ActionSupport {

	/**
	 * this method is used for Users action which are create/search/modify job seekers in website side 
	 */
	private static final long serialVersionUID = 1L;
	
	private Users user;
	private UserService userService;
	private Map<String, Object> request;
	private Map<String, Object> session;
	
	
	//used for create new user info
	public Users getUser(){
		return user;
	}
	
	public void setUser(Users user){
	     this.user = user;
	}
	
	//used for check the action of users; 
	public UserService getUserService(){
		return userService;
	}
	
	public void setUserService(UserService userService){
		this.userService = userService;
	}
	
	@SuppressWarnings("unchecked")
	public String list(){
		request = (Map<String, Object>)ActionContext.getContext().get("request");
		request.put("users", userService.queryAll());
		return "success";
	}
	
	public String checkUser(){
		boolean checker = userService.checkUser(user);
		
		if(checker){
			session = ActionContext.getContext().getSession();
			session.put("user1", user);
			return list();
		}else {
			return "error";
		}
	}
	
	public String addUser(){
		userService.addUser(user);
		return list();
	}
	
	public String deleteUser(){
		userService.deleteUser(user.getId());
		return list();
	}
	
	public String updateUser_front(){
		user = userService.queryById(user.getId());
		return "update";
	}
	
	public String updateUser_back(){
		userService.updateUser(user);
		return list();
	}
	
	@SuppressWarnings("unchecked")
	public String queryUser(){
		request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("user2", userService.queryUser(user));
		request.put("tag", 2);
		return list();
	}
    
}
