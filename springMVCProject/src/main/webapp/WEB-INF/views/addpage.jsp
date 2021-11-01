<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="header.jsp" %>
    
    
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

<%if(msg!=null && !msg.isEmpty()){%>
<h1><%=msg %></h1>
<%} %>

<br>
<form action="./add" method="post">
<table>

<tr> 
<td> <label>Employee Id</label> </td>
<td> <input type="number" name="id" placeholder="Enter Your Id"></td>
</tr>
<tr> 
<td> <label>Employee Name</label> </td>
<td> <input type="text" name="name" placeholder="Enter Your Name"></td>
</tr>
<tr> 
<td> <label>Employee Password</label> </td>
<td> <input type="password" name="password" placeholder="Enter Your Password"></td>
</tr>
<tr> 
<td> <label>Employee Date Of Birth</label> </td>
<td> <input type="date" name="dob" placeholder="Enter Your Date Of Birth"></td>
</tr>
</table>
<input type="submit" value="Add Employee">
</form>
</body>
</html>