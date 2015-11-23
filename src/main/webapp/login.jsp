<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Auction House</title>

    <link rel="stylesheet" type="text/css" media="screen" href='<c:url value="css/bootstrap.min.css"/>'/>
    <link href="<c:url value="/css/basic.css" />" rel="stylesheet">
</head>
<body>
<div class="row">
    <div class="col-md-4 col-md-offset-4">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">Please sign in</h3>
            </div>
            <div class="panel-body">
                <form accept-charset="UTF-8" role="form" name='loginForm' action="<c:url value='login'/>" method='POST'>
                    <fieldset>
                        <div class="form-group">
                            <input class="form-control" placeholder="Login" name="login" type="text">
                        </div>
                        <div class="form-group">
                            <input class="form-control" placeholder="Password" name="password" type="password" value="">
                        </div>
                        <div class="checkbox">
                            <label>
                                <input name="remember" type="checkbox" value="Remember Me"> Remember Me
                            </label>
                        </div>
                        <input class="btn btn-lg btn-success btn-block" type="submit" value="Login">
                    </fieldset>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>