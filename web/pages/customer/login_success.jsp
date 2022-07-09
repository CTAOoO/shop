<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <%--    静态包含base标签，JQuery文件--%>
    <%@include file="/pages/common/head.jsp" %>
    <style type="text/css">
        #l_content {
            align-content: center;
            margin-top: 150px;
            margin-left: 300px;
        }

        .login_banner {
            height: 800px;
            background-color: #39987c;
        }
    </style>
</head>
<body>
    <div id="main">
        <div id="header">
            <table>
                <tr>
                    <button><a href="http://localhost:8080/shop/pages/brand/brand_regist.jsp">商品品牌注册</a></button>
                </tr>

                <tr>
                    <button><a href="http://localhost:8080/shop/pages/supplier/supplier_regist.jsp">供应商注册</a></button>
                </tr>
                <tr>
                    <button><a href="http://localhost:8080/shop/pages/commodity/commodity_regist.jsp">商品注册</a></button>
                </tr>
                <tr>
                    <button><a href="http://localhost:8080/shop/pages/sort/sort_regist.jsp">商品分类注册</a></button>
                </tr>
                <tr>
                    <form action="orderSerlvet" method="post">
                        <input type="hidden" name="action" value="login">
                        <input type="submit" value="我的订单">
                    </form>
                </tr>
            </table>

        </div>
        <c:forEach items="${requestScope.commodityList}" var="commodity">
            <div id="commodity">
                <div class="b_list">
                    <div class="commodity_info">
                        <form action="orderSerlvet" method="post">
                            <input type="hidden" name="action" value="regist">
                            <input type="hidden" name="customerNumber"
                                   value="<%=request.getAttribute("customerNumber")==null?"":request.getAttribute("customerNumber")%>">
                            <div class="commodity_name">
                                <span class="sp1">商品名:</span>
                                <span class="sp2">${commodity.commodityName}</span>
                            </div>
                            <div class="commodity_id">
                                <input type="hidden" name="commodityId" value="${commodity.commodityId}">
                                <span class="sp1">商品分类:</span>
                                <span class="sp2">${commodity.sortId}</span>
                            </div>
                            <div class="commodity_price">
                                <input type="hidden" name="commodityPrice" value="${commodity.marketValue}">
                                <span class="sp1">价格:</span>
                                <span class="sp2">${commodity.marketValue}</span>
                            </div>
                            <div class="commodity_amount">
                                <span class="sp1">库存:</span>
                                <span class="sp2">${commodity.stock}</span>
                            </div>
                            <div class="commodity_amount">
                                <span class="sp1">订购数量:</span>
                                <span class="sp2"><input type="text" name="orderNumber" id="min" value="0"></span>
                            </div>
                            <div class="commodity_add">
                                <input type="submit" value="加入购物车"/>
                            </div>
                        </form>
                    </div>
                </div>

            </div>
        </c:forEach>
    </div>
</body>
</html>