package com.metacube.EADSession11.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
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

import com.metacube.EADSession11.entities.Employee;
import com.metacube.EADSession11.entities.Friend;
import com.metacube.EADSession11.entities.Organization;
import com.metacube.EADSession11.facade.EmployeeFacade;
import com.metacube.EADSession11.facade.FriendFacade;
import com.metacube.EADSession11.facade.OrganizationFacade;


@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeFacade empfacade;
	
	@Autowired
	FriendFacade frndfacade;
	
	@Autowired
	OrganizationFacade orgFacade;
	
	@RequestMapping("/loginPage")
	public String login(){
		return "loginPage";
	}
	
	@ModelAttribute
	public void profilePicture(HttpServletRequest request,Model model) throws Exception{
		HttpSession session = request.getSession();
		if(session.getAttribute("emp_id")!=null){
			Employee emp = empfacade.getEmployee((Integer)(session.getAttribute("emp_id")));
			System.out.println("heree"+ emp.getName());
			model.addAttribute("emp", emp);
			model.addAttribute("emp_name",session.getAttribute("emp_name").toString());
			File file = new File("C:\\eclipseworkspace\\EAD-Session11\\src\\main\\webapp\\images\\"+session.getAttribute("emp_id").toString()+".jpg");
			if(file.exists()){
				model.addAttribute("image", session.getAttribute("emp_id").toString()+".jpg");
			}
			else{
				model.addAttribute("image","default.jpg");
			}
				
		}
	}
	
	@RequestMapping("/Verification")
	public String Verification(Model model,@RequestParam("email") String email,@RequestParam("password") String password,HttpServletRequest request) throws Exception{
		Employee emp;
		try{
			emp = empfacade.validUser(email, password);
		}
		catch(Exception ex){
			model.addAttribute("message", "Invalid User");
			return "loginPage";
		}
		HttpSession session = request.getSession(true);
		session.setAttribute("email",emp.getEmail());
		session.setAttribute("emp_id", emp.getId());
		session.setAttribute("emp_name",emp.getName());
		model.addAttribute("emp",emp);
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
	public String update(@ModelAttribute("employee") Employee emp,@RequestParam("submit") String submit,HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		Employee emp1 = empfacade.getEmployee((Integer)(session.getAttribute("emp_id")));
		emp.setGender(emp1.getGender());
		emp.setOrganization_id(emp1.getOrganization_id());
		emp.setPassword(emp1.getPassword());
		System.out.println(emp);
		if(submit.equals("Update")){
			empfacade.updateEmployee(emp);
		}
		return "profile";
		
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request,Model model) throws Exception{
		HttpSession session = request.getSession();
		session.invalidate();
		Employee employee = new Employee();
		List<Organization> org_list = orgFacade.getAllOrganization();
		model.addAttribute("orgList", org_list);
		model.addAttribute("employee", employee);
		return "index";
		
	}
}
