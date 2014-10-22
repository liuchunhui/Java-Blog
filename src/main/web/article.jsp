<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: huihui
  Date: 14-10-22
  Time: 下午8:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <s:form action="article">
        <s:textfield name="title" key="title"/> </br>
        <s:textfield name="context" key="content"/></br>
        <s:submit value="保存" key="article" />
    </s:form>
</body>
</html>
