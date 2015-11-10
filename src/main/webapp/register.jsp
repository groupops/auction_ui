<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Auction House</title>

    <link rel="stylesheet" type="text/css" media="screen" href='<c:url value="css/bootstrap.min.css"/>'/>
    <link rel="stylesheet" type="text/css" media="screen" href='<c:url value="css/basic.css"/>'/>
</head>
<body>

<div class="panel-primary navbar-header text-center col-center col-md-4">
    <div class="panel-heading">
        <h1 class="panel-title">Sign up your personal data</h1>
    </div>
    <div class="panel-body">
        <c:if test="${not empty error}">
            <div class="error">${error}</div>
        </c:if>
        <c:if test="${not empty msg}">
            <div class="msg">${msg}</div>
        </c:if>

        <form name='registerForm'
              action="<c:url value='register' />" method='POST'>

            <div class="col-md-8 col-center">
                <div class="input-group">
                    <span class="input-group-addon glyphicon">@</span>
                    <input name="login" id="login" type="text" class="form-control required-field" placeholder="User name (e-mail)">
                </div>
                <div class="input-group">
                    <span class="input-group-addon glyphicon">#</span>
                    <input name="password" id="password" type="text" class="form-control" placeholder="Password">
                </div>
                <div class="input-group">
                    <span class="input-group-addon glyphicon">#</span>
                    <input name="password" id="confirmPassword" type="text" class="form-control" placeholder="Confirm password">
                </div>
                <div class="row col-md-6 col-center">
                    <div class="col-left">
                        <button type="submit" class="btn btn-success">Ok</button>
                    </div>
                    <div class="col-right">
                        <a href="<c:url value="/"/>" class="btn btn-danger">Cancel</a>
                    </div>
                </div>
            </div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
    </div>
</div>

</body>
</html>