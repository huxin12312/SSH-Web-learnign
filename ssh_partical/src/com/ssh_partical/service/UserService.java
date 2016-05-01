package com.ssh_partical.service;

import java.util.List;

import com.ssh_partical.model.Users;

public interface UserService {
	public boolean checkUser(Users user);
	
	public boolean addUser(Users user);
	
	public boolean deleteUser(Integer id);
 
	public boolean updateUser(Users user);
	
	public List<Users> queryUser(Users user);
	
	public Users queryById(Integer id);
	
	public List<Users> queryAll();
}
