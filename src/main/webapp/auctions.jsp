<%--
  Created by IntelliJ IDEA.
  User: Dmytro_Ulanovych
  Date: 10/27/2015
  Time: 6:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of available auctions</title>
    <%@include file="includes.jsp" %>

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

<ol id="auctions">
    <li class="ui-state-default"> 1</li>
    <li class="ui-state-default"> 2</li>
    <li class="ui-state-default"> 3</li>
    <li class="ui-state-default"> 4</li>
    <li class="ui-state-default"> 5</li>
    <li class="ui-state-default"> 6</li>
    <li class="ui-state-default"> 7</li>
    <li class="ui-state-default"> 8</li>
    <li class="ui-state-default"> 9</li>
</ol>

</body>
</html>
