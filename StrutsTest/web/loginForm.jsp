<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>
<html>
    <head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
        <title><s:text name="loginPage" /></title>
    </head>
    <body>
        <s:form action="login">
            <s:textfield name="username" key="user" />
            <s:textfield name="password" key="pass" />
            <s:submit value="login" />
        </s:form>
    乱码！
    </body>
</html>