<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>webapp</title>
</head>
<body>
<form method="post" action="webapp">
    <p><b>Your name:</b><br>
        <input type="text" name = "name"size="40">
    </p>
    <p><b>Your age:</b><br>
        <input type="text" name="age" size="40">

        <input type="submit" value="Confirm">
        <input type="reset" value="Reset"></p>
</form>
<form method="post" action="erase">
<input type="submit" value="Delete all records">
</form>

<% String name = request.getParameter("name");%>
<% String age = request.getParameter("age");%>
</body>
</html>