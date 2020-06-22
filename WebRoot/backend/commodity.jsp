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
	<!-- 引入xadmin -->
	<script type="text/javascript" src="backjs/commodity.js"></script>
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
                            <button class="layui-btn" onclick="xadmin.open('添加商品','backend/add-commodity.jsp',600,400)"><i class="layui-icon"></i>添加</button>
                        </div>
                        <!-- 查询 -->
                        <form id="pageComForm" action="AdminCommodityServlet.shtml" method="post">
                       	 	<input type="hidden" name="getPageCom" />
                       	 	<label style="display:inline-block;" for="">商品名称查询：</label>
	                        <input style="display:inline-block;"  class="layui-input" placeholder="商品名称" value="${param.comName }" name="comName">
	                        <label style="display:inline-block;" for="">系列查询：</label>
	                        <!-- 系列 -->
							<select name="seriesId" data="${param.seriesId }">
								<option value="0">全部系列</option>
								<c:forEach items="${sessionScope.seriessLicom }" var="s">
									<option value="${s.id }">${s.sName }</option>
								</c:forEach>
							</select>
							<script>
								$('[name=seriesId]').val($('[name=seriesId]').attr('data'));
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
                                  <th>ID</th>
                                  <th>展示</th>
                                  <th>商品名</th>
                                  <th>商品系列</th>
                                  <th>上架时间</th>
                                  <th>操作</th>
                              </thead>
                              <tbody>
                              <c:forEach items="${sessionScope.commoditycLi }" var="c">
                                <tr>
                                  <td>${c.id }</td>
                                  <td><img src="${c.image }" width="100px" height="100px;" alt="" /></td>
                                  <td>${c.cName }</td>
                                  <td>${c.series.sName }</td>
                                  <td>${c.putawayTime }</td>
                                  <td class="td-manage">
                                    <a title="编辑"  onclick="xadmin.open('修改商品','AdminCommodityServlet.shtml?action=update&comid=${c.id }',600,400)" href="javascript:;">
                                      <i class="layui-icon">&#xe642;</i>
                                    </a>
                                    <a title="删除" data-delete-com="${c.id }" class="data-delete-com" href="javascript:;">
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
