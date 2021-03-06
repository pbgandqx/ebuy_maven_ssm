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
<title>橙汁园餐厅 -- 列表</title>
<link href="<%=basePath%>jsp/shop/resources/css/shoplists.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="wrap">
		<iframe src="<%=basePath%>jsp/shop/header.jsp" style="height: 168px;"></iframe>
		<div class="content">
			<div class="block">
				<div class="crumb">
					<ul>
						<li><a href="<%=basePath%>shop/index">首页</a></li>
						<li><span>/</span></li>
						<li><a id="types" href="#">今日新品</a></li>
						<li><span>/</span></li>
						<li><a id="lists" href="#">商品列表</a></li>
					</ul>
				</div>
				<div class="quick">
					<button class="all cur">全部</button>
					<button class="price"><a href="<%=basePath%>shop/toshoptypepirce">价格</a></button>
					<button class="sales">销量</button>
				</div>
				<div class="block-wrap">
					<c:forEach var="getProductTypeShoplist" items="${requestScope.getProductTypeShoplist}">
					<div class="item">
						<a href="<%=basePath%>shop/toshopdetial?id=${getProductTypeShoplist.id}"><img style="width: 250px;height: 180px;" alt="" src="<%=basePath%>${getProductTypeShoplist.picUrl}"></a>
						<label><em>￥${getProductTypeShoplist.price}</em><span>￥${getProductTypeShoplist.originalPrice}</span>67人付款</label>
						<h3>${getProductTypeShoplist.name}<button class="buy"><a href="<%=basePath%>shop/toshopdetial?id=${getProductTypeShoplist.id}">购买</a></button></h3>
					</div>
					</c:forEach>

				</div>
				<div class="pager">
					<button href="<%=basePath%>shop/toshoptypelists?page=${requestScope.page-1}">&lt;&lt;</button>
					<button><a href="<%=basePath%>shop/toshoptypelists?page=${requestScope.page-1}">上一页</a></button>
					<button><a href="<%=basePath%>shop/toshoptypelists?page=${requestScope.page+1}">下一页</a></button>
					<%--
					<button>3</button>
					<button>4</button>
					<button>5</button>
					<button>6</button>--%>
					<button href="<%=basePath%>shop/toshoptypelists?page=${requestScope.page+1}">&gt;&gt;</button>
			</div>
			<br>
		</div>
		<iframe src="<%=basePath%>jsp/shop/footer.jsp" style="height: 120px;"></iframe>
	</div>
</body>
</html>