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
    <li><a href="<%=basePath%>/backstage/product/toProduct">产品管理</a></li>
        <li><a href="#">产品添加</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>产品添加</span></div>
    <form action="<%=basePath%>backstage/product/doSaveProduct" method="post">
    <ul class="forminfo">
    <ul class="forminfo">
        <li><label>*产品分类</label><select name="productTypeId" class="dfinput"><option value="${product.productTypeId}">请选择</option>
        </select><i></i></li>
    <li><label>*产品名称</label><input name="name" type="text" class="dfinput" /><i></i></li>
    <li><label>*产品图片</label><input name="picUrl" type="text" class="dfinput"/>
        <input type="button" id="image1" class="dfinput" style="width:120px;" value="点我选择图片" />
        <a href="#" id="clearImagePath1">清除选择图片路径</a>
        <i></i></li>
        <li><label>*产品原价</label><input name="originalPrice" type="text" class="dfinput" /><i></i></li>
        <li><label>*产品现价</label><input name="Price" type="text" class="dfinput" /><i></i></li>
        <li><label>*产品库存</label><input name="number" type="text" class="dfinput" /><i></i></li>
        <li><label>*优先级</label><input name="orderNum" type="text" class="dfinput" /><i></i></li>
        <li><label>*点击数</label><input name="click" type="text" class="dfinput" /><i></i></li>
        <li><label>*是否上架</label><select name="onSale"  class="dfinput"></select><i></i></li>
        <li><label>*产品描述</label><textarea name="description" cols="90" rows="30" class="textinput" ></textarea><i></i></li>
        <li><label>*产品内容</label><textarea name="content" cols="90" rows="30" class="textinput" ></textarea><i></i></li>
        <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="添加产品类别"/></li>
    </ul>
    </form>
    
    </div>
</body>
</html>
