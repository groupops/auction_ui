<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Create new Auction</title>
    <link href="<c:url value="/css/basic.css" />" rel="stylesheet">
    <%@include file="../includes.jsp" %>

    <link rel="stylesheet" type="text/css" media="screen" href='<c:url value="/css/bootstrap.min.css"/>'/>
    <script type="text/javascript" src="//code.jquery.com/jquery-1.11.3.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h2>Create new auction</h2>
    <form class="form-horizontal" role="form" action="<c:url value='/auctions/add'/>" method='POST'>
        <div class="form-group">
            <label class="sr-only" for="title">Title:</label>
            <input name="title" type="text" class="form-control" id="title" placeholder="Auction name">
        </div>
        <div class="form-group">
            <label class="sr-only" for="description">Description:</label>
            <textarea id="description" class="form-control" rows="5" name="description" placeholder="Desctiption"></textarea>
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</div>
</body>
</html>
