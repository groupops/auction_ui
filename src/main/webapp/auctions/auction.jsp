<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Auction for ${auction.title}</title>
    <link href="<c:url value="/css/basic.css" />" rel="stylesheet">
    <%@include file="../includes.jsp" %>

    <link rel="stylesheet" type="text/css" media="screen" href='<c:url value="/css/bootstrap.min.css"/>'/>
    <script type="text/javascript" src="//code.jquery.com/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.10/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.10/js/dataTables.bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h1>Book information:</h1>

    <c:choose>
        <c:when test="${auction.active}">
            <table class="table">
                <tr>
                    <td style="width: 30%">Title</td>
                    <td>${auction.title}</td>
                </tr>
                <tr>
                    <td>Description</td>
                    <td>${auction.description}</td>
                </tr>
            </table>
            <div id="time">
                <label></label>
            </div>

            <h2 style="padding-bottom: 25px; padding-top: 20px">Max Bid: ${currentBid.bid}</h2>
            <div class="progress">
                <div class="progress-bar progress-bar-success progress-bar-striped active" role="progressbar"
                     aria-valuenow="10" aria-valuemin="120" aria-valuemax="120" style="width:100%; color: black">
                    120 seconds left
                </div>
            </div>
            <form class="form-inline" role="form" action="<c:url value='/auctions/bid'/>" method='POST'>
                <div class="form-group">
                    <label for="amount">Your bid:</label>
                    <input name="amount" type="text" class="form-control" id="amount" value="${currentBid.bid+1}">
                </div>
                <button type="submit" class="btn btn-default">Do Bid</button>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <input type="hidden" name="auctionId" value="${auction.id}"/>
            </form>

            <span style="color:red">${message}</span>

        </c:when>
        <c:otherwise>
            <table class="table">
                <tr>
                    <td style="width: 30%"> Title</td>
                    <td>${auction.title}</td>
                </tr>
                <tr>
                    <td>Description</td>
                    <td>${auction.description}</td>
                </tr>
                <tr>
                    <td>Sold for</td>
                    <td>${auction.finalPrice}</td>
                </tr>
            </table>
        </c:otherwise>
    </c:choose>
</div>

</body>
</html>
