<%@page import="com.te.springmvcproject.dto.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="header.jsp" %>
    <% List<Employee> employees =(List<Employee>)request.getAttribute("viewall"); %>
    <%String msg=(String)request.getAttribute("msg"); %>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<br>
<br>
<%if(msg!=null && !msg.isEmpty()){ %>
<h1><%=msg %></h1>
<%} %>

<%if(employees!=null){ %>
<h1><%= employees%></h1>
<%}%>

</body>
</html>