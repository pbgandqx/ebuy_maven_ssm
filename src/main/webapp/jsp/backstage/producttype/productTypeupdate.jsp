<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>
    <link href="<%=basePath%>jsp/backstage/css/style.css" rel="stylesheet" type="text/css"/>
    <!-- 导入kindEditor所需插件 -->
    <link rel="stylesheet" href="<%=basePath%>plugins/kindeditor-4.1.10/themes/default/default.css" />
    <script src="<%=basePath%>plugins/kindeditor-4.1.10/kindeditor.js"></script>
    <script src="<%=basePath%>plugins/kindeditor-4.1.10/lang/zh_CN.js"></script>
    <script>
        var message = '${requestScope.myMessage}';
        //如果没有收到服务端发来的信息，那么就不弹出对话框
        if (message != '') {
            alert(message);
        }
        //实现kindeditor弹出图片上传窗口
        KindEditor.ready(function(K) {
            var editor = K.editor({//图片上传
                //指定上传文件的服务器端程序。
                uploadJson:  '<%=basePath%>plugins/kindeditor-4.1.10/jsp/upload_json.jsp',
                //指定浏览远程图片的服务器端程序
                fileManagerJson: '<%=basePath%>plugins/kindeditor-4.1.10/jsp/file_manager_json.jsp',
                allowFileManager : true
            });
            K('#image1').click(function() {
                editor.loadPlugin('image', function() {//动态加载插件，image为插件名
                    editor.plugin.imageDialog({
                        showLocal : true,//是否显示本地图片上传窗口
                        showRemote : true,//是否显示网络图片窗口
                        fillDescAfterUploadImage:false,//个人建议只在文本编辑器中使用true，true时图片上传成功后切换到图片编辑标签，false时插入图片后关闭弹出框。
                        imageUrl : K('#url1').val(),
                        clickFn : function(url, title, width, height, border, align) {
                            K('#url1').val(url);
                            editor.hideDialog();
                        }
                    });
                });
            });
        });
    </script>
</head>

<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">首页</a></li>
        <li><a href="<%=basePath%>/backstage/producttype/toProducttype">产品类别管理</a></li>
        <li><a href="#">产品类别编辑</a></li>
    </ul>
</div>

<div class="formbody">

    <div class="formtitle"><span>产品类别编辑</span></div>
    <form action="<%=basePath%>backstage/producttype/doProductTypeupdate" method="post">
        <ul class="forminfo">
       <%--     <input name="id" type="hidden" class="dfinput"
                   value="${requestScope.producttype.id}"/>--%>
            <li><label></label><input name="id" type="hidden" class="dfinput" value="${requestScope.productType.id}"/><i></i></li>
            <li><label>*产品分类名称</label><input name="name" type="text" class="dfinput" value="${requestScope.productType.name}"/><i></i></li>
            <li><label>*图片</label><input name="imageUrl" type="text" class="dfinput" value="${requestScope.productType.imageUrl}"/>
                <input type="button" id="image1" class="dfinput" style="width:120px;" value="点我选择图片" />
                <a href="#" id="clearImagePath1">清除选择图片路径</a>
                <i></i></li>
            <li><label>*优先级</label><input name="orderNum" type="text" class="dfinput" value="${requestScope.productType.orderNum}"/><i></i></li>
            <li><label>外部链接地址</label><input name="linkUrl" type="text" class="dfinput" value="${requestScope.productType.linkUrl}"/><i></i></li>
           <li><label>产品描述</label><textarea name="intro" cols="90" rows="30" class="textinput" value="${requestScope.productType.intro}}"></textarea><i></i></li>
           <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="编辑产品类别"/></li>
        </ul>
    </form>

</div>
</body>
</html>
