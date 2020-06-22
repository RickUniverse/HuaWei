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
    
    <title>确认订单华为商城</title>
    
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
	<!-- 引入confirm样式 -->
	<link rel="stylesheet" type="text/css" href="css/confirm.css?_=<%=new Date().getTime()%>">
	<!-- 引入jquery -->
	<script src="js/jquery-1.8.3.js"></script>
	<!-- 引入confirm -->
	<script src="js/confirm.js"></script>
	<!-- 引入导航栏navjs -->
	<script src="js/nav.js"></script>
  </head>
  
  <body>
  		<!-- 导航 -->
		<div class="shortcut">
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
					<li><a target="_Blank" href="CartServlet.shtml?hidhuser=${sessionScope.huser.id }" class="l-shop-cart">购物车</a></li>
				</ul>
			</div>
		</div>
    	<!-- 购物车导航 -->
    	<div class="cart-nav">
    		<div class="cart-content after">
    			<img src="homeimage/cart/nav-cart1.png" alt="" />
    			<h1>确认订单</h1>
    			<img src="homeimage/cart/nav-cart2.png" alt="" />
    		</div>
    	</div>
    	<!-- 地址 -->
    	<div class="address-box after">
    		<h2>收货地址</h2>
    		<ul><!-- 河北&nbsp;邯郸 &nbsp;肥乡县&nbsp; 屯庄营乡&nbsp; 吕莹收件点 -->
    			<c:forEach items="${sessionScope.huser.addressLi }" var="a" varStatus="status">
    			<c:if test="${a.id == sessionScope.huser.defaultAddress }" var="oke">
    			<li data-address-id="${a.id }" class="back-address">
    			</c:if>
    			<c:if test="${not oke }">
    			<li data-address-id="${a.id }"  class="">
    			</c:if>
    				<c:if test="${a.id == sessionScope.huser.defaultAddress }" var="ok">
    				<span class="defule-inline-block">默认地址</span>
    				</c:if>
    				<c:if test="${not ok }">
    				<span class="defule-hide">默认地址</span>
    				</c:if>
    				<div class="now-address">
    					<p class="after">
    						<b>${a.aName }</b>
    						<span>${a.phone }</span>
    					</p>
    					<div class="detail-address">${a.country }&nbsp;${a.detail }</div>
    					<div class="operation">
    						<a href="javascript:;" class="edit-address">编辑</a>
    						<a href="javascript:;" class="remover-address">删除</a>
    						<c:if test="${a.id == sessionScope.huser.defaultAddress }" var="oks">
		    					<a href="javascript:;"  data-address-ids="${a.id }" class="default-address defule-hide">设为默认</a>
		    				</c:if>
		    				<c:if test="${not oks }">
		    					<a href="javascript:;" data-address-ids="${a.id }" class="default-address">设为默认</a>
		    				</c:if>
    					</div>
    				</div>
    			</li>
    			</c:forEach>
    			<li>
    				<a class="add-address-new" href="javascript:;">新增收货地址</a>
    			</li>
    		</ul>
    	</div>
 		<!-- 订单商品内容 -->
 		<div class="indent-box">
 			<div class="commodity-detail-box after">
 				<div class="fl">
 					<div class="order-list-detail">
 					<c:forEach items="${sessionScope.shoppcartLi }" var="sc">
 						<div class="order-main">
 							<div class="after com-ord-m">
 								<div class="cart-img fl">
			    					<a href="javascript:;" target="_blank">
			    						<img src="${sc.colorandConfigure.commodity.image }" alt="" />
			    					</a>
			    				</div>
			    				<ul class="after order-ul fl">
			    					<li>
			    						<a href="javascript:;">${sc.colorandConfigure.title }</a>
			    						<p>${sc.colorandConfigure.configure.cName }&nbsp;${sc.colorandConfigure.color.cName } ${sc.combo.cName }</p>
			    					</li>
			    					<li>
			    						x&nbsp;${sc.total }
			    					</li>
			    					<li>
			    						<span>￥${sc.totalPrice }</span>
			    					</li>
			    				</ul>
 							</div>
		    				<div class="cart-combo after">
			    				<h1>套餐:${sc.combo.cName }</h1>
			    				<c:forEach items="${sc.combo.commodityLi }" var="c">
			    				<ul>
			    					<li>
			    						<a href="javascript:;">
			    							<img src="${c.image }" alt="" />
			    						</a>
			    						<a class="title-c" href="javascript:;">${c.colorandConfigure.title }</a>
			    					</li>
			    					<li>x 1</li>
			    					<li><span>￥${c.colorandConfigure.price }</span></li>
			    				</ul>
			    				</c:forEach>
			    			</div>
 						</div>
 					</c:forEach>
 					</div>
 				</div>
 				<div class="fr detail-yun">
 					<div class="top-detail">
 						<p>商品由<span>华为商城</span>选择合作快递</p>
 						<p>今天付款，预计2025月2日（周六）送达 </p>
 					</div>
 					<div class="bottom-detail">
 						<ul>
 							<li>
 								<strong>商品总金额:</strong>
 								<span>￥${sessionScope.huser.totalPrice }</span>
 							</li>
 							<li>
 								<strong>优惠金额:</strong>
 								<span>-￥${sessionScope.huser.youPrice }</span>
 							</li>
 							<li>
 								<strong>结算金额:</strong>
 								<span class="totalPrice">￥${sessionScope.huser.totalPrice }</span>
 							</li>
 						</ul>
 					</div>
 				</div>
 			</div>
 		</div>
  		<!-- 详细地址确认 -->
  		<div class="address-ready after">
  			<div class="ready-box fr">
  				<p class="price">应付总额：<span>￥${sessionScope.huser.totalPrice }</span></p>
	  			<p class="jifen">可获得积分：<fmt:formatNumber value="${sessionScope.huser.totalPrice % 400 }" type="number" pattern="#"/></p>
	  			<p class="address address-change">配送至：${sessionScope.huser.addredd.country }&nbsp;${sessionScope.huser.addredd.detail }&nbsp;${sessionScope.huser.addredd.aName }&nbsp;${sessionScope.huser.addredd.phone }</p>
	  			<p class="submit add-indent-s">提交订单</p>
  			</div>
  		</div>
  		<!-- from表单 -->
		<form id="addIndentForm" action="ConfirmServlet.shtml?action=addIndent" method="post">
 			<input type="hidden" value="<fmt:formatNumber value="${sessionScope.huser.totalPrice % 400 }" type="number" pattern="#"/>" name="hidintegral" />
 			<input type="hidden" value="${sessionScope.huser.id }" name="hidhuser" />
 			<input type="hidden" value="${sessionScope.huser.totalPrice }" name="hidTotalPrice" />
 			<input type="hidden" value="${sessionScope.huser.defaultAddress }" name="hidaddress" />
 			<input type="hidden" value="${sessionScope.huser.defaultAddress }" name="defaultAddress" />
		</form>
  		<!-- addAddress -->
  		<div class="addAddress-box">
  			
  			<div class="address-content">
  				<h1>-添加地址-</h1>
  				<p>
  					<label>收货人:</label>
  					<input type="text" value="" name="aName" />
  				</p>
  				<p>
  					<label>手机号:</label>
  					<input type="text" value="" name="phone" />
  				</p>
  				<p>
  					<input type="hidden" value="" name="country" />
  				</p>
  				<p>
  					<label for="">收货地址省:</label>
  					<select name="sheng" id="">
  						<option value="1">请选择...</option>
  						<option value="河北省">河北省</option>
  					</select>
  					<label for="">市:</label>
  					<select name="shi" id="">
  						<option value="1">请选择...</option>
  						<option value="邯郸市">邯郸市</option>
  					</select>
  					<label for="">区:</label>
  					<select name="qu" id="">
  						<option value="1">请选择...</option>
  						<option value="肥乡区">肥乡区</option>
  					</select>
  					<label for="">镇:</label>
  					<select name="zhen" id="">
  						<option value="1">请选择...</option>
  						<option value="旧店乡">旧店乡</option>
  					</select>
  				</p>
  				<p>
  					<label>详细地址:</label>
  					<input type="text" value="" name="detail" />
  				</p>
  				<p>
  					<a class="cancel-add" href="javascript:;">取消</a>
  					<a class="add-address" href="javascript:;">保存地址</a>
  				</p>
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
