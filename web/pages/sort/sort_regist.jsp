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
                var sort_photo = $("#sort_photo").val();
                if (sort_photo) {
                    var sort_photoPatt = /^\w{5,12}$/;
                    // 3.使用test方法验证
                    if (!sort_photoPatt.test(sort_photo)) {
                        // 4.提示用户结果
                        $(".errorMsg").text("商品分类图片不合法,必须由字母，数字下划线组成，长度5到12");
                        return false;
                    }
                }
                $(".errorMsg").text("");
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
                    <h1>商品分类注册</h1>
                    <b></b>
                    <span class="errorMsg">
                        ${ empty requestScope.msg ? "请输入商品分类相关信息":requestScope.msg }
                    </span>
                </div>
                <div class="form">
                    <form action="sortServlet" method="post">
                        <label>商品分类编号：</label>
                        <input type="text" class="itxt" placeholder="请输入商品分类编号" name="sortId" id="sort_id"
                               value="<%=request.getAttribute("sortId")==null?"":request.getAttribute("sortId")%>"><br>
                        <label>商品分类名称：</label>
                        <input type="text" class="itxt" placeholder="请输入商品分类名称" name="sortName" id="sort_name"
                               value="<%=request.getAttribute("sortName")==null?"":request.getAttribute("sortName")%>"><br>
                        <label>商品分类图片：</label>
                        <input type="text" class="itxt" placeholder="请输入商品分类图片(可为空)" name="sortPhoto"
                               id="sort_photo"><br>
                        <label>商品规格成分：</label>
                        <input type="text" class="itxt" placeholder="请输入商品规格成分(可为空)" name="normChengfen"
                               id="norm_chengfen"><br>
                        <label>商品规格含量：</label>
                        <input type="text" class="itxt" placeholder="请输入商品规格含量(可为空)" name="normContent"
                               id="norm_content"><br>
                        <input type="submit" value="注册" id="sub_btn">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>