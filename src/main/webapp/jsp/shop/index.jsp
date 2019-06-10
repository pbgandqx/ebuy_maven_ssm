<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>橙汁园餐厅 -- 首页</title>
<link href="<%=basePath%>jsp/shop/resources/css/index.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="wrap">
		<iframe src="<%=basePath%>jsp/shop/header.html" style="height: 168px;"></iframe>
		<div class="content">
			<div class="logo">
				<img alt="" src="<%=basePath%>jsp/shop/resources/images/index-logo.jpg">
				<div class="menu">
					<ul>
						<c:forEach var="productType" items="${requestScope.productTypes}">
						<li><a href="shoplists.html"><img class="left" alt="" src="<%=basePath%>${productType.imageUrl}">${productType.name}<img class="right" alt="" src="<%=basePath%>jsp/shop/resources/images/menu-right.png"></a></li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<div class="block">
				<div class="title">
					<label class="new">今日新品</label>
					<a href="<%=basePath%>jsp/shop/shoplists.html">更多&gt;&gt;</a>
				</div>
				<div class="block-wrap">
					<div class="item">
						<a href="<%=basePath%>jsp/shop/shopdetial.html"><img alt="" src="<%=basePath%>jsp/shop/resources/images/foods/01.jpg"></a>
						<label><em>￥18.00</em><span>￥20.00</span>67人付款</label>
						<h3>回锅肉炒西芹</h3>
					</div>
					<div class="item">
						<a href="<%=basePath%>jsp/shop/shopdetial.html"><img alt="" src="<%=basePath%>jsp/shop/resources/images/foods/01.jpg"></a>
						<label><em>￥18.00</em><span>￥20.00</span>67人付款</label>
						<h3>回锅肉炒西芹</h3>
					</div>
					<div class="item">
						<a href="<%=basePath%>jsp/shop/shopdetial.html"><img alt="" src="<%=basePath%>jsp/shop/resources/images/foods/01.jpg"></a>
						<label><em>￥18.00</em><span>￥20.00</span>67人付款</label>
						<h3>回锅肉炒西芹</h3>
					</div>
					<div class="item">
						<a href="<%=basePath%>jsp/shop/shopdetial.html"><img alt="" src="<%=basePath%>jsp/shop/resources/images/foods/01.jpg"></a>
						<label><em>￥18.00</em><span>￥20.00</span>67人付款</label>
						<h3>回锅肉炒西芹</h3>
					</div>
				</div>
			</div>
			<div class="block">
				<div class="title">
					<label class="hot">热门订单</label>
					<a href="<%=basePath%>jsp/shop/shoplists.html">更多&gt;&gt;</a>
				</div>
				<div class="block-wrap">
					<div class="item">
						<a href="<%=basePath%>jsp/shop/shopdetial.html"><img alt="" src="<%=basePath%>jsp/shop/resources/images/foods/01.jpg"></a>
						<label><em>￥18.00</em><span>￥20.00</span>67人付款</label>
						<h3>回锅肉炒西芹</h3>
					</div>
					<div class="item">
						<a href="<%=basePath%>jsp/shop/shopdetial.html"><img alt="" src="<%=basePath%>jsp/shop/resources/images/foods/01.jpg"></a>
						<label><em>￥18.00</em><span>￥20.00</span>67人付款</label>
						<h3>回锅肉炒西芹</h3>
					</div>
					<div class="item">
						<a href="<%=basePath%>jsp/shop/shopdetial.html"><img alt="" src="<%=basePath%>jsp/shop/resources/images/foods/01.jpg"></a>
						<label><em>￥18.00</em><span>￥20.00</span>67人付款</label>
						<h3>回锅肉炒西芹</h3>
					</div>
					<div class="item">
						<a href="<%=basePath%>jsp/shop/shopdetial.html"><img alt="" src="<%=basePath%>jsp/shop/resources/images/foods/01.jpg"></a>
						<label><em>￥18.00</em><span>￥20.00</span>67人付款</label>
						<h3>回锅肉炒西芹</h3>
					</div>
				</div>
			</div>
			<div class="block">
				<div class="title noborder">
					<label class="act">活动推介</label>
					<a href="<%=basePath%>jsp/shop/shoplists.html" style="display: none;">更多&gt;&gt;</a>
				</div>
				<div class="block-wrap border">
					<div class="crumb">
						<ul>
							<li class="cur"><a href="#">限时秒杀</a></li>
							<li><a href="#">拼团</a></li>
							<li><a href="#">特惠</a></li>
							<li><a href="#">热门排行</a></li>
						</ul>
						<a href="<%=basePath%>jsp/shop/shoplists.html">更多&gt;&gt;</a>
					</div>
					<div class="item">
						<a href="<%=basePath%>jsp/shop/shopdetial.html"><img alt="" src="<%=basePath%>jsp/shop/resources/images/foods/01.jpg"></a>
						<label><em>￥18.00</em><span>￥20.00</span>67人付款</label>
						<h3>回锅肉炒西芹</h3>
					</div>
					<div class="item">
						<a href="<%=basePath%>jsp/shop/shopdetial.html"><img alt="" src="<%=basePath%>jsp/shop/resources/images/foods/01.jpg"></a>
						<label><em>￥18.00</em><span>￥20.00</span>67人付款</label>
						<h3>回锅肉炒西芹</h3>
					</div>
					<div class="item">
						<a href="<%=basePath%>jsp/shop/shopdetial.html"><img alt="" src="<%=basePath%>jsp/shop/resources/images/foods/01.jpg"></a>
						<label><em>￥18.00</em><span>￥20.00</span>67人付款</label>
						<h3>回锅肉炒西芹</h3>
					</div>
					<div class="item">
						<a href="<%=basePath%>jsp/shop/shopdetial.html"><img alt="" src="<%=basePath%>jsp/shop/resources/images/foods/01.jpg"></a>
						<label><em>￥18.00</em><span>￥20.00</span>67人付款</label>
						<h3>回锅肉炒西芹</h3>
					</div>
				</div>
			</div>
			<br>
		</div>
		<iframe src="<%=basePath%>jsp/shop/footer.html" style="height: 120px;"></iframe>
	</div>
</body>
</html>