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
        <div class="x-nav">
            <span class="layui-breadcrumb">
                <a href="">首页</a>
                <a href="">演示</a>
                <a>
                    <cite>导航元素</cite></a>
            </span>
            <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" onclick="location.reload()" title="刷新">
                <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i>
            </a>
        </div>
        <div class="layui-fluid">
            <div class="layui-row layui-col-space15">
                <div class="layui-col-md12">
                    <div class="layui-card">
                        <h1 style="margin: 20px 10px;">订单管理</h1>
                        <form id=pageOrdForm action="AdminOrderServlet.shtml" method="post">
                       	 	<input type="hidden" name="getPageOrd" />
                       	 	<label style="display:inline-block;" for="">按照订单id查询：</label>
	                        	<input style="display:inline-block;" value="${param.ordId }" class="layui-input" placeholder="订单id" name="ordId">
	                        	
	                        	<!-- 订单状态 -->
								<label style="display:inline-block;" for="">订单状态查询：</label>
								<select name="statusId" style="width: 140px;" data="${param.statusId }">
									<option value="0">全部状态</option>
									<c:forEach items="${sessionScope.statsdLi }" var="s">
										<option value="${s.id }">${s.sName }</option>
									</c:forEach>
								</select>
								<script>
									
								</script>
	                        	
	                        	<div style="display:inline-block;"  class="layui-input-inline layui-show-xs-block" style="width: 100px;">
	                                 <button class="layui-btn getPageOrd-btn" lay-submit="" lay-filter="sreach">
	                                     <i class="layui-icon">&#xe615;</i></button>
	                            </div>
                        </form>
                        <script>
                        	$(function(){
                        		$('[name=statusId]').val($('[name=statusId]').attr('data'));
                        		$('.getPageOrd-btn').click(function(){
	                        		$('#pageOrdForm').trigger('submit');
	                        	});
	                        	//发货
	                        	$('.data-fa-huos').click(function(){
	                        		var td = $(this).parent().parent().children().eq(3);
	                        		var fa = $(this).parent();
	                        		var current = $(this);
	                        		$.ajax({
										url : 'AdminOrderServlet.shtml',
										type : 'post',
										data : {
											'action' : 'fahuo',
											'ordId' : $(this).attr('data-fa-huo')
										},
										success : function(result) {
											if(result == 'true') {
												$(td).text('待收货');
												$(current).remove();
											}else {
												alert('修改失败');
											}
										}
									});
	                        	});
                        	});
                        	
                        	function getPageOrd(page){
								$('[name=getPageOrd]').val(page);
								$('#pageOrdForm').trigger('submit');
							}
                        </script>
                        <div class="layui-card-body container-detail">
                        	<div class="detail-box">
                        	<c:forEach items="${sessionScope.orderLi }" var="ord"> 
                        		<h1 class="close-detail content-detail content-${ord.id }">关闭</h1>
                        		<%-- <a href="javascript:;"  class="close-detail content-detail content-${ord.id }">关闭</a> --%>
                        		<table style="margin: 0px auto;" class="layui-table layui-form content-detail content-${ord.id }">
                                <thead>
                                    <tr>
                                    	<th width="40px">订单ID</th>
                                        <th width="40">订单详情ID</th>
                                        <th width="140">商品名</th>
                                        <th width="30">图片</th>
                                        <th width="240">配置</th>
                                        <th width="140">颜色</th>
                                        <th width="40">购买数量</th>
                                        <th width="140">套餐</th>
                                     </tr>
                                </thead>
                                <tbody>
	                                	<c:forEach items="${ord.indentDetailLi }" var="o">
	                                    <tr>
	                                    	<td>${ord.id }</td>
	                                        <td>${o.id }</td>
	                                        <td>${o.colorAndConfigure.commodity.cName }</td>
	                                        <td><img src="${o.colorAndConfigure.commodity.image }" width="80px" height="80px" alt="" /></td>
	                                        <td>${o.colorAndConfigure.configure.cName }</td>
	                                        <td>${o.colorAndConfigure.color.cName }</td>
	                                        <td>${o.total }</td>
	                                        <td>${o.combo.cName }</td>
	                                    </tr>
	                                    </c:forEach>
                                </tbody>
                            </table>
                             </c:forEach>
                        	</div>
                        	<script>
	                        	$(function() {
                        			$('.data-detail').click(function() {
                        				$('.detail-box').css('display', 'block');
                        				$('.content-detail').css('display', 'none');
                        				$('.content-' + $(this).attr('data-detail') + '').show(500);
                        			});
                        			$('.close-detail').click(function(){
                        				$(this).parent().hide(500);
                        			});
                        		});
	                        </script>
                            <table class="layui-table layui-form">
                                <thead>
                                    <tr>
                                        <th>订单编号</th>
                                        <th>收货人</th>
                                        <th>总金额</th>
                                        <th>订单状态</th>
                                        <th>积分</th>
                                        <th>地址</th>
                                        <th>订单发起者</th>
                                        <th>下单时间</th>
                                        <th>操作</th></tr>
                                </thead>
                                <tbody>
                                	<c:forEach items="${sessionScope.orderLi }" var="o"> 
                                    <tr>
                                        <td>${o.id }</td>
                                        <td>${o.address.aName }</td>
                                        <td>${o.payment }</td>
                                        <td>${o.indentState.sName }</td>
                                        <td>${o.integral }</td>
                                        <td>${o.address.aName }&nbsp;&nbsp;&nbsp;${o.address.phone }&nbsp;&nbsp;&nbsp;${o.address.country }&nbsp;&nbsp;&nbsp;${o.address.detail }</td>
                                        <td>${o.hUser.uName }</td>
                                        <td>${o.orderdate }</td>
                                        <td class="td-manage">
                                        	<c:if test="${o.indentState.id == 1 }" var="ok">
	                                        	<a title="删除"  href="javascript:;">
	                                                <i class="layui-icon">&#xe640;</i>
	                                            </a>
                                            </c:if>
                                            <c:if test="${o.indentState.id == 3 }" var="ok">
	                                        	<a class="yes-fahuo data-fa-huos" data-fa-huo="${o.id }" title="确定发货"  href="javascript:;">
	                                                	确定发货
	                                            </a>
                                            </c:if>
                                            <a class="yes-fahuo data-detail" title="确定发货" data-detail="${o.id }" href="javascript:;">
	                                                	查看详情
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
                                  <a class="prev" onclick="getPageOrd(${sessionScope.pageOrd.prevPage})" href="javascript:;">&lt;&lt;</a>
                                  <c:forEach begin="1" end="${sessionScope.pageOrd.totalPage}" var="i">
                                  <c:if test="${sessionScope.pageOrd.pageNo == i }" var="ok">
                                  <a class="num current" style="background-color: #009688;color: #ffffff;"  onclick="getPageOrd(${i})" href="javascript:;">${i }</a>
                                  </c:if>
                                  <c:if test="${not ok }">
                                  <a class="num" onclick="getPageOrd(${i})" href="javascript:;">${i }</a>
                                  </c:if>
                                  </c:forEach>
                                  <a class="next" onclick="getPageOrd(${sessionScope.pageOrd.nextPage})" href="javascript:;">&gt;&gt;</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <script></script>
</html>
