<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>橙汁园餐厅 -- 页头</title>
<link href="resources/css/header.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="header">
		<div class="toolbar">
			<a href="<%=basePath%>shop/toindex" target="top">&nbsp;首页&nbsp;</a>
			<a href="signin.jsp" target="top">&nbsp;登录/注册&nbsp;</a>
			<a href="shopcart.html" target="top">&nbsp;购物车&nbsp;</a>
		</div>
		<div class="content">
			<img alt="" src="resources/images/logo.png">
			<form class="search-wrap" target="_top" action="#">
				<input type="text" id="s">
				<button id="submit">搜索</button>
			</form>
		</div>
		<div class="menu">
			<ul>
				<li class="cur"><a href="index.jsp" target="top">全部分类</a></li>
				<li><a href="<%=basePath%>shop/toindex" target="top">首页</a></li>
				<li><a href="<%=basePath%>shop/toshoplists" target="top" style="color: #d2364c;">今日新品</a></li>
				<li><a href="<%=basePath%>shop/toshoplists" target="top">热门订单</a></li>
				<li><a href="<%=basePath%>shop/toshoplists" target="top">限时秒杀</a></li>
				<li><a href="<%=basePath%>shop/toshoplists" target="top">拼团</a></li>
				<li><a href="<%=basePath%>shop/toshoplists" target="top">特惠</a></li>
			</ul>
		</div>
	</div>
</body>
</html>