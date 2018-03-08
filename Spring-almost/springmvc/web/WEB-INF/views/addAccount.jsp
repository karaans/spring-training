<%--
  Created by IntelliJ IDEA.
  User: SEEDINFOTECH
  Date: 3/7/2018
  Time: 4:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add Account</title>
</head>
<body>
<h2>Account Information</h2>

<fieldset>
    <s:form method="post" action="save" modelAttribute="account">
        <div>
            <p>Account Id</p>
            <s:input path="id"/>
            <s:errors path="id"/>
        </div>

        <div>
            <p>Name</p>
            <s:input path="name"/>
            <s:errors path="name"/>
        </div>

        <div>
            <p>Balance</p>
            <s:input path="balance"/>
            <s:errors path="balance"/>
        </div>

        <div>
            <s:button>Save</s:button>
        </div>
    </s:form>
</fieldset>

</body>
</html>
