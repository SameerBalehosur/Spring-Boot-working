<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    <% String errMsg=(String)request.getAttribute("errMsg");%>
    
    <% if(errMsg!=null){ %>
    <h1> <%=errMsg  %></h1> 
    <%} %>
    
     <% String msg=(String)request.getAttribute("msg");%>
    
    <% if(msg!=null){ %>
    <h1> <%=msg  %></h1> 
    <%} %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<fieldset>

<legend>Employee Login</legend>
<form action="./login" method="post">
<table>
<tr>
<td> <label> Enter Your Username</label></td>
<td><input type="number" name="id" placeholder="your username"></td>

</tr>
<tr>
<td> <label> Enter Your Password</label></td>
<td><input type="password" name="pwd" placeholder="your password"></td>

</tr>

</table>
<input type="submit" value="Login">



</form>

</fieldset>

</body>
</html>