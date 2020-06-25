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

<title>华为商城（VMALL.COM）_华为手机、荣耀手机、官网正品保障</title>

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
<!-- 引入bodycss样式 -->
<link rel="stylesheet" type="text/css" href="css/body.css?_=<%=new Date().getTime()%>">
<!-- 引入footcss样式 -->
<link rel="stylesheet" type="text/css" href="css/foot.css?_=<%=new Date().getTime()%>">
<!-- 自定animate -->
<script src="js/animate.js"></script>
<!-- 引入头部js -->
<script src="js/head.js"></script>
<!-- 引入导航栏navjs -->
<script src="js/nav.js"></script>
<!-- 引入jquery -->
<script src="js/jquery-1.8.3.js"></script>
</head>

<body style="overflow-x: hidden;">
	<!-- 头部 -->
	<!-- 顶部广告 -->
	<div class="top-banner">
		<div class="banner-img">
			<!-- div[class=qq]*1 -->
			<a href="javascript:;" class="top-a"> <img
				src="homeimage/top_banner.jpg" alt="" />
			</a> <a href="javascript:;" class="button-banner-close"></a>
		</div>
	</div>
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
	<div class="bottom-var">
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
						<input type="submit" class="search-sub" />
						<div class="search-cont"><!-- ListSearchServlet.html?commodityName=P40 ListSearchServlet.html?commodityName=荣耀30系列-->
							<a href="javascript:;"> 荣     </a> <a href="javascript:;"> 荣耀30系列     </a>
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
	<!-- focus轮播 -->
	<div class="slider">
		<div class="focus">
			<div class="focus-box">
				<div class="arrow">
					<a href="javascript:;" class="arrow-l"></a> <a href="javascript:;"
						class="arrow-r"></a>
				</div>
				<ul class="after focus-ul">
					<c:forEach items="${sessionScope.carLi }" var="cli" varStatus="status">
					<c:if test="${status.count == 1 }" var="ok">
						<c:if test="${fn:length(cli.href) > 7}" var="okk">
							<li style="z-index:1;"><a href="${cli.href }"><img
									src="${cli.image }" alt="" /></a>
							</li>
						</c:if>
						<c:if test="${not okk }">
							<li style="z-index:1;"><a href="DetailServlet.shtml?colorandConfigureId=${cli.colorandconfigureId }"><img
									src="${cli.image }" alt="" /></a>
							</li>
						</c:if>
					</c:if>
					<c:if test="${not ok }">
						<c:if test="${fn:length(cli.href) > 7}" var="okk">
							<li><a href="${cli.href }"><img
								src="${cli.image }" alt="" /></a>
							</li>
						</c:if>
						<c:if test="${not okk }">
							<li><a href="DetailServlet.shtml?colorandConfigureId=${cli.colorandconfigureId }"><img
								src="${cli.image }" alt="" /></a>
							</li>
						</c:if>
					</c:if>
					</c:forEach>
				</ul>
				<ol class="after circle"></ol>
			</div>
			<!-- category -->
			<form id="form" action="ListSearchServlet.html" method="post" target="_blank">
				<input type="hidden" name="hidCategory" value="" id="hidCategory" />
				<input type="hidden" name="hidSeries" value="" id="hidSeries" />
				<input type="hidden" name="max" value="100000000" id="hidMaxPrice" /><!-- 默认价格无限 -->
			</form>
			<script>
				var form = document.getElementById('form');
				function getCategory(val){
					document.getElementById('hidCategory').value = val;
					document.getElementById('hidSeries').value = "";
					form.submit();
				}
				function getSeries(val){
					document.getElementById('hidSeries').value = val;
					document.getElementById('hidCategory').value = "";
					form.submit();
				}
			</script>
			<div class="focus-category">
				<ul class="focus-category-one-ul">
					<c:forEach items="${sessionScope.omli }" var="om"
						varStatus="status">
						<a href="javascript:;" class="focus-category-a"
							data-category-index="${status.count }">
							<li class="focus-category-li">${om.category.sName }</li>
						</a>
					</c:forEach>
					<c:forEach items="${sessionScope.omli  }" var="om">
						<div class="category-two cate-${om.categoryId}">
							<ul class="category-ul">
								<c:forEach items="${om.liSeries }" var="lis">
									<a onclick="getSeries(${lis.id })" href="javascript:;" class="category-ul-a">
										<li><img src="${lis.image }" alt="" />
											<p>${lis.sName }</p></li>
									</a>
								</c:forEach>
							</ul>
							<a onclick="getCategory(${om.categoryId })" class="category-a" href="javascript:;">查看全部</a>
						</div>
					</c:forEach>
					<script>
				  	var category_one = document.querySelectorAll('.focus-category-a');
					var category_two = document.querySelectorAll('.category-two');
					for(var i = 0; i < category_one.length; i++){
						category_one[i].addEventListener('mouseenter', function(e) {
							var index = this.getAttribute('data-category-index')-1;
							category_two[index].style.display = 'block';
							
							category_two[index].addEventListener('mouseleave', function(e) {
								this.style.display = 'none';
							});
						});
						category_one[i].addEventListener('mouseleave', function(e) {
							var index = this.getAttribute('data-category-index')-1;
							category_two[index].style.display = 'none';
						});
					}
					for(var i = 0; i < category_two.length; i++){
						category_two[i].addEventListener('mouseenter', function(e) {
							this.style.display = 'block';
						})
						category_two[i].addEventListener('mouseleave', function(e) {
							this.style.display = 'none';
						})
					}
				  </script>
					
			</div>
		</div>

	</div>
	<!-- body身体部分 -->
	<div class="home-promo">
		<div class="home-channel-main">
						<ul class="channel-ul after">
							<li class="channel-left-li">
								<div class="channel-con-div">
									<div class="fl">
										<a href="javascript:;"> <img src="homeimage/logged.png"
											alt="" />
										</a>
									</div>
									<div class="fr">
										<div class="channel-nih">
											<c:if test="${sessionScope.huser eq '[]' }" var="ok">
											你好！ <span>请登录...</span> 。
											</c:if>
											<c:if test="${not ok }">
											你好！ <span>${sessionScope.huser.phone}</span> 。
											</c:if>
										</div>
										<div class="channel-a-to">
											<a class="xin" href="javascript:;">新人福利</a> <a class="hui"
												href="javascript:;">会员频道</a>
										</div>
									</div>
								</div>
							</li>
							<li class="channel-cent-li">
								<ul class="channel-cen-ul after">
									<a href="javascript:;">
										<li>
											<div class="channel-cen-img"></div>
											<div class="channel-cen-title">企业特惠</div>
									</li>
									</a>
									<a href="javascript:;">
										<li>
											<div class="channel-cen-img"></div>
											<div class="channel-cen-title">会员领券</div>
									</li>
									</a>
									<a href="javascript:;">
										<li>
											<div class="channel-cen-img"></div>
											<div class="channel-cen-title">以旧换新</div>
									</li>
									</a>
									<a href="javascript:;">
										<li>
											<div class="channel-cen-img"></div>
											<div class="channel-cen-title">华为P40系列</div>
									</li>
									</a>
									<a href="javascript:;">
										<li>
											<div class="channel-cen-img"></div>
											<div class="channel-cen-title">特惠预定</div>
									</li>
									</a>
									<a href="javascript:;">
										<li>
											<div class="channel-cen-img"></div>
											<div class="channel-cen-title">华为数码</div>
									</li>
									</a>
								</ul> <script>
								var channel_img = document.querySelectorAll('.channel-cen-img');
								var sum = 0;
								for(var i = 0; i < channel_img.length; i++){
									channel_img[i].style.backgroundPositionX = '-'+sum+'px';
									sum+=40;
								}
							</script>
							</li>
							<li class="channel-right-li">
								<div class="ri-top">
									<span>公告:</span> <a href="javascript:;">HUAWEI nova 7
										系列5G新品预约发布会公告</a>
								</div>
								<div class="ri-bottom">
									<a href="javascript:;" class="ri-bottom-a1">优购码</a> <a
										href="javascript:;" class="ri-bottom-a2">更换电池</a> <a
										href="javascript:;" class="ri-bottom-a3">补够保障</a>
								</div>
							</li>
						</ul>
					</div>
			
		<a href="javascript:;" class="promo-a-i"> 
			<img src="homeimage/promo/1.png" alt="" />
		</a> 
		<a href="javascript:;" class="promo-a-i">
		 	<img src="homeimage/promo/2.png" alt="" />
		</a> 
		<a href="javascript:;" class="promo-a-i"> 
			<img src="homeimage/promo/3.jpg" alt="" />
		</a> 
		<a href="javascript:;" class="promo-a-i"> 
			<img src="homeimage/promo/4.jpg" alt="" />
		</a>
		<div class="channel-background">
			<div class="fl"></div>
			<div class="fr"></div>
		</div>
	</div>
	<!-- 楼层 -->
	<div>
		<c:forEach items="${sessionScope.fLi }" var="f">
			<div class="home-channel-floor after">
				<div class="h after">
					<h2 class="fl">${f.category.sName }</h2>
					<ul class="fl">
						<c:forEach items="${f.liSeries }" var="s" varStatus="status">
							<li><a target="_Blank" href="ListSearchServlet.html?hidSeries=${s.id }">${s.sName }</a></li>
						</c:forEach>
					</ul>
					<div class="fr">
						<a target="_Blank" href="ListSearchServlet.html?hidSeries=0&hidCategory=${f.categoryId }">查看更多</a>
					</div>
				</div>
				<div class="home-channel-floor-box">
					<c:forEach items="${f.liColorandConfigure }" var="c" varStatus="status">
						<c:if test="${status.count eq 1 }" var="ok">
							<div class="a fl">
								<ul>
									<li><a target="_Blank" href="DetailServlet.shtml?colorandConfigureId=${c.id }"> <img src="${c.commodity.image }"
											alt="" style="width: 230px;height: 290px;" />
									</a></li>
								</ul>
							</div>
						</c:if>
						<c:if test="${not ok }">
							<div class="b">
								<ul>
									<li><a target="_Blank" href="DetailServlet.shtml?colorandConfigureId=${c.id }">
											<div>
												<p>
													<img src="${c.commodity.image }" alt="" />
												</p>
											</div>
											<p class="fl-tit">${c.commodity.cName }</p>
											<p class="fl-desc">${c.promotion.title }</p>
											<p class="fl-price">¥${c.price }</p>
									</a></li>
								</ul>
							</div>
						</c:if>
					</c:forEach>
				</div>
			</div>
		</c:forEach>
	</div>
	<!-- 底部推广 -->
	<div class="channel-foot-img">
		<a href="javascript:;"><img src="homeimage/foot.jpg" alt="" /></a>
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
