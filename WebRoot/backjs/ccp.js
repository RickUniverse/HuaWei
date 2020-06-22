$(function(){
	//颜色添加
	$('.add-color-name').click(function(){
		var colorName = $('[name=add-color-name]').val();
		if(colorName==null||colorName==''){
			alert('颜色名称不能为空！');
			return;
		}
		location.href = "AdminCCPServlet.shtml?action=addColor&addColorName="+colorName+"";
	});
	//删除颜色
	$('.data-delete-color').click(function(){
		var tr = $(this).parent().parent();
		$.ajax({
			url : 'AdminCCPServlet.shtml',
			type : 'post',
			data : {
				'action' : 'removeColor',
				'colorId' : $(this).attr('data-delete-color')
			},
			success : function(result) {
				if (result == 'true') {
					$(tr).remove();
					alert('删除成功！');
				} else {
					alert('删除失败，可能有关联的商品！');
				}
			}
		});
	})
	
	//配置添加
	$('.add-conf-name').click(function(){
		var confName = $('[name=add-conf-name]').val();
		if(confName==null||confName==''){
			alert('配置名称不能为空！');
			return;
		}
		location.href = "AdminCCPServlet.shtml?action=addConf&addconfName="+confName+"";
	});
	//删除配置
	$('.data-delete-conf').click(function(){
		var tr = $(this).parent().parent();
		$.ajax({
			url : 'AdminCCPServlet.shtml',
			type : 'post',
			data : {
				'action' : 'removeConf',
				'confId' : $(this).attr('data-delete-conf')
			},
			success : function(result) {
				if (result == 'true') {
					$(tr).remove();
					alert('删除成功！');
				} else {
					alert('删除失败，可能有关联的商品！');
				}
			}
		});
	})
	
	//促销添加
	$('.add-tit-con-name').click(function(){
		var tit = $('[name=add-pro-tit]').val();
		var con = $('[name=add-pro-con]').val();
		if(tit==null||tit==''){
			alert('标题不能为空！');
			return;
		}
		if(con==null||con==''){
			alert('内容不能为空！');
			return;
		}
		location.href = "AdminCCPServlet.shtml?action=addpro&addtit="+tit+"&addcon="+con+"";
	});
	//删除促销
	$('.data-delete-pro').click(function(){
		var tr = $(this).parent().parent();
		$.ajax({
			url : 'AdminCCPServlet.shtml',
			type : 'post',
			data : {
				'action' : 'removepro',
				'proId' : $(this).attr('data-delete-pro')
			},
			success : function(result) {
				if (result == 'true') {
					$(tr).remove();
					alert('删除成功！');
				} else {
					alert('删除失败，可能有关联的商品！');
				}
			}
		});
	})
	
	
	
	
	
	
	
});
function getPageColor(page){
	$('[name=getPageColor]').val(page);
	$('#pageColForm').trigger('submit');
}
function getPageConf(page){
	$('[name=getPageConf]').val(page);
	$('#pageConfForm').trigger('submit');
}
function getPagePro(page){
	$('[name=getPagePro]').val(page);
	$('#pageProForm').trigger('submit');
}






