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

                // 1.获取联系人电话输入框内容
                var supplier_contact_number = $("#supplier_contact_number").val();
                // 2.创建正则表达式对象
                var supplier_numberPatt = /^[1][3,4,5,7,8][0-9]{9}$/;
                // 3.使用test方法验证
                if (!supplier_numberPatt.test(supplier_contact_number)) {
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
                    <form action="supplierServlet" method="post">
                        <label>供应商名:</label>
                        <input type="text" class="itxt" placeholder="请输入供应商名" name="supplierName" id="supplier_name"
                               value="<%=request.getAttribute("supplierName")==null?"":request.getAttribute("supplierName")%>"/><br>
                        <label>联系人</label>
                        <input type="text" class="itxt" placeholder="请输入联系人" name="supplierContact"
                               id="supplier_contact"/><br>
                        <label>联系人电话</label>
                        <input type="text" class="itxt" placeholder="请输入联系人电话" name="supplierNumber"
                               id="supplier_contact_number"
                               value="<%=request.getAttribute("supplierNumber")==null?"":request.getAttribute("supplierNumber")%>"/><br>
                        <label>简介</label>
                        <input type="text" class="itxt" placeholder="请输入简介" name="supplierInformation"
                               id="supplier_information"/><br>
                        <input type="submit" value="注册" id="sub_btn">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>