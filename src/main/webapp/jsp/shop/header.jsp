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
<link href="<%=basePath%>jsp/shop/resources/css/header.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="header">
		<div class="toolbar">
			<a href="<%=basePath%>shop/index" target="top">&nbsp;首页&nbsp;</a>
			<%--<a href="<%=basePath%>shop/tosignin" target="top">&nbsp;登录/注册&nbsp;</a>--%>
			<c:choose>
				<c:when test="${sessionScope.customer!=null}">
					欢迎您!<strong>用户：${customer.username}&nbsp;</strong>&nbsp;<a href="<%=basePath%>shop/logout" target="_parent">&nbsp;退出</a>
				</c:when>
				<c:otherwise>
					<div>欢迎！&nbsp;</div>
				</c:otherwise>
			</c:choose>

			<a href="<%=basePath%>shop/toshopcart" target="top">&nbsp;购物车&nbsp;</a>

		</div>
		<div class="content">
			<img alt="" src="<%=basePath%>jsp/shop/resources/images/logo.png">
			<form class="search-wrap" target="_top" action="#">
				<input type="text" id="s" style="float: left">
				<button id="submit">搜索</button>
			</form>
		</div>
		<div class="menu">
			<ul>
				<li class="cur"><a href="<%=basePath%>shop/index" target="top">全部分类</a></li>
				<li><a href="<%=basePath%>shop/index" target="top">首页</a></li>
				<li><a href="<%=basePath%>shop/toshoplists" target="top" <%--style="color: #d2364c;"--%>>今日新品</a></li>
				<li><a href="<%=basePath%>shop/toshoplists" target="top">热门订单</a></li>
				<li><a href="<%=basePath%>shop/toshoplists" target="top">限时秒杀</a></li>
				<li><a href="<%=basePath%>shop/toshoplists" target="top">拼团</a></li>
				<li><a href="<%=basePath%>shop/toshoplists" target="top">特惠</a></li>
			</ul>
		</div>
	</div>
</body>
</html>