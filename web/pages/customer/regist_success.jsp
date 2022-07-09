<%--
  Created by IntelliJ IDEA.
  User: ctao
  Date: 2022/6/20
  Time: 23:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--    静态包含base标签，JQuery文件--%>
<%@include file="/pages/common/head.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    注册成功
    <form action="customerServlet" method="post">
        <input type="hidden" name="action" value="back">
        <input type="submit" value="返回主页">
    </form>
</body>
</html>
