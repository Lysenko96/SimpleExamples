<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<%--<a href="helloServlet">Hello Servlet</a>--%>
<form action= "${pageContext.request.contextPath}/helloServlet" method="post">
    <br/><input name="message">
    <button type="submit">send</button>
</form>
<br/>
<form action="${pageContext.request.contextPath}/fileServlet" method="post" enctype="multipart/form-data">
    <br/><input type="text" name="author">
    <br/><input type="file" name="file">
    <button type="submit">send</button>
</form>
</body>
</html>