package com.ty.school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.school.dao.TeacherDao;
import com.ty.school.dto.Teacher;

@Component
public class TeacherService {

	@Autowired
	TeacherDao teacherDao;

	public Teacher saveTeacher(Teacher teacher) {
		return teacherDao.saveTeacher(teacher);
	}

	public Teacher getIdByTeacher(int id) {
		return teacherDao.getIdByTeacher(id);
	}

	public List<Teacher> getAllTeacher() {
		return teacherDao.getAllTeacher();
	}

	public boolean deleteTeacherById(int id) {
		return teacherDao.deleteTeacherById(id);
	}

	public Teacher updateTeacher(Teacher teacher) {
		return teacherDao.updateTeacher(teacher);
	}
}
