<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Auction House</title>

    <link rel="stylesheet" type="text/css" media="screen" href='<c:url value="css/bootstrap.min.css"/>'/>
    <link href="<c:url value="/css/basic.css" />" rel="stylesheet">
</head>
<body>
<div id="login-box">

    <div class="panel-primary navbar-header text-center col-center">
        <div class="panel-heading">
            <h1 class="panel-title">Log in</h1>
        </div>
        <div class="panel-body">
            <c:if test="${not empty error}">
                <div class="error">${error}</div>
            </c:if>
            <c:if test="${not empty msg}">
                <div class="msg">${msg}</div>
            </c:if>

            <form name='loginForm' action="<c:url value='login' />" method='POST'>
                <div class="input-group">
                    <span class="input-group-addon glyphicon">@</span>
                    <input name="login" id="login" type="text" class="form-control required-field" placeholder="User name (e-mail)">
                </div>
                <div class="input-group">
                    <span class="input-group-addon glyphicon">#</span>
                    <input name="password" id="password" type="text" class="form-control" placeholder="Password">
                </div>

                <div class="row col-sm-0 col-center">
                    <div class="col-left">
                        <button type="submit" class="btn btn-success">Ok</button>
                    </div>
                    <div class="col-right">
                        <a href="<c:url value="/"/>" class="btn btn-danger">Cancel</a>
                    </div>
                </div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>
        </div>
    </div>
</div>

</body>
</html>