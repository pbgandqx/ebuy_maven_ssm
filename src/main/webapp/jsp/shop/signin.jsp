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
<title>橙汁园餐厅 -- 登录</title>
<link href="<%=basePath%>jsp/shop/resources/css/signin.css" rel="stylesheet" type="text/css">
</head>
<div class="wrap signin">
	<div class="content">
		<div class="title">
			<a href="<%=basePath%>shop/toindex">&nbsp;首页&nbsp;</a>
			<a href="<%=basePath%>shop/tosignin">&nbsp;登录/注册&nbsp;</a>
			<a href="<%=basePath%>shop/toshopcart">&nbsp;购物车&nbsp;</a>
		</div>
		<div class="main">
			<div class="header">
				<a href="<%=basePath%>shop/tosignup">注册</a>
			</div>
			<div class="logo">
				<div>
					<img alt="" src="<%=basePath%>shop/resources/images/signin-logo.png">
					<span>用户登陆</span>
				</div>
			</div>
			<form action="#">
				<div class="input-wrap">
					<img alt="" src="<%=basePath%>shop/resources/images/signin-user.png">
					<input type="text" id="u" placeholder="请输入手机号">
				</div>
				<div class="input-wrap">
					<img alt="" src="<%=basePath%>shop/resources/images/signin-pwd.png">
					<input type="password" id="p" placeholder="请输入密码">
				</div>
			<%--	<div class="input-wrap">
					<img alt="" src="<%=basePath%>shop/resources/images/signin-cpt.png">
					<input class="sort" type="text" id="c" placeholder="请输入验证码">
					<img class="signin-cpt" alt="" src="<%=basePath%>shop/resources/images/signin-cpts.png">
				</div>--%>
				<div class="input-wrap nobg">
					<button class="btn-inline lbtn" id="submit">登录</button>
					<button class="btn-inline" id="pback">找回密码</button>
				</div>
			</form>
		</div>
	</div>
	<div class="footer">
		<h1>订餐热线：0772-1234567</h1>
		<p>版权所有@ 2012-2019 南方橙汁园连锁有限公司   桂ICP备90887766号  桂餐证字2010110108002888<br>
地址：桂柳市文林区中文苑路1号橙汁园大厦B座111层11号</p>
	</div>
</div>
</html>