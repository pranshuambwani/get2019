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
 * Servlet implementation class Verification
 */
@WebServlet("/Verification")
public class Verification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Verification() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		try {
			Employee employee = EmployeeDAO.validUser(email, password);
			if(employee!=null){
				HttpSession session = request.getSession();
				session.setAttribute("email",employee.getEmail());
				session.setAttribute("emp_id", employee.getEmp_id());
				request.setAttribute("employeeDetail", employee);
				request.getRequestDispatcher("profile.jsp").forward(request, response);
			}
			else{
				request.setAttribute("message", "Email/Password is Invalid");
				request.getRequestDispatcher("loginPage.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
