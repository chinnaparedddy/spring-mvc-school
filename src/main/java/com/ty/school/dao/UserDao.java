package com.ty.school.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.school.dto.User;

@Component
public class UserDao {

	@Autowired
	EntityManagerFactory entityManagerFactory;
	public User saveUser(User user) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
		return user;
	}
	public List<User> validateUser(String email,String password) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		String sql="select u from User u where u.email=?1 and u.password=?2";
		Query query=entityManager.createQuery(sql);
		query.setParameter(1, email);
		query.setParameter(2, password);
		List<User> users=query.getResultList();
		
		entityTransaction.commit();
		return users;
		
	}
}
