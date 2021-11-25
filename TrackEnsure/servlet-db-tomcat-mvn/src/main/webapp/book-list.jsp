<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book management</title>
</head>
<body>
	<header>
		<nav>
			<ul>
				<li><a href="<%=request.getContextPath()%>/list">Books</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div>
		<div>
			<h3>List of Books</h3>
			<hr>
			<div>
				<a href="<%=request.getContextPath()%>/new">Add New Book</a>
			</div>
			<br>
			<table>
				<thead>
					<tr>
						<th>Id</th>
						<th>Name</th>
						<th>Author</th>
						<th>Genre</th>
						<th>Page count</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach var="book" items="${books}">
						<tr>
							<td><c:out value="${book.id}" /></td>
							<td><c:out value="${book.name}" /></td>
							<td><c:out value="${book.author}" /></td>
							<td><c:out value="${book.genre}" /></td>
							<td><c:out value="${book.pageCount}" /></td>
							<td><a href="edit?id=<c:out value='${book.id}'/>">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${book.id}'/>">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>