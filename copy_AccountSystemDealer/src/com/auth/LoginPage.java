package com.auth;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginPage
 */
@WebServlet("/LoginPage")
public class LoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginPage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Dealer_LoginPage.doPost");

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String rolename = request.getParameter("rolename");

		String sql = "SELECT auth_users.username ,password, rolename "
				+ "FROM auth_users INNER JOIN auth_roles "
				+ "ON auth_users.username = auth_roles.username "
				+ "WHERE auth_users.username = '"+username+"'";
		/**6/16
		 * String rolename = request.getParameter("rolename"); from hidden type value
		 * Syso(rolename) -> out.print(null)
		 *
		 * 6/17
		 * formの間に余計な文字列を外すとhidden typeのデータが送信できた。
		 */


		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/account", "java", "java");
/* 6/15
			Statement st_AuthUsers = conn.createStatement();
			ResultSet rs_AuthUsers = st_AuthUsers
					.executeQuery("SELECT username, password FROM auth_users WHERE username = '"
							+ username + "'");
			Statement st_AuthRoles = conn.createStatement();
			ResultSet rs_AuthRoles = st_AuthRoles
					.executeQuery("SELECT username, rolename FROM auth_roles WHERE username = '"
							+ username + "'");
*/
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);

			/**6/17
			 * ResultSetのsql構文
			 * INNER JOIN ON を利用
			 * 構文 :
			 * select auth_users.username ,password, rolename from auth_users INNER JOIN auth_roles
			 * ON auth_users.username = auth_roles.username;
			 *
			 * 結果 :
			 * +----------+----------+----------+
			 * | username | password | rolename |
			 * +----------+----------+----------+
			 * | ddd      | ddd      | dealer   |
			 * | dea      | dea      | dealer   |
			 * | ggg      | ggg      | dealer   |
			 * | ooo      | ooo      | orderer  |
			 * | ord      | ord      | orderer  |
			 * +----------+----------+----------+
			 */


			boolean authCheck = false;
			if(rs.next()){
				if(username.equals(rs.getString("username"))) {
					if(password.equals(rs.getString("password"))) {
						if(rolename.equals(rs.getString("rolename"))) {
							authCheck = true;
						}
					}
				}
			}
/* 6/15
			boolean usernameCheck = false, passwordCheck = false, rolenameCheck = false;

			if (rs_AuthUsers.next() && rs_AuthRoles.next()) {
				if (username.equals(rs_AuthUsers.getString("username"))) {
					usernameCheck = true;
					if (password.equals(rs_AuthUsers.getString("password"))) {
						passwordCheck = true;
						if (rolename.equals(rs_AuthRoles.getString("rolename"))) {
							rolenameCheck = true;
						}
					}
				}
			}
*/
//6/15		if ((usernameCheck && passwordCheck) && rolenameCheck) {
			if (authCheck) {
				response.sendRedirect("/AccountSystemDealer/auth/dealerLogin_succeeded.jsp"
						+ "?username="+username);
			} else {
				response.sendRedirect("/AccountSystemDealer/error/login_error.html");
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
