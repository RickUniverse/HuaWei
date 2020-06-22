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
    
    <title>我的订单_个人中心_华为商城</title>
    
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
	<!-- 引入Personally样式 -->
	<link rel="stylesheet" type="text/css" href="css/personally.css?_=<%=new Date().getTime()%>">
	<!-- 引入jquery -->
	<script src="js/jquery-1.8.3.js"></script>
	<!-- 引入personally -->
	<script src="js/personally.js"></script>
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
		<!-- 导航bottom -->
		<div class="bottom-var" style="box-shadow: -10px 5px 10px rgba(125,125,125,.1);">
			<div class="con-box after">
				<div class="fl">
					<div class="ico-img fl">
						<a href="javascript:;"> <img src="homeimage/icon-img.png"
							alt="" />
						</a>
					</div>
					<div class="nav-r fl">
						<ul class="var-img after">
							<li><a href="javascript:;"><img src="homeimage/var-0.png" alt="" /></a>
							</li>
							<li><a href="javascript:;"><img src="homeimage/var-1.png" alt="" /></a>
							</li>
							<li><a href="javascript:;">华为 P40 系列</a></li>
							<li><a href="javascript:;">荣耀30系列</a></li>
							<li><a href="javascript:;">安心居家</a></li>
						</ul>
					</div>
				</div>
				<div class="fr">
					<div class="search-box">
						<form id="search-form" action="ListSearchServlet.html" method="post" class="after">
							<input type="hidden" name="max" value="100000000" id="hidMaxPrice" /><!-- 默认价格无限 -->
							
							<input type="text" maxlength="200" name="commodityName"  value="" class="search-so" id="search-so" /> 
							<input type="submit" value="" class="search-sub" />
							<div class="search-cont"><!-- ListSearchServlet.html?commodityName=P40 ListSearchServlet.html?commodityName=荣耀30系列-->
								<a href="javascript:;"> P40 </a> <a href="javascript:;"> 荣耀30系列 </a>
							</div>
							<script>
								var search_a = document.getElementsByClassName('search-cont')[0].children;
								for(var i = 0; i < search_a.length; i++){
									search_a[i].addEventListener('click', function(e) {
										document.getElementById('search-so').value = this.innerText;
										document.getElementById('search-form').submit();
									});
								}
							</script>
						</form>
					</div>
				</div>
			</div>
		</div>
  		<!-- 顶部导航栏 -->
    	<div class="breadcrumb-area">
    		<p>
    			<a href="HomePageServlet.shtml">首页</a>
    			<span></span>
    			<a href="javascript:;">我的商城</a>
    			<span></span>
    			<a href="javascript:;">个人中心</a>
    		</p>
    	</div>
    	<!-- 全部内容 -->
    	<div class="content-box after">
    		<div class="menu-area fl after">
    			<div class="menu-title">
    				<h6>我的商城</h6>
    			</div>
    			<dl>
    				<dt>我的消息</dt>
    				<dd>
    					<a href="javascript:;">消息中心(24)</a>
    				</dd>
    				<dd>
    					<a href="javascript:;">活动推送</a>
    				</dd>
    			</dl>
    			<dl>
    				<dt>订单中心</dt>
    				<dd>
    					<a style="color: #cf0a2c;" href="javascript:;">我的订单(${sessionScope.huser.totalIndent })</a>
    				</dd>
    				<dd>
    					<a href="javascript:;">我的退换货</a>
    				</dd>
    				<dd>
    					<a href="javascript:;">我的退款</a>
    				</dd>
    				<dd>
    					<a href="javascript:;">我的回收单</a>
    				</dd>
    				<dd>
    					<a href="javascript:;">商品评价</a>
    				</dd>
    			</dl>
    			<dl>
    				<dt>我的资产</dt>
    				<dd>
    					<a href="javascript:;">我的积分</a>
    				</dd>
    				<dd>
    					<a href="javascript:;">我的优惠券</a>
    				</dd>
    				<dd>
    					<a href="javascript:;">我的代金券</a>
    				</dd>
    				<dd>
    					<a href="javascript:;">我的花瓣</a>
    				</dd>
    				<dd>
    					<a href="javascript:;">等级与特权</a>
    				</dd>
    			</dl>
    			<dl>
    				<dt>购买支持</dt>
    				<dd>
    					<a href="javascript:;">收货地址管理</a>
    				</dd>
    				<dd>
    					<a href="javascript:;">实名认证</a>
    				</dd>
    				<dd>
    					<a href="javascript:;">我的预约</a>
    				</dd>
    				<dd>
    					<a href="javascript:;">到货通知</a>
    				</dd>
    				<dd>
    					<a href="javascript:;">我的优享购</a>
    				</dd>
    			</dl>
    			<dl>
    				<dt>
    					<a href="javascript:;">帮助中心</a>
    				</dt>
    			</dl>
    		</div>
    		<!-- 表单提交  -->
    		<form id="persForm" action="PersonallyServlet.shtml" method="post">
    			<input type="hidden" value="${sessionScope.huser.id }" name="hUserId" />
    			<input type="hidden" value="0" name="statusId" />
    			<input type="hidden" value="" name="action" />
    			<input type="hidden" value="" name="stateChick" />
    			<input type="hidden" value="" name="array" />
    			<input type="hidden" value="" name="indentId" />
    			<input type="hidden" value="${sessionScope.page.pageNo }" name="hidPage" />
    		</form>
    		<div class="body-content fr">
    			<div class="con-title">
    				<h6>我的订单</h6>
    			</div>
    			<div class="status-condition">
    				<!-- 隐藏状态 -->
    				<input type="hidden" name="hidStatusId" value="${sessionScope.statusid }" />
    				
    				<c:if test="${sessionScope.statusid == 0}" var="okk">
    				<a onclick="getStatus(0)" class="status-action" href="javascript:;">全部有效订单</a>
    				</c:if>
    				<c:if test="${not okk}">
    				<a onclick="getStatus(0)" href="javascript:;">全部有效订单</a>
    				</c:if>
    				
    				<c:forEach items="${sessionScope.statusli }" var="st">
    				<c:if test="${sessionScope.statusid == st.id}" var="ok">
    				<a class="status-action" onclick="getStatus(${st.id })" href="javascript:;">${st.sName }&nbsp; <span>${st.count }</span></a>
    				</c:if>
    				<c:if test="${not ok}">
    				<a onclick="getStatus(${st.id })" href="javascript:;">${st.sName }&nbsp; <span>${st.count }</span></a>
    				</c:if>
    				</c:forEach>
    			</div>
    			<c:if test="${sessionScope.statusid == 2}">
    			<div class="all-check">
    				<input data-huserid="${sessionScope.huser.id }" class="all_check_input" type="checkbox" />
    				<a href="javascript:;">全选</a>
    				<a class="merge-pay getAllPaying" href="javascript:;">合并支付</a>
    			</div>
    			</c:if>
    			<div class="indent-content">
    				<div class="thead-top">
    					<table>
    						<thead>
    							<tr>
    								<th class="commodity-tit">商品</th>
    								<th class="one-price-tit">单价/元</th>
    								<th class="store-tit">数量</th>
    								<th class="status-tit">状态</th>
    								<th class="yes-money-tit">实付款/元</th>
    								<th class="operate-tit">订单状态及操作</th>
    							</tr>
    						</thead>
    					</table>
    				</div>
    				<div class="list-group">
    					<!-- 订单 -->
    					<c:forEach items="${sessionScope.indentLi }" var="ili">
    					<div class="list-group-item">
    						<div class="in-info">
    							<p>
    								<c:if test="${sessionScope.statusid == 2}">
	    								<c:if test="${ili.checked }" var="ok">
	    								<input data-indentid="${ili.id}" type="checkbox" checked="checked" />
	    								</c:if>
	    								<c:if test="${not ok}">
	    								<input data-indentid="${ili.id}" type="checkbox" />
	    								</c:if>
	    							</c:if>
    								<span>${ili.orderdate}&nbsp;&nbsp;&nbsp;订单号：</span>
    								<a href="javascript:;">${ili.id}</a>
    							</p>
    						</div>
    						<div class="pro">
    							<table>
    								<tr>
    									<td>
    										<div class="o-pro-main">
    											<!-- 商品 -->
    											<c:forEach items="${ili.indentDetailLi }" var="de">
    											<div class="p-main">
    												<div class="p-info">
    													<p>
    														<a href="javascript:;">
    															<img src="${de.colorAndConfigure.commodity.image }"alt="" />
    														</a>
    													</p>
    													<p>
    														<a href="javascript:;">${de.colorAndConfigure.title }</a>
    													</p>
    												</div>
    												<div class="p-price">
    													<span>￥${de.colorAndConfigure.price }</span>
    												</div>
    												<div class="p-quty">${de.total }</div>
    											</div>
    											<!-- 套餐-->
    											<c:forEach items="${de.combo.commodityLi }" var="com">
    											<div class="p-main">
    												<div class="p-info">
    													<p>
    														<a href="javascript:;">
    															<img src="${com.image }" alt="" />
    														</a>
    													</p>
    													<p>
    														<span class="tao-can-du">套餐</span><a href="javascript:;">${com.colorandConfigure.title }</a>
    													</p>
    												</div>
    												<div class="p-price">
    													<span>￥${com.colorandConfigure.price }</span>
    												</div>
    												<div class="p-quty">1</div>
    											</div>
    											</c:forEach>
    										</c:forEach>
    										<!-- 结尾 -->
    										</div>
    										<div class="o-pro-condition">
    											${ili.indentState.sName}
    										</div>
    									</td>
    									<td class="yes-price-ok">
    									<c:if test="${ili.indentState.id == 2 }" var="ok">
    										￥0.00
    									</c:if>
    									<c:if test="${not ok }">
    										￥${ili.payment}
    									</c:if>
    									</td>
    									<td class="action-a">
    									<c:choose>
    										<c:when test="${ili.indentState.id == 2 }">
    											<p>
	    											<a onclick="getIndentId(${ili.id })" class="now-pay-money" href="javascript:;">
	    												<span>立即支付</span>
	    											</a>
	    										</p>
	    										<p>
	    											<a  onclick="getIndentIdNoIndent(${ili.id })" href="javascript:;">
	    												<span>取消订单</span>
	    											</a>
	    										</p>
	    										<p>
	    											<a href="javascript:;">
	    												<span>修改订单</span>
	    											</a>
	    										</p>
	    										<p>
	    											<a href="javascript:;">
	    												<span>订单详情</span>
	    											</a>
	    										</p>
    										</c:when>
    										<c:when test="${ili.indentState.id == 4 }">
    											<p>
	    											<a onclick="getIndentIdDoYes(${ili.id })" class="now-pay-money" href="javascript:;">
	    												<span style="background-color: #5cb85c;">确认收货</span>
	    											</a>
	    										</p>
	    										<p>
	    											<a href="javascript:;">
	    												<span>修改订单</span>
	    											</a>
	    										</p>
	    										<p>
	    											<a href="javascript:;">
	    												<span>订单详情</span>
	    											</a>
	    										</p>
    										</c:when>
    										<c:when test="${ili.indentState.id == 5 }">
    											<p>
	    											<a onclick="getIndentIdDoAppraise(${ili.id })" class="now-pay-money" href="javascript:;">
	    												<span style="background-color: #eb6100;">完成评价</span>
	    											</a>
	    										</p>
	    										<p>
	    											<a href="javascript:;">
	    												<span>订单详情</span>
	    											</a>
	    										</p>
    										</c:when>
    										<c:when test="${ili.indentState.id == 6 }">
	    										<p>
	    											<a href="javascript:;">
	    												<span>订单详情</span>
	    											</a>
	    										</p>
    										</c:when>
    										<c:otherwise>
    											<p>
	    											<a href="javascript:;">
	    												<span>修改订单</span>
	    											</a>
	    										</p>
	    										<p>
	    											<a href="javascript:;">
	    												<span>订单详情</span>
	    											</a>
	    										</p>
    										</c:otherwise>
    									</c:choose>
    									</td>
    								</tr>
    							</table>
    						</div>
    					</div>
    					</c:forEach>
    					
    				</div>
    			</div>
    			<c:if test="${sessionScope.statusid == 2}">
    			<div class="hebing-pay fl">
    				<input data-huserid="${sessionScope.huser.id }" class="all_check_input" type="checkbox" />
    				<span class="all-checked-span">全选</span>
    				<a class="pay-he-e-e getAllPaying" href="javascript:;">合并支付</a>
    			</div>
    			</c:if>
    			<div class="page-box">
    				<ul>
    					<a onclick="getPage(1)" href="javascript:;">
    						<li>首页</li>
    					</a>
    					<a onclick="getPage(${sessionScope.page.prevPage})" href="javascript:;">
    						<li>上一页</li>
    					</a>
    					<c:forEach begin="1" end="${sessionScope.page.totalPage}" var="i">
    					<c:if test="${i == sessionScope.page.pageNo}" var="ok">
    					<a class="pageaction" onclick="getPage(${i})" href="javascript:;">
    						<li>${i}</li>
    					</a>
    					</c:if>
    					<c:if test="${not ok }">
    					<a onclick="getPage(${i})" href="javascript:;">
    						<li>${i}</li>
    					</a>
    					</c:if>
    					</c:forEach>
    					<a onclick="getPage(${sessionScope.page.nextPage})" href="javascript:;">
    						<li>下一页</li>
    					</a>
    					<a onclick="getPage(${sessionScope.page.totalPage})" href="javascript:;">
    						<li>末页</li>
    					</a>
    				</ul>
    			</div>
    		</div>
    	</div>
    	<!-- foot脚部 -->
		<div class="service-container" style="margin-top: 40px;">
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
