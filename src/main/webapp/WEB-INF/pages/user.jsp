<%--
  Created by IntelliJ IDEA.
  User: daniel
  Date: 10/01/18
  Time: 18:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Some Random Page</title>
</head>
<body>

    <p>This is a normal page.</p>
    
    <form id="logout" action="/logout" method="post" >
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
	<c:if test="${pageContext.request.userPrincipal.name != null}">
        <a href="javascript:document.getElementById('logout').submit()">Logout</a>
	</c:if>
</body>
</html>
