<%--
  Created by IntelliJ IDEA.
  User: SEEDINFOTECH
  Date: 3/8/2018
  Time: 2:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List of Accounts</title>
</head>
<body>

<h2>List of Accounts</h2>

<fieldset>
    <table border="3">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Balance</th>
        </tr>

        <c:forEach items="${accountList}" var="list">
            <tr>
                <td>${list.id}</td>
                <td>${list.name}</td>
                <td>${list.balance}</td>
            </tr>
        </c:forEach>
    </table>
</fieldset>

</body>
</html>
