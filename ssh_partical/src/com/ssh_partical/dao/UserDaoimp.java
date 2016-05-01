package com.ssh_partical.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ssh_partical.model.Users;

public class UserDaoimp implements UserDao {

	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public boolean checkUser(Users user) {
		// TODO Auto-generated method stub
		//open the session
		Session session = sessionFactory.openSession();
		//begin transaction
		session.beginTransaction();
		
		Query query = session.createQuery("from Users u where u.id=:id and u.name =:name");
		query.setParameter("id", user.getId());
		query.setParameter("name", user.getName());
		
		//search for unique result by using id and name 
		Users u = (Users)query.uniqueResult();
		
		//close transaction
		session.getTransaction().commit();
		session.close();
		
		//if there has value from query, return true else return false
		if(u != null) return true;
		else return false;
	}

	@Override
	public boolean addUser(Users user) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
		return true;
	}

	@Override
	public boolean deleteUser(Integer id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Users u =(Users)session.get(Users.class, id);
		session.delete(u);
		session.getTransaction().commit();
		session.close();
		
		return true;
	}

	@Override
	public boolean updateUser(Users user) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
		session.close();
		
		return true;
	}

	@Override
	public List<Users> queryUser(Users user) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		StringBuilder hq = new StringBuilder(" from Users u where 1=1");
		
		ArrayList<String> arr = new ArrayList<String>();
		
		if(user.getName() != null && "".hashCode() != user.getName().hashCode()){
			hq.append(" and u.name =?");
			arr.add(user.getName());
		}
		
		if(user.getCompany() != null && "".hashCode() != user.getCompany().hashCode()){
			hq.append(" and u.company =?");
			arr.add(user.getCompany());
		}
		Query query = session.createQuery(hq.toString());
		
		for(int i = 0; i < arr.size(); i++){
			query.setString(i, arr.get(i));
		}
		
		@SuppressWarnings("unchecked")
		List<Users> users = query.list();
		
		session.getTransaction().commit();
		session.close();
		return users;
	}

	@Override
	public Users queryById(Integer id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Users user = (Users) session.get(Users.class, id);
		session.getTransaction().commit();
		session.close();
		return user;
	}

	@Override
	public List<Users> queryAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery(" from User u");
		
		@SuppressWarnings("unchecked")
		List<Users> user = query.list();
		session.getTransaction().commit();
		session.close();
		return user;
	}

}
