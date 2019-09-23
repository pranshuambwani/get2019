package com.metacube.EADSession9.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.metacube.EADSession9.Facade.EmployeeFacade;
import com.metacube.EADSession9.Facade.FriendFacade;
import com.metacube.EADSession9.entities.Employee;
import com.metacube.EADSession9.entities.Friend;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeFacade empfacade;
	
	@Autowired
	FriendFacade frndfacade;
	
	@RequestMapping("/loginPage")
	public String login(){
		return "loginPage";
	}
	
	@ModelAttribute
	public void profilePicture(HttpServletRequest request,Model model) throws Exception{
		HttpSession session = request.getSession();
		if(session.getAttribute("emp_id")!=null){
			Employee emp = empfacade.getEmployee((Integer)(session.getAttribute("emp_id")));
			model.addAttribute("emp", emp);
			model.addAttribute("emp_name",session.getAttribute("emp_name").toString());
			File file = new File("C:\\Users\\Pranshu\\Downloads\\GET2019-EAD-Assignment9\\GET2019-EAD-Assignment9\\EAD-Session9\\src\\main\\webapp\\images\\"+session.getAttribute("emp_id").toString()+".jpg");
			if(file.exists()){
				System.out.println("here");
				System.out.println(session.getAttribute("emp_id").toString());
				model.addAttribute("image", session.getAttribute("emp_id").toString()+".jpg");
			}
			else{
				System.out.println("hereis");
				model.addAttribute("image","default.jpg");
				
			}
				
		}
	}
	
	@RequestMapping("/Verification")
	public String Verification(Model model,@RequestParam("email") String email,@RequestParam("password") String password,HttpServletRequest request) throws Exception{
		Employee emp = empfacade.validUser(email, password); 
		if(emp!=null){
			HttpSession session = request.getSession();
			session.setAttribute("email",emp.getEmail());
			session.setAttribute("emp_id", emp.getEmp_id());
			session.setAttribute("emp_name",emp.getName());
			
		}
		else
		{
			model.addAttribute("message", "Invalid User");
			return "loginPage";
		}
		return "profile";
	}
	
	/*@RequestMapping("/check")
	public String check(Model model){
		File file = new File("C:\\eclipseworkspace\\EAD-Session9\\src\\main\\webapp\\images\\default.jpg");
		if(file.exists()){
			model.addAttribute("image", "found");
		}
		else
			model.addAttribute("image", " not found");
		return "test";
	}*/
	
	@RequestMapping("/changepicture")
	public String changepicture(@RequestParam("image") MultipartFile file,HttpServletRequest request){
		HttpSession session = request.getSession();
		if (!file.isEmpty()) {
			String path=session.getServletContext().getRealPath("/");  
	        String filename=file.getOriginalFilename();  
	          
	         
	        try{  
	        byte barr[]=file.getBytes();  
	          
	        BufferedOutputStream bout=new BufferedOutputStream(  
	                 new FileOutputStream(path+"/images/"+session.getAttribute("emp_id").toString()+".jpg"));  
	        bout.write(barr);  
	        bout.flush();  
	        bout.close();  
	          
	        }catch(Exception e){System.out.println(e);}  
		
		}
		return "profile";
		
	}
	
	@RequestMapping("/home")
	public String home(){
		return "profile";
	}
	
	@RequestMapping("/friends")
	public String friends(HttpServletRequest request,Model model) throws Exception{
		HttpSession session = request.getSession();
		List<Friend> frnd_list = frndfacade.getAllFriends((Integer)session.getAttribute("emp_id"));
		model.addAttribute("frnd_list", frnd_list);
		return "friends";
	}
	
	@RequestMapping("/FriendProfile")
	public String ShowFriendProfile(@RequestParam("id") Integer id,Model model) throws Exception{
		Friend friend = frndfacade.getFriendProfile(id);
		model.addAttribute("friend", friend);
		return "showfriendprofile";
	}
	
	@RequestMapping("/editprofile")
	public String EditProfile(HttpServletRequest request,Model model) throws Exception{
		HttpSession session = request.getSession();
		Employee emp = empfacade.getEmployee((Integer)(session.getAttribute("emp_id")));
		model.addAttribute("employee", emp);
		return "editprofile";
	}
	@RequestMapping("/updateprofile")
	public String update(@ModelAttribute("employee") Employee emp,@RequestParam("submit") String submit) throws Exception{
		if(submit.equals("Update")){
			empfacade.updateEmployee(emp);
		}
		return "profile";
		
	}
}
