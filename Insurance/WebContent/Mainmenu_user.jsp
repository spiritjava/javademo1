<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="top" style=height:100px>
<%
session=request.getSession(false);
String n=(String)session.getAttribute("username");
out.print("<center><h2>welcome "+n+"</h2></center>");
%></div>
<div id="middle" style=""height:200pxborder:solid;">
<center><h1>welcome to A2ZInsurance</h1>
<a href="AutoPremium.jsp">
<h3> Compute Auto Insurance Premium</h3></a></center></div>
<div id="bottom"></div>
</body>
</html>