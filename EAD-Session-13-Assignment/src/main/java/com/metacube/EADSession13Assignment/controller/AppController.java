package com.metacube.EADSession13Assignment.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.metacube.EADSession13Assignment.dto.SearchStudentDto;
import com.metacube.EADSession13Assignment.dto.StudentDto;
import com.metacube.EADSession13Assignment.entity.StudentEntity;
import com.metacube.EADSession13Assignment.service.StudentService;
import com.metacube.EADSession13Assignment.util.DtoUtil;


@Controller
public class AppController {
	
	@Autowired
	private StudentService studentObj;
	
	@Value("${home.message}")
	private String message;

	
	@GetMapping("/login")
	public String getLogin(Model model , @RequestParam(value="error" , required=false) String error) {
		model.addAttribute("message" ,message);
		if(error != null) {
			model.addAttribute("error" ,"Wrong id password");
		}
		return "login";
	}
	
	
	@GetMapping("/home")
	public String getHome(Model model , @RequestParam(value="logged" , required=false) String loggedin ,@RequestParam(value = "denied" , required=false) String denied) {
		model.addAttribute("message" ,message);
		if(loggedin != null) {
			model.addAttribute("loggedin" ,"Welcome User");
		} 
		if(denied != null) {
			model.addAttribute("loggedin" ,"No permission");
		}
		return "home";
	}

	@GetMapping("/showStudent")
	public String displayStudent(Model model) {
		model.addAttribute("studentDetails", studentObj.getAll());
		return "showStudent";
		
	}
	

	@GetMapping("/addstudent")
	public String AddStudent(Model model) {
		model.addAttribute("student", new StudentDto());
		return "addStudent";
	}

	@PostMapping("/addstudent")
	public String doSignupByPost(@ModelAttribute("studentCommand") @Validated StudentDto student , BindingResult errorResult , Model model) {
		if(errorResult.hasErrors()) {
			ObjectError oe = new  ObjectError("Email","Fill The Form");
			errorResult.addError(oe);
			return "addStudent";
		} else {
			List<StudentEntity> studentData = studentObj.duplicateEmail(DtoUtil.map(student,StudentEntity.class));
			if(studentData.size()>0) {
				
				model.addAttribute("succes", "Student Email Exit");
				return "addStudent";
			} 
			studentObj.insertData(DtoUtil.map(student,StudentEntity.class));
			model.addAttribute("succes", "Student Add Succefulyy");
			return "addStudent";
		}
	}

	@GetMapping("/searchStudent") 
	public String searchStudentByGet(Model model) {
		model.addAttribute("SearchCommand", new SearchStudentDto());
		return "Search";
	}
	
	
	@PostMapping("/searchStudent") 
	public String searchStudentByPost(@ModelAttribute("SearchCommand") @Validated SearchStudentDto student , BindingResult errorResult , Model model) {
		List<StudentEntity> studentData = studentObj.findByID(DtoUtil.map(student,StudentEntity.class));
		if(studentData.size()>0) {
			model.addAttribute("studentData", studentData);
			return "Search";
		}
		model.addAttribute("succes", "No Student  Find");
		return "Search";
	}
	
	@GetMapping("/logout") 
	public String logout(Model model) {
		return "redirect:/login";
	}
}
