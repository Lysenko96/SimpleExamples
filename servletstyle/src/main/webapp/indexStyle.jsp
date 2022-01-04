<html>
<body>
<h2>Hello Servlet!</h2>
<%String name = request.getParameter("name"); %>
<%= "Hello " + name %>
<form>
<input type="submit" name="sumbit" value="send">
</form>
</body>
</html>
