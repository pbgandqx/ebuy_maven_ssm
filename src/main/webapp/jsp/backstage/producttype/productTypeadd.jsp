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
    <li><a href="<%=basePath%>/backstage/producttype/toProducttype">产品类别管理</a></li>
        <li><a href="#">产品类别添加</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>产品类别添加</span></div>
    <form action="<%=basePath%>backstage/producttype/doSaveProductType" method="post">
    <ul class="forminfo">
    <li><label>*产品分类名称</label><input name="name" type="text" class="dfinput" /><i></i></li>
    <li><label>*图片</label><input name="imageUrl" type="text" class="dfinput"/><i></i></li>
        <li><label>*优先级</label><input name="orderNum" type="text" class="dfinput" /><i></i></li>
        <li><label>外部链接地址</label><input name="linkUrl" type="text" class="dfinput" /><i></i></li>
        <li><label>产品描述</label><input name="intro" type="text" class="dfinput"/><i></i></li>
        <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="添加产品类别"/></li>
    </ul>
    </form>
    
    </div>
</body>
</html>
