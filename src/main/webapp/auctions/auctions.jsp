<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List of available auctions</title>
    <link href="<c:url value="/css/basic.css" />" rel="stylesheet">
    <%@include file="../includes.jsp" %>

    <link rel="stylesheet" type="text/css" media="screen" href='<c:url value="/css/bootstrap.min.css"/>'/>
    <script type="text/javascript" src="//code.jquery.com/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.10/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.10/js/dataTables.bootstrap.min.js"></script>
</head>
<body style="padding: 50px">

<div class="jumbotron">
    <h1>Welcome to the book auctions online!</h1>
    <p>Sell what you do not need anymore</p>
    <p>Find book of your dream!</p>
</div>
<div>
    <a id="add-auction-page" data-toggle="modal" target="#add-auction-form" class="btn btn-success"
       href="<c:url value="/auctions/add"/>">Add
        Auction</a>
</div>

<div class="container">
    <h2>Active auctions</h2>
</div>

<table id="active-auctions" class="table table-striped table-bordered" cellspacing="0" width="100%">
    <thead>
    <tr>
        <th>Auction</th>
        <th>Description</th>
        <th>Seller</th>
        <th>Created</th>
    </tr>
    </thead>

    <tbody>
    <jsp:useBean id="activeAuctions" scope="request"
                 type="java.util.List<com.epam.training.auction.common.AuctionTransferObject>"/>
    <c:if test="${not empty activeAuctions}">
        <c:forEach items="${activeAuctions}" var="auction">
            <tr>
                <td><a href="<c:url value="/auctions/${auction.id}"/>">${auction.title}</a></td>
                <td>${auction.description}</td>
                <td>${auction.seller.username}</td>
                <td>${auction.createdAt}</td>
            </tr>
        </c:forEach>
    </c:if>
    </tbody>
</table>

<div class="container">
    <h2>Archived auctions</h2>
</div>
<table id="archived-auctions" class="table table-striped table-bordered" cellspacing="0" width="100%">
    <thead>
    <tr>
        <th>Auction</th>
        <th>Description</th>
        <th>Seller</th>
        <th>Winner</th>
        <th>Finished</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${not empty archivedAuctions}">
        <c:forEach items="${archivedAuctions}" var="auction">
            <tr>
                <td><a href="<c:url value="/auctions/${auction.id}"/>">${auction.title}</a></td>
                <td>${auction.description}</td>
                <td>${auction.seller.username}</td>
                <td>${auction.winner.username}</td>
                <td>${auction.updatedAt}</td>
            </tr>
        </c:forEach>
    </c:if>
    </tbody>
</table>

<script type="text/javascript">
    $(document).ready(function () {
        $('#active-auctions, #archived-auctions').DataTable();
    });
</script>
</body>
</html>
