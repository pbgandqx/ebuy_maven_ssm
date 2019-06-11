<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
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
		<iframe src="<%=basePath%>jsp/shop/header.html" style="height: 168px;"></iframe>
		<div class="content">
			<div class="block">
				<div class="crumb">
					<ul>
						<li><a href="<%=basePath%>jsp/shop/index.jsp">首页</a></li>
						<li><span>/</span></li>
						<li><a id="types" href="#">今日新品</a></li>
						<li><span>/</span></li>
						<li><a id="lists" href="#">商品列表</a></li>
					</ul>
				</div>
				<div class="quick">
					<button class="all cur">全部</button>
					<button class="buy">已定</button>
					<button class="price">价格</button>
					<button class="sales">销量</button>
				</div>
				<div class="block-wrap">
					<c:forEach var="product" items="${requestScope.newProducts}">
					<div class="item">
						<a href="<%=basePath%>jsp/shop/shopdetial.html"><img style="width: 250px;height: 180px;" alt="" src="<%=basePath%>${product.picUrl}"></a>
						<label><em>￥${product.price}</em><span>￥${product.originalPrice}</span>67人付款</label>
						<h3>${product.name}</h3>
					</div>
					</c:forEach>
					<%--<div class="item">
						<a href="shopdetial.html"><img alt="" src="resources/images/foods/01.jpg"></a>
						<label><em>￥18.00</em><span>￥20.00</span>67人付款</label>
						<h3>回锅肉炒西芹<button class="buy">购买</button></h3>
					</div>
					<div class="item">
						<a href="shopdetial.html"><img alt="" src="resources/images/foods/01.jpg"></a>
						<label><em>￥18.00</em><span>￥20.00</span>67人付款</label>
						<h3>回锅肉炒西芹</h3>
					</div>
					<div class="item">
						<a href="shopdetial.html"><img alt="" src="resources/images/foods/01.jpg"></a>
						<label><em>￥18.00</em><span>￥20.00</span>67人付款</label>
						<h3>回锅肉炒西芹<button class="buy">购买</button></h3>
					</div>
					<div class="item">
						<a href="shopdetial.html"><img alt="" src="resources/images/foods/01.jpg"></a>
						<label><em>￥18.00</em><span>￥20.00</span>67人付款</label>
						<h3>回锅肉炒西芹<button class="buy">购买</button></h3>
					</div>
					<div class="item">
						<a href="shopdetial.html"><img alt="" src="resources/images/foods/01.jpg"></a>
						<label><em>￥18.00</em><span>￥20.00</span>67人付款</label>
						<h3>回锅肉炒西芹<button class="buy">购买</button></h3>
					</div>
					<div class="item">
						<a href="shopdetial.html"><img alt="" src="resources/images/foods/01.jpg"></a>
						<label><em>￥18.00</em><span>￥20.00</span>67人付款</label>
						<h3>回锅肉炒西芹<button class="buy">购买</button></h3>
					</div>
					<div class="item">
						<a href="shopdetial.html"><img alt="" src="resources/images/foods/01.jpg"></a>
						<label><em>￥18.00</em><span>￥20.00</span>67人付款</label>
						<h3>回锅肉炒西芹<button class="buy">购买</button></h3>
					</div>
					<div class="item">
						<a href="shopdetial.html"><img alt="" src="resources/images/foods/01.jpg"></a>
						<label><em>￥18.00</em><span>￥20.00</span>67人付款</label>
						<h3>回锅肉炒西芹<button class="buy">购买</button></h3>
					</div>
					<div class="item">
						<a href="shopdetial.html"><img alt="" src="resources/images/foods/01.jpg"></a>
						<label><em>￥18.00</em><span>￥20.00</span>67人付款</label>
						<h3>回锅肉炒西芹<button class="buy">购买</button></h3>
					</div>
					<div class="item">
						<a href="shopdetial.html"><img alt="" src="resources/images/foods/01.jpg"></a>
						<label><em>￥18.00</em><span>￥20.00</span>67人付款</label>
						<h3>回锅肉炒西芹<button class="buy">购买</button></h3>
					</div>
					<div class="item">
						<a href="shopdetial.html"><img alt="" src="resources/images/foods/01.jpg"></a>
						<label><em>￥18.00</em><span>￥20.00</span>67人付款</label>
						<h3>回锅肉炒西芹<button class="buy">购买</button></h3>
					</div>
					<div class="item">
						<a href="shopdetial.html"><img alt="" src="resources/images/foods/01.jpg"></a>
						<label><em>￥18.00</em><span>￥20.00</span>67人付款</label>
						<h3>回锅肉炒西芹<button class="buy">购买</button></h3>
					</div>
					<div class="item">
						<a href="shopdetial.html"><img alt="" src="resources/images/foods/01.jpg"></a>
						<label><em>￥18.00</em><span>￥20.00</span>67人付款</label>
						<h3>回锅肉炒西芹<button class="buy">购买</button></h3>
					</div>
					<div class="item">
						<a href="shopdetial.html"><img alt="" src="resources/images/foods/01.jpg"></a>
						<label><em>￥18.00</em><span>￥20.00</span>67人付款</label>
						<h3>回锅肉炒西芹<button class="buy">购买</button></h3>
					</div>
					<div class="item">
						<a href="shopdetial.html"><img alt="" src="resources/images/foods/01.jpg"></a>
						<label><em>￥18.00</em><span>￥20.00</span>67人付款</label>
						<h3>回锅肉炒西芹<button class="buy">购买</button></h3>
					</div>--%>
				</div>
				<div class="pager">
					<button>&lt;&lt;</button>
					<button>1</button>
					<button>2</button>
					<button>3</button>
					<button>4</button>
					<button>5</button>
					<button>6</button>
					<button>&gt;&gt;</button>
				</div>
			</div>
			<br>
		</div>
		<iframe src="<%=basePath%>jsp/shop/footer.html" style="height: 120px;"></iframe>
	</div>
</body>
</html>