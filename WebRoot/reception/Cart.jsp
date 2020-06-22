<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>我的购物车</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="shortcut icon" href="homeimage/favicon.ico" />
	<!-- 引入全局css样式  -->
	<link rel="stylesheet" type="text/css" href="css/data.css?_=<%=new Date().getTime()%>">
	<!-- 引入头部css样式 -->
	<link rel="stylesheet" type="text/css" href="css/head.css?_=<%=new Date().getTime()%>">
	<!-- 引入footcss样式 -->
	<link rel="stylesheet" type="text/css" href="css/foot.css?_=<%=new Date().getTime()%>">
	<!-- 引入detail样式 -->
	<link rel="stylesheet" type="text/css" href="css/cart.css?_=<%=new Date().getTime()%>">
	<!-- 引入jquery -->
	<script src="js/jquery-1.8.3.js"></script>
	<!-- 引入导航栏navjs -->
	<script src="js/nav.js"></script>
	<!-- 引入cart -->
	<script src="js/cart.js"></script>
  </head>
  
  <body>
  		<!-- 导航 -->
		<div class="shortcut">
			<input type="hidden" value="true" name="hidCartOrConfirm" />
			<div class="layout">
				<ul class="fl">
					<li><a href="HomePageServlet.shtml">首页</a></li>
					<li><a href="javascript:;">华为官网</a></li>
					<li><a href="javascript:;">荣耀官网</a></li>
					<li><a href="javascript:;">花粉俱乐部</a></li>
					<li><a href="javascript:;">V码(优购码)</a></li>
					<li><a href="javascript:;">企业购</a></li>
					<li><a href="javascript:;">Select Region</a></li>
					<li class="icon-li"><a href="javascript:;"
						class="icon-dropdown">更多精彩</a></li>
				</ul>
				<ul class="fr">
					<c:if test="${sessionScope.huser eq null }" var="ok">
					<li class="qing-deng"><a class="icon-dropdown" href="javascript:;">请登录</a></li>
					<li><a href="javascript:;">注册</a></li>
					</c:if>
					<c:if test="${not ok }">
					<li class="huser-hid"><a class="icon-dropdown" href="javascript:;">${sessionScope.huser.phone }</a>
						<div class="dropdown-i-mall" >
							<div class="drop-t-m after">
								<div class="drop-l fl">
									<a href="javascript:;">
										<img src="homeimage/${sessionScope.huser.photo }" alt="" />
									</a>
								</div>
								<div class="drop-r fl">
									<div class="jindu">
										<em></em>
										<p></p>
									</div>
									<div class="xiaoxi">
										<a class="wei-shi-m" href="javascript:;">未实名</a>
										<a class="xiao-x" href="javascript:;">消息(12)</a>
									</div>
								</div>
								<div class="drop-b fl">
									<h6 class="fl">我的订单</h6>
									<a class="fr" href="javascript:;">更多</a>
								</div>
							</div>
							<div class="drop-c-m after">
								<ul class="after">
									<li>
										<a href="javascript:;">待付款</a>
									</li>
									<li>
										<a href="javascript:;">待收货</a>
									</li>
									<li>
										<a href="javascript:;">待评价</a>
									</li>
									<li>
										<a href="javascript:;">退换货</a>
									</li>
									<li>
										<a href="javascript:;">旧机回收</a>
									</li>
								</ul>
								<div class="youhuiq">
									<div class="youhui-qe">
										<a href="javascript:;">
											<p>${sessionScope.huser.total }</p>
											<p>积分</p>
										</a>
										<a href="javascript:;">
											<p>${sessionScope.huser.onsaleCoupon }</p>
											<p>优惠券</p>
										</a>
										<a href="javascript:;">
											<p>${sessionScope.huser.cashCoupon }</p>
											<p>代金券</p>
										</a>
									</div>
								</div>
							</div>
							<div class="drop-b-m">
								<p><a href="HomePageServlet.shtml?active=removeHuser">退出登录</a></p>
							</div>
						</div>
					</li>
					</c:if>
					<li><a href="PersonallyServlet.shtml?hUserId=${sessionScope.huser.id }&statusId=0">我的订单</a></li>
					<li class="icon-li"><a href="javascript:;"
						class="icon-dropdown">客户服务</a></li>
					<li class="icon-li"><a href="javascript:;"
						class="icon-dropdown">网站导航</a></li>
					<li class="icon-li"><a href="javascript:;"
						class="icon-dropdown">手机版</a></li>
				</ul>
			</div>
		</div>
    	<!-- 购物车导航 -->
    	<div class="cart-nav">
    		<div class="cart-content after">
    			<img src="homeimage/cart/nav-cart1.png" alt="" />
    			<h1>我的购物车</h1>
    			<img src="homeimage/cart/nav-cart.png" alt="" />
    		</div>
    	</div>
    	<!-- 购物车内商品内容 -->
    	<div class="cart-list">
    		<div class="cart-title after">
    			<label class="checkbox">
    				<input class="j_cdall" type="checkbox"  value="${huser.id }" />
    				全部选中
    			</label>
    			<ul>
    				<li>商品</li>
    				<li>单价</li>
    				<li>数量</li>
    				<li>小计</li>
    				<li>操作</li>
    			</ul>
    		</div>
    		<div id="j_tb">
    		<c:if test="${sessionScope.scLi eq null }">
	    		<div class="null-commodity">
	    			<h1>购物车是空的</h1>
	    		</div>
    		</c:if>
    		<c:if test="${sessionScope.scLi eq '[]' }">
	    		<div class="null-commodity">
	    			<h1>购物车是空的</h1>
	    		</div>
    		</c:if>
    		<c:if test="${huser == null }">
    			<div class="null-commodity">
	    			<h1>购物车是空的</h1>
	    		</div>
    		</c:if>
    		<c:if test="${huser != null }">
    		<c:forEach items="${sessionScope.scLi }" var="sc">
    		<div class="cart-commodity-content">
    			<div class="cart-commodity after">
    				<c:if test="${sc.checked }" var="ok">
    				<label><input type="checkbox" value="${sc.id }" checked="checked"/></label>
    				</c:if>
    				<c:if test="${not ok}">
    				<label><input type="checkbox" value="${sc.id }"/></label>
    				</c:if>
    				<div class="cart-img fl">
    					<a href="javascript:;" target="_blank">
    						<img src="${sc.colorandConfigure.commodity.image }" alt="" />
    					</a>
    				</div>
    				<ul>
    					<li>
    						<a href="javascript:;">${sc.colorandConfigure.title }</a>
    						<p>${sc.colorandConfigure.color.cName } ${sc.colorandConfigure.configure.cName } ${sc.combo.cName }  </p>
    					</li>
    					<li>
    						<span>￥&nbsp;${sc.colorandConfigure.price }</span>
    					</li>
    					<li>
    						<div class="num-com after">
    							<span class="num-com-subtract" data-shopingcart="${sc.id }">-</span>
    							<span class="num-count">${sc.total }</span>
    							<span class="num-com-add" data-shopingcart="${sc.id }">+</span>
    						</div>
    					</li>
    					<li>
    						<span>￥${sc.totalPrice }</span>
    					</li>
    					<li>
    						<a class="one-delete-a" data-shopingcart="${sc.id }" href="javascript:;">删除</a>
    					</li>
    				</ul>
    			</div>
    			<!-- //判断套餐价格是否为0.0 -->
    			<c:if test="${sc.combo.price != '0.0' }">
    			<div class="cart-combo after">
    				<h1>套餐:${sc.combo.cName }</h1>
    				<c:forEach items="${sc.combo.commodityLi}" var="cl" varStatus="status">
    				<ul>
    					<li>
    						<a href="javascript:;">
    							<img src="${cl.image}" alt="" />
    						</a>
    						<a class="title-c" href="javascript:;">${cl.colorandConfigure.title }</a>
    					</li>
    					<li>
    						<span class="yuanjia">￥&nbsp;${cl.colorandConfigure.price }</span>
    					</li>
    					<li>x 1</li>
    					<c:if test="${status.count <=1 }">
    					<li><span>￥${sc.combo.price }</span></li>
    					</c:if>
    				</ul>
    				</c:forEach>
    			</div>
    			</c:if>
    		</div>
    		</c:forEach>
    		</c:if>
    		</div>
    		<form id="goConfirmForm" action="ConfirmServlet.shtml" method="post">
    			<input type="hidden" value="${huser.id }" name="hidhuser" />
    		</form>
    		<div class="goback after">
    			<label class="fl checked_all"><input class="j_cdall" value="${huser.id }" type="checkbox" /><a class="all-check" href="javascript:;">全选</a><a class="delete-all" href="javascript:;">删除</a></label>
    			<div class="fr">
    				<div class="cart-detail fl">
    					<p>
    						<label>共计:</label>
    						<span class="totalPrice">￥&nbsp;${huser.totalPrice }</span>
    					</p>
    					<div class="yun">
    						<p>已选择<em class="totalChecked">${huser.totalCheck }</em>件,优惠<span class="youPrice">￥&nbsp;${huser.youPrice }</span></p>
    					</div>
    				</div>
    				<div class="go fr">
    					<a class="goSettlement" href="javascript:;">立即结算</a>
    				</div>
    			</div>
    		</div>
    	</div>
    	<!-- foot脚部 -->
		<div class="service-container">
			<div class="slogan-container">
				<div>
					<ul class="after">
						<li class="s1">
							<a href="javascript:;">
								<i></i>
								百强企业 品质保证
							</a>
						</li>
						<li class="s2">
							<a href="javascript:;">
								<i></i>
								7天退货 15天换货
							</a>
						</li>
						<li class="s3">
							<a href="javascript:;">
								<i></i>
								48元起免运费
							</a>
						</li>
						<li class="s4">
							<a href="javascript:;">
								<i></i>
								1000家维修网点 全国联保
							</a>
						</li>
					</ul>
				</div>
			</div>
			<div class="service after">
				<div class="fl service-d1 after">
					<dl class="service-d1-dl">
						<dt>购物相关</dt>
						<dd>购物指南</dd>
						<dd>配送方式</dd>
						<dd>支付方式</dd>
						<dd>常见问题</dd>
					</dl>
					<dl>
						<dt>保修与退换货</dt>
						<dd>保修政策</dd>
						<dd>退换货政策</dd>
						<dd>退换货流程</dd>
						<dd>保修状态查询</dd>
						<dd>配件防伪查询</dd>
					</dl>
					<dl>
						<dt>维修与技术支持</dt>
						<dd>售后网点</dd>
						<dd>预约维修</dd>
						<dd>手机寄修</dd>
						<dd>备件价格查询</dd>
						<dd>上门服务</dd>
					</dl>
					<dl>
						<dt>特色服务</dt>
						<dd>防伪查询</dd>
						<dd>补购保障</dd>
						<dd>以旧换新</dd>
						<dd>礼品包装</dd>
					</dl>
					<dl>
						<dt>关于我们</dt>
						<dd>公司介绍</dd>
						<dd>华为商城简介</dd>
						<dd>华为零售店</dd>
						<dd>荣耀零售店</dd>
						<dd>意见反馈</dd>
					</dl>
					<dl>
						<dt>友情链接</dt>
						<dd>华为集团</dd>
						<dd>华为CBG官网</dd>
						<dd>荣耀官网</dd>
						<dd>花粉俱乐部</dd>
						<dd>华为云</dd>
					</dl>
				</div>
				<div class="fr service-d2">
					<dl>
						<dt>950805</dt>
						<dd class="title-s">7x24小时客服热线（仅收市话费）</dd>
						<dd class="title-q">
							<a href="javascript:;">
								<i></i>
								在线客服
							</a>
						</dd>
						<dd class="title-w">
							<div class="after">
								<span class="fl" style="font-size: 14px;line-height:26px; color: #333333;">关注Vmall：</span>
								<a class="title-w-a1" href="javascript:;"></a>
								<a class="title-w-a2" href="javascript:;"></a>
								<a class="title-w-a3" href="javascript:;"></a>
								<a class="title-w-a4" href="javascript:;"></a>
							</div>
						</dd>
					</dl>
				</div>
			</div>
			<div class="footer-container after">
				<p class="fl">
					<a href="javascript:;">
						<img src="homeimage/foot-ico.png" alt="" style="width: 82px" />
					</a>
				</p>
				<div class="fl fotter-fl2">
					<ul class="after">
						<li>
							<a href="javascript:;">华为集团</a>
						</li>
						<em>|</em>
						<li>
							<a href="javascript:;">华为CBG官网</a>
						</li>
						<em>|</em>
						<li>
							<a href="javascript:;">荣耀官网</a>
						</li>
						<em>|</em>
						<li>
							<a href="javascript:;">花粉俱乐部</a>
						</li>
						<em>|</em>
						<li>
							<a href="javascript:;">华为应用市场</a>
						</li>
						<em>|</em>
						<li>
							<a href="javascript:;">EMUI</a>
						</li>
						<em>|</em>
						<li>
							<a href="javascript:;">华为终端云空间</a>
						</li>
						<em>|</em>
						<li>
							<a href="javascript:;">开发者联盟</a>
						</li>
						<em>|</em>
						<li>
							<a href="javascript:;">华为商城手机版</a>
						</li>
						<em>|</em>
						<li>
							<a href="javascript:;">网站地图</a>
						</li>
					</ul>
					<p>
						<a href="javascript:;">隐私声明</a>
						<a href="javascript:;">服务协议</a>
						<a href="javascript:;">COOKIES</a>
						<a href="javascript:;">Copyright © 2012-2020 华为终端有限公司 版权所有 粤ICP备19015064号</a>
						<a href="javascript:;">粤公网安备 44190002003939号增值电信业务经营许可证：粤B2-20190762</a>
						<a href="javascript:;">备案主体编号：44201919072182</a>
					</p>
				</div>
				<div class="fr">
					<a href="javascript:;"><img src="homeimage/foot-ico2.png" alt="" /></a>
				</div>
			</div>
		</div>
  </body>
</html>
