<%@page import="com.te.springmvcproject.dto.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="header.jsp" %>
   
    <%Employee employee=(Employee)request.getAttribute("details"); %>
    
    <%String msg=(String)request.getAttribute("msg"); %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<br>
<br> <br>
<%if(msg!=null && !msg.isEmpty()){ %>
    <h1><%=msg %></h1>
    <%} %>
<form action="./search" method="post">
<input type="number" name="empId" placeholder="enter the userId">
<input type="submit" value="Search">


</form>
<br> <br> <br>
<%if(employee!=null){ %>
<h1>Your Id is:
    <%=employee.getId()%></h1>
<h1>Your Name is:
    <%=employee.getName() %></h1>
<h1>Your DOB is:
    <%=employee.getDob() %></h1>
<h1>Your Password is:
    <%=employee.getPassword() %></h1>
    <%} %>
</body>
</html>