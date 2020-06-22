<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
            <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i></a>
        </div>
        <div class="layui-fluid">
            <div class="layui-row layui-col-space15">
                <div class="layui-col-md12">
                    <div class="layui-card">
                        <div class="layui-card-header">
                            <button class="layui-btn" onclick="xadmin.open('添加颜色配置','backend/add-colorAndConfigure.jsp',600,400)"><i class="layui-icon"></i>添加颜色配置</button>
                            <button class="layui-btn" onclick="xadmin.open('添加颜色配置或促销','AdminCCPServlet.shtml',1150,500)"><i class="layui-icon"></i>添加颜色配置或促销</button>
                        </div>
                        <!-- 查询 -->
                        <form id="pageComForm" action="AdminColorAndConfigureServlet.shtml" method="post">
                       	 	<input type="hidden" name="getPageCou" />
                       	 	<label style="display:inline-block;" for="">商品名称查询：</label>
	                        <input style="display:inline-block;"  class="layui-input" placeholder="商品名称" value="${sessionScope.comName }" name="comName">
	                        <!-- 颜色-->
	                        <label style="display:inline-block;" for="">颜色查询：</label>
							<select name="colorId" style="width: 140px;" data="${sessionScope.colorId }">
								<option value="0">全部颜色</option>
								<c:forEach items="${sessionScope.colorsLi }" var="s">
									<option value="${s.id }">${s.cName }</option>
								</c:forEach>
							</select>
							<!-- 配置 -->
							<label style="display:inline-block;" for="">配置查询：</label>
							<select name="configureId" style="width: 140px;" data="${sessionScope.configureId }">
								<option value="0">全部配置</option>
								<c:forEach items="${sessionScope.configureLi }" var="s">
									<option value="${s.id }">${s.cName }</option>
								</c:forEach>
							</select>
							<script>
								$('[name=colorId]').val($('[name=colorId]').attr('data'));
								$('[name=configureId]').val($('[name=configureId]').attr('data'));
							</script>
							<div style="display:inline-block;"  class="layui-input-inline layui-show-xs-block" style="width: 100px;">
	                              <button class="layui-btn getPageCom-btn" lay-submit="" lay-filter="sreach">
	                                 <i class="layui-icon">&#xe615;</i></button>
	                         </div>
                        </form>
                        <script>
                        	$('.getPageCom-btn').click(function(){
                        		$('#pageComForm').trigger('submit');
                        	});
                        </script>
                        <div class="layui-card-body ">
                            <table class="layui-table layui-form">
                              <thead>
                                <tr>
                                  <th>颜色配置ID</th>
                                  <th>商品ID</th>
                                  <th>所属商品</th>
                                  <th>配置</th>
                                  <th>颜色</th>
                                  <th>库存</th>
                                  <th>价格</th>
                                  <th>该颜色配置图片</th>
                                  <th>标题</th>
                                  <th>描述</th>
                                  <th>促销内容</th>
                                  <th>操作</th>
                              </thead>
                              <tbody>
                              	<c:forEach items="${sessionScope.couLi }" var="c">
                                <tr>
                                  <td>${c.id }</td>
                                  <td>${c.commodity.id }</td>
                                  <td>${c.commodity.cName }</td>
                                  <td>${c.configure.cName }</td>
                                  <td>${c.color.cName }</td>
                                  <td>${c.store }</td>
                                  <td>${c.price }</td>
                                  <td class="current-img">
                                  	<img src="homeimage/commodity/${fn:substringBefore(c.images,';')}" width="50px" height="50px" alt="" title="" />
                                  	<div class="img-box-div">
                                  		<c:forTokens items="${c.images }" delims=";" var="i">
                                  		<img src="homeimage/commodity/${i }" width="50px" height="50px" alt="" />
                                  		</c:forTokens>
                                  	</div>
                                  </td>
                                  <td>${c.title }</td>
                                  <td>${c.descs }</td>
                                  <td>${c.promotion.title }</td>
                                  <td class="td-manage">
                                    <a title="编辑"  onclick="xadmin.open('修改','AdminColorAndConfigureServlet.shtml?action=doupdateCou&couId=${c.id }')" href="javascript:;">
                                      <i class="layui-icon">&#xe642;</i>
                                    </a>
                                    <a title="删除" data-delete-cou="${c.id }" class="data-delete-cou" href="javascript:;">
                                      <i class="layui-icon">&#xe640;</i>
                                    </a>
                                  </td>
                                </tr>
                                </c:forEach>
                              </tbody>
                            </table>
                        </div>
                        <div class="layui-card-body ">
                            <div class="page">
                                <div>
                                  <a class="prev" onclick="getPageCom(${sessionScope.pageCou.prevPage})" href="javascript:;">&lt;&lt;</a>
                                  <c:forEach begin="1" end="${sessionScope.pageCou.totalPage}" var="i">
                                  <c:if test="${sessionScope.pageCou.pageNo == i }" var="ok">
                                  <a class="num current" style="background-color: #009688;color: #ffffff;"  onclick="getPageCom(${i})" href="javascript:;">${i }</a>
                                  </c:if>
                                  <c:if test="${not ok }">
                                  <a class="num" onclick="getPageCom(${i})" href="javascript:;">${i }</a>
                                  </c:if>
                                  </c:forEach>
                                  <a class="next" onclick="getPageCom(${sessionScope.pageCou.nextPage})" href="javascript:;">&gt;&gt;</a>
                                </div>
                            </div>
                        </div>
                    
                    </div>
                </div>
            </div>
        </div> 
    </body>
    <script>
    	$(function(){
    		//显示图片
    		$('.current-img').children(':first').siblings().hide();
    		$('.current-img').mouseover(function(){
    			$(this).children(':first').siblings().show();
    		});
    		$('.current-img').mouseout(function(){
    			$(this).children(':first').siblings().hide();
    		});
    		//删除
    		$('.data-delete-cou').click(function(){
    			var tr = $(this).parent().parent();
				$.ajax({
					url : 'AdminColorAndConfigureServlet.shtml',
					type : 'post',
					data : {
						'action' : 'removeCou',
						'coucId' : $(this).attr('data-delete-cou')
					},
					success : function(result) {
						if (result == 'true') {
							$(tr).remove();
							alert('删除成功！');
						} else {
							alert('删除失败，可能有关联的细分表！');
						}
					}
				});
    		});
    	});
    	function getPageCom(page) {
    			$('[name=getPageCou]').val(page);
    			$('#pageComForm').trigger('submit');
    		}
    </script>
</html>
