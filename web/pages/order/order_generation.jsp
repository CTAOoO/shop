<%--
  Created by IntelliJ IDEA.
  User: ctao
  Date: 2022/6/19
  Time: 23:39
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%--    静态包含base标签，JQuery文件--%>
    <%@include file="/pages/common/head.jsp" %>
    <script type="text/javascript">
        $(function () {
            // 用于复用删除的function函数
            var delete_Fun = function () {
                var $trObj = $(this).parent().parent();
                var name = $trObj.find("td:first").text();
                // confirm 是JavaScript中提供的一个确认提示框，用户选择确定，返回true，否者返回false
                if (confirm("你确定要删除" + name + "？")) {
                    $trObj.remove();
                }
                // 防止页面跳转
                return false;
            }
            // 删除a标签绑定的单击事件
            $("a").click(delete_Fun);
        })
    </script>
</head>
<body>
<div id="main">
    <table id="employeeTable" border="2">
        <tr>
            <td>订单号</td>
            <td>订单号_详</td>
            <td>商品编号</td>
            <td>单价</td>
            <td>数量</td>
            <td>总价</td>
        </tr>
        <c:forEach items="${requestScope.orderDetailedList}" var="orderDetailed">
            <tr>
                <td>${orderDetailed.orderId}</td>
                <td>${orderDetailed.orderDetailedId}</td>
                <td>${orderDetailed.commodityId}</td>
                <td>${orderDetailed.unitPrice}</td>
                <td>${orderDetailed.orderNumber}</td>
                <td>${orderDetailed.money}</td>
                <td>
                    <form action="orderSerlvet" method="post">
                        <input type="hidden" name="action" value="delete">
                        <input type="hidden" name="orderId" value="${orderDetailed.orderId}">
                        <input type="submit" value="删除">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
