package ead3;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/UpdateRecord")
public class UpdateRecord extends HttpServlet {
	
       

    public UpdateRecord() {
   
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Database db = Database.getInstances();
		String query = "select * from studentdetail where id="+id;
		Student student = new Student();
		try {
			ResultSet rs = db.getData(query);
			if(rs.next()){
				student.setId(rs.getInt(1));
				student.setFirst_name(rs.getString(2));
				student.setLast_name( rs.getString(3));
				student.setFname(rs.getString(4));
				student.setEmail(rs.getString(5));
				student.setClass_name(rs.getInt(6));
				student.setAge(rs.getInt(7));
				request.setAttribute("update_student", student);
				request.getRequestDispatcher("updatestudent.jsp").forward(request, response);
			}
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
	}

}