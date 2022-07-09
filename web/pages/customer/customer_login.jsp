<%--
  Created by IntelliJ IDEA.
  User: ctao
  Date: 2022/6/19
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>客户登录界面</title>
    <%@include file="/pages/common/head.jsp"%>
</head>
<body>
<div class="login_banner">
    <div id="l_content">
        <span class="login_word">欢迎登录</span>
    </div>
    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>客户</h1>
                    <a href="pages/customer/customer_regist.jsp">立即注册</a>
                </div>
                <div class="msg_cont">
                    <b></b>
                    <span class="errorMsg">
                    <%=request.getAttribute("msg") == null ? "请输入名称和密码" : request.getAttribute("msg")%>
                </span>
                </div>
                <div class="form">
                    <form action="customerServlet" method="post">
                        <input type="hidden" name="action" value="login"/>
                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名"
                               autocomplete="off" tabindex="1" name="customerName"
                               value="<%=request.getAttribute("customerName")==null?"":request.getAttribute("customerName")%>"/>
                        <br/>
                        <br/>
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码"
                               autocomplete="off" tabindex="1" name="customerPassword"/>
                        <br/>
                        <br/>
                        <input type="submit" value="登录" id="sub_btn"/>
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
</body>
</html>
