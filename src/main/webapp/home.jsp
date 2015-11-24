<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <h1 class="panel-title">Auction home page</h1>
    </div>
    <div class="panel-body">
        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <h3>Hi : ${pageContext.request.userPrincipal.name}</h3>
            <div class="col-sm-4 col-center">
                <form class="form-inline" role="form" action="<c:url value="/logout"/>" method="post"
                      id="logoutForm">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <input name="submit" type="submit" class="btn btn-warning" value="Logout"/>
                </form>
            </div>
        </c:if>

        <c:if test="${pageContext.request.userPrincipal.name == null}">
            <div class="col-sm-4 col-center">
                <a style="width: 75px" href="<c:url value="/login"/>" class="btn btn-success" role="button">Login</a>
            </div>
            <div class="col-sm-4 col-center">
                <a style="width: 75px" href="<c:url value="/register"/>" class="btn btn-info" role="button">Register</a>
            </div>
        </c:if>
        <div class="col-sm-4 col-center">
            <a style="width: 75px" href="<c:url value="/auctions"/>" class="btn btn-success" role="button">Auctions</a>
        </div>
    </div>
</div>
</body>
</html>
