<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<h1>HOME PAGE</h1>
	This is index page with cool content.

	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<h3>You are logged in. Welcome : ${pageContext.request.userPrincipal.name}</h3>
		<br>
		<form action="<c:url value="/logout"/>" method="post" id="logoutForm">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<input name="submit" type="submit" value="LOGOUT" />
		</form>
		<br>
	</c:if>

	<c:if test="${pageContext.request.userPrincipal.name == null}">
		You have to log in first.
		<br>
		<a href="<c:url value="/login"/>">LOGIN</a>
		<br>
		<a href="<c:url value="/register"/>">REGISTER</a>
	</c:if>
</body>
</html>
