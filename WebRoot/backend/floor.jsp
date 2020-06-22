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
        <div class="layui-fluid" style="overflow: hidden;">
       		<!-- 楼层 -->
            <div class="layui-row layui-col-space15" >
                <div class="layui-col-md12">
                    <div class="layui-card">
                    <h2 style="padding: 10px 0px 25px 20px;">楼层</h2>
                        <div class="layui-card-body ">
                            <form action="javascript:;" class="layui-form layui-col-space5">
                            <label style="display:inline-block;" for="">颜色配置id：</label>
                                <div class="layui-inline layui-show-xs-block">
                                    <input type="number" name="add-couIds" min="1" placeholder="颜色配置id" autocomplete="off" class="layui-input">
                                </div>
                                <div class="layui-inline layui-show-xs-block">
                                     <!-- 楼层 -->
                                     <label style="display:inline-block;" for="">选择楼层：</label>
									<select name="addfloorIds" data="${sessionScope.categoruId }">
										<option value="0">全部楼层</option>
										<c:forEach items="${sessionScope.flLi }" var="cate">
											<option value="${cate.id }">${cate.id }</option>
										</c:forEach>
									</select>
                                </div>
                                <div class="layui-inline layui-show-xs-block">
                                    <button class="layui-btn add-tit-con-name add-flor-cou"  lay-submit="" lay-filter="sreach"><i class="layui-icon"></i>增加</button>
                                </div>
                            </form>
                        </div>
                        <!-- 查询 -->
                        <form id="pageProForm" action="AdminFloorServlet.shtml" method="post">
                       	 	<input type="hidden" name="getPageCou" />
                       	 	<label style="display:inline-block;" for="">颜色配置id查询：</label>
	                        	<input style="display:inline-block;" type="number" min="1" value="${sessionScope.couId }" class="layui-input" placeholder="颜色配置id" name="couId">
	                        	
	                        	<!-- 楼层 -->
	                        	<label style="display:inline-block;" for="">楼层查询：</label>
								<select name="floorId" data="${sessionScope.floorId }">
									<option value="0">全部楼层</option>
									<c:forEach items="${sessionScope.flLi }" var="f">
										<option value="${f.id }">${f.id }</option>
									</c:forEach>
								</select>
	                        	
	                        	<div style="display:inline-block;"  class="layui-input-inline layui-show-xs-block" >
	                                 <button class="layui-btn getPagePro-btn" lay-submit="" lay-filter="sreach">
	                                     <i class="layui-icon">&#xe615;</i></button>
	                            </div>
                        </form>
                        <script>
                        	$('[name=floorId]').val($('[name=floorId]').attr('data'));
                        
                        	$('.getPagePro-btn').click(function(){
                        		$('#pageProForm').trigger('submit');
                        	});
                        	function getPagePro(page){
                        		$('[name=getPageCou]').val(page);
								$('#pageProForm').trigger('submit');
                        	}
                        	//添加
                        	$('.add-flor-cou').click(function(){
                        		var couid = $('[name=add-couIds]').val();
                        		var flId = $('[name=addfloorIds]').val();
                        		if(couid==null||couid==''){
                        			alert('颜色配置id不能为空！');
                        			return;
                        		}else if(flId<=0){
                        			alert('请选择楼层！');
                        			return;
                        		}
                        		location.href = "AdminFloorServlet.shtml?action=addflor&fid="+flId+"&couId="+couid+"";
                        	})
                        	//删除
                        	$(function(){
                        		$('.data-delete-pro').click(function(){
									var tr = $(this).parent().parent();
									$.ajax({
										url : 'AdminFloorServlet.shtml',
										type : 'post',
										data : {
											'action' : 'removeFl',
											'scomId' : $(this).attr('data-delete-pro')
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
								})
                        	});
                        </script>
                        <div class="layui-card-body ">
                            <table class="layui-table layui-form">
                                <thead>
                                  <tr>
                                    <th>颜色配置ID</th>
                                    <th>楼层展示图片</th>
                                    <th>所属楼层</th>
                                    <th>商品名</th>
                                    <th>价格</th>
                                    <th>促销</th>
                                    <th>操作</th>
                                </thead>
                                <tbody>
                                <c:forEach items="${sessionScope.coucolurLi }" var="c">
                                  <tr>
                                    <td>${c.id }</td>
                                    <td><img src="${c.commodity.image }" width="100px" height="100px" alt="" /></td>
                                    <td>${c.floorId }</td>
                                    <td>${c.commodity.cName }</td>
                                    <td>${c.price }</td>
                                    <td>${c.promotion.title }</td>
                                    <td class="td-manage">
                                      <a data-delete-pro="${c.scormId }" title="删除" class="data-delete-pro" href="javascript:;">
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
                                  <a class="prev" onclick="getPagePro(${sessionScope.pageCou.prevPage})" href="javascript:;">&lt;&lt;</a>
                                  <c:forEach begin="1" end="${sessionScope.pageCou.totalPage}" var="i">
                                  <c:if test="${sessionScope.pageCou.pageNo == i }" var="ok">
                                  <a class="num current" style="background-color: #009688;color: #ffffff;"  onclick="getPagePro(${i})" href="javascript:;">${i }</a>
                                  </c:if>
                                  <c:if test="${not ok }">
                                  <a class="num" onclick="getPagePro(${i})" href="javascript:;">${i }</a>
                                  </c:if>
                                  </c:forEach>
                                  <a class="next" onclick="getPagePro(${sessionScope.pageCou.nextPage})" href="javascript:;">&gt;&gt;</a>
                                </div>
                            </div>
                        </div>
                  
                    </div>
                </div>
            </div>
       
        </div> 
    </body>
</html>
