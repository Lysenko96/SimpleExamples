<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Panel</title>
</head>
<body>
	Successfully Admin!
	<div align="center">
		<h1>User list</h1>
		<table border="1" cellpadding="2">
			<tr>
				<th>id</th>
				<th>Email</th>
				<!--  <th>Password</th> -->
				<th>Name</th>
				<th>Surname</th>
				<th>Role</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${listUser}" var="user" varStatus="status">
				<tr>
					<td>${user.id}</td>
					<td>${user.email}</td>
					<!--	<td>${user.passwd}</td> -->
					<td>${user.name}</td>
					<td>${user.surname}</td>
					<td>${user.role}</td>
					<td><a href="edit?id=${user.id}">Edit</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<a href="/catalog">log out</a>
</body>
</html>