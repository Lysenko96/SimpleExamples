<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring Login Form</title>
</head>
<body>
	<form:form name="submitForm" method="POST">
		<div align="center">
			<table>
				<tr>
					<td>Email</td>
					<td><input type="text" name="email" id="email" /></td>
					<%=request.getParameter("email")%>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" id="password" /></td>
					<%=request.getParameter("password")%>
				</tr>
				<tr>
					<td>User Name</td>
					<td><input type="text" name="name" id="name" /></td>
					<%=request.getParameter("name")%>
				</tr>
				<tr>
					<td>User Surname</td>
					<td><input type="text" name="surname" id="surname" /></td>
					<%=request.getParameter("surname")%>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Submit" /></td>
				</tr>
				<tr>
					<td><select name="role">
							<option value="" selected disabled hidden>select role</option>
							<option value="ADMIN">admin</option>
							<option value="USER">user</option>
					</select></td>
					<%=request.getParameter("role")%>
				</tr>
			</table>

		</div>
	</form:form>
</body>
</html>