package ead3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	
    public AddStudent() {
    	
    }
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer rollno = Integer.parseInt(request.getParameter("rollno"));
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String father = request.getParameter("fathername");
		String email = request.getParameter("email");
		Integer student_class = Integer.parseInt(request.getParameter("class"));
		Integer age = Integer.parseInt(request.getParameter("age"));
		String submit =request.getParameter("submit");
		Database dbcon = Database.getInstances();
		String query="";
		if(submit.equals("Update"))
			query="update studentdetail set firstName='"+fname+"',lastName='"+lname+"',fatherName='"+father+"',email='"+email+"',class="+student_class+",age="+age+" where id="+rollno;
		else
			query = "insert into studentdetail(id,firstName,lastName,fatherName,email,class,age) values("+rollno+",'"+fname+"','"+lname+"','"+father+"','"+email+"',"+student_class+","+age+")";
		try {
			int res = dbcon.setData(query);
			if(res > 0){
				if(submit.equals("Update")){
					response.sendRedirect("ShowStudent");
					return;
				}
				request.setAttribute("message", "Student Record Added Successfully");
				request.getRequestDispatcher("addstudent.jsp").forward(request, response);
			}
			else{
				request.setAttribute("message", "Some Error Occur!! Try Again");
				request.getRequestDispatcher("addstudent.jsp").forward(request, response);
			}
				
			
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			if(submit.equals("Update")){
				Student student = new  Student();
				student.setId(rollno);
				student.setFirst_name(fname);
				student.setLast_name(lname);
				student.setFname(father);
				student.setEmail(email);
				student.setClass_name(student_class);
				student.setAge(age);
				request.setAttribute("update_student", student);
				request.setAttribute("message", "Email/Roll no Already Exists.....");
				request.getRequestDispatcher("updatestudent.jsp").forward(request, response);
			}
			request.setAttribute("message", "Email/Roll no Already Exists.....");
			request.getRequestDispatcher("addstudent.jsp").forward(request, response);
		}
	}

}