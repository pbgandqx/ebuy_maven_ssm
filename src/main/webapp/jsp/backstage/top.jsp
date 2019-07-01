﻿<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>
<script type="text/javascript">
$(function(){	
	//顶部导航切换
	$(".nav li a").click(function(){
		$(".nav li a.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
})	
</script>


</head>

<body style="background:url(images/topbg.gif) repeat-x;">

    <div class="topleft">
    <a href="main.html" target="_parent"><img src="images/logo.png" title="系统首页" /></a>
    </div>
        
    <ul class="nav">
    <li><a href="#" target="rightFrame" class="selected"><img src="images/icon01.png" title="工作台" /><h2>工作台</h2></a></li>
    <li><a href="<%=basePath %>backstage/adminmanage/toManageAdmin" target="rightFrame"><img src="images/icon02.png" title="管理账号模块" /><h2>管理账号模块</h2></a></li>
    <li><a href="<%=basePath %>backstage/customer/tocustomer"  target="rightFrame"><img src="images/icon03.png" title="客户模块" /><h2>客户模块</h2></a></li>
    <li><a href="<%=basePath%>backstage/producttype/toProducttype"  target="rightFrame"><img src="images/icon04.png" title="产品分类模块" /><h2>产品分类模块</h2></a></li>
    <li><a href="<%=basePath%>backstage/product/toProduct" target="rightFrame"><img src="images/icon05.png" title="产品模块" /><h2>产品模块</h2></a></li>
    <li><a href="<%=basePath%>backstage/customer/tocustomer"  target="rightFrame"><img src="images/icon06.png" title="订单客户模块" /><h2>订单客户模块</h2></a></li>
    </ul>
            
    <div class="topright">    
    <ul>
    <li><span><img src="images/help.png" title="帮助"  class="helpimg"/></span><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    <li><a href="<%=basePath%>backstage/logout" target="_parent">退出</a></li>
    </ul>
     
    <div class="user">
    <span>${sessionScope.admin.name}，注册日期：<fmt:formatDate value="${sessionScope.admin.createTime}" pattern="yyyy年MM月dd日 HH:mm"/></span>
    <i>消息</i>
    <b>5</b>
    </div>    
    
    </div>
</body>
</html>
