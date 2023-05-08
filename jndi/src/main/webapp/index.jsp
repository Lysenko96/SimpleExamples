<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Start CRUD</title>
</head>
<body>
<h1><%= "Start CRUD" %></h1>
<br/>
<a href="start-servlet?actionName=/add">Start /add</a>
<a href="start-servlet?actionName=/getAll">Start /getAll</a>
<a href="start-servlet?actionName=/getById&id=">Start /getById</a>
<a href="start-servlet?actionName=/update&id=">Start /update</a>
<a href="start-servlet?actionName=/deleteById&id=">Start /deleteById</a>
</body>
</html>