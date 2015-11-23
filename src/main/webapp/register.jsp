<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Auction House</title>
    <jsp:include page="includes.jsp"/>
    <script type="text/javascript" src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
    <script type="text/javascript" src="js/registration-validator.js"></script>
    <link rel="stylesheet" type="text/css" media="screen" href='<c:url value="css/bootstrap.min.css"/>'/>
    <link rel="stylesheet" type="text/css" media="screen" href='<c:url value="css/basic.css"/>'/>
</head>
<body>
<style>

</style>


<div class="row">
    <div class="col-md-6">

    </div>
    <div class="col-md-6 col-center" style="border: lightgray solid 1px;">
        <c:if test="${not empty error}">
            <div class="error">${error}</div>
        </c:if>
        <c:if test="${not empty msg}">
            <div class="msg">${msg}</div>
        </c:if>
        <form class="form-horizontal" id="register" name='registerForm' action="<c:url value='register' />"
              method='POST'>
            <fieldset>

                <h3 align="center">Register</h3>

                <div class="form-group">
                    <label class="col-md-4 control-label" for="login">Login</label>
                    <div class="col-md-6">
                        <input id="login" name="login" type="text" placeholder="Login" class="form-control input-md">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-md-4 control-label" for="password">Password</label>
                    <div class="col-md-6">
                        <input id="password" name="password" type="password" placeholder="Password"
                               class="form-control input-md">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-md-4 control-label" for="confirmPassword">Confirm Password</label>
                    <div class="col-md-6">
                        <input id="confirmPassword" name="confirmPassword" type="password"
                               placeholder="Confirm Password" class="form-control input-md">
                    </div>
                </div>

                <!-- Button (Double) -->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="submit"></label>
                    <div class="col-md-8">
                        <button id="submit" name="submit" class="btn btn-success">Register</button>
                        <button id="reset" name="reset" type="reset" class="btn btn-danger">Reset</button>
                    </div>
                </div>

            </fieldset>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
    </div>
</div>

</body>
</html>