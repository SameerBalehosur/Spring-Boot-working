<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="header.jsp" %>
    
       <%String delete=(String)request.getAttribute("delete"); %>
    
    <%String errMsg=(String)request.getAttribute("msg"); %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<br>
<br>

<%if(delete!=null && !delete.isEmpty()){ %>
    <h1><%=delete %></h1>
    <%} %>
    
    <%if(errMsg!=null && !errMsg.isEmpty()){ %>
    <h1><%=errMsg %></h1>
    <%} %>
    
<form action="./delete" method="post">
<input type="number" name="empId" placeholder="enter the userId">
<input type="submit" value="Delete">
</form>
</body>
</html>