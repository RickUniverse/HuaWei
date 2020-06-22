<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">

<c:choose>
	<c:when test="${sessionScope.that eq 'category' }">
		<title>华为--${sessionScope.category.sName }</title>
	</c:when>
	<c:when test="${sessionScope.that eq 'series' }">
		<title>华为--${sessionScope.series.category.sName }--${sessionScope.series.sName }</title>
	</c:when>
	<c:when test="${sessionScope.that eq 'cNames'}">
	<title>华为--"${sessionScope.cName }"</title>
    </c:when>
	<c:otherwise>
		<title>华为--商品搜索</title>
	</c:otherwise>
</c:choose>

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
	<!-- 引入list样式 -->
	<link rel="stylesheet" type="text/css" href="css/list.css?_=<%=new Date().getTime()%>">
	<!-- 引入jquery -->
	<script src="js/jquery-1.8.3.js"></script>
	<!-- 引入list。js -->
	<script src="js/list.js"></script>
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
		<div class="bottom-var" style="background-color: #ffffff;">
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
							
							<input type="text" maxlength="200" name="commodityName"  value="${param.commodityName }" class="search-so" id="search-so" /> 
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
  		<!-- list导航 -->
    	<div class="breadcrumb-area">
    		<p>
    			<a href="HomePageServlet.shtml">首页</a>
    			<span></span>
    			<c:if test="${sessionScope.category.id eq null}" var="ok">
    			<a href="ListSearchServlet.html?hidCategory=1">全部</a>
    			</c:if>
    			<c:if test="${not ok }">
    			<a href="ListSearchServlet.html?hidCategory=${sessionScope.category.id }">全部</a>
    			</c:if>
    			<c:choose>
    				<c:when test="${sessionScope.that eq 'cNames'}">
    				<span></span>
	    			<a class="data_cNames" href="javascript:;">${sessionScope.cName }</a>
    				</c:when>
    			
	    			<c:when test="${sessionScope.that eq 'category' }">
	    			<span></span>
	    			<a class="hidCategory" data-categorys="${sessionScope.category.id }" href="ListSearchServlet.html?hidCategory=${sessionScope.category.id }">${sessionScope.category.sName }</a>
	    			</c:when>
	    			
	    			<c:when test="${sessionScope.that eq 'series' }">
	    			<span></span>
	    			<a class="hidCategory" data-categorys="${sessionScope.series.category.id }" href="ListSearchServlet.html?hidCategory=${sessionScope.series.category.id }">${sessionScope.series.category.sName }</a>
	    			<span></span>
	    			<a class="hidSeries" data-seriess="${sessionScope.series.id }" href="ListSearchServlet.html?hidCategory=${sessionScope.category.id }&hidSeries=${sessionScope.series.id }">${sessionScope.series.sName }</a>
	    			</c:when>
	    			<c:otherwise>
				    </c:otherwise>
    			</c:choose>
    		</p>
    	</div>
 		<div class="layout-list-search">
 			<p>
 				<span>分类：</span>
 				<c:choose>
    				<c:when test="${sessionScope.that eq 'cNames'}">
    				<span></span>
	    			<a class="data_cNames" href="javascript:;">${sessionScope.cName }</a>
    				</c:when>
    			
	    			<c:when test="${sessionScope.that eq 'category' }">
	    			<span></span>
	    			<a class="hidCategory" data-categorys="${sessionScope.category.id }" href="ListSearchServlet.html?hidCategory=${sessionScope.category.id }">${sessionScope.category.sName }</a>
	    			</c:when>
	    			
	    			<c:when test="${sessionScope.that eq 'series' }">
	    			<span></span>
	    			<a class="hidCategory" data-categorys="${sessionScope.series.category.id }" href="ListSearchServlet.html?hidCategory=${sessionScope.series.category.id }">${sessionScope.series.category.sName }</a>
	    			<span></span>
	    			<a class="hidSeries" data-seriess="${sessionScope.series.id }" href="ListSearchServlet.html?hidCategory=${sessionScope.category.id }&hidSeries=${sessionScope.series.id }">${sessionScope.series.sName }</a>
	    			</c:when>
	    			<c:otherwise>
				    </c:otherwise>
    			</c:choose>
 			</p>
 			<p class="search-price">
 				<span class="price-min-max" data-priceminmax="0-0">价格区间：</span>
 				<a href="javascript:;">0-1000</a>
 				<a href="javascript:;">0-10000000</a>
 				<a href="javascript:;">1000-3000</a>
 				<a href="javascript:;">2000-3000</a>
 				<a href="javascript:;">3000-4000</a>
 				<a href="javascript:;">5000-6000</a>
 				<a href="javascript:;">7000-8000</a>
 				<a href="javascript:;">8000-100000</a>
 			</p>
 			<c:if test="${sessionScope.conLi != '[]' }">
 			<p class="last-p">
 				<span class="configure-ids" data-configures="0">配置：</span>
 				<c:forEach items="${sessionScope.conLi }" var="con">
 				<a data-configure="${con.id }" href="javascript:;">${con.cName }</a>
 				</c:forEach>
 			</p>
 			</c:if>
 		</div>
  		<div class="channel-list-search">
  			<ul class="after weiyi">
  				<c:if test="${sessionScope.cconfiLi eq '[]' }">
  				<h1 style="font-size: 60px;color: #999999;text-align: center;line-height: 200px">暂无该商品</h1>
  				</c:if>
  				<c:forEach items="${sessionScope.cconfiLi }" var="c">
  				<li>
  					<a href="DetailServlet.shtml?colorandConfigureId=${c.id }">
  						<div>
  							<img src="${c.commodity.image }" alt="" />
  						</div>
  						<span class="search-name">${c.commodity.cName }</span>
  						<span class="search-price">￥${c.price }</span>
  						<span class="search-promotion">${c.promotion.title }</span>
  						<span class="search-tit">${c.title }</span>
  					</a>
  				</li>
  				</c:forEach>
  			</ul>
  		</div>
 		<div class="page-box">
 			<ul class="after page-quan-a" data-pageNo="1">
 				<a class="hidPage" onclick="getPage(1)" href="javascript:;">
 					<li>首页</li>
 				</a>
 				<a class="hidPage" onclick="getPage(${sessionScope.pageBean.prevPage})" href="javascript:;">
 					<li>上一页</li>
 				</a>
 				<c:forEach begin="1" end="${sessionScope.pageBean.totalPage}" var="i">
	 			<a class="hidPage hidPage-number" onclick="getPage(${i})" href="javascript:;">
	 				<li>${i}</li>
	 			</a>
	 			</c:forEach>
 				<a class="hidPage" onclick="getPage(${sessionScope.pageBean.nextPage})" href="javascript:;">
 					<li>下一页</li>
 				</a>
 				<a class="hidPage" onclick="getPage(${sessionScope.pageBean.totalPage})" href="javascript:;">
 					<li>末页</li>
 				</a>
 				<a class="hidPage" href="javascript:;">
 					<li>总页数：${sessionScope.pageBean.totalPage}； 当前页：${sessionScope.pageBean.pageNo}； 总条数：${sessionScope.pageBean.totalCount}； 上一页：${sessionScope.pageBean.prevPage}； 下一页：${sessionScope.pageBean.nextPage}</li>
 				</a>
 			</ul>
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
