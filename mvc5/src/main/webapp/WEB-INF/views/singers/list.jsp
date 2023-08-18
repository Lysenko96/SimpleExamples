<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <thread>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Birth Date</th>
        </tr>
    </thread>
    <tbody>
    <!-- don't work jstl -->
    <c:forEach items="${singers}" var="singer">
        <tr>
            <td><c:out value="${singer.firstName}"/></td>
            <td><c:out value="${singer.lastName}"/></td>
            <td><c:out value="${singer.birthDate}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
