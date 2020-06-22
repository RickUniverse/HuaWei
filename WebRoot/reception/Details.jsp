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
    
    <title>${sessionScope.commodity.series.sName }--${sessionScope.commodity.colorandConfigure.title}</title>
    
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
	<link rel="stylesheet" type="text/css" href="css/detail.css?_=<%=new Date().getTime()%>">
	<!-- 引入jquery -->
	<script src="js/jquery-1.8.3.js"></script>
	<!-- 引入animate -->
	<script src="js/animate.js"></script>
	<!-- 引入导航栏navjs -->
	<script src="js/nav.js"></script>
	<!-- 引入list。js -->
	<script src="js/detail.js"></script>
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
	<div class="bottom-var" style="box-shadow: -3px 2px 10px rgba(125,125,125,.1);margin-bottom: 10px;">
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
  		<!-- list导航 -->
    	<div class="breadcrumb-area">
    		<p>
    			<a href="HomePageServlet.shtml">首页</a>
    			<span></span>
    			<a href="ListSearchServlet.html?hidCategory=${sessionScope.commodity.category.id }">${sessionScope.commodity.category.sName }</a>
    			<span></span>
    			<a href="ListSearchServlet.html?hidCategory=${sessionScope.commodity.category.id }&hidSeries=${sessionScope.commodity.series.id }">${sessionScope.commodity.series.sName }</a>
    			<span></span>
    			<a href="javascript:;">${sessionScope.commodity.cName }--${sessionScope.commodity.colorandConfigure.title}</a>
    		</p>
    	</div>
    	<!-- 表单提交 -->
    	<form id="detailForm" action="DetailServlet.shtml?action=hidCul" method="post">
    	<input type="hidden" value="${sessionScope.commodity.colorandConfigure.colorId}" name="hidcolor" />
    	<input type="hidden" value="${sessionScope.commodity.colorandConfigure.configureId}" name="hidconfigureId"  />
    	<input type="hidden" value="${sessionScope.commodity.colorandConfigure.id}" name="prevcolorandConfigureId" />
    	<input type="hidden" value="${sessionScope.commodity.id}" name="hidcommodity"  />
    	<input type="hidden" value="${sessionScope.commodity.comboId}" name="hidcombo"  />
    	
		<input type="hidden" value="1" name="hidtotal"  />
		<input type="hidden" value="${sessionScope.commodity.colorandConfigure.price}" name="hidprice"  />
		<input type="hidden" value="${sessionScope.huser.id}" name="hidhuser"  />
		<input type="hidden" value="addCart" name="action"  />
		<input type="hidden" value="0.0" name="comboprice"  />
    	</form>
    	<!-- 主体 -->
    	<div class="product-details-box after">
    		<div class="show-product fl">
    			<div class="product-img">
    				<div class="show-big-img">
    					<c:if test="${fn:substringBefore(sessionScope.commodity.colorandConfigure.images,';') == ''}" var="okff">
		    				<img src="homeimage/commodity/${sessionScope.commodity.colorandConfigure.images }" alt="" />
	    					<div class="magnifying-glass">
	    						<img src="homeimage/commodity/${sessionScope.commodity.colorandConfigure.images}" alt="" />
	    					</div>
		    			</c:if>
		    			<c:if test="${not okff}">
		    				<img src="homeimage/commodity/${fn:substringBefore(sessionScope.commodity.colorandConfigure.images,';')}" alt="" />
	    					<div class="magnifying-glass">
	    						<img src="homeimage/commodity/${fn:substringBefore(sessionScope.commodity.colorandConfigure.images,';')}" alt="" />
	    					</div>
		    			</c:if>
    					
    					<div class="magnifying-glass-small"></div>
    				</div>
    				<div class="show-small-img after">
    					<a href="javascript:;" class="arrow-l fl"></a>
    					<div class="small-d-box fl">
    						<ul class="after">
    							<c:forTokens items="${sessionScope.commodity.colorandConfigure.images }" delims=";" var="img">
	    						<li><img src="homeimage/commodity/${img }" alt="" /></li>
	    						</c:forTokens>
	    					</ul>
    					</div>
    					<a href="javascript:;" class="arrow-r fl"></a>
    				</div>
    			</div>
    		</div>
    		<div class="details-product fr">
    			<div class="product-title">
    				<h1>${sessionScope.commodity.colorandConfigure.title}</h1>
    			</div>
    			<div class="product-desc">
    				<span>${sessionScope.commodity.colorandConfigure.descs}</span>
    			</div>
    			<div class="product-price-prom">
    				<div class="price after">
    					<label for="">价&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;格</label>
    					<em>¥</em>
    					<span>${sessionScope.commodity.colorandConfigure.price}</span>
    				</div>
    				<div class="prom after">
    					<c:if test="${sessionScope.commodity.colorandConfigure.promotionLi != '[]' }">
    					<label for="">促&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;销</label>
    					<div class="prom-content fl">
    						<c:forEach items="${sessionScope.commodity.colorandConfigure.promotionLi }" var="p">
    						<div class="tit-con after">
    							<em>${p.title }</em>
    							<div class="content">${p.content}</div>
    						</div>
    						</c:forEach>
    					</div>
    					</c:if>
    				</div>
    			</div>
    			<div class="product-stock after" style="display: none;">
    				<label for="">商品库存</label>
    				<div><span class="current-stock">${sessionScope.commodity.colorandConfigure.store}</span><em>件</em></div>
    			</div>
    			<div class="product-stock after">
    				<label for="">上架时间</label>
    				<div>${sessionScope.commodity.putawayTime}</div>
    			</div>
    			<div class="product-id after">
    				<label for="">商品编码</label>
    				<div>${sessionScope.commodity.colorandConfigure.id}</div>
    			</div>
    			<div class="color-configure-combo">
    				<dl class="color after">
    					<label for="">商品颜色${fn:substringBefore(c.images,';') == ''}${c.images}</label>
    					<ul class="after color-xuan-a">
    						<c:forEach items="${sessionScope.commodity.colorLi}" var="c">
	    						<c:if test="${c.exist }" var="ok">
		    						<c:if test="${sessionScope.commodity.colorandConfigure.colorId == c.id}" var="osk">
		    						<li data-color="${c.id }" class="available">
		    							<c:if test="${fn:substringBefore(c.images,';') == ''}" var="tupian">
		    								<img src="homeimage/commodity/${c.images}" alt=""/>
		    							</c:if>
		    							<c:if test="${not tupian}">
		    								<img src="homeimage/commodity/${fn:substringBefore(c.images,';')}" alt=""/>
		    							</c:if>
		    							<p class="currentcolor">${c.cName}</p>
		    						</li>
		    						</c:if>
		    						<c:if test="${not osk }">
		    						<li data-color="${c.id }">
		    							<c:if test="${fn:substringBefore(c.images,';') == ''}" var="tupian">
		    								<img src="homeimage/commodity/${c.images}" alt=""/>
		    							</c:if>
		    							<c:if test="${not tupian}">
		    								<img src="homeimage/commodity/${fn:substringBefore(c.images,';')}" alt=""/>
		    							</c:if>
		    							<p class="currentcolor">${c.cName}</p>
		    						</li>
		    						</c:if>
	    						</c:if>
	    						<c:if test="${not ok }">
	    						<li data-color="${c.id }" class="no-click">
	    							<c:if test="${fn:substringBefore(c.images,';') == ''}" var="tupian">
		    							<img src="homeimage/commodity/${c.images}" alt=""/>
		    						</c:if>
		    						<c:if test="${not tupian}">
		    							<img src="homeimage/commodity/${fn:substringBefore(c.images,';')}" alt=""/>
		    						</c:if>
		    						<p class="currentcolor">${c.cName}</p>
	    						</li>
	    						</c:if>
    						</c:forEach>
    					</ul>
    				</dl>
    				<dl class="configure after">
    					<label for="">选择版本</label>
    					<ul class="after fl configure-all-li">
    						<c:forEach items="${sessionScope.commodity.configureLi}" var="c">
	    						<c:if test="${c.exisit }" var="ok">
	    							<c:if test="${sessionScope.commodity.colorandConfigure.configureId == c.id}" var="osk">
	    							<li data-configure="${c.id }" class="available">${c.cName} <input type="hidden" value="${c.cName}" name="currentconfigure" /> </li>
	    							</c:if>
	    							<c:if test="${not osk}">
	    							<li data-configure="${c.id }">${c.cName} <input type="hidden" value="${c.cName}" name="currentconfigure" /> </li>
	    							</c:if>
	    						</c:if>
	    						<c:if test="${not ok }">
	    						<li data-configure="${c.id }" class="no-click">${c.cName} <input type="hidden" value="${c.cName}" name="currentconfigure" /> </li>
	    						</c:if>
    						</c:forEach>
    					</ul>
    				</dl>
    				<dl class="combo">
    					<label for="">选择套餐</label>
    					<ul class="after combo-ul-all ">
    						<c:forEach items="${sessionScope.commodity.comboLi}" var="c">
    						<c:if test="${sessionScope.commodity.comboId == c.id }" var="okk">
    								<c:set var="action" value="available"></c:set>
    						</c:if>
    						<c:if test="${not okk }">
    								<c:set var="action" value=""></c:set>
    						</c:if>
    						<li class="${action }" data-combo-price="${c.price }" data-combo="${c.id }">${c.cName }
    						<c:if test="${c.price != '0.0' }">
    						<div class="combo-commodity after">
    								<div class="current-commodity current-commodity-di">
    									<img src="${sessionScope.commodity.image}" alt="" width="100px" height="100px" />
    									<span class="name">${sessionScope.commodity.cName}</span>
    									<p>${sessionScope.commodity.colorandConfigure.title}</p>
    								</div>
    								<div class="combo-tit">
    									<h1>当前+</h1>
    								</div>
    								<c:forEach items="${c.commodityLi }" var="cm">
    								<div class="fl current-combo ">
    									<div class="current-commodity">
	    									<img src="${cm.image }" alt="" width="100px" height="100px" />
	    									<span class="name">${cm.cName }</span>
    										<p>${cm.colorandConfigure.title }</p>
    									</div>
    								</div>
    								</c:forEach>
    								<div class="combo-desc">
    									<p class="after">
    										<span class="jian fl">价格:</span>
    										<span class="price fl">${c.price }元</span>
    										<span class="jian fl">优惠:</span>
    										<span class="price fl">${c.huiPrice }元</span>
    									</p>
    								</div>
    							</div>
    							</c:if>
    							<input type="hidden" value="${c.cName}" name="currentcombo" />
    							</li>
    						</c:forEach>
    					</ul>
    				</dl>
    			</div>
    			<div class="current-product after">
    				<label for="">已选择商品:</label>
    				<div class="fl current-commodity-xuanz"></div>
    			</div>
    			<div class="add-product after">
    				<div class="product-num after fl">
    					<span class="num-box">1</span>
    					<span class="num-add">+</span>
    					<span class="num-subtract">-</span>
    				</div>
    				<div class="add-cart fl">
    					加入购物车
    				</div>
    				<!-- 表单提交 -->
			    	<form id="goCartForm" action="CartServlet.shtml" method="post">
					<input type="hidden" value="${sessionScope.huser.id}" name="hidhuser"  />
			    	</form>
			    	<!-- 主体 -->
    				<!-- <div class="add-indent">
    					立即下单
    				</div> -->
    			</div>
    		</div>
    	</div>
    	<hr />
    	<div class="layout-pei">
    		<p>
    			<a href="javascript:;">商品详情
    				<em></em>
    			</a>
    			<a href="javascript:;">规格与参数</a>
    			<a href="javascript:;">包装与售后</a>
    			<a href="javascript:;">用户评论(200+)</a>
    		</p>
    	</div>
    	<div class="pro-tab-feature-content">
    		<p>
    			<img src="homeimage/detail/1.jpg" alt="" />
    		</p>
    		<p>
    			<img src="homeimage/detail/2.jpg" alt="" />
    		</p>
    		<p>
    			<img src="homeimage/detail/3.jpg" alt="" />
    		</p>
    	</div>
    	<div class="goCartHidBox">
    		<div class="content">
    			<p>${sessionScope.commodity.series.sName }--${sessionScope.commodity.colorandConfigure.title}，已成功加入购物车！</p>
    			<div>
    				<span class="close-btn">在逛逛</span>
    				<span class="gocart-btn">去结算</span>
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
