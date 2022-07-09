<%--
  Created by IntelliJ IDEA.
  User: ctao
  Date: 2022/6/20
  Time: 22:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%--    静态包含base标签，JQuery文件--%>
    <%@include file="/pages/common/head.jsp" %>
    <script type="text/javascript">
        // 给注册绑定单击事件
        $(function () {
            $("#sub_btn").click(function () {
                // 验证商品编号：必须由字母，数字下划线组成，长度5到12
                // 1.获取用户输入框内容
                var commodity_id = $("#commodity_id").val();
                // 2.创建正则表达式对象
                var commodity_idPatt = /^\w{5,12}$/;
                // 3.使用test方法验证
                if (!commodity_idPatt.test(commodity_id)) {
                    $(".errorMsg").text("品牌名称不合法，必须由字母，数字下划线组成，长度5到12");
                    return false;
                }
                $(".errorMsg").text("");
                // 验证商品品牌名称：必须由字母，数字下划线组成，长度2到12
                // 1.获取用户输入框内容
                var brand_name = $("#brand_name").val();
                // 2.创建正则表达式对象
                var brand_namePatt = /^\w{2,12}$/;
                // 3.使用test方法验证
                if (!brand_namePatt.test(brand_name)) {
                    $(".errorMsg").text("品牌名称不合法，必须由字母，数字下划线组成，长度2到12");
                    return false;
                }
                $(".errorMsg").text("");
                // 1.获取商品分类编号输入框内容
                var sort_id = $("#sort_id").val();
                // 2.创建正则表达式对象
                var sort_idPatt = /^\w{5,12}$/;
                // 3.使用test方法验证
                if (!sort_idPatt.test(sort_id)) {
                    // 4.提示用户结果
                    $(".errorMsg").text("商品分类编号不合法,必须由字母，数字下划线组成，长度5到12");
                    return false;
                }
                $(".errorMsg").text("");
                // 2.获取商品分类图片
                var commodity_photo = $("#commodity_photo").val();
                if (commodity_photo) {
                    var commodity_photoPatt = /^\w{5,12}$/;
                    // 3.使用test方法验证
                    if (!commodity_photoPatt.test(commodity_photo)) {
                        // 4.提示用户结果
                        $(".errorMsg").text("商品分类图片不合法,必须由字母，数字下划线组成，长度5到12");
                        return false;
                    }
                }
                $(".errorMsg").text("");
            })
        })

    </script>
    <style type="text/css">
        .login_banner{
            height:800px;
            background-color: #39987c;
        }

        .login_form{
            height:720px;
            width:406px;
            float: right;
            margin-right:50px;
            margin-top: 50px;
            background-color: #fff;
        }
    </style>
</head>
<body>
<div class="login_banner">
    <div id="l_content">
        <span class="login_word">欢迎注册</span>
    </div>
    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>商品添加</h1>
                    <b></b>
                    <span class="errorMsg">
                        ${ empty requestScope.msg ? "请输入商品相关信息":requestScope.msg }
                    </span>
                </div>
                <div class="form">
                    <form action="brandServlet" method="post">
                        <label>商品编号:</label>
                        <input type="text" class="itxt" placeholder="请输入商品编号" name="commodityId" id="commodity_id"
                               value="<%=request.getAttribute("commodityId")==null?"":request.getAttribute("commodityId")%>"/>
                        <br>
                        <br>
                        <label>商品品牌名称:</label>
                        <input type="text" class="itxt" placeholder="请输入商品品牌名称" name="brandName" id="brand_name"
                               value="<%=request.getAttribute("brandName")==null?"":request.getAttribute("brandName")%>"/>
                        <br>
                        <br>
                        <label>供应商名:</label>
                        <input type="text" class="itxt" placeholder="请输入供应商名(可以为空)" name="VendorName" id="Vendor_name"
                               value="<%=request.getAttribute("vendorName")==null?"":request.getAttribute("vendorName")%>"/>
                        <br>
                        <br>
                        <label>商品分类编号:</label>
                        <input type="text" class="itxt" placeholder="请输入商品分类编号" name="sortId" id="sort_id"
                               value="<%=request.getAttribute("brandName")==null?"":request.getAttribute("brandName")%>"/>
                        <br>
                        <br>
                        <label>商品名称:</label>
                        <input type="text" class="itxt" placeholder="请输入商品名称" name="commodityName" id="commodity_name"/>
                        <br>
                        <br>
                        <label>计量单位:</label>
                        <input type="text" class="itxt" placeholder="请输入计量单位" name="metering" id="metering"/>
                        <br>
                        <br>
                        <label>市场价:</label>
                        <input type="text" class="itxt" placeholder="请输入市场价" name="marketValue" id="market_value"/>
                        <br>
                        <br>
                        <label>销售价:</label>
                        <input type="text" class="itxt" placeholder="请输入销售价" name="SalesPrice" id="Sales_price"/>
                        <br>
                        <br>
                        <label>成本价:</label>
                        <input type="text" class="itxt" placeholder="请输入成本价" name="CostPrice" id="Cost_price"/>
                        <br>
                        <br>
                        <label>商品照片:</label>
                        <input type="text" class="itxt" placeholder="请输入商品照片(可以为空)" name="commodityPhoto"
                               id="commodity_photo"/>
                        <br>
                        <br>
                        <label>商品简介:</label>
                        <input type="text" class="itxt" placeholder="请输入商品简介(可以为空)" name="commodityInformation"
                               id="commodity_information"/>
                        <br>
                        <br>
                        <label>商品库存量:</label>
                        <input type="text" class="itxt" placeholder="请输入商品库存量" name="stock" id="stock"/>
                        <br>
                        <br>
                        <input type="submit" value="添加" id="sub_btn">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
