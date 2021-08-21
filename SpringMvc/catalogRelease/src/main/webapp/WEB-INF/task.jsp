<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
					<td>Tag</td>
					<td><input name="tag" id="tag" /></td>
				</tr>
				<tr>
					<td>Title</td>
					<td><textarea name="title" id="title"></textarea></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Submit" /></td>
				</tr>
			</table>
			<a href="/catalog/">to start page</a>
		</div>
	</form:form>
</body>
</html>