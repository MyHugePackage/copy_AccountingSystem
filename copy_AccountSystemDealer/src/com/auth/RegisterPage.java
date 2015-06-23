package com.auth;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterPage
 */
@WebServlet("/RegisterPage")
public class RegisterPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterPage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Dealer_RegisterPage.doPost");

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String rolename = request.getParameter("rolename");

		Calendar calendar = Calendar.getInstance();
		java.sql.Timestamp timestampObject = new java.sql.Timestamp(calendar.getTime().getTime());
		// http://alvinalexander.com/java/java-timestamp-example-current-time-now


		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/account", "java", "java");
			Statement st_AuthUsers = conn.createStatement();
//			ResultSet rs_AuthUsers = st_AuthUsers.executeQuery("");

			Statement st_AuthRoles = conn.createStatement();
//			ResultSet rs_AuthRoles = st_AuthRoles.executeQuery("");

			Statement st_AuthCheck = conn.createStatement();
			ResultSet rs_AuthCheck = st_AuthCheck.executeQuery("SELECT username FROM auth_users "
					+ "WHERE username = '"+username+"'");

			boolean authCheck = true;
			if(rs_AuthCheck.next()){
				authCheck = false;
			}

			if(authCheck){
				boolean inputCheck = false;
				if((username != null && username != "")&&(password != null && password != "")){
				st_AuthUsers.executeUpdate("INSERT INTO auth_users "
						+ "values('"+username+"','"+password+"','"+timestampObject+"','"+timestampObject+"')");
				st_AuthRoles.executeUpdate("insert into auth_roles "
						+ "values('"+username+"','"+rolename+"','"+timestampObject+"','"+timestampObject+"')");
				inputCheck = true;
				}

				if(inputCheck){
					response.sendRedirect("/AccountSystemDealer/auth/dealerRegistered.html");
				} else {
					response.sendRedirect("/AccountSystemDealer/error/register_error.html");
				}

			} else {
				response.sendRedirect("/AccountSystemDealer/error/alreadyRegistered.html");
			}
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
