<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@taglib
uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<td>User Name</td>
<td><input type="text" name="name" id="name"/></td>
<%= request.getParameter("name")%>
</tr>
<tr>
<td>Password</td>
<td><input type="password" name="passwd" id="passwd" /></td>
<%= request.getParameter("passwd")%>
</tr>
<tr>
<td></td>
<td><input type="submit" value="Submit" /></td>
</tr>
</table>

</div>
</form:form>
</body>
</html>
