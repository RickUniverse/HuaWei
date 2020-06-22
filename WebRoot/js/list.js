$(function(){
	//价格ajax
	$('.search-price a').click(function(){
		$(this).addClass('current').siblings().removeClass('current');
		$('.price-min-max').attr('data-priceminmax',$(this).html());
		var array = $(this).html().split('-');
		$.ajax({
			url : 'ListSearchServlet.html',
			type : 'post',
			data : {"min":array[0],"max":array[1],"commodityName":$('.data_cNames').eq(0).text(),"hidPage":$('.page-box .after').attr('data-pageNo'),"configureId":$('.configure-ids').attr('data-priceminmax'),"hidCategory":$('.hidCategory').data('categorys'),"hidSeries":$('.hidSeries').data('seriess'),"action":"price"},
			success : function(result){
				createLi(result);
				createPageA(result);
			}
		})
	});
	//配置ajax
	$('.last-p a').click(function(){
		$(this).addClass('current').siblings().removeClass('current');
		$('.configure-ids').attr('data-configures',$(this).data('configure'));
		var array = $('.price-min-max').attr('data-priceminmax').split('-');
		$.ajax({
			url:'ListSearchServlet.html',
			type:'post',
			data:{"min":array[0],"max":array[1],"commodityName":$('.data_cNames').eq(0).text(),"hidPage":$('.page-box .after').attr('data-pageNo'),"configureId":$(this).data('configure'),"hidCategory":$('.hidCategory').data('categorys'),"hidSeries":$('.hidSeries').data('seriess'),"action":"configore"},
			success:function(result){
				createLi(result);
				createPageA(result);
				/*localStorage.setItem('pageList', result)
				console.log(localStorage.getItem('pageList'))//字符串
				var list = JSON.parse(localStorage.getItem('pageList'));
				console.log(list)//集合，集合中有两个数据，一个集合数组，一个page对象
				$(list).each(function(i,e){
					console.log(e)//第一个是数组        ，，，，第二个是对象
				})*/
			}
		})
	});
	
	//页码元素跟未来页码元素样式
	$('.hidPage-number:first').addClass('current');
	$(document).on('click','.hidPage-number',function(){
		$(this).addClass('current').siblings().removeClass('current');
	});
	
});
//创建商品dom元素
function createLi(result){
	var ul = $('.weiyi').empty();
	$(eval('('+result+')')[0]).each(function(i,e){
		var li = $('<li></li>');
		var a = $('<a href="javascript:;"></a>').appendTo($(li));
		$('<div><img src="'+e.commodity.image+'" alt="" /></div>').appendTo($(a));
		$('<span class="search-name">'+e.commodity.cName+'</span>').appendTo($(a));
		$('<span class="search-price">￥'+e.price+'</span>').appendTo($(a));
		$('<span class="search-promotion">'+e.promotion.title+'</span>').appendTo($(a));
		$('<span class="search-tit">'+e.title+'</span>').appendTo($(a));
		$(li).appendTo($('.weiyi'));
	});
	if($('.weiyi').children().length<=0){
		$('<h1 style="font-size: 60px;color: #999999;text-align: center;line-height: 200px">暂无该商品</h1>').appendTo($('.weiyi'));
	}
}
//创建页码dom元素
function createPageA(result){
	var ul = $('.page-quan-a').empty();
	var page = $(eval('('+result+')')[1]);
	$(page).each(function(i,e){
		$('<a class="hidPage" onclick="getPage(1)" href="javascript:;"></a>').html('<li>首页</li>').appendTo($(ul));
		$('<a class="hidPage" onclick="getPage('+e.prevPage+')" href="javascript:;"></a>').html('<li>上一页</li>').appendTo($(ul));
		for(var r = 1;r <= e.totalPage; r++){
			var active = '';
			if(r==e.pageNo){
				active = 'current';
			}
			$('<a class="hidPage hidPage-number '+active+'" onclick="getPage('+r+')" href="javascript:;"></a>').html('<li>'+r+'</li>').appendTo($(ul));
		}
		$('<a class="hidPage" onclick="getPage('+e.nextPage+')" href="javascript:;"></a>').html('<li>下一页</li>').appendTo($(ul));
		$('<a class="hidPage" onclick="getPage('+e.totalPage+')" href="javascript:;"></a>').html('<li>末页</li>').appendTo($(ul));
		$('<a class="hidPage" href="javascript:;"></a>').html('<li>总页数：'+e.totalPage+'； 当前页：'+e.pageNo+'； 总条数：'+e.totalCount+'； 上一页：'+e.prevPage+'； 下一页：'+e.nextPage+'</li>').appendTo($(ul));
	})
}

//获得页码
function getPage(val){
	$('.hidPage').parent().attr('data-pageNo',val);
	var array = $('.price-min-max').attr('data-priceminmax').split('-');
	$.ajax({
		url : 'ListSearchServlet.html',
		type : 'post',
		data : {"min":array[0],"max":array[1],"commodityName":$('.data_cNames').text(),"hidPage":val,"configureId":$('.configure-ids').attr('data-priceminmax'),"hidCategory":$('.hidCategory').data('categorys'),"hidSeries":$('.hidSeries').data('seriess'),"action":"getPage"},
		success : function(result){
			createLi(result);
			createPageA(result);
		}
	})
}

//***待用
window.onbeforeunload = function() //author: meizz
{
var n = window.event.screenX - window.screenLeft;
var b = n > document.documentElement.scrollWidth-20;
if(b && window.event.clientY < 0 || window.event.altKey)
{
alert("是关闭而非刷新");
window.event.returnValue = ""; //这里可以放置你想做的操作代码
}else
{
alert("是刷新而非关闭");
}
}
window.onbeforeunload = function() //author: meizz
{
var n = window.event.screenX - window.screenLeft;
var b = n > document.documentElement.scrollWidth-20;
if(b && window.event.clientY < 0 || window.event.altKey)
{
alert("是关闭而非刷新");
window.event.returnValue = ""; //这里可以放置你想做的操作代码
}else
{
alert("是刷新而非关闭");
}
}































