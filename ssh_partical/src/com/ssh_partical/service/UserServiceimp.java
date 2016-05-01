package com.ssh_partical.service;

import java.util.List;

import com.ssh_partical.dao.UserDao;
import com.ssh_partical.model.Users;

public class UserServiceimp implements UserService {

	private UserDao userdao;
    
	public void setUserDao(UserDao userdao){
		this.userdao = userdao;
	}
	
	public UserDao getUserDao(){
		return userdao;
	}
	@Override
	public boolean checkUser(Users user) {
		// TODO Auto-generated method stub
		
		return userdao.checkUser(user);
	}

	@Override
	public boolean addUser(Users user) {
		// TODO Auto-generated method stub
		return userdao.addUser(user);
	}

	@Override
	public boolean deleteUser(Integer id) {
		// TODO Auto-generated method stub
		return userdao.deleteUser(id);
	}

	@Override
	public boolean updateUser(Users user) {
		// TODO Auto-generated method stub
		return userdao.updateUser(user);
	}

	@Override
	public List<Users> queryUser(Users user) {
		// TODO Auto-generated method stub
		return userdao.queryUser(user);
	}

	@Override
	public Users queryById(Integer id) {
		// TODO Auto-generated method stub
		return userdao.queryById(id);
	}

	@Override
	public List<Users> queryAll() {
		// TODO Auto-generated method stub
		return userdao.queryAll();
	}

}
