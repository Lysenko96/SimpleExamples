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
		<c:if test="${book != null}">
			<form action="update" method="post">
		</c:if>
		<c:if test="${book == null}">
			<form action="add" method="post">
		</c:if>

		<caption>
			<h2>
				<c:if test="${book != null}">
		Edit Book
		</c:if>
				<c:if test="${book == null}">
		Add New Book
		</c:if>
			</h2>
		</caption>

		<c:if test="${book != null}">
			<input type="hidden" name="id" value="<c:out value='${book.id}'/>" />
		</c:if>
		<fieldset>
			<label>Book Name</label> <input type="text"
				value="<c:out value='${book.name}'/>" name="name"
				required="required">
		</fieldset>
		<fieldset>
			<label>Book Author</label> <input type="text"
				value="<c:out value='${book.author}'/>" name="author"
				required="required">
		</fieldset>
		<fieldset>
			<label>Book Genre</label>
			<p><input type="radio" value="<c:out value='${book.genre}'/>"
				name="genre" required="required">FANTASY<br>
				<input type="radio" value="<c:out value='${book.genre}'/>"
				name="genre" required="required">SCI_FI<br>
				<input type="radio" value="<c:out value='${book.genre}'/>"
				name="genre" required="required">MYSTERY<br>
				<input type="radio" value="<c:out value='${book.genre}'/>"
				name="genre" required="required">THRILLER<br>
				<input type="radio" value="<c:out value='${book.genre}'/>"
				name="genre" required="required">ROMANCE<br>
				</p>
		</fieldset>
		<fieldset>
			<label>Book Page Count</label> <input type="text"
				value="<c:out value='${book.pageCount}'/>" name="pageCount"
				required="required">
		</fieldset>
		<button type="submit">Save</button>
		</form>
	</div>
</body>
</html>