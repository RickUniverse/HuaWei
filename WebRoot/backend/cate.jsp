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
    
    <title></title>
    
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
	<!-- 引入xadmin -->
	<script type="text/javascript" src="backjs/xadmin.js"></script>
	<!-- 引入jquery -->
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<!-- 引入js -->
	<script type="text/javascript" src="backjs/cate.js"></script>
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
                <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i>
            </a>
        </div>
        <div class="layui-fluid">
            <div class="layui-row layui-col-space15">
                <div class="layui-col-md12">
                    <div class="layui-card">
                    <h1 style="padding: 25px 0px 25px 20px;border-bottom: 1px solid #999999">添加商品种类跟细分</h1>
                        <div class="layui-card-body ">
                            <form action="javascript:;" method="post" enctype="multipart/form-data" class="layui-form layui-col-space5">
                                <div class="layui-input-inline layui-show-xs-block">
                                    <input class="layui-input" placeholder="种类名" name="cate_name_add"></div>
                                <div class="layui-input-inline layui-show-xs-block">
                                    <button class="layui-btn layui-btn-add-cate"  lay-submit="" lay-filter="sreach"><i class="layui-icon"></i>增加种类</button>
                                </div>
                             </form>
                                <hr />
                             <form id="addSeriesForm" action="AdminCateServlet.shtml?action=addSeries" method="post" enctype="multipart/form-data" class="layui-form layui-col-space5">
                                <div class="layui-input-inline layui-show-xs-block">
                                	<!-- 名字 -->
                                    <input class="layui-input" placeholder="细分名" name="series_name"></div>
                                   <div class="layui-input-inline layui-show-xs-block">
                                   		<!-- 类别 -->
                                    	<select name="cate-add-series" id="">
                                    		<option value="0">全部分类</option>
                                    		<c:forEach items="${sessionScope.categoryLi }" var="cate">
                                    		<option value="${cate.id }">${cate.sName }</option>
                                    		</c:forEach>
                                    	</select>
									</div>
									<div class="layui-input-inline layui-show-xs-block">
										<!-- 图片-->
										<input type="file"  accept="image/*"  name="sImage" value="s" />
									</div>
									<!-- 预览图片盒子 -->
									<div class="layui-input-inline layui-show-xs-block image-show-box"></div>
									<!-- 按钮 -->
                                <div class="layui-input-inline layui-show-xs-block">
                                	<!-- 按钮-->
                                    <button class="layui-btn layui-btn-add-servies"><i class="layui-icon"></i>增加细分</button>
                                </div>
                             </form>
                            <hr>
                        </div>
                        <div class="layui-card-body ">
                        <h1 style="padding: 25px 0px 25px 20px;border-bottom: 1px solid #999999;margin-bottom: 10px;">商品种类操作</h1>
                        <form id="pageCateForm" action="AdminCateServlet.shtml" method="post">
                       	 	<input type="hidden" name="getPageCate" />
                       	 	<label style="display:inline-block;" for="">类别名称查询：</label>
	                        	<input style="display:inline-block;"  value="${sessionScope.cateName }" class="layui-input" placeholder="种类名" name="cateName">
	                        	<div style="display:inline-block;"  class="layui-input-inline layui-show-xs-block" style="width: 100px;">
	                                 <button class="layui-btn getPageCate-btn" lay-submit="" lay-filter="sreach">
	                                     <i class="layui-icon">&#xe615;</i></button>
	                            </div>
                        </form>
                        <script>
                        	$('.getPageCate-btn').click(function(){
                        		$('#pageCateForm').trigger('submit');
                        	});
                        </script>
                            <table class="layui-table layui-form">
                              <thead>
                                <tr>
                                  <th width="70">ID</th>
                                  <th>分类名</th>
                                  <th>操作</th>
                              </thead>
                              <tbody class="x-cate">
                              <c:forEach items="${sessionScope.cateSeach }" var="cate">
                                <tr cate-id='1' fid='0' >
                                  <td>${cate.id }</td>
                                  <td>
                                    <i class="layui-icon x-show" status='true'>&#xe623;</i>
                                    	${cate.sName }
                                  </td>
                                   <td class="td-manage">
                                    <button data-cate-remove="${cate.id }" class="layui-btn-danger layui-btn layui-btn-xs layui-btn-remove-cate"  href="javascript:;" ><i class="layui-icon">&#xe640;</i>删除</button>
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
                                  <a class="prev" onclick="getPageCate(${sessionScope.pageCate.prevPage})" href="javascript:;">&lt;&lt;</a>
                                  <c:forEach begin="1" end="${sessionScope.pageCate.totalPage}" var="i">
                                  <c:if test="${sessionScope.pageCate.pageNo == i }" var="ok">
                                  <a class="num current" style="background-color: #009688;color: #ffffff;"  onclick="getPageCate(${i})" href="javascript:;">${i }</a>
                                  </c:if>
                                  <c:if test="${not ok }">
                                  <a class="num" onclick="getPageCate(${i})" href="javascript:;">${i }</a>
                                  </c:if>
                                  </c:forEach>
                                  <a class="next" onclick="getPageCate(${sessionScope.pageCate.nextPage})" href="javascript:;">&gt;&gt;</a>
                                </div>
                            </div>
                        </div>
                        <div class="layui-card-body ">
                         <h1 style="padding: 25px 0px 25px 20px;border-bottom: 1px solid #999999;margin-bottom: 10px;">细分操作</h1>
                        <form id="pageSerForm" action="AdminCateServlet.shtml" method="post">
                       	 	<input type="hidden" name="getPageSeries" />
                       	 	<label style="display:inline-block;" for="">细分名称查询：</label>
	                        <input style="display:inline-block;"  class="layui-input" placeholder="细分名 " value="${sessionScope.seriesName }" name="seriesName">
	                        <label style="display:inline-block;" for="">类别查询：</label>
	                        <!-- 类别 -->
							<select name="cate-search-series" data="${sessionScope.categoruId }">
								<option value="0">全部分类</option>
								<c:forEach items="${sessionScope.categoryLi }" var="cate">
									<option value="${cate.id }">${cate.sName }</option>
								</c:forEach>
							</select>
							<script>
								$('[name=cate-search-series]').val($('[name=cate-search-series]').attr('data'));
							</script>
							<div style="display:inline-block;"  class="layui-input-inline layui-show-xs-block" style="width: 100px;">
	                              <button class="layui-btn getPageSeries-btn" lay-submit="" lay-filter="sreach">
	                                 <i class="layui-icon">&#xe615;</i></button>
	                         </div>
                        </form>
                        <script>
                        	$('.getPageSeries-btn').click(function(){
                        		$('#pageSerForm').trigger('submit');
                        	});
                        </script>
                            <table class="layui-table layui-form">
                              <thead>
                                <tr>
                                  <th width="30">ID</th>
                                  <th>展示图片</th>
                                  <th>细分名</th>
                                  <th>关联的商品数量</th>
                                  <th width="20">所属分类</th>
                                  <th width="80">分类名</th>
                                  <th width="150">操作</th>
                              </thead>
                              <tbody class="x-cate">
                               <c:forEach items="${sessionScope.seriesLi }" var="ser">
                                <tr cate-id='1' fid='0' >
                                  <td>${ser.id }</td>
                                  <td><img src="${ser.image }" alt="" width="100px" height="100px" /></td>
                                  <td>
                                    <input type="text" class="layui-input x-sort" name="sName"  value="${ser.sName }">
                                  </td>
                                  <td>${ser.reCommodityCount }</td>
                                  <td>
                                  		<select name="cateupdate" data="${ser.categoryId }">
                                    		<c:forEach items="${sessionScope.categoryLi }" var="cate">
                                    		<option value="${cate.id }">${cate.sName }</option>
                                    		</c:forEach>
                                    	</select>
                                  </td>
                                  <td>
                                   	${ser.category.sName }
                                  </td>
                                  <td class="td-manage">
                                    <button data-seriesId="${ser.id }" class="layui-btn layui-btn layui-btn-xs servier-update"  ><i class="layui-icon">&#xe642;</i>修改</button>
                                    <button data-seriesId="${ser.id }" data-reCommodityCount="${ser.reCommodityCount }" class="layui-btn-danger layui-btn layui-btn-xs servier-delete"  href="javascript:;" ><i class="layui-icon">&#xe640;</i>删除</button>
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
                                  <a class="prev" onclick="getPageSeries(${sessionScope.pageSer.prevPage})" href="javascript:;">&lt;&lt;</a>
                                  <c:forEach begin="1" end="${sessionScope.pageSer.totalPage}" var="i">
                                  <c:if test="${sessionScope.pageSer.pageNo == i }" var="ok">
                                  <a class="num current" style="background-color: #009688;color: #ffffff;"  onclick="getPageSeries(${i})" href="javascript:;">${i }</a>
                                  </c:if>
                                  <c:if test="${not ok }">
                                  <a class="num" onclick="getPageSeries(${i})" href="javascript:;">${i }</a>
                                  </c:if>
                                  </c:forEach>
                                  <a class="next" onclick="getPageSeries(${sessionScope.pageSer.nextPage})" href="javascript:;">&gt;&gt;</a>
                                </div>
                            </div>
                        </div>
                   
                    </div>
                </div>
            </div>
        </div>
        
    </body>
</html>
