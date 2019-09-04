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
import javax.servlet.http.HttpSession;

import com.metacube.DAO.EmployeeDAO;
import com.metacube.DAO.OrganizationDAO;
import com.metacube.services.Employee;
import com.metacube.services.Organization;

/**
 * Servlet implementation class UpdatePage
 */
@WebServlet("/UpdatePage")
public class UpdatePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		try {
				Employee employee = EmployeeDAO.getEmployee(Integer.parseInt(session.getAttribute("emp_id").toString()));
				List<Organization> org_list = OrganizationDAO.getAllOrganization();
				request.setAttribute("employeeDetail", employee);
				request.setAttribute("organization_list",org_list);
				request.getRequestDispatcher("editprofile.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
