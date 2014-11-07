<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: huihui
  Date: 14-10-22
  Time: 下午4:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><s:text name="loginPage" /></title>
</head>
<body>
    <s:form action="login" >
        <s:textfield name="username" key="user" />
        <s:textfield name="password" key="pass" />
        <s:submit value="登录" key="login" />
    </s:form>
</body>
</html>
