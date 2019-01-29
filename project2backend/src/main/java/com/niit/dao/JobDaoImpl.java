package com.niit.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.models.Job;
@Repository
@Transactional
public class JobDaoImpl implements JobDao {
	@Autowired
	private SessionFactory sessionFactory;
	public void addJob(Job job) {
		Session session=sessionFactory.getCurrentSession();
		session.save(job);
		
		
	}

}
