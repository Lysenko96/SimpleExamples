<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Books</title>
</head>
<body>
    <jsp:useBean id="bookBean" scope="request" type="com.te.myservletmvn.beans.BookBean"/>
    <h1>${bookBean.size}</h1>
    <table>
        <thead>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>author</th>
            <th>genre</th>
            <th>pageCount</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${bookBean.books}" var="b">
                <tr>
                    <td>${b.id}</td>
                    <td>${b.name}</td>
                    <td>${b.author}</td>
                    <td>${b.genre}</td>
                    <td>${b.pageCount}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>