<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>show shop repo</title>
</head>
<body>

	<%@ page import="net.pack.servletstyle.beans.ShopRepo"%>
	<% ShopRepo repo = (ShopRepo) session.getAttribute("repo"); %>
	<%= repo %>


<%-- 	<jsp:useBean id="shopRepo" scope="session"
		type="net.pack.servletstyle.beans.ShopRepo" /> --%>
<%-- 	<jsp:getProperty name="shopRepo" property="nameProduct" /></h1>
	<jsp:getProperty name="shopRepo" property="countProduct" /></h1> --%>
</body>
</html>