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
	<!-- 引入jquery -->
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<!-- 引入layui -->
	<script src="lib/layui/layui.js" charset="utf-8"></script>
	<!-- 引入xadmin -->
	<script type="text/javascript" src="backjs/xadmin.js"></script>
	<!-- 引入color-configure-promotion.js -->
	<script type="text/javascript" src="backjs/ccp.js"></script>
  </head>
  
    <body>
        <div class="x-nav">
          <span class="layui-breadcrumb">
            <a href="javascript:;">首页</a>
            <a href="javascript:;">演示</a>
            <a>
              <cite>导航元素</cite></a>
          </span>
          <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" onclick="location.reload()" title="刷新">
            <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i></a>
        </div>
        <div class="layui-fluid">
        <!-- 套餐-->
            <div class="layui-row layui-col-space15" >
                <div class="layui-col-md12">
                    <div class="layui-card">
                    <%-- <h1>${request.comboName }</h1> --%>
                    <h2 style="padding: 10px 0px 25px 20px;">套餐</h2>
                        <div class="layui-card-body ">
                            <form id="addcomForm" action="AdminComboServlet.shtml?action=addCom" method="post" class="layui-form layui-col-space5">
                                <label style="color:#999999; display: block;" for="">注:添加套餐时，如果套餐价格为&nbsp;&nbsp;&nbsp;0.0&nbsp;&nbsp;&nbsp;(英文字符)则说明改套餐是官方标配，没有套餐内商品！同一个商品拥有的套餐名不能重复！</label>
                                <div class="layui-inline layui-show-xs-block">
                                    <input type="text" name="comboName"  placeholder="套餐名称" autocomplete="off" class="layui-input">
                                </div>
                                <div class="layui-inline layui-show-xs-block">
                                     <input type="number" name="commodityId"  placeholder="商品id" autocomplete="off" class="layui-input">
                                </div>
                                <div class="layui-inline layui-show-xs-block">
                                    <input type="text" min="1" name="price"  placeholder="套餐价格" autocomplete="off" class="layui-input">
                                </div>
                                <div class="layui-inline layui-show-xs-block">
                                     <input type="text" name="huiPrice"  placeholder="优惠价格" autocomplete="off" class="layui-input">
                                </div>
                                <div class="layui-inline layui-show-xs-block">
                                    <button class="layui-btn add-combo"  lay-submit="" lay-filter="sreach"><i class="layui-icon"></i>增加</button>
                                </div>
                            </form>
                        </div>
                        <!-- 查询 -->
                        <form id="pageProForm" action="AdminComboServlet.shtml" method="post">
                       	 	<input type="hidden" name="getPageCom" />
                       	 	<label style="display:inline-block;" for="">套餐名称查询：</label>
	                        	<input style="display:inline-block;"  value="${param.comboNames }" class="layui-input" placeholder="套餐名称" name="comboNames">
	                        	<label style="display:inline-block;" for="">商品名称查询：</label>
	                        	<input style="display:inline-block;"  value="${param.commodityName }" class="layui-input" placeholder="商品名称" name="commodityName">
	                        	<div style="display:inline-block;"  class="layui-input-inline layui-show-xs-block" style="width: 100px;">
	                                 <button class="layui-btn getPageCom-btn" lay-submit="" lay-filter="sreach">
	                                     <i class="layui-icon">&#xe615;</i></button>
	                            </div>
                        </form>
                        <script>
                        	$('.getPageCom-btn').click(function(){
                        		$('#pageProForm').trigger('submit');
                        	});
                        	function getPageCom(page){
								$('[name=getPageCom]').val(page);
								$('#pageProForm').trigger('submit');
							}
							$(function(){
								//添加细分
								$('.add-combo').click(function() {
									var comboName = $('[name=comboName]').val();
									var commodityId = $('[name=commodityId]').val();
									var price = $('[name=price]').val();
									var huiPrice = $('[name=huiPrice]').val();
									if (comboName == null || comboName == '') {
										alert('套餐名称不能为空！');
										return false;
									} else if (commodityId <= 0) {
										alert('请输入商品id！');
										return false;
									} else if (price == '' || price == null) {
										alert('请输入商品价格！');
										return false;
									} else if (huiPrice == '' || huiPrice == null) {
										alert('请输入优惠价格！');
										return false;
									}
									$('#addcomForm').trigger('submit');
									return false;
								});
								//删除种类
								$('.data-delete-com').click(function() {
									var tr = $(this).parent().parent();
									$.ajax({
										url : 'AdminComboServlet.shtml',
										type : 'post',
										data : {
											'action' : 'removeCom',
											'comId' : $(this).attr('data-delete-pro')
										},
										success : function(result) {
											if (result == 'true') {
												$(tr).remove();
												alert('删除成功！');
											} else {
												alert('删除失败，可能有关联的表！');
											}
										}
									});
								});
							});
                        </script>
                        <div class="layui-card-body ">
                            <table class="layui-table layui-form">
                                <thead>
                                  <tr>
                                    <th>套餐ID</th>
                                    <th>套餐名</th>
                                    <th>商品id</th>
                                    <th>商品名</th>
                                    <th>套餐价格</th>
                                    <th>优惠价格</th>
                                    <th>操作</th>
                                </thead>
                                <tbody>
                                <c:forEach items="${sessionScope.comboLi }" var="c">
                                  <tr>
                                    <td>${c.id }</td>
                                    <td>${c.cName }</td>
                                    <td>${c.commodityId }</td>
                                    <td>${c.commodity.cName }</td>
                                    <td>${c.price }</td>
                                    <td>${c.huiPrice }</td>
                                    <td class="td-manage">
                                      <a data-delete-pro="${c.id }" title="删除" class="data-delete-com" href="javascript:;">
                                        <i class="layui-icon">&#xe640;</i>
                                      </a>
                                    </td>
                                  </tr>
                                  </c:forEach>
                                </tbody>
                              </table>
                        </div>
                        <!-- 分页 -->
                         <div class="layui-card-body ">
                            <div class="page">
                                <div>
                                  <a class="prev" onclick="getPageCom(${sessionScope.pageCom.prevPage})" href="javascript:;">&lt;&lt;</a>
                                  <c:forEach begin="1" end="${sessionScope.pageCom.totalPage}" var="i">
                                  <c:if test="${sessionScope.pageCom.pageNo == i }" var="ok">
                                  <a class="num current" style="background-color: #009688;color: #ffffff;"  onclick="getPageCom(${i})" href="javascript:;">${i }</a>
                                  </c:if>
                                  <c:if test="${not ok }">
                                  <a class="num" onclick="getPageCom(${i})" href="javascript:;">${i }</a>
                                  </c:if>
                                  </c:forEach>
                                  <a class="next" onclick="getPageCom(${sessionScope.pageCom.nextPage})" href="javascript:;">&gt;&gt;</a>
                                </div>
                            </div>
                        </div>
                  
                    </div>
                </div>
            </div>
            <!-- 套餐内商品 -->
            <div class="layui-row layui-col-space15">
                <div class="layui-col-md12">
                    <div class="layui-card">
                    <h2 style="padding: 10px 0px 25px 20px;">套餐内商品</h2>
                        <div class="layui-card-body ">
                            <form id="commForm" action="AdminComboServlet.shtml?action=addComm" method="post" class="layui-form layui-col-space5">
                                
                                <div class="layui-inline layui-show-xs-block">
                                    <input type=number name="add-comboId" min="1"  placeholder="套餐id" autocomplete="off" class="layui-input">
                                </div>
                                <div class="layui-inline layui-show-xs-block">
                                    <input type="number" name="add-comodityId" min="1"  placeholder="商品id" autocomplete="off" class="layui-input">
                                </div>
                                <div class="layui-inline layui-show-xs-block">
                                    <button class="layui-btn addCommm"  lay-submit="" lay-filter="sreach"><i class="layui-icon"></i>增加</button>
                                </div>
                            </form>
                        </div>
                        <!-- 查询 -->
                        <form id="pageCommForm" action="AdminComboServlet.shtml" method="post">
                       	 	<input type="hidden" name="getPageComm" />
                       	 	<label style="display:inline-block;" for="">套餐名称查询：</label>
	                        	<input style="display:inline-block;"  value="${sessionScope.comboNameTwo }" class="layui-input" placeholder="套餐名称" name="comboNameTwo">
	                        	<label style="display:inline-block;" for="">商品名称查询：</label>
	                        	<input style="display:inline-block;"  value="${sessionScope.commodityNameTwo }" class="layui-input" placeholder="商品名称" name="commodityNameTwo">
	                        	<div style="display:inline-block;"  class="layui-input-inline layui-show-xs-block" style="width: 100px;">
	                                 <button class="layui-btn getPageComm-btn" lay-submit="" lay-filter="sreach">
	                                     <i class="layui-icon">&#xe615;</i></button>
	                            </div>
                        </form>
                        <script>
                        	$('.getPageComm-btn').click(function(){
                        		$('#pageCommForm').trigger('submit');
                        	});
                        	function getPageComm(page){
								$('[name=getPageComm]').val(page);
								$('#pageCommForm').trigger('submit');
							}
							$(function(){
								//添加细分
								$('.addCommm').click(function() {
									var addcomboId = $('[name=add-comboId]').val();
									var addcomodityId = $('[name=add-comodityId]').val();
									if (addcomboId <= 0) {
										alert('套餐id不能为空！');
										return false;
									} else if (addcomodityId <= 0) {
										alert('商品id不能为空！');
										return false;
									}
									$('#commForm').trigger('submit');
									return false;
								});
								//删除种类
								$('.data-delete-comm').click(function() {
									var tr = $(this).parent().parent();
									$.ajax({
										url : 'AdminComboServlet.shtml',
										type : 'post',
										data : {
											'action' : 'removeComm',
											'commId' : $(this).attr('data-delete-conf')
										},
										success : function(result) {
											if (result == 'true') {
												$(tr).remove();
												alert('删除成功！');
											} else {
												alert('删除失败，可能有关联的表！');
											}
										}
									});
								});
							});
                        </script>
                        <div class="layui-card-body ">
                            <table class="layui-table layui-form">
                                <thead>
                                
                                  <tr>
                                    <th>ID</th>
                                    <th>套餐ID</th>
                                    <th>套餐名称</th>
                                    <th>商品ID</th>
                                    <th>商品名称</th>
                                    <th>操作</th>
                                </thead>
                                <tbody>
                                <c:forEach items="${sessionScope.combocommLi }" var="c">
                                  <tr>
                                    <td>${c.id }</td>
                                    <td>${c.comboId }</td>
                                    <td>${c.combo.cName }</td>
                                    <td>${c.commodityId }</td>
                                    <td>${c.commodity.cName }</td>
                                    <td class="td-manage">
                                      <a data-delete-conf="${c.id }" class="data-delete-comm" title="删除" href="javascript:;">
                                        <i class="layui-icon">&#xe640;</i>
                                      </a>
                                    </td>
                                  </tr>
                                  </c:forEach>
                                </tbody>
                              </table>
                        </div>
                         <!-- 分页 -->
                         <div class="layui-card-body ">
                            <div class="page">
                                <div>
                                  <a class="prev" onclick="getPageComm(${sessionScope.pageComm.prevPage})" href="javascript:;">&lt;&lt;</a>
                                  <c:forEach begin="1" end="${sessionScope.pageComm.totalPage}" var="i">
                                  <c:if test="${sessionScope.pageComm.pageNo == i }" var="ok">
                                  <a class="num current" style="background-color: #009688;color: #ffffff;"  onclick="getPageComm(${i})" href="javascript:;">${i }</a>
                                  </c:if>
                                  <c:if test="${not ok }">
                                  <a class="num" onclick="getPageComm(${i})" href="javascript:;">${i }</a>
                                  </c:if>
                                  </c:forEach>
                                  <a class="next" onclick="getPageComm(${sessionScope.pageComm.nextPage})" href="javascript:;">&gt;&gt;</a>
                                </div>
                            </div>
                        </div>
                   
                    </div>
                </div>
            </div>
       	
        </div> 
    </body>
    <script>
      layui.use(['laydate','form'], function(){
        var laydate = layui.laydate;
        var form = layui.form;
        
        //执行一个laydate实例
        laydate.render({
          elem: '#start' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
          elem: '#end' //指定元素
        });
      });

       /*用户-停用*/
      function member_stop(obj,id){
          layer.confirm('确认要停用吗？',function(index){

              if($(obj).attr('title')=='启用'){

                //发异步把用户状态进行更改
                $(obj).attr('title','停用')
                $(obj).find('i').html('&#xe62f;');

                $(obj).parents("tr").find(".td-status").find('span').addClass('layui-btn-disabled').html('已停用');
                layer.msg('已停用!',{icon: 5,time:1000});

              }else{
                $(obj).attr('title','启用')
                $(obj).find('i').html('&#xe601;');

                $(obj).parents("tr").find(".td-status").find('span').removeClass('layui-btn-disabled').html('已启用');
                layer.msg('已启用!',{icon: 5,time:1000});
              }
              
          });
      }

      /*用户-删除*/
      function member_del(obj,id){
          layer.confirm('确认要删除吗？',function(index){
              //发异步删除数据
              $(obj).parents("tr").remove();
              layer.msg('已删除!',{icon:1,time:1000});
          });
      }



      function delAll (argument) {

        var data = tableCheck.getData();
  
        layer.confirm('确认要删除吗？'+data,function(index){
            //捉到所有被选中的，发异步进行删除
            layer.msg('删除成功', {icon: 1});
            $(".layui-form-checked").not('.header').parents('tr').remove();
        });
      }
    </script>
    <script>var _hmt = _hmt || []; (function() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
      })();</script>
</html>
