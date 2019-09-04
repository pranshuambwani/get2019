package com.metacube.parkingsystem;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.metacube.DAO.EmployeeDAO;
import com.metacube.services.Employee;

/**
 * Servlet implementation class UpdateProfile
 */
@WebServlet("/UpdateProfile")
public class UpdateProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String submit = request.getParameter("submit");
		if(!submit.equals("cancel")){
			Employee emp = new Employee();
			emp.setEmp_id(Integer.parseInt(request.getParameter("id")));
			emp.setName(request.getParameter("empName"));
			emp.setGender(request.getParameter("gender"));
			emp.setEmail(request.getParameter("email"));
			emp.setContact(request.getParameter("contact"));
			emp.setOrganization_id(Integer.parseInt(request.getParameter("org")));
			try {
				EmployeeDAO.updateEmployee(emp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				
		HttpSession session = request.getSession();
		Employee employee=null;
		try {
			employee = EmployeeDAO.getEmployee(Integer.parseInt(session.getAttribute("emp_id").toString()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("employeeDetail", employee);
		request.getRequestDispatcher("profile.jsp").forward(request, response);
		}
	
}



