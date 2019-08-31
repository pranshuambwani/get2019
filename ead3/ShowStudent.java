package ead3;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ShowStudent")
public class ShowStudent extends HttpServlet {
	
  
    public ShowStudent() {
  
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String query = "select * from studentdetail";
		List<Student> student_list = new ArrayList<Student>();
		Database db = Database.getInstances();
		ResultSet res;
		try {
			res = db.getData(query);
			while(res.next()){
				Student student = new Student();
				student.setId(res.getInt(1));
				student.setFirst_name(res.getString(2));
				student.setLast_name( res.getString(3));
				student.setFname(res.getString(4));
				student.setEmail(res.getString(5));
				student.setClass_name(res.getInt(6));
				student.setAge(res.getInt(7));
				student_list.add(student);
			}
			
			request.setAttribute("student_list", student_list);
			request.getRequestDispatcher("showstudents.jsp").forward(request, response);
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			response.getWriter().println("error");
			ex.printStackTrace();
		}
		
	}

}