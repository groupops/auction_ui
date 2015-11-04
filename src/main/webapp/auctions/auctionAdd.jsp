<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Auction Name Here</title>
</head>
<body>
<h1>Create new auction</h1>

<form action="<c:url value='/auctions/add' />" method='POST'>
    <b>Title: </b><br><input type="text" name="title"/> <br>
    <b>Description: </b><br><textarea name="description" rows="4" cols="50"/></textarea>
    <br>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="submit" value="submit">
</form>
</body>
</html>
