<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>收银台</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="shortcut icon" href="homeimage/favicon.ico" />
	<!-- 引入jquery -->
	<script src="js/jquery-1.8.3.js"></script>

	<!-- 图片导航 -->
	<div style="width: 1200px;margin: 20px auto;">
    	<img src="homeimage/cashier/t.png" alt="" />
    </div>
    <!-- 订单内容 -->
    <div style="width: 1200px;margin: 20px auto; color: #999999;" class="ready-go">
    	<c:if test="${sessionScope.inLi == null }" var="ok">
    		<h4>订单号:${sessionScope.indent.id }</h4>
	    	<c:forEach items="${sessionScope.indent.indentDetailLi }" var="i">
	    	<p>商品名称：${i.colorAndConfigure.commodity.cName}</p>
	    	<p>商品配置：${i.colorAndConfigure.configure.cName}&nbsp;${i.colorAndConfigure.color.cName}</p>
	    	</c:forEach>
	    	<p style="line-height: 40px; font-size: 20px;">邮递地址：${sessionScope.indent.address.country }&nbsp;&nbsp;&nbsp;&nbsp;${sessionScope.indent.address.detail }&nbsp;&nbsp;&nbsp;&nbsp;${sessionScope.indent.address.phone }&nbsp;&nbsp;&nbsp;&nbsp;${sessionScope.indent.address.aName }</p>
	   		<button class="confirm-fukuan">确认支付</button>
	   		<input type="hidden" name="hidindentid" value="${sessionScope.indent.id }" />
    	</c:if>
    	<c:if test="${not ok }">
    		<c:forEach items="${sessionScope.inLi }" var="in">
    			<h4>订单号:${in.id }</h4>
		    	<c:forEach items="${in.indentDetailLi }" var="i">
		    	<p>商品名称：${i.colorAndConfigure.commodity.cName}</p>
		    	<p>商品配置：${i.colorAndConfigure.configure.cName}&nbsp;${i.colorAndConfigure.color.cName}</p>
		    	</c:forEach>
		    	<p style="line-height: 40px; font-size: 20px;">邮递地址：${in.address.country }&nbsp;&nbsp;&nbsp;&nbsp;${in.address.detail }&nbsp;&nbsp;&nbsp;&nbsp;${in.address.phone }&nbsp;&nbsp;&nbsp;&nbsp;${in.address.aName }</p>
		   		
    		</c:forEach>
    		<button class="confirm-fukuanall">确认支付</button>
		   	<input type="hidden" name="hidindentid" value="${sessionScope.togoIntends}" />
    	</c:if>
    </div>
    <script>
    	$(function(){
    		$('.confirm-fukuan').click(function(){
    			$.ajax({
    				url : 'ConfirmServlet.shtml',
    				type : 'post',
    				data : {'action':'cashier','indentId':$('[name=hidindentid]').val()},
    				success : function(result){
    					if(result == 'true'){
    						alert('支付成功！');
    						location.href = 'HomePageServlet.shtml';
    					}else{
    						alert('支付失败！');
    					}
    				}
    			});
    		});
    		$('.confirm-fukuanall').click(function(){
    			$.ajax({
    				url : 'ConfirmServlet.shtml',
    				type : 'post',
    				data : {'action':'allCashier','indentId':$('[name=hidindentid]').val()},
    				success : function(result){
    					if(result == 'true'){
    						alert('支付成功！');
    						location.href = 'HomePageServlet.shtml';
    					}else{
    						alert('支付失败！');
    					}
    				}
    			});
    		});
    	});
    </script>
    <div style="width: 1200px;margin: 20px auto;">
    	<img src="homeimage/cashier/f.png" alt="" />
    </div>
  </body>
</html>
