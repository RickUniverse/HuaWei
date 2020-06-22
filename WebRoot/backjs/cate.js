$(function() {
	//初始化细分种类
	$('[name=cateupdate]').each(function(i, e) {
		$(e).val($(e).attr('data'));
	});
	//添加类别
	$('.layui-btn-add-cate').click(function() {
		var dateName = $('[name=cate_name_add]').val();
		if (dateName == null || dateName == '') {
			alert('类别名称不能为空！')
			return false;
		}
		location.href = "AdminCateServlet.shtml?action=addCategory&category=" + dateName + "";
	});
	//删除种类
	$('.layui-btn-remove-cate').click(function() {
		var tr = $(this).parent().parent();
		$.ajax({
			url : 'AdminCateServlet.shtml',
			type : 'post',
			data : {
				'action' : 'removeCategory',
				'categoryId' : $(this).attr('data-cate-remove')
			},
			success : function(result) {
				if (result == 'true') {
					$(tr).remove();
					alert('删除成功！');
				} else {
					alert('删除失败，可能有关联的细分表！');
				}
			}
		});
	});
	//添加细分
	$('.layui-btn-add-servies').click(function() {
		var seriesName = $('[name=series_name]').val();
		var cateId = $('[name=cate-add-series]').val();
		var image = $('[name=sImage]').val();
		if (seriesName == null || seriesName == '') {
			alert('细分名称不能为空！');
			return false;
		} else if (cateId <= 0) {
			alert('请选择细分所属类别！');
			return false;
		} else if (image == '' || image == null) {
			alert('请选择一个图片！');
			return false;
		}
		$('#addSeriesForm').trigger('submit');
		return false;
	});
	//预览图片
	$('[name=sImage]').change(function() {
		var file = $('[name=sImage]').get(0).files[0];
		var reader = new FileReader();
		reader.readAsDataURL(file);
		reader.onload = function(e) {
			$('<img class="showImage" src="' + e.target.result + '" alt="" width="100px" height="100px" />').appendTo($('.image-show-box'));
		/* $('.showImage').get(0).src = ; */
		}
	});
	//细分修改
	$('.servier-update').click(function(){
		var input = $(this).parent().prev().prev().prev().prev().children(0).val();
		var select = $(this).parent().prev().prev().children(0).val();
		if(input == ''||input==null){
			return;
		}else if(select<=0){
			return;
		}else{
			$.ajax({
				url : 'AdminCateServlet.shtml',
				type : 'post',
				data : {
					'action' : 'updateSeries',
					'categoryId' : select,
					'sName' : input,
					'seriesId' : $(this).attr('data-seriesId')
				},
				success : function(result) {
					if (result == 'true') {
						alert('修改成功！');
					} else {
						alert('修改失败');
					}
				}
			});
		}
	});
	//细分删除
	$('.servier-delete').click(function(){
		var seriesid = $(this).attr('data-seriesId');
		var recom = $(this).attr('data-reCommodityCount');
		if(recom>=1){
			alert('该细分有商品关联，不可删除！');
			return;
		}
		location.href = "AdminCateServlet.shtml?action=deleteSeries&seriesId=" + seriesid + "";
	});
});

function getPageCate(page){
	$('[name=getPageCate]').val(page);
	$('#pageCateForm').trigger('submit');
}
function getPageSeries(page){
	$('[name=getPageSeries]').val(page);
	$('#pageSerForm').trigger('submit');
}




























