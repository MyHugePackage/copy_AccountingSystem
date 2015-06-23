package com.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainClass
 */
//@WebServlet("/MainClass")
public class MainClass extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html;charset=UTF-8");

		PrintWriter writer = response.getWriter();

		writer.println("<html></head></head><body>");
		writer.println("ログインしてください。<br>");
		writer.println("初めての方は、新規登録を行ってください。<br><br>");
		writer.println("<form action=\"/AccountSystemDealer/LoginPage\" method=\"post\">");
		writer.println("<input type=\"hidden\" name=\"rolename\" value=\"dealer\"/>");
		writer.println("ユーザーID : <input type=\"text\" name=\"username\"/><br>");
		writer.println("パスワード <input type =\"password\" name =\"password\"/><br><br>");
		writer.println("<input type =\"submit\" value=\"ログイン\" name =\"enter\"/><input type =\"reset\" value=\"クリア\" name =\"claer\"/><br>");
		writer.println("</form>");
		writer.println("新規登録は<a href = \"/AccountSystemDealer/auth/register.html\">こちら</a>");
		writer.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
