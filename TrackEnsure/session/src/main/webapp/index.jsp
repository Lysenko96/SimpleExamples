<html>
<body>
<h2>Hello World!</h2>
<form action="hello-servlet" method="post">
<label for="number">Number  <%= (String) request.getAttribute("123") %></label>
    <br>
<input type="text" id="number" name="numField">
<input  type="submit" value="send">
</form>
</body>
</html>
