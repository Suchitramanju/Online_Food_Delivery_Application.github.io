<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
	<form action="LoginServlet" method="post">
		<%String error=(String)session.getAttribute("error"); 
			if(error!=null){
		%>
		<p style="color:red"><%= error %></p>
		<% } %>
		<table>
			<tr>
				<td><label>Email</label></td>
				<td><input type="email" name="email"></td>
			</tr>
			<tr>
				<td><label>Password</label></td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Login"></td>
			</tr>
		</table>
		<p><a href="registration.jsp">No Account , create new Account!</a></p>
	</form>
</body>
</html>