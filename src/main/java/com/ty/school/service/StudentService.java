package com.ty.school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.school.dao.StudentDao;
import com.ty.school.dto.Student;

@Component
public class StudentService {

	@Autowired
	StudentDao studentDao;
	public Student saveStudent(Student student) {
		return studentDao.saveStudent(student);
	}
	public Student getStudentById(int id) {
		return studentDao.getStudentById(id);
	}
	public List<Student> getAllStudent(){
		return studentDao.getAllStudent();
	}
	public boolean studentDeleteById(int id) {
		return  studentDao.studentDeleteById(id);
	}
	public Student updateStudent(Student student) {
		return studentDao.updateStudent(student);
	}
}
