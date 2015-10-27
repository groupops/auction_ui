<%--
  Created by IntelliJ IDEA.
  User: Dmytro_Ulanovych
  Date: 10/27/2015
  Time: 5:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <%@include file="includes.jsp" %>
</head>
<body>
Hi from login!

<form action="">
    <p>
        <jsp:text>Name</jsp:text>
        <input name="name" type="text"/>

    </p>

    <p>
        <jsp:text>Password</jsp:text>
        <input name="password" type="text"/>
    </p>

    <input type="submit" value="Login" title="Login"/>
</form>

</body>
</html>
