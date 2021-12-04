<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Result</title>
</head>
<body>
	<jsp:useBean id="bean" scope="session" type="com.te.session.MyBean" />
	<h1>
		Result is
		<jsp:getProperty name="bean" property="num" /></h1>
	<form action="clear" method="get">
		<input type="submit" name="btn" value="clear"> <input
			type="submit" name="btn" value="back">
	</form>
</body>
</html>