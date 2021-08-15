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
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="passwd" id="passwd" /></td>
				</tr>
				<tr>
					<td>User Name</td>
					<td><input type="text" name="name" id="name" /></td>
				</tr>
				<tr>
					<td>User Surname</td>
					<td><input type="text" name="surname" id="surname" /></td>
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
					<%-- <%=request.getParameter("role")%> --%>
				</tr>
			</table>
			<a href="/catalog/">to start page</a>
		</div>
	</form:form>
</body>
</html>