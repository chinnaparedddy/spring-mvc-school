package com.ty.school.controler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ty.school.dto.Student;
import com.ty.school.service.StudentService;

@Controller
public class StudentControler {

	@Autowired
	private StudentService studentService;

	@RequestMapping("/load")
	public ModelAndView loadStudent( ModelAndView modelAndView) {
		modelAndView.setViewName("studentsave.jsp");
		modelAndView.addObject("user", new Student());
		return modelAndView;
	}
	@RequestMapping("/savestudent")
	public ModelAndView saveStudent(@ModelAttribute Student student,ModelAndView modelAndView) {
		studentService.saveStudent(student);
		modelAndView.setViewName("Schoolhome.jsp");
		modelAndView.addObject("save", student.getName()+" :Add Sucessfully");
		return modelAndView;
	}
	@RequestMapping("/allstudents")
	public ModelAndView allStudent(ModelAndView modelAndView) {
		List<Student> students=studentService.getAllStudent();
		modelAndView.setViewName("AllStudents.jsp");
		modelAndView.addObject("students", students);
		return modelAndView;
	}
	@RequestMapping("/editstudent")
	public ModelAndView editStudent(@RequestParam(value = "id") int id) {
		Student student=studentService.getStudentById(id);
		ModelAndView modelAndView=new ModelAndView("updatestudent.jsp");
		modelAndView.addObject("student", student);
		return modelAndView;
		
	}
	@RequestMapping("/edit")
	public ModelAndView editStudent1(@ModelAttribute Student student,ModelAndView modelAndView) {
		studentService.updateStudent(student);
		modelAndView.setViewName("allstudents");
		modelAndView.addObject("students","updated" );
		return modelAndView;
	}
	@RequestMapping("/deletestudent")
	public ModelAndView deleteStudent(HttpServletRequest req) {
		int id=Integer.parseInt(req.getParameter("id"));
		studentService.studentDeleteById(id);
		ModelAndView modelAndView=new ModelAndView("allstudents");
		modelAndView.addObject("student", "deleted");
		return modelAndView;
	}
}
