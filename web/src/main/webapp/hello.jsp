<%@ page import="java.util.Date" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Hello jsp</title>
</head>
<body>
<form method="get" action="hell/aoeu">
    <input type="text"name="name" value="Matija"/>
    <input type="text" name="a" value="b"/>
    <input type="submit" value="Pošlji"/>

    <% out.print("Hi from Java!"); %>;
    <%= new Date() %>;
</form>
</body>
</html>