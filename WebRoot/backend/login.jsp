<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>华为-管理登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="shortcut icon" href="homeimage/favicon.ico" />
	<!-- 引入样式 -->
	<link rel="stylesheet" type="text/css" href="backcss/font.css">
	<link rel="stylesheet" type="text/css" href="backcss/xadmin.css">
	<link rel="stylesheet" href="backcss/login.css">
	<link rel="stylesheet" type="text/css" href="lib/layui/css/layui.css">
	<!-- 引入layui -->
	<script src="lib/layui/layui.js" charset="utf-8"></script>
	<!-- 引入xadmin -->
	<script type="text/javascript" src="backjs/xadmin.js"></script>
	<script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
	<script src="lib/layui/layui.js" charset="utf-8"></script>

  </head>
  
<body class="login-bg">
    
    <div class="login layui-anim layui-anim-up">
        <div class="message">华为-管理登录</div>
        <div id="darkbannerwrap"></div>
        
        <form method="post" action="AdminIndexServlet.shtml" class="layui-form" >
            <input name="username" placeholder="管理员名"  type="text" lay-verify="required" class="layui-input" >
            <hr class="hr15">
            <input name="password" lay-verify="required" placeholder="密码"  type="password" class="layui-input">
            <hr class="hr15">
            <input value="登录" lay-submit lay-filter="login" style="width:100%;" type="submit" name="login">
            <hr class="hr20" >
        </form>
    </div>
	<script>
		$(function(){
			$('[name=login]').click(function(){
				if($('[name=username]').val()==''){
					alert('管理员名不能为空！')
					return false;
				}else if($('[name=password]').val()==''){
					alert('密码不能为空！')
					return false;
				}
				$.ajax({
						url : 'AdminLoginServlet.shtml',
						type : 'post',
						data : {'aName':$('[name=username]').val(),'aPassword':$('[name=password]').val()},
						success : function(result){
							if(result=='true'){
								location.href = "AdminIndexServlet.shtml";
							}else{
								alert('管理员名或密码错误！');
								return false;
							}
						}
					});
					return false;
			});
		})
	</script>
</body>
</html>
