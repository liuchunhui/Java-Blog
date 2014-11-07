<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: huihui
  Date: 14-10-22
  Time: 下午4:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><s:text name="succPage" /></title>
</head>
<body>
    本站访问次数为：${applicationScope.counter} </br>
    ${sessionScope.user}，您已经登录！</br>
    ${requestScope.tip}
</body>
</html>
