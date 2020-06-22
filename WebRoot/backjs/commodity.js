$(function(){
	$('.data-delete-com').click(function(){
		var tr = $(this).parent().parent();
		$.ajax({
			url : 'AdminCommodityServlet.shtml',
			type : 'post',
			data : {
				'action' : 'removeCom',
				'comid' : $(this).attr('data-delete-com')
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
	
});
function getPageCom(page){
	$('[name=getPageCom]').val(page);
	$('#pageComForm').trigger('submit');
}
