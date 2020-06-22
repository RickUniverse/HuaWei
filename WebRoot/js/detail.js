/*detail*/
/*product-smill*/
window.addEventListener('load', function(e) {
	
	//小图片切换显示
	var small_img = document.getElementsByClassName('small-d-box')[0].children[0].children;
	var show_big_imgs = document.getElementsByClassName('show-big-img')[0].children[0];
	//默认选中第一个
	small_img[0].className = "current";
	for(var i = 0; i < small_img.length; i++){
		small_img[i].addEventListener('mouseenter', function(e) {
			for(var j = 0; j < small_img.length; j++){
				small_img[j].className = "";
			}
			this.className = "current";
			show_big_imgs.setAttribute('src', this.children[0].getAttribute('src'));
			bigimg.children[0].setAttribute('src', this.children[0].getAttribute('src'));
		});
		small_img[i].addEventListener('mouseleave', function(e) {
			
		});
	}
	//套餐显示
	var combo = document.querySelector(".combo-ul-all");
	var ul_li = combo.children;
	for(var i = 0; i < ul_li.length; i++){
		ul_li[i].addEventListener('mouseenter', function(e) {
			this.children[0].display = 'block';
			this.children[0].setAttribute('class', 'combo-commodity after have-pom')
		});
		ul_li[i].addEventListener('mouseleave', function(e) {
			this.children[0].display = 'none';
			this.children[0].setAttribute('class', 'combo-commodity after ')
		});
	}
	
	/*移动放大镜*/
	var big_img = document.getElementsByClassName('show-big-img')[0];
	var mas = document.querySelector('.magnifying-glass-small');
	var bigimg = document.querySelector('.magnifying-glass');
	/*鼠标移入显示*/
	big_img.addEventListener('mouseover', function(e) {
		mas.style.display = 'block';
		bigimg.style.display = 'block';
		//鼠标移动
		big_img.addEventListener('mousemove', function(e) {
			var moveY = e.pageY - mas.offsetHeight/2 - this.offsetTop;//移动距离
			var moveX = e.pageX - mas.offsetWidth/2 - this.offsetLeft;//移动距离
			var maxY = big_img.offsetHeight - mas.offsetHeight;//上下最大移动距离
			var maxX = big_img.offsetWidth - mas.offsetWidth;//左右最大移动距离
			
			if(moveY <= 0){
				moveY = 0;
			}else if(moveY >= maxY){
				moveY = maxY;
			}
			if(moveX <= 0){
				moveX = 0;
			}else if(moveX >= maxX){
				moveX = maxX;
			}
			mas.style.top = moveY + 'px';
			mas.style.left = moveX + 'px';
			
			//大图片的移动距离=遮挡层的移动距离*大图片的最大移动距离/遮挡层的最大移动距离
			
			var MaxBigImgY = bigimg.children[0].offsetHeight - bigimg.offsetHeight;
			var MaxBigImgX = bigimg.children[0].offsetWidth - bigimg.offsetWidth;
			
			var moveBigImgY = moveY * MaxBigImgY / maxY;
			var moveBigImgX = moveX * MaxBigImgX / maxX;
			
			bigimg.children[0].style.top = -moveBigImgY + 'px';
			bigimg.children[0].style.left = -moveBigImgX + 'px';
		});
	});
	big_img.addEventListener('mouseout', function(e) {
		mas.style.display = 'none';
		bigimg.style.display = 'none';
	});
	
	
	//点击按钮切换
	var arrow_l = document.querySelector('.show-small-img').querySelector('.arrow-l');
	var arrow_r = document.querySelector('.show-small-img').querySelector('.arrow-r');
	var ul = document.querySelector('.show-small-img').querySelector('ul');
	var liwidth = ul.children[0].offsetWidth;
	var ulMax = (ul.children.length - 4)*liwidth;
	
	/*console.log("ulleft:"+ul.offsetLeft)
	console.log("liwidth:"+ul.children[0].offsetWidth)
	console.log("ulmax:"+ulMax);*/
	
	var num = 0;
	var ulMove = 0;//ul需要移动的距离
	//右侧
	arrow_r.addEventListener('click', function(e) {
		num++;
		ulMove = liwidth * num;
		if(ulMove >= ulMax){
			ulMove = ulMove - liwidth;
			num--;
		}
		animate(ul,-ulMove);
	});
	//左侧
	arrow_l.addEventListener('click', function(e) {
		num--;
		if(num <= 0){
			ulMove = 0;
			num = 0;
		}
		ulMove = liwidth * num;
		animate(ul,-ulMove);
	});
	
	
});
/*jquery*/
$(function(){
	$('.combo-ul-all>li').click(function(){
		$('.current-commodity-xuanz').html(colorcurrent+curfigurecurrent+combocurrent);
		if($(this).hasClass('available')){
			$('[name=hidcombo]').val(0);
			$(this).removeClass('available');
			$('[name=comboprice]').val('0.0');
			$('.current-commodity-xuanz').html(colorcurrent+curfigurecurrent);
		}else{
			$('[name=hidcombo]').val($(this).attr('data-combo'));
			$(this).addClass('available').siblings().removeClass('available');
			$('[name=comboprice]').val($(this).attr('data-combo-price'));
			$('.current-commodity-xuanz').html(colorcurrent+curfigurecurrent+'/'+$('[name=currentcombo]').val());
			
		}
		
	});
	$('.color-xuan-a>li').click(function(){
		if($(this).hasClass('available')){
			$('[name=hidcolor]').val(0);
			$(this).removeClass('available');
		}else{
			$('[name=hidcolor]').val($(this).attr('data-color'));
			$(this).addClass('available').siblings().removeClass('available');
		}
		$('#detailForm').trigger('submit');
	});
	$('.configure-all-li>li').click(function(){
		if($(this).hasClass('available')){
			$('[name=hidconfigureId]').val(0);
			$(this).removeClass('available');
		}else{
			$('[name=hidconfigureId]').val($(this).attr('data-configure'));
			$(this).addClass('available').siblings().removeClass('available');
		}
		$('#detailForm').trigger('submit');
	});
	
	//当前选中
	var colorcurrent = "";
	$('.color-xuan-a>li').each(function(i,e){
		if($(this).hasClass('available')){
			colorcurrent = $(this).children().eq(1).text();
		}
	});
	var curfigurecurrent = "";
	$('.configure-all-li>li').each(function(i,e){
		if($(this).hasClass('available')){
			curfigurecurrent = '/' + $('[name=currentconfigure]').val();
		}
	});
	var combocurrent = "";
	$('.combo-ul-all>li').each(function(i,e){
		if($(this).hasClass('available')){
			combocurrent = '/' + $('[name=currentcombo]').val();
		}
	});
	$('.current-commodity-xuanz').html(colorcurrent+curfigurecurrent+combocurrent);
	
	//数量加减
	var pric_num = $('.num-box').text();
	var current_stact = $('.current-stock').text();
	$('.num-add').click(function(){
		if( pric_num++ < current_stact){
			$('.num-box').text(pric_num);
			$('[name=hidtotal]').val(pric_num);
		}else{
			$(this).css('cursor','not-allowed ');
			pric_num = current_stact;
		}
	});
	$('.num-subtract').click(function(){
		if( pric_num-- > 1){
			$('.num-box').text(pric_num);
			$('[name=hidtotal]').val(pric_num);
		}else{
			$(this).css('cursor','not-allowed ');
			pric_num = 1;
		}
	});
	
	
	
	
	//隐藏添加成功购物车
	$('.goCartHidBox').css({'width':$(document).width(),'height':$(document).height()});
	$(window).resize(function(){
		$('.goCartHidBox').css({'width':$(document).width(),'height':$(document).height()});
	});
	$('.close-btn').click(function(){
		$('.goCartHidBox').hide();
	});
	$('.gocart-btn').click(function(){
		/*var url = "CartServlet.shtml?hidhuser="+$('[name=hidhuser]').val()+"";
		location.href = url;*/
		document.getElementById('goCartForm').submit();
	});
	
	
	
	/*购物车点击*/
	var gou_cart = $('.add-cart');
	$('.add-cart').click(function(){
		if($('[name=hidhuser]').val() == ''){
			location.href = "HomePageServlet.shtml";
		}else{
			var isok = $('[name=hidcolor]').val() == 0 ? alert('请选择颜色') : $('[name=hidconfigureId]').val() == 0 ? alert('请选择配置') : $('[name=hidcombo]').val() == 0 ? alert('请选择套餐') : null;
			/*if(null == undefined){
				console.log('undefind=null')
			}*/
			if(isok === null){
				/*$('#goCart').trigger('submit');*/
				$.ajax({
					url : 'DetailServlet.shtml',
					type : 'post',
					data : {'action':'addCart','colorandConfigureId':$('[name=prevcolorandConfigureId]').val(),'hidtotal':$('[name=hidtotal]').val(),'hidprice':$('[name=hidprice]').val(),'comboprice':$('[name=comboprice]').val(),'hidcombo':$('[name=hidcombo]').val(),'hidhuser':$('[name=hidhuser]').val()},
					success : function(result){
						if( result == 'true'){
							$('.goCartHidBox').show();
						}else{
							alert('购物车内该配置商品已达库存上限！');
						}
					}
				})
			}
		}
	});
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
});

































