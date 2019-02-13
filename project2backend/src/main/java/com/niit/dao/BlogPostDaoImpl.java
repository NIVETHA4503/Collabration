package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.models.BlogPost;
@Repository
@Transactional
public class BlogPostDaoImpl implements BlogPostDao {
	@Autowired
private SessionFactory sessionFactory;
	public void addBlogPost(BlogPost blogPost) {
		Session session=sessionFactory.getCurrentSession();
		session.save(blogPost);

	}
	public List<BlogPost> getBlogsApproved() {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from BlogPost where approved=true");
		List<BlogPost> blogsApproved=query.list();
		return blogsApproved;
	}
	public List<BlogPost> getBlogsWaitingForApproval() {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from BlogPost where approved=false");
		List<BlogPost> blogsWaitingForApproval=query.list();
		return blogsWaitingForApproval;
	}

}