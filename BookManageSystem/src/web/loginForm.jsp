<%--
  Created by IntelliJ IDEA.
  User: huihui
  Date: 14-11-21
  Time: 上午10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8" />
    <title><s:text name="loginPage"/></title>
</head>
<body>
    <s:form action="login">
        <s:textfield name="username" key="user" />
        <s:textfield name="password" key="pass" />
        <s:submit key="login" />
    </s:form>
</body>
</html>
