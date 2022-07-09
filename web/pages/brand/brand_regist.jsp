<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <%--    静态包含base标签，JQuery文件--%>
    <%@include file="/pages/common/head.jsp" %>
    <script type="text/javascript">
        // 给注册绑定单击事件
        $(function () {
            $("#sub_btn").click(function () {
                // 验证商品品牌照片
                // 1.获取商品品牌照片输入框内容
                var brand_photo = $("#brand_photo").val();
                if (brand_photo) {
                    // 2.创建正则表达式对象
                    var brand_photoPatt = /^\w{5,12}$/;
                    // 3.使用test方法验证
                    if (!brand_photoPatt.test(brand_photo)) {
                        // 4.提示用户结果
                        $(".errorMsg").text("商品品牌图片不合法，必须由字母，数字下划线组成，长度5到12");
                        return false;
                    }
                    $(".errorMsg").text("");
                }
            })
        })

    </script>
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
                    <h1>商品品牌注册</h1>
                        <b></b>
                        <span class="errorMsg">
                            ${ empty requestScope.msg ? "请输入商品品牌相关信息":requestScope.msg }
                        </span>
                </div>
                <div class="form">
                    <form action="brandServlet" method="post">
                        <label>商品品牌名称:</label>
                        <input type="text" class="itxt" placeholder="请输入商品品牌名称" name="brandName" id="brand_name"
                               value="<%=request.getAttribute("brandName")==null?"":request.getAttribute("brandName")%>"/>
                        <br>
                        <br>
                        <label>商品品牌地址:</label>
                        <input type="text" class="itxt" placeholder="请输入商品品牌地址" name="brandAddress" id="brand_address"/>
                        <br>
                        <br>
                        <label>商品品牌照片:</label>
                        <input type="text" class="itxt" placeholder="请输入商品品牌照片(可以为空)" name="brandPhoto"
                               id="brand_photo"/>
                        <br>
                        <br>
                        <input type="submit" value="注册" id="sub_btn">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>