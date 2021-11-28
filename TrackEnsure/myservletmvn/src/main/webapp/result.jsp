<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Books</title>
</head>
<body>
	<jsp:useBean id="book" scope="request"
		type="com.te.myservletmvn.entity.Book" />
	<tr>
		<td>${book.id}</td>
		<td>${book.name}</td>
		<td>${book.author}</td>
		<td>${book.genre}</td>
		<td>${book.pageCount}</td>
	</tr>
</body>
</html>