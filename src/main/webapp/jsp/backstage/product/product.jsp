<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>订餐系统后台管理</title>
    <link href="<%=basePath%>jsp/backstage/css/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="<%=basePath%>jsp/backstage/js/jquery.js"></script>

    <script type="text/javascript">
        $(document).ready(function () {
            $(".click").click(function () {
                $(".tip").fadeIn(200);
            });

            $(".tiptop a").click(function () {
                $(".tip").fadeOut(200);
            });

            $(".sure").click(function () {
                $(".tip").fadeOut(100);
            });

            $(".cancel").click(function () {
                $(".tip").fadeOut(100);
            });

            $("a[name='deleteProduct']").click(function () {
                $this = $(this);
                var name = $(this).attr("id");
                if (window.confirm("确认要删除该产品(" + name + ")吗？删除后无法恢复！")) {
                    var url = $(this).attr("href");
                    $.get(url,
                        function (data) {
                            if (data.status == 1) {
                                $this.parent().parent().remove();
                            }
                        });
                }
                return false;
            });

        });
    </script>


</head>


<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">首页</a></li>
        <li><a href="#">产品管理</a></li>

    </ul>
</div>

<div class="rightinfo">

    <div class="tools">

        <ul class="toolbar">
            <a href="<%=basePath%>backstage/product/toSaveProduct">
                <li class="click"><span><img src="<%=basePath%>jsp/backstage/images/t01.png"/></span>添加产品</li>
            </a>
        </ul>


        <ul class="toolbar1">

        </ul>

    </div>


    <table class="tablelist">
        <thead>
        <tr>
            <th><input name="" type="checkbox" value="" checked="checked"/></th>
            <th>产品图片</th>
            <th>产品名</th>
            <th>产品分类</th>
            <th>产品价格</th>
            <th>发布人</th>
            <th>是否上架</th>
            <th>库存</th>
            <th>点击数</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="product" items="${requestScope.list}">
            <tr>
                <td><input name="" type="checkbox" value=""/></td>
                <td class="imgtd">
                    <img src="<%=basePath%>${product.picUrl}" style="width:80px;height:60px;"/>
                </td>
                <td style="text-align: center;">${product.name}
                    <p style="color: #7f7f7f">发布时间：${product.createTime}</p>
                </td>
                <td>${product.productType.name}
                    <p style="color: #7f7f7f;line-height: 8px">ID:${product.productType.id}</p>
                </td>
                <td style="color: red">${product.price}<br/>
                    <p style="color: #7f7f7f;line-height: 8px"><s>${product.originalPrice}</s></p>
                </td>
                <td>${product.creator.name}</td>
                <td>
                    <c:choose>
                        <c:when test="${product.onSale==true}">
                            上架中
                        </c:when>
                        <c:otherwise>
                            <a style="color: red">已下架</a>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>${product.number}</td>
                <td>${product.click}</td>

                <td><a href="<%=basePath%>backstage/product/toProductupdate?id=${product.id}" class="tablelink">修改</a>
                    <a id="${product.name}" name="deleteProduct"
                       href="<%=basePath%>backstage/product/dodeleteProduct?id=${product.id}" class="tablelink"> 删除</a>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>


    <div class="pagin">
        <div class="message">共<i class="blue">${fn:length(list)}</i>
            条记录,当前显示第<i class="blue">${requestScope.page}</i>页,共
            <i class="blue">${requestScope.maxPage}</i>页
        </div>
        <ul class="paginList">
            <li class="paginItem">
                <a href="<%=basePath%>backstage/product/toProduct?page=1">首页</a>
            </li>
            <li class="paginItem">
                <a href="<%=basePath%>backstage/product/toProduct?page=${requestScope.page-1}">上一页</a>
            </li>
            <li class="paginItem">
                <a href="<%=basePath%>backstage/product/toProduct?page=${requestScope.page+1}">下一页</a>
            </li>
            <li class="paginItem">
                <a href="<%=basePath%>backstage/product/toProduct?page=${requestScope.maxPage}">尾页</a>
            </li>
        </ul>
    </div>


    <div class="tip">
        <div class="tiptop"><span>提示信息</span><a></a></div>

        <div class="tipinfo">
            <span><img src="images/ticon.png"/></span>
            <div class="tipright">
                <p>是否确认对信息的修改 ？</p>
                <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
            </div>
        </div>

        <div class="tipbtn">
            <input name="" type="button" class="sure" value="确定"/>&nbsp;
            <input name="" type="button" class="cancel" value="取消"/>
        </div>

    </div>


</div>

<script type="text/javascript">
    $('.tablelist tbody tr:odd').addClass('odd');
</script>
</body>
</html>
