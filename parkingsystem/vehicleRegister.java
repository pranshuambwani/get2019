package com.metacube.parkingsystem;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metacube.DAO.VehicleDAO;
import com.metacube.services.Vehicle;
import com.mysql.jdbc.ResultSet;

/**
 * Servlet implementation class vehicleRegister
 */
@WebServlet("/vehicleRegister")
public class vehicleRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public vehicleRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicle_name(request.getParameter("vehicle_name"));
		vehicle.setType(request.getParameter("type"));
		vehicle.setVehicle_number(request.getParameter("vehicle_number"));
		vehicle.setEmp_id(Integer.parseInt(request.getParameter("emp_id")));
		vehicle.setIdentification(request.getParameter("identification"));
		try {
			Integer id = VehicleDAO.insertVehicle(vehicle);
			request.setAttribute("type", vehicle.getType());
			request.setAttribute("emp_id", vehicle.getEmp_id());
			request.setAttribute("vehicle_id", VehicleDAO.getlastInsertedVehicleId());
			request.getRequestDispatcher("generate_pass.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			try {
				request.setAttribute("message", "Some error Occur!! Try Again");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			e.printStackTrace();
		}
		
	}

}
