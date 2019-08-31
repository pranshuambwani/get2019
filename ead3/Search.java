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

@WebServlet("/Search")
public class Search extends HttpServlet {
    
    public Search() {

    }
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String column = request.getParameter("column");
		String value = request.getParameter("value");
		String order = request.getParameter("ordered");
		String query = "";
		if(order.equals("class") || order.equals("age")){
			query = "select * from studentdetail where "+column+"='"+value+"' order by "+order;
		}
		else
		 query = "select * from studentdetail where "+column+"='"+value+"'";
		Database db = Database.getInstances();
		try {
			ResultSet rs = db.getData(query);
			List<Student> list = new ArrayList<Student>();
			while(rs.next()){
				Student student= new Student();
				student.setId(rs.getInt(1));
				student.setFirst_name(rs.getString(2));
				student.setLast_name(rs.getString(3));
				student.setFname(rs.getString(4));
				student.setEmail(rs.getString(5));
				student.setClass_name(rs.getInt(6));
				student.setAge(rs.getInt(7));
				list.add(student);
			}
			request.setAttribute("student_list", list);
			request.getRequestDispatcher("searchstudents.jsp").forward(request, response);
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}

}