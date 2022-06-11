package com.ty.school.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ty.school.dto.Teacher;
import com.ty.school.service.TeacherService;

@Controller
public class TeacherControler {

	@Autowired
	private TeacherService teacherService;

	@RequestMapping("/loadteacher")
	public ModelAndView loadTeacher() {
		ModelAndView modelAndView = new ModelAndView("createteacher.jsp");
		modelAndView.addObject("teacher", new Teacher());
		return modelAndView;
	}

	@RequestMapping("/saveteacher")
	public ModelAndView saveTeacher(@ModelAttribute Teacher teacher) {
		teacherService.saveTeacher(teacher);
		ModelAndView modelAndView = new ModelAndView("teacherhome.jsp");
		modelAndView.addObject("save", teacher.getName() + ": Sava Sucesfully");
		return modelAndView;
	}

	@RequestMapping("/teachers")
	public ModelAndView teacherGetById(@ModelAttribute(value = "id") int id) {
		Teacher teacher=teacherService.getIdByTeacher(id);
		ModelAndView modelAndView = new ModelAndView("getteacher.jsp");
		modelAndView.addObject("teacher",teacher );
		return modelAndView;
	}
	@RequestMapping("/editteacher")
	public ModelAndView editTeacher(ModelAndView modelAndView ,@RequestParam(value = "id")int id) {
		 Teacher teacher=teacherService.getIdByTeacher(id);
		modelAndView.setViewName("updateteacher.jsp");
		modelAndView.addObject("edit", teacher);
		return modelAndView;
	}
	@RequestMapping("/update")
	public ModelAndView updateTeacher(@ModelAttribute Teacher teacher) {
		teacherService.updateTeacher(teacher);
		ModelAndView modelAndView=new ModelAndView("allteachers");
		modelAndView.addObject("teacher", "update");
		return modelAndView;
	}
	@RequestMapping("/allteachers")
	public ModelAndView allTeacher() {
		List<Teacher> teachers=teacherService.getAllTeacher();
		ModelAndView modelAndView=new ModelAndView("allteachers.jsp");
		modelAndView.addObject("teachers", teachers);
		return modelAndView;
	}
	@RequestMapping("/deleteteacher")
	public ModelAndView deleteTeacher(@RequestParam(value = "id") int id) {
		teacherService.deleteTeacherById(id);
		ModelAndView modelAndView=new ModelAndView("allteachers");
		modelAndView.addObject("teacherd", "deletes");
		return modelAndView;
	}
}
