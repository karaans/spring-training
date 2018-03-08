<%--
  Created by IntelliJ IDEA.
  User: SEEDINFOTECH
  Date: 3/7/2018
  Time: 12:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
<h2>Welcome to Spring MVC</h2>
<h3>Message : <%= request.getAttribute("fMsg") %>
</h3>
<h3>Cookie : <%= request.getAttribute("testCookie")%>
</h3>

<h3>Account</h3>
<p>ID:      ${account.id}</p>
<p>Name:    ${account.name}</p>
<p>Balance: ${account.balance}</p>

</body>
</html>
