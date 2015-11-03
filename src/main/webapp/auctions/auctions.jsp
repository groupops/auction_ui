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

Here will be the list of auctions

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
