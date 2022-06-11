package com.ty.school.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.school.dto.Teacher;
@Component
public class TeacherDao {

	@Autowired
	EntityManagerFactory entityManagerFactory;
	public Teacher saveTeacher(Teacher teacher) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(teacher);
		entityTransaction.commit();
		return teacher;
	}
	public Teacher getIdByTeacher(int id) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager.find(Teacher.class, id);
	}
	public List<Teacher> getAllTeacher(){
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		String sql="select t from Teacher t";
		Query query=entityManager.createQuery(sql);
		return query.getResultList();
	}
	public boolean deleteTeacherById(int id) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		Teacher teacher=entityManager.find(Teacher.class, id);
		if(teacher!=null) {
			entityManager.remove(teacher);
			entityTransaction.commit();
			return true;
		}else {
			return false;
		}
	}
	public Teacher updateTeacher(Teacher teacher) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		Teacher teacher1=entityManager.find(Teacher.class, teacher.getId());
		if(teacher1!=null) {
			entityManager.merge(teacher);
			entityTransaction.commit();
			return teacher;
		}else {
			return null;
		}

	}

}
