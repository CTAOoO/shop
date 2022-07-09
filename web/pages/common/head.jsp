<%--
  Created by IntelliJ IDEA.
  User: ctao
  Date: 2022/6/19
  Time: 12:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme()
            + "://"
            + request.getServerName()
            + ":"
            + request.getServerPort()
            + request.getContextPath()
            + "/";
%>
<base href="<%=basePath%>">
<link type="text/css" rel="stylesheet" href="static/css/style_shop.css">
<script type="text/javascript" src="static/jquery-1.11.0.js/jquery-1.11.0.min.js"></script>
