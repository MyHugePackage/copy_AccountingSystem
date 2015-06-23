<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <jsp:useBean id="uBean" class="com.auth.UserBean" scope="session"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String username = request.getParameter("username");
//6/18 String password = request.getParameter("password"); // 入らない。6/17
out.println(username+"<br>");
//6/18 out.println(password);
%>
<jsp:setProperty property="username" name="uBean" value="<%=username%>"/>
username : <jsp:getProperty property="username" name="uBean"/>

<a href="/AccountSystemDealer/main/productList.jsp">商品リスト</a>
</body>
</html>