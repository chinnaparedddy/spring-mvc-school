package com.ty.school.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.school.dto.Student;

@Component
public class StudentDao {

	@Autowired
	EntityManagerFactory entityManagerFactory;

	public Student saveStudent(Student student) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
		return student;
	}
	public Student getStudentById(int id) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		Student student=entityManager.find(Student.class, id);
		entityTransaction.commit();
		return student;
	}
	public List<Student> getAllStudent(){
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		String sql="select s from Student s";
		Query query=entityManager.createQuery(sql);
		return query.getResultList();
	}
	public boolean studentDeleteById(int id) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		Student student=entityManager.find(Student.class, id);
		if(student!=null) {
	     entityManager.remove(student);
	     entityTransaction.commit();
	     return true;
		}else {
			return false;
		}
	}
	public Student updateStudent(Student student) {
		
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		Student student1=entityManager.find(Student.class, student.getId());
		if(student1!=null) {
			entityManager.merge(student);
			entityTransaction.commit();
			return student;
		}else {
			return null;
		}
		
	}
	
}
