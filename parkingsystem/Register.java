package com.metacube.parkingsystem;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metacube.DAO.EmployeeDAO;
import com.metacube.DAO.OrganizationDAO;
import com.metacube.services.Employee;
import com.metacube.services.Organization;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			Employee emp = new Employee();
			emp.setName(request.getParameter("empName"));
			emp.setGender(request.getParameter("gender"));
			emp.setContact(request.getParameter("contact"));
			emp.setEmail(request.getParameter("email"));
			emp.setPassword(request.getParameter("password"));
			emp.setOrganization_id(Integer.parseInt(request.getParameter("org")));
			try {
				List<Organization> org_list = OrganizationDAO.getAllOrganization();
				request.setAttribute("organization_list",org_list);
				int res = EmployeeDAO.insertEmployee(emp);
				if(res>0){
					request.setAttribute("message",EmployeeDAO.getLastInsertedEmpId());
					request.getRequestDispatcher("vehicleform.jsp").forward(request, response);
				}
				else{
					request.setAttribute("message", "Email already exist");
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}						
	}
}
