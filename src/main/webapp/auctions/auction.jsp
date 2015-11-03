<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>List of available auctions</title>
    <%@include file="../includes.jsp" %>

    <style>
        #feedback {
            font-size: 1.4em;
        }

        #auctions .ui-selecting {
            background: #FECA40;
        }

        #auctions .ui-selected {
            background: #F39814;
            color: white;
        }

        #auctions {
            list-style-type: none;
            margin: 0;
            padding: 0;
            width: 450px;
        }

        #auctions li {
            margin: 3px;
            padding: 1px;
            float: left;
            width: 100px;
            height: 80px;
            font-size: 4em;
            text-align: center;
        }
    </style>
    <script>
        $(function () {
            $("#auctions").selectable();
        });
    </script>
</head>
<body>

<h1>Book information:</h1>

<b>Title: </b>${auction.title}
<br>
<b>Description: </b>${auction.description}
<br><br>
<b>Current Bid: </b> ${currentBid.bid}

<form action="<c:url value='/auctions/bid' />" method='POST'>
<input type="text" name="amount">
<input type="hidden" name="auctionId" value="${auction.id}"/>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
<input type="submit" value="bid">
</form>

<br><br>
<span style="color:red">${message}</span>




</body>
</html>
