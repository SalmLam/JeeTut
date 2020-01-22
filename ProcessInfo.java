package com.salma;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
/**
 * Servlet implementation class ProcessInfo
 */
@WebServlet("/ProcessInfo")
public class ProcessInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/DisplayInfo.jsp";
		String fName = request.getParameter("fname");
		String lName = request.getParameter("lname");
		String phone = request.getParameter("phone");
		
		updateDB(fName, lName, phone);
		Customer cust = new Customer(fName, lName, phone);	
		request.setAttribute("cust", cust);
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}
	
	protected void updateDB(String fName, String lName, String phone) {
		Connection con;
		try {
			Class.forName("com.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/test1";
			String user = "dbadmin";
			String pw = "turtle";
			con = DriverManager.getConnection(url, user, pw);
			Statement s = con.createStatement();
			//String query = "INSERT INTO CUSTOMOR " + "(first_name, last_name, phone, cust_id) " + 
			//"VALUES ('" + fName + "', '" + lName + "', '" + phone + "' , 1)";
			String query = "INSERT INTO salmaTable VALUES ('salma')";
			s.executeUpdate(query);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("ouf class not found");
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ouf sql");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
 