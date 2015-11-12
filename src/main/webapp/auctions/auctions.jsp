<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>List of available auctions</title>
    <link href="<c:url value="/css/basic.css" />" rel="stylesheet">
    <%@include file="../includes.jsp" %>
</head>
<body>

<br>
<a href="<c:url value="/auctions/add"/>">ADD AUCTION</a>
<br>
<br>
<table id="activeAuctions">
    <c:if test="${not empty activeAuctions}">
    		<c:forEach items="${activeAuctions}" var="auction">
              <tr>
              <td>
              <a href="<c:url value="/auctions/${auction.id}"/>">
                    ${auction.title}
                    </a>
              </td>
              <td>
                    ${auction.description}
              </td>
              </tr>
        </c:forEach>
    </c:if>
</table>

</body>
</html>
