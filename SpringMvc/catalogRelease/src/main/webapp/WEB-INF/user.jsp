<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Panel</title>
</head>
<body>
	Successfully User!
	<div align="center">
		<h1>Task list</h1>
		<form method="get" action="search">
			<input type="text" name="keyword" /> &nbsp; <input type="submit"
				value="Search" />
		</form>
		<table border="1" cellpadding="2">
			<tr>
				<th>id</th>
				<th>Tag</th>
				<th>Title</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${listTask}" var="task" varStatus="status">
				<tr>
					<td>${task.id}</td>
					<td>${task.tag}</td>
					<td>${task.title}</td>
					<td><a href="editTask?id=${task.id}">Edit</a> <a
						href="deleteTask?id=${task.id}">Delete</a>
				</tr>
			</c:forEach>
		</table>
	</div>
	<a href="/catalog/">log out</a>
	<a href="/catalog/task">add task</a>
</body>
</html>