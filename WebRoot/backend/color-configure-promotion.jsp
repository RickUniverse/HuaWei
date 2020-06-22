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
        <div class="layui-fluid" style="overflow: hidden;">
            <div class="layui-row layui-col-space15" style="width: 370px; float: left;">
                <div class="layui-col-md12">
                    <div class="layui-card">
                    <h2 style="padding: 10px 0px 25px 20px;">颜色</h2>
                        <div class="layui-card-body ">
                            <form action="javascript:;" class="layui-form layui-col-space5">
                                
                                <div class="layui-inline layui-show-xs-block">
                                    <input type="text" name="add-color-name"  placeholder="颜色名" autocomplete="off" class="layui-input">
                                </div>
                                <div class="layui-inline layui-show-xs-block">
                                    <button class="layui-btn add-color-name"  lay-submit="" lay-filter="sreach"><i class="layui-icon"></i>增加</button>
                                </div>
                            </form>
                        </div>
                       <!-- 查询 -->
                        <form id="pageColForm" action="AdminCCPServlet.shtml" method="post">
                       	 	<input type="hidden" name="getPageColor" />
                       	 	<label style="display:inline-block;" for="">颜色名称查询：</label>
	                        	<input style="display:inline-block;"  value="${sessionScope.colorName }" class="layui-input" placeholder="颜色名" name="colorName">
	                        	<div style="display:inline-block;"  class="layui-input-inline layui-show-xs-block" style="width: 100px;">
	                                 <button class="layui-btn getPageCol-btn" lay-submit="" lay-filter="sreach">
	                                     <i class="layui-icon">&#xe615;</i></button>
	                            </div>
                        </form>
                        <script>
                        	$('.getPageCol-btn').click(function(){
                        		$('#pageColForm').trigger('submit');
                        	});
                        </script>
                        <div class="layui-card-body ">
                            <table class="layui-table layui-form">
                                <thead>
                                  <tr>
                                    <th>ID</th>
                                    <th>颜色名</th>
                                    <th>操作</th>
                                </thead>
                                <tbody>
                                <c:forEach items="${sessionScope.colorLi }" var="c">
                                  <tr>
                                    <td>${c.id }</td>
                                    <td>${c.cName }</td>
                                    <td class="td-manage">
                                      <!-- <a title="编辑"  href="javascript:;">
                                        <i class="layui-icon">&#xe642;</i>
                                      </a> -->
                                      <a data-delete-color="${c.id }" title="删除" class="data-delete-color"  href="javascript:;">
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
                                  <a class="prev" onclick="getPageColor(${sessionScope.pageColor.prevPage})" href="javascript:;">&lt;&lt;</a>
                                  <c:forEach begin="1" end="${sessionScope.pageColor.totalPage}" var="i">
                                  <c:if test="${sessionScope.pageColor.pageNo == i }" var="ok">
                                  <a class="num current" style="background-color: #009688;color: #ffffff;"  onclick="getPageColor(${i})" href="javascript:;">${i }</a>
                                  </c:if>
                                  <c:if test="${not ok }">
                                  <a class="num" onclick="getPageColor(${i})" href="javascript:;">${i }</a>
                                  </c:if>
                                  </c:forEach>
                                  <a class="next" onclick="getPageColor(${sessionScope.pageColor.nextPage})" href="javascript:;">&gt;&gt;</a>
                                </div>
                            </div>
                        </div>
                        
                    </div>
                </div>
            </div>
            <!-- 第二个配置 -->
            <div class="layui-row layui-col-space15" style="width: 370px; float: left;">
                <div class="layui-col-md12">
                    <div class="layui-card">
                    <h2 style="padding: 10px 0px 25px 20px;">配置</h2>
                        <div class="layui-card-body ">
                            <form action="javascript:;" class="layui-form layui-col-space5">
                                
                                <div class="layui-inline layui-show-xs-block">
                                    <input type="text" name="add-conf-name"  placeholder="配置名" autocomplete="off" class="layui-input">
                                </div>
                                <div class="layui-inline layui-show-xs-block">
                                    <button class="layui-btn add-conf-name"  lay-submit="" lay-filter="sreach"><i class="layui-icon"></i>增加</button>
                                </div>
                            </form>
                        </div>
                        <!-- 查询 -->
                        <form id="pageConfForm" action="AdminCCPServlet.shtml" method="post">
                       	 	<input type="hidden" name="getPageConf" />
                       	 	<label style="display:inline-block;" for="">配置名称查询：</label>
	                        	<input style="display:inline-block;"  value="${sessionScope.confName }" class="layui-input" placeholder="配置名" name="confName">
	                        	<div style="display:inline-block;"  class="layui-input-inline layui-show-xs-block" style="width: 100px;">
	                                 <button class="layui-btn getPageConf-btn" lay-submit="" lay-filter="sreach">
	                                     <i class="layui-icon">&#xe615;</i></button>
	                            </div>
                        </form>
                        <script>
                        	$('.getPageConf-btn').click(function(){
                        		$('#pageConfForm').trigger('submit');
                        	});
                        </script>
                        <div class="layui-card-body ">
                            <table class="layui-table layui-form">
                                <thead>
                                
                                  <tr>
                                    <th>ID</th>
                                    <th>分类名</th>
                                    <th>操作</th>
                                </thead>
                                <tbody>
                                <c:forEach items="${sessionScope.confLi }" var="c">
                                  <tr>
                                    <td>${c.id }</td>
                                    <td>${c.cName }</td>
                                    <td class="td-manage">
                                      <!-- <a title="编辑" href="javascript:;">
                                        <i class="layui-icon">&#xe642;</i>
                                      </a> -->
                                      <a data-delete-conf="${c.id }" class="data-delete-conf" title="删除" href="javascript:;">
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
                                  <a class="prev" onclick="getPageConf(${sessionScope.pageconf.prevPage})" href="javascript:;">&lt;&lt;</a>
                                  <c:forEach begin="1" end="${sessionScope.pageconf.totalPage}" var="i">
                                  <c:if test="${sessionScope.pageconf.pageNo == i }" var="ok">
                                  <a class="num current" style="background-color: #009688;color: #ffffff;"  onclick="getPageConf(${i})" href="javascript:;">${i }</a>
                                  </c:if>
                                  <c:if test="${not ok }">
                                  <a class="num" onclick="getPageConf(${i})" href="javascript:;">${i }</a>
                                  </c:if>
                                  </c:forEach>
                                  <a class="next" onclick="getPageConf(${sessionScope.pageconf.nextPage})" href="javascript:;">&gt;&gt;</a>
                                </div>
                            </div>
                        </div>
                   
                    </div>
                </div>
            </div>
       	<!-- 第三个促销 -->
            <div class="layui-row layui-col-space15" style="width: 400px; float: left;">
                <div class="layui-col-md12">
                    <div class="layui-card">
                    <h2 style="padding: 10px 0px 25px 20px;">促销</h2>
                        <div class="layui-card-body ">
                            <form action="javascript:;" class="layui-form layui-col-space5">
                                
                                <div class="layui-inline layui-show-xs-block">
                                    <input type="text" name="add-pro-tit"  placeholder="促销标题" autocomplete="off" class="layui-input">
                                     <input type="text" name="add-pro-con"  placeholder="内容" autocomplete="off" class="layui-input">
                                </div>
                                <div class="layui-inline layui-show-xs-block">
                                    <button class="layui-btn add-tit-con-name"  lay-submit="" lay-filter="sreach"><i class="layui-icon"></i>增加</button>
                                </div>
                            </form>
                        </div>
                        <!-- 查询 -->
                        <form id="pageProForm" action="AdminCCPServlet.shtml" method="post">
                       	 	<input type="hidden" name="getPagePro" />
                       	 	<label style="display:inline-block;" for="">促销名称查询：</label>
	                        	<input style="display:inline-block;"  value="${sessionScope.proName }" class="layui-input" placeholder="促销标题" name="proName">
	                        	<div style="display:inline-block;"  class="layui-input-inline layui-show-xs-block" style="width: 100px;">
	                                 <button class="layui-btn getPagePro-btn" lay-submit="" lay-filter="sreach">
	                                     <i class="layui-icon">&#xe615;</i></button>
	                            </div>
                        </form>
                        <script>
                        	$('.getPagePro-btn').click(function(){
                        		$('#pageProForm').trigger('submit');
                        	});
                        </script>
                        <div class="layui-card-body ">
                            <table class="layui-table layui-form">
                                <thead>
                                  <tr>
                                    <th>ID</th>
                                    <th>标题</th>
                                    <th>内容</th>
                                    <th>操作</th>
                                </thead>
                                <tbody>
                                <c:forEach items="${sessionScope.proLi }" var="p">
                                  <tr>
                                    <td>${p.id }</td>
                                    <td>${p.title }</td>
                                    <td>${p.content }</td>
                                    <td class="td-manage">
                                      <a data-delete-pro="${p.id }" title="删除" class="data-delete-pro" href="javascript:;">
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
                                  <a class="prev" onclick="getPagePro(${sessionScope.pagepro.prevPage})" href="javascript:;">&lt;&lt;</a>
                                  <c:forEach begin="1" end="${sessionScope.pagepro.totalPage}" var="i">
                                  <c:if test="${sessionScope.pagepro.pageNo == i }" var="ok">
                                  <a class="num current" style="background-color: #009688;color: #ffffff;"  onclick="getPagePro(${i})" href="javascript:;">${i }</a>
                                  </c:if>
                                  <c:if test="${not ok }">
                                  <a class="num" onclick="getPagePro(${i})" href="javascript:;">${i }</a>
                                  </c:if>
                                  </c:forEach>
                                  <a class="next" onclick="getPagePro(${sessionScope.pagepro.nextPage})" href="javascript:;">&gt;&gt;</a>
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
