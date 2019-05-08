<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="<%=basePath%>jsp/backstage/css/style.css" rel="stylesheet" type="text/css" />
<script>
 var message='${requestScope.myMessage}';
 //如果没有收到服务端发来的信息，那么就不弹出对话框
 if(message!=''){
    alert(message);
 }

</script>
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="<%=basePath%>/backstage/customer/tocustomer">客户管理</a></li>
        <li><a href="#">客户添加</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>客户添加</span></div>
    <form action="<%=basePath%>backstage/customer/doSaveCustomer" method="post">
    <ul class="forminfo">
    <li><label>*账号名</label><input name="username" type="text" class="dfinput" /><i></i></li>
    <li><label>*姓名</label><input name="name" type="text" class="dfinput"/><i></i></li>
    <%--    <li><label>头像</label><input name="picUrl" type="text" class="dfinput" /><i></i></li>--%>
        <li><label>头像</label>
            <input id="url1" name="picUrl" type="text" class="dfinput" value="" readonly="readonly"/>
            <input type="button" id="image1" class="dfinput" style="width:120px;" value="点我选择图片" />
            <a href="#" id="clearImagePath1">清除选择图片路径</a>
            <i></i>
        </li>
        <li><label>电话</label><input name="tel" type="text" class="dfinput" /><i></i></li>
        <li><label>地址</label><input name="address" type="text" class="dfinput" /><i></i></li>
        <li><label>邮编</label><input name="zip" type="text" class="dfinput" /><i></i></li>
        <li><label>电子邮箱</label><input name="email" type="text" class="dfinput" /><i></i></li>
        <li><label>客户简介</label><textarea name="intro" cols="90" rows="30" class="textinput" /></textarea><i></i></li>
        <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="添加客户"/></li>
    </ul>
    </form>
    
    </div>
</body>
</html>
