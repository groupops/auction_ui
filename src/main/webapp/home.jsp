<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Auction House</title>

    <link rel="stylesheet" type="text/css" media="screen" href='<c:url value="css/bootstrap.min.css"/>'/>
    <link rel="stylesheet" type="text/css" media="screen" href='<c:url value="css/basic.css"/>'/>

<body>

	<div class="panel-primary navbar-header text-center col-center col-lg-8">
        <div class="panel-heading">
            <h1 class="panel-title">HOME PAGE</h1>
            This is index page with cool content.
        </div>
        <div class="panel-body">
            <div class="col-sm-4 col-center">
                <c:if test="${pageContext.request.userPrincipal.name != null}">
                    <h3>You are logged in. Welcome : ${pageContext.request.userPrincipal.name}</h3>
                    <div class="col-sm-4 col-center">
                        <br>
                        <form action="<c:url value="/logout"/>" method="post" id="logoutForm">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                            <input name="submit" type="submit" value="LOGOUT" />
                        </form>
                        <br>
                    </div>
                </c:if>

                <c:if test="${pageContext.request.userPrincipal.name == null}">
                    <h3> <strong> You have to log in first. </strong> </h3>
                    <div class="col-sm-4 col-center">
                        <br>
                        <a href="<c:url value="/login"/>" class="btn btn-success btn-md active btn-block">Login</a>
                        <br>
                        <a href="<c:url value="/register"/>" class="btn btn-primary btn-md active btn-block">Register</a>
                    </div>
                </c:if>
                <div class="col-sm-4 col-center">
                    <br>
                    <a href="<c:url value="/auctions"/>" class="btn btn-info btn-md active btn-block">Auctions</a>
                </div>
            </div>
        </div>
	</div>
</body>
</html>
