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
<div class="layui-card-body ">
	<h1
		style="padding: 25px 0px 25px 20px;border-bottom: 1px solid #999999;margin-bottom: 20px;">轮播操作</h1>
		<!-- 添加 -->
		<form id="addCarouselForm"
		action="AdminCarouselServlet.shtml?action=addCarousel" method="post"
		enctype="multipart/form-data" class="layui-form layui-col-space5">
		<label style="color:#999999; display: block;" for="">注:添加轮播时，默认为http://(字符串长度等于7),链接地址为商品详情页面.该字符串长度大于7的话，则连接地址为该地址！</label>
		<div class="layui-input-inline layui-show-xs-block">
			<!-- 请输入链接地址 -->
			<input class="layui-input" value="http://" placeholder="请输入链接地址" name="href">
		</div>
		<div class="layui-input-inline layui-show-xs-block">
			<!-- 请输入轮播顺序 -->
			<input class="layui-input" type="number" min="1" placeholder="请输入轮播顺序" name="order">
		</div>
		<div class="layui-input-inline layui-show-xs-block">
			<!-- 请输入颜色配置ID -->
			<input class="layui-input" type="number" min="1" placeholder="请输入颜色配置ID" name="couId">
		</div>
		<div class="layui-input-inline layui-show-xs-block">
			<!-- 图片-->
			<input type="file" accept="image/*" name="sImage" value="s" />
		</div>
		<!-- 预览图片盒子 -->
		<div class="layui-input-inline layui-show-xs-block image-show-box"></div>
		<!-- 按钮 -->
		<div class="layui-input-inline layui-show-xs-block">
			<!-- 按钮-->
			<button class="layui-btn layui-btn-add-carousel">
				<i class="layui-icon"></i>添加轮播
			</button>
		</div>
	</form>
	<script>
	    $(function(){
	    	//添加细分
			$('.layui-btn-add-carousel').click(function() {
				var href = $('[name=href]').val();
				var order = $('[name=order]').val();
				var couId = $('[name=couId]').val();
				var sImage = $('[name=sImage]').val();
				if (href == null || href == '') {
					alert('链接地址不能为空！');
					return false;
				} else if (order <= 0) {
					alert('请安排顺序！');
					return false;
				} else if (couId <= 0) {
					alert('请选择颜色配置id！');
					return false;
				} else if (sImage == '' || sImage == null) {
					alert('请选择一个图片！');
					return false;
				}
				$('#addCarouselForm').trigger('submit');
				return false;
			});
			
			//修改
			$('.data-update').click(function(){
				var order = $(this).parent().prev().prev().prev().prev().children(0).val();
				var href = $(this).parent().prev().prev().prev().prev().prev().find('input').val();
				var carId = $(this).attr('data-update');
				if(href == ''||href==null){
					return;
				}else if(order<=0){
					return;
				}else{
					$.ajax({
						url : 'AdminCarouselServlet.shtml',
						type : 'post',
						data : {
							'action' : 'updateCarousel',
							'order' : order,
							'carId' : carId,
							'href' : href
						},
						success : function(result) {
							if (result == 'true') {
								alert('修改成功！');
							} else {
								alert('修改失败');
							}
						}
					});
				}
			});
			
			//删除
			$('.data-delete').click(function() {
				var tr = $(this).parent().parent();
				$.ajax({
					url : 'AdminCarouselServlet.shtml',
					type : 'post',
					data : {
						'action' : 'deleteCarousel',
						'carId' : $(this).attr('data-delete')
					},
					success : function(result) {
						if (result == 'true') {
							$(tr).remove();
							alert('删除成功！');
						} else {
							alert('删除失败！');
						}
					}
				});
			});
	    });
	</script>
	<table class="layui-table layui-form">
		<thead>
			<tr>
				<th width="30">ID</th>
				<th width="150">轮播图片</th>
				<th>链接地址</th>
				<th>轮播顺序</th>
				<th>颜色配置id</th>
				<th width="20">商品名称</th>
				<th width="80">价格</th>
				<th width="150">操作</th>
		</thead>
		<tbody class="x-cate">
			<c:forEach items="${sessionScope.carouselLi }" var="c">
				<tr cate-id='1' fid='0'>
					<td>${c.id }</td>
					<td style="width: 100px;height: 100px;"><img src="${c.image }" alt="" /></td>
					<td><input type="text" class="layui-input x-sort" name="sName" value="${c.href }"></td>
					<td><input type="number" min="1" class="layui-input x-sort" name="sName" value="${c.orders }"></td>
					<td>${c.colorandconfigureId }</td>
					<td>${c.colorandConfigure.commodity.cName }</td>
					<td>${c.colorandConfigure.price }</td>
					<td class="td-manage">
						<button data-update="${c.id }"
							class="layui-btn layui-btn layui-btn-xs data-update">
							<i class="layui-icon">&#xe642;</i>修改
						</button>
						<button data-delete="${c.id }"
							class="layui-btn-danger layui-btn layui-btn-xs data-delete"
							href="javascript:;">
							<i class="layui-icon">&#xe640;</i>删除
						</button>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>
