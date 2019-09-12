package com.metacube.EADSession8.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.metacube.EADSession8.entities.Student;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Value("${message.default.welcome}")
    private String welcomeMessage;
	
	@RequestMapping("/home")
	public String hello(Model model,HttpServletRequest request){
		HttpSession session = request.getSession();
		if(session.getAttribute("student_list")==null){
			session.setAttribute("student_list", new ArrayList<Student>());
		}
		model.addAttribute("welcome", welcomeMessage);
		return "index";
	}
	
	@RequestMapping("/addstudent")
	public String addStudentPage(Model model){
		Student student = new  Student();
		model.addAttribute("student", student);
		return "add-student-form";
	}
	
	@RequestMapping("/addstudentdetail")
	public String addstudentdetail(@Valid @ModelAttribute("student") Student student,BindingResult result,HttpServletRequest request,Model model){
		System.out.println(student);
		if (result.hasErrors()) {
	        return "add-student-form";
	    }
		HttpSession session = request.getSession();
		ArrayList<Student> student_list = (ArrayList<Student>)session.getAttribute("student_list");
		student_list.add(student);
		session.setAttribute("student_list", student_list);
		model.addAttribute("message", "Record Addded Successfully");
		return addStudentPage(model);		
	}
	
	@RequestMapping("/ShowStudent")
	public String ShowStudent(Model model,HttpServletRequest request){
		HttpSession session = request.getSession();
		model.addAttribute("student_list",(ArrayList<Student>)session.getAttribute("student_list"));
		return "show-students";
	}
}
