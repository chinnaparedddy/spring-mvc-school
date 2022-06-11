package com.ty.school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.school.dao.UserDao;
import com.ty.school.dto.User;

@Component
public class UserService {

	@Autowired
	UserDao userDao;
	public User saveUser(User user) {
		return userDao.saveUser(user);
	}
	public List<User> validateUser(String email,String password) {
		return userDao.validateUser(email, password);
	}
}
