/*加载事件*/
$(function(){
	//默认地址修改
	$(document).on('click','.default-address',function(){
		$(this).parent().parent().parent().find('span').eq(0).addClass('defule-inline-block').removeClass('defule-hide');
		$(this).addClass('defule-hide');
		$(this).parent().parent().parent().siblings().find('span').addClass('defule-hide').removeClass('defule-inline-block');
		$(this).parent().parent().parent().siblings().find('.default-address').addClass('defule-inline-block').removeClass('defule-hide')
	})
	//添加地址
	$('.addAddress-box').css({'width':$(document).width(),'height':$(document).height()});
	$(window).resize(function(){
		$('.addAddress-box').css({'width':$(document).width(),'height':$(document).height()});
	});
	$('.cancel-add').click(function(){
		$('.addAddress-box').hide();
	});
	$(document).on('click','.add-address-new',function(){
		$('.addAddress-box').show();
	})
	//添加地址
	$(document).on('click','.add-address',function(){
		if($('[name=aName]').val()==''&&$('[name=phone]').val()==''&&$('[name=detail]').val()==''){
			alert('姓名电话或详细地址不能为空！');
			return;
		}
		if($('[name=sheng]').val()!=1&&$('[name=shi]').val()!=1&&$('[name=qu]').val()!=1&&$('[name=zhen]').val()!=1){
			$('[name=country]').val($('[name=sheng]').val()+' '+$('[name=shi]').val()+' '+$('[name=qu]').val()+' '+$('[name=zhen]').val());
		}else{
			alert('请选择正确地址！');
			return;
		}
		$.ajax({
			url : 'ConfirmServlet.shtml',
			type : 'post',
			data : {'aName':$('[name=aName]').val(),'phone':$('[name=phone]').val(),'country':$('[name=country]').val(),'detail':$('[name=detail]').val(),'hidhuser':$('[name=hidhuser]').val(),'action':'addAddress'},
			success : function(result){
				$('.address-box ul').empty();
				$(eval('('+result+')')).each(function(i,e){
					var li = null;
					if(e.id == $('[name=defaultAddress]').val()){
						li = $('<li data-address-id="'+e.id+'" class="back-address"></li>');
					}else{
						li = $('<li data-address-id="'+e.id+'" ></li>');
					}
					if(e.id == $('[name=defaultAddress]').val()){
						$('<span class="">默认地址</span>').appendTo($(li));
					}else{
						$('<span class="defule-hide">默认地址</span>').appendTo($(li));
					}
					var divbox = $('<div class="now-address"><p class="after"><b>'+e.aName+'</b><span>'+e.phone+'</span></p><div class="detail-address">'+e.country+'&nbsp;'+e.detail+'</div></div>');
					
					var ope = $('<div class="operation"><a href="javascript:;" class="edit-address">编辑</a><a href="javascript:;" class="remover-address">删除</a></div>');
					if(e.id == $('[name=defaultAddress]').val()){
						$('<a href="javascript:;" data-address-ids="'+e.id+'" class="default-address defule-hide">设为默认</a>').appendTo($(ope));
					}else{
						$('<a href="javascript:;" data-address-ids="'+e.id+'" class="default-address">设为默认</a>').appendTo($(ope));
					}
					$(ope).appendTo($(divbox));
					$(divbox).appendTo($(li));
					$(li).appendTo($('.address-box ul'));
				});
				$('<li><a class="add-address-new" href="javascript:;">新增收货地址</a></li>').appendTo($('.address-box ul'));
			}
		});
		$('.addAddress-box').hide();
		$('.address-content input').val('');//重置添加输入的值
		$('.address-content select').val('1');//重置添加输入的值
	});
	
	//点击地址
	$(document).on('click','.address-box ul>li:not(:last)',function(){
		$(this).addClass('back-address').siblings().removeClass('back-address');
		$('[name=hidaddress]').val($(this).attr('data-address-id'));
		$.ajax({
			url : 'ConfirmServlet.shtml',
			type : 'post',
			data : {'action':'change','addressId':$(this).attr('data-address-id')},
			success : function(result){
				var address = eval('('+result+')');
				$('.address-change').html('配送至：'+address.country+'&nbsp;'+address.detail+'&nbsp;'+address.aName+'&nbsp;'+address.phone)
			}
		});
	});
	//设置默认地址
	$(document).on('click','.default-address',function(){
		var de = $(this).attr('data-address-ids');
		$.ajax({
			url : 'ConfirmServlet.shtml',
			type : 'post',
			data : {'action':'defaultAddress','addressId':de,'hidhuser':$('[name=hidhuser]').val()},
			success : function(){
				$('[name=defaultAddress]').val(de);
			}
		});
	});
	
	
	//生成订单
	$('.add-indent-s').click(function(){
		var flag = false;
		$('.address-box li').each(function(i,e){
			if($(e).hasClass('back-address')){
				flag = true;
			}
		})
		if(flag){
			$('#addIndentForm').trigger('submit');
		}else{
			alert('请选择地址！');
		}
		
	});

});








































