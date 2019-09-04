package com.metacube.parkingsystem;

import java.io.IOException;

import javafx.scene.chart.PieChart.Data;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metacube.DAO.PassDAO;
import com.metacube.services.Pass;

/**
 * Servlet implementation class PassGenerated
 */
@WebServlet("/PassGenerated")
public class PassGenerated extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PassGenerated() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Pass pass = new Pass();
		pass.setEmp_id(Integer.parseInt(request.getParameter("emp_id")));
		pass.setPass_type(request.getParameter("plan"));
		pass.setVehicle_id(Integer.parseInt(request.getParameter("vehicle_id")));
		String v_type = request.getParameter("v_type");
		String pass_type = request.getParameter("plan");
		String rate = "";
		if( v_type.equals("CYCLE")){
			if(pass_type.equals("daily"))
				rate="$0.6";
			else if(pass_type.equals("monthly"))
				rate="$1.38";
			else
				rate = "$6.94";
		}
		else if(v_type.equals("MOTOR CYCLE")){
			if(pass_type.equals("daily"))
				rate="$0.13";
			else if(pass_type.equals("monthly"))
				rate="$2.77";
			else
				rate = "$13.88";	
		}
		else if(v_type.equals("FOUR WHEELER")){
			if(pass_type.equals("daily"))
				rate="$0.277";
			else if(pass_type.equals("monthly"))
				rate="$6.94";
			else
				rate = "$48.61";
		}
		pass.setRate(rate);
		try {
			PassDAO.insertPass(pass);
			response.sendRedirect("Index");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
