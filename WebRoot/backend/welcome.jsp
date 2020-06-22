<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html class="x-admin-sm">
    <head>
    	<base href="<%=basePath%>">
    	
        <meta charset="UTF-8">
        <title>欢迎页面-X-admin2.2</title>
        <meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		
		<link rel="stylesheet" type="text/css" href="backcss/font.css">
		<link rel="stylesheet" type="text/css" href="backcss/xadmin.css">
		<link rel="stylesheet" type="text/css" href="lib/layui/css/layui.css">
        <script src="lib/layui/layui.js" charset="utf-8"></script>
        <script type="text/javascript" src="backjs/xadmin.js"></script>
        <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
        <!--[if lt IE 9]>
          <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
          <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <div class="layui-fluid">
            <div class="layui-row layui-col-space15">
                <div class="layui-col-md12">
                    <div class="layui-card">
                        <div class="layui-card-body ">
                            <blockquote class="layui-elem-quote">欢迎管理员：
                                <span class="x-red">${sessionScope.admin.aName }</span><!-- ！当前时间:2018-04-25 20:50:53 -->
                            </blockquote>
                        </div>
                    </div>
                </div>
                <div class="layui-col-md12">
                    <div class="layui-card">
                        <div class="layui-card-header">数据统计</div>
                        <div class="layui-card-body ">
                            <ul class="layui-row layui-col-space10 layui-this x-admin-carousel x-admin-backlog">
                                <li class="layui-col-md2 layui-col-xs6">
                                    <a href="javascript:;" class="x-admin-backlog-body">
                                        <h3>商品总数量</h3>
                                        <p>
                                            <cite class="totalStarc">${sessionScope.admin.comTotal }</cite></p>
                                    </a>
                                </li>
                                <li class="layui-col-md2 layui-col-xs6">
                                    <a href="javascript:;" class="x-admin-backlog-body">
                                        <h3>总商品种类</h3>
                                        <p>
                                            <cite class="totalCategory">${sessionScope.admin.categoryTotal }</cite></p>
                                    </a>
                                </li>
                                 <li class="layui-col-md2 layui-col-xs6 ">
                                    <a href="javascript:;" class="x-admin-backlog-body">
                                        <h3>销售总金额</h3>
                                        <p>
                                            <cite class="totalPrice">${sessionScope.admin.totalPrice }￥</cite></p>
                                    </a>
                                </li>
                                <li class="layui-col-md2 layui-col-xs6">
                                    <a href="javascript:;" class="x-admin-backlog-body">
                                        <h3>总商品系列</h3>
                                        <p>
                                            <cite class="totalSeries">${sessionScope.admin.seriesTotal }</cite></p>
                                    </a>
                                </li>
                                <li class="layui-col-md2 layui-col-xs6">
                                    <a href="javascript:;" class="x-admin-backlog-body">
                                        <h3>订单总数量</h3>
                                        <p>
                                            <cite class="totalIndent">${sessionScope.admin.indentTotal }</cite></p>
                                    </a>
                                </li>
                                <li class="layui-col-md2 layui-col-xs6">
                                    <a href="javascript:;" class="x-admin-backlog-body">
                                        <h3>总用户数量</h3>
                                        <p>
                                            <cite class="totalHUser">${sessionScope.admin.hUserTotal }</cite></p>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <script>
                	window.addEventListener('load', function(e) {
                		//循环读取现在的统计记录
                		setInterval(function() {
                			var xhr = new XMLHttpRequest();
	                		xhr.open('post', 'AdminIndexServlet.shtml?action=getAdmin', true);
	                		xhr.onreadystatechange = function(){
	                			if(xhr.readyState == 4){
	                				if(xhr.status == 200){
	                					var admin = eval('('+xhr.responseText+')');
	                					document.querySelector('.totalStarc').innerHTML = admin.comTotal;
	                					document.querySelector('.totalCategory').innerHTML = admin.categoryTotal;
	                					document.querySelector('.totalPrice').innerHTML = admin.totalPrice + '￥';
	                					document.querySelector('.totalSeries').innerHTML = admin.seriesTotal;
	                					document.querySelector('.totalIndent').innerHTML = admin.indentTotal;
	                					document.querySelector('.totalHUser').innerHTML = admin.hUserTotal;
	                				}
	                			}
	                		}
	                		xhr.send(null);
                		}, 5000);
                	});
                </script>
                <div class="layui-col-md12">
                    <div class="layui-card">
                        <div class="layui-card-header">系统信息</div>
                        <div class="layui-card-body ">
                            <table class="layui-table">
                                <tbody>
                                    <tr>
                                        <th>xxx版本</th>
                                        <td>1.0.180420</td></tr>
                                    <tr>
                                        <th>服务器地址</th>
                                        <td>x.xuebingsi.com</td></tr>
                                    <tr>
                                        <th>操作系统</th>
                                        <td>WINNT</td></tr>
                                    <tr>
                                        <th>运行环境</th>
                                        <td>Apache/2.4.23 (Win32) OpenSSL/1.0.2j mod_fcgid/2.3.9</td></tr>
                                    <tr>
                                        <th>PHP版本</th>
                                        <td>5.6.27</td></tr>
                                    <tr>
                                        <th>PHP运行方式</th>
                                        <td>cgi-fcgi</td></tr>
                                    <tr>
                                        <th>MYSQL版本</th>
                                        <td>5.5.53</td></tr>
                                    <tr>
                                        <th>ThinkPHP</th>
                                        <td>5.0.18</td></tr>
                                    <tr>
                                        <th>上传附件限制</th>
                                        <td>2M</td></tr>
                                    <tr>
                                        <th>执行时间限制</th>
                                        <td>30s</td></tr>
                                    <tr>
                                        <th>剩余空间</th>
                                        <td>86015.2M</td></tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="layui-col-md12">
                    <div class="layui-card">
                        <div class="layui-card-header">开发团队</div>
                        <div class="layui-card-body ">
                            <table class="layui-table">
                                <tbody>
                                    <tr>
                                        <th>版权所有</th>
                                        <td>***********
                                            <a href="HomePageServlet.shtml" target="_blank">访问官网</a></td>
                                    </tr>
                                    <tr>
                                        <th>开发者</th>
                                        <td>***********</td></tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <style id="welcome_style"></style>
                <div class="layui-col-md12">
                    <blockquote class="layui-elem-quote layui-quote-nm">感谢layui,百度Echarts,jquery,本系统由x-admin提供技术支持。</blockquote></div>
            </div>
        </div>
        </div>
    </body>
</html>