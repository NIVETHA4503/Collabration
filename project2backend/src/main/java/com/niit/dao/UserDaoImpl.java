package com.niit.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.models.User;
@Repository
@Transactional
public class UserDaoImpl implements UserDao {
@Autowired
private SessionFactory sessionFactory;
	public void userRegistration(User user) {
		Session session=sessionFactory.getCurrentSession();
		session.save(user);
		
	}
	public boolean isEmailUnique(String email) {
		Session session=sessionFactory.getCurrentSession();
		User user=(User)session.get(User.class,email);
		if(user==null)
			return true;
		else
		return false;
	}
	public boolean isPhonenumberUnique(String phonenumber) {
		Session session=sessionFactory.getCurrentSession();
Query query=session.createQuery("from User where phonenumber=:pnumber");
		User user=(User)query.uniqueResult();
		if(user==null)
			return true;
		else
		return false;
		
	}


}
