<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'welcome1.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="shortcut icon" href="homeimage/favicon.ico" />
	<!-- 引入样式 -->
	<link rel="stylesheet" type="text/css" href="backcss/font.css">
	<link rel="stylesheet" type="text/css" href="backcss/xadmin.css">
	<link rel="stylesheet" type="text/css" href="lib/layui/css/layui.css">
	<!-- 引入layui -->
	<script src="lib/layui/layui.js" charset="utf-8"></script>
	<!-- 引入jquery -->
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<!-- 引入xadmin -->
	<script type="text/javascript" src="backjs/xadmin.js"></script>

  </head>
  
    <body>
        <div class="layui-fluid">
            <div class="layui-row">
                <form id="addComForm" action="AdminCommodityServlet.shtml?action=updateCom" method="post" enctype="multipart/form-data" class="layui-form">
                   <input type="hidden" name="comId"  value="${sessionScope.commodity.id }"/>
                    <div class="layui-form-item">
                        <label for="username" class="layui-form-label">
                            <span class="x-red">*</span>商品名</label>
                        <div class="layui-input-inline">
                            <input type="text" id="cName" name="cName" value="${sessionScope.commodity.cName }" lay-verify="required" autocomplete="off" class="layui-input"></div>
                    </div>
                    <div class="layui-form-item">
                        <label for="username" class="layui-form-label">
                            <span class="x-red">*</span>系列：</label>
                        <div class="layui-input-inline">
                            <select name="serid-cateid" data="${sessionScope.commodity.categoryId }-${sessionScope.commodity.seriesId }">
								<option value="0">全部系列</option>
								<c:forEach items="${sessionScope.seriessLicom }" var="s">
									<option value="${s.categoryId}-${s.id }">${s.sName }</option>
								</c:forEach>
							</select>
						</div>
                    </div>
                    <div class="layui-form-item">
                        <label for="phone" class="layui-form-label">
                            <span class="x-red">*</span>展示图片</label>
                        <div class="layui-input-inline">
                            <input type="file"  accept="image/*"  name="image" value="s" /></div>
		        	<div class="layui-form-item">
			            <label for="L_repass" class="layui-form-label"></label>
			            <button class="layui-btn add-commodity-btn" lay-filter="add" lay-submit="">修改</button></div>
        		</form>
        	</div>
        </div>
        <script>
	        function getPageCom(page){
				$('[name=getPageCom]').val(page);
				$('#pageComForm').trigger('submit');
				window.open('','_self');
				window.close();
			}
        	$(function(){
        		$('[name=serid-cateid]').val($('[name=serid-cateid]').attr('data'))
        		
        		$('.add-commodity-btn').click(function(){
        			var cName = $('[name=cName]').val();
					var serid_cateid = $('[name=serid-cateid]').val();
					var image = $('[name=image]').val();
					if (cName == null || cName == '') {
						alert('商品名称不能为空！');
						return false;
					} else if (serid_cateid <= 0) {
						alert('请选择细分！');
						return false;
					} else if (image == '' || image == null) {
						alert('请选择一个图片！');
						return false;
					}
					$('#addComForm').trigger('submit');
					return false;
        		});
        	});
        </script>
    </body>
</html>
