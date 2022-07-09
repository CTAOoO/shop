<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <%--    静态包含base标签，JQuery文件--%>
    <%@include file="/pages/common/head.jsp" %>
    <script type="text/javascript" src="static/jquery-1.11.0.js/jquery-1.11.0.min.js"></script>
    <script type="text/javascript">
        // 给注册绑定单击事件
        $(function () {
            $("#sub_btn").click(function () {
                // 验证用户名：必须由字母，数字下划线组成，长度5到12
                // 1.获取用户输入框内容
                var customer_name = $("#customer_name").val();
                // 2.创建正则表达式对象
                var customer_namePatt = /^\w{5,12}$/;
                // 3.使用test方法验证
                if (!customer_namePatt.test(customer_name)) {
                    // 4.提示用户结果
                    $(".errorMsg").text("用户名不合法,必须由字母，数字下划线组成，长度5到12");
                    return false;
                }
                $(".errorMsg").text("");
                // 验证用户电话：11位
                // 1.获取用户密码输入框内容
                var customer_number = $("#customer_number").val();
                // 2.创建正则表达式对象
                var customer_numberPatt = /^[1][3,4,5,7,8][0-9]{9}$/;
                // 3.使用test方法验证
                if (!customer_numberPatt.test(customer_number)) {
                    // 4.提示用户结果
                    $(".errorMsg").text("电话号不合法");
                    return false;
                }
                $(".errorMsg").text("");
            })
        })

    </script>
</head>
<body>
<div>
    <div>
    <span class="errorMsg" style="color: red">
        <%=request.getAttribute("msg") == null ? "请输入用户相关信息" : request.getAttribute("msg")%>
    </span>
    </div>
    <div>
        <form action="customerServlet" method="post">
            <input type="hidden" name="action" value="regist"/>
            <label>用户名称:</label>
            <input type="text" class="itxt" placeholder="请输入用户名" name="customerName" id="customer_name"
                   value="<%=request.getAttribute("customerName")==null?"":request.getAttribute("customerName")%>"/>
            <br>
            <br>
            <label>用户密码:</label>
            <input type="password" class="itxt" placeholder="请输入密码" name="customerPassword" id="customer_password"/>
            <br>
            <br>
            <label>用户电话:</label>
            <input type="text" class="itxt" placeholder="请输入电话" name="customerNumber" id="customer_number"
                   value="<%=request.getAttribute("customerNumber")==null?"":request.getAttribute("customerNumber")%>"/>
            <br>
            <br>
            <label>用户地址:</label>
            <input type="text" class="itxt" placeholder="请输入地址" name="customerAddress" id="customer_address"/>
            <br>
            <br>
            <input type="submit" value="注册" id="sub_btn">
        </form>
    </div>
</div>
</body>
</html>