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
	<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>橙汁园餐厅 -- 注册</title>
<%--<link href="<%=basePath%>resources/css/signin.css" rel="stylesheet" type="text/css">--%>
	<link href="<%=basePath%>jsp/shop/resources/css/signin.css" rel="stylesheet" type="text/css">
	<script language="JavaScript" src="<%=basePath%>jsp/shop/resources/js/jquery.js"></script>
	<script src="<%=basePath%>jsp/shop/resources/js/cloud.js" type="text/javascript"></script>
	<script>
        var message='${requestScope.myMessage}';
        //如果没有收到服务端发来的信息，那么就不弹出对话框
        if(message!=''){
            alert(message);
        }
	</script>
</head>
<div class="wrap signin">
	<div class="content">
		<div class="title">&nbsp;</div>
		<div class="main">
			<div class="header">
				<a href="<%=basePath%>shop/tosignin">登录</a>
			</div>
			<div class="logo">
				<div>
					<img alt="" src="<%=basePath%>jsp/shop/resources/images/signup-logo.png">
					<span>用户注册</span>
				</div>
			</div>
			<form  action="<%=basePath%>shop/doSaveShopSignup" method="post">
				<div class="input-wrap">
					<img alt="" src="<%=basePath%>resources/images/signin-user.png">
					<input name="username" type="text" id="u" placeholder="请输入用户名">
				</div>
				<div class="input-wrap">
					<img alt="" src="<%=basePath%>resources/images/signin-pwd.png">
					<input name="password" type="password" id="p" placeholder="请输入密码">
				</div>
				<div class="input-wrap">
					<img alt="" src="<%=basePath%>resources/images/signin-pwd.png">
					<input type="tel" name="tel" id="p2" placeholder="请输入手机号码">
				</div>
				<div class="input-wrap nobg">
					<button class="btn-default"  id="submit">注册</button>
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