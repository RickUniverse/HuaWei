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
                <form id="couForm" action="AdminColorAndConfigureServlet.shtml?action=updateCou" method="post"  enctype="multipart/form-data"  class="layui-form">
                	<div class="layui-form-item">
                		<input type="hidden" value="${sessionScope.colAndCou.id  }" name="coucId" />
                		<!-- 商品-->
                        <label style="display:inline-block;" for=""><span class="x-red">*</span>对应商品：</label>
							<select name="commodityId" style="width: 140px;" data="${sessionScope.colAndCou.commodityId  }">
								<option value="0">全部商品</option>
								<c:forEach items="${sessionScope.comLi }" var="s">
									<option value="${s.id }">${s.cName }</option>
								</c:forEach>
							</select>
                    </div>
                	<div class="layui-form-item">
                        <!-- 颜色-->
	                        <label style="display:inline-block;" for=""><span class="x-red">*</span>选择颜色：</label>
							<select name="colorId" style="width: 140px;" data="${sessionScope.colAndCou.colorId }">
								<option value="0">全部颜色</option>
								<c:forEach items="${sessionScope.colorLi }" var="s">
									<option value="${s.id }">${s.cName }</option>
								</c:forEach>
							</select>
                    </div>
                    <div class="layui-form-item">
                        	<!-- 配置 -->
							<label style="display:inline-block;" for=""><span class="x-red">*</span>选择配置：</label>
							<select name="configureId" style="width: 140px;" data="${sessionScope.colAndCou.configureId }">
								<option value="0">全部配置</option>
								<c:forEach items="${sessionScope.configureLi }" var="s">
									<option value="${s.id }">${s.cName }</option>
								</c:forEach>
							</select>
                    </div>
                    <div class="layui-form-item">
                       		<label style="display:inline-block;" for=""><span class="x-red">*</span>选择促销：</label>
							<select name="promotionId" style="width: 140px;" data="${sessionScope.colAndCou.promotionId  }">
								<option value="0">全部促销</option>
								<c:forEach items="${sessionScope.proLi }" var="s">
									<option value="${s.id }">${s.title }</option>
								</c:forEach>
							</select>
                    </div>
                    <div class="layui-form-item">
                        <label for="phone" class="layui-form-label"><span class="x-red">*</span>库存：</label>
                        <input type="number" min="1" id="phone" name="store" value="${sessionScope.colAndCou.store }" required="" lay-verify="phone" autocomplete="off" class="layui-input">
                    </div>
                    <div class="layui-form-item">
                        <label for="username" class="layui-form-label">
                            <span class="x-red">*</span>价格：</label>
                            <input type="text" id="username" name="price" required="" value="${sessionScope.colAndCou.price }" lay-verify="required" autocomplete="off" class="layui-input">
                    </div>
                    <div class="layui-form-item">
                        <label for="L_email" class="layui-form-label">
                            <span class="x-red">*</span>标题：</label>
                        <div class="layui-input-inline">
                            <input type="text" id="L_email" name="title" required="" value="${sessionScope.colAndCou.title }" lay-verify="email" autocomplete="off" class="layui-input"></div>
                        <div class="layui-form-mid layui-word-aux">
                            <span class="x-red">*</span></div>
                    </div>
                    
			        <div class="layui-form-item layui-form-text">
			            <label for="desc" class="layui-form-label"> <span class="x-red">*</span>描述：</label>
			            <div class="layui-input-block">
			                <textarea placeholder="请输入内容" id="descs" name="descs" class="layui-textarea">${sessionScope.colAndCou.descs }</textarea>
			            </div>
			        </div>
			        <div class="layui-form-item">
                        <label for="L_email" class="layui-form-label">
                            <span class="x-red">*</span>图片集合：</label>
                        <div class="layui-input-inline">
                            <input type="file" id="L_email" name="images" accept="image/*" multiple="multiple" required="" lay-verify="email" autocomplete="off" class="layui-input"></div>
                        <div class="layui-form-mid layui-word-aux">
                            <span class="x-red">*</span></div>
                    </div>
			        <div class="layui-form-item">
			            <label for="L_repass" class="layui-form-label"></label>
			            <button class="layui-btn add-colorandconfigure-btn" lay-filter="add" lay-submit="">修改</button>
			        </div>
        		</form>
        	</div>
        </div>
        <script>
        	$(function(){
        		//初始化
        		$('[name=commodityId]').val($('[name=commodityId]').attr('data'));
        		$('[name=colorId]').val($('[name=colorId]').attr('data'));
        		$('[name=configureId]').val($('[name=configureId]').attr('data'));
        		$('[name=promotionId]').val($('[name=promotionId]').attr('data'));
        		
        		//修改
        		$('.add-colorandconfigure-btn').click(function(){
        			var commodityId = $('[name=commodityId]').val();
					var colorId = $('[name=colorId]').val();
					var configureId = $('[name=configureId]').val();
					var promotionId = $('[name=promotionId]').val();
					var store = $('[name=store]').val();
					var price = $('[name=price]').val();
					var title = $('[name=title]').val();
					var descs = $('[name=descs]').text();
					var images = $('[name=images]').val();
					console.log(descs)
					if (commodityId <= 0) {
						alert('请选择商品！');
						return false;
					} else if (colorId <= 0) {
						alert('请选择颜色！');
						return false;
					} else if (configureId <= 0) {
						alert('请选择配置！');
						return false;
					} else if (promotionId <= 0) {
						alert('请选择促销！');
						return false;
					} else if (store == '' || store == null ||store <= 0) {
						alert('数量不正确！');
						return false;
					} else if (price == '' || price == null || price <= 0) {
						alert('价格不正确！');
						return false;
					} else if (title == null || title == '') {
						alert('标题不能为空！');
						return false;
					} else if (descs == null || descs == '') {
						alert('详细说明不能为空！');
						return false;
					} else if (images == null || images == '') {
						alert('请选择一个或多个图片！');
						return false;
					}
					
					$('#couForm').trigger('submit');
					return false;
        		});
        	});
        </script>
    </body>
</html>
