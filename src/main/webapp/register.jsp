<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value="/css/basic.css" />" rel="stylesheet">
</head>
<body>
<div id="login-box">

    <h2>Register new user</h2>

    <c:if test="${not empty error}">
        <div class="error">${error}</div>
    </c:if>
    <c:if test="${not empty msg}">
        <div class="msg">${msg}</div>
    </c:if>

    <form name='registerForm'
          action="<c:url value='register' />" method='POST'>

        <table>
            <tr>
                <td>E-mail:</td>
                <td><input type='text' name='username' value=''></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type='password' name='password'/></td>
            </tr>
            <tr>
                <td colspan='2'><input name="submit" type="submit"
                                       value="register"/></td>
            </tr>
        </table>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
    <a href="<c:url value="/"/>">return to home page</a>
</div>

</body>
</html>