window.addEventListener('load', function(e) {
	
	//获取input
	var all_click = document.querySelectorAll('.all_check_input');
	var inputs = document.querySelector('.list-group').querySelectorAll('input');

	if(inputs.length>0 && $('[name=hidStatusId]').val()==2){
		/*初始化选中按钮*/
		oneCheck(inputs,all_click);
		
		/*全选span标签*/
		document.querySelector('.all-checked-span').addEventListener('click', function(e) {
			all_click[0].click();
		});
	}
	
	//全选按钮
	for(var i = 0; i < all_click.length; i++){
		all_click[i].addEventListener('click', function(e) {
			for(var j = 0; j < inputs.length; j++){
				inputs[j].checked = this.checked;
			}
			for(var j = 0; j < all_click.length; j++){
				all_click[j].checked = this.checked;
			}
			//ajax
			checkIndent($('[name=hUserId]').val(),0,this.checked,$('[name=statusId]').val(),getAllIndentId(inputs));
		});
	}
	
	for(var j = 0; j < inputs.length; j++){
		inputs[j].addEventListener('click', function(e) {
			oneCheck(inputs,all_click);
			//ajax
			checkIndent($('[name=hUserId]').val(),this.getAttribute('data-indentid'),this.checked,$('[name=statusId]').val());
		});
	}
	
	
	//合并支付
	//订单点击多个个订单结算
	//在加载文档完成后点击事件
	var alltoPaying = document.querySelectorAll('.getAllPaying');
	for(var i = 0; i < alltoPaying.length; i++){
		alltoPaying[i].addEventListener('click', function(e) {
			if(getAllCheckedIndentId(inputs).length>0){
				$('[name=action]').val('allPaying');
				$('[name=array]').val(JSON.stringify(getAllCheckedIndentId(inputs)));
				$('#persForm').trigger('submit');
			}else{
				alert('请先选择订单!');
			}
		});
	}
	
});

/*初始化单选按钮*/
function oneCheck(inputs,all_click){//全部商品按钮跟全部全选按钮
	var flag = true;
	for(var i = 0; i < inputs.length; i++){
		if(!inputs[i].checked){
			flag = false;
		}
	}
	for(var i = 0; i < all_click.length; i++){
		all_click[i].checked = flag;
	}
}
//获取选中的订单id
function getAllIndentId(inputs) {
	var array = [];
	for (var j = 0; j < inputs.length; j++) {
		array.push(inputs[j].getAttribute('data-indentid'));
	}
	return array;
}
function getAllCheckedIndentId(inputs) {
	var array = [];
	for (var j = 0; j < inputs.length; j++) {
		if(inputs[j].checked){
			array.push(inputs[j].getAttribute('data-indentid'));
		}
	}
	return array;
}
//选中ajax
function checkIndent(hUserId, indentId, isChecked, statusId, array) {
	var xhr = new XMLHttpRequest();
	xhr.open('post', 'PersonallyServlet.shtml', true);
	xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
	xhr.send("action=checked&array=" + JSON.stringify(array) + "&hUserId=" + hUserId + "&isChecked=" + isChecked + "&indentId=" + indentId + "&statusId=" + statusId + "");
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
			}
		}
	}
}
//状态点击
function getStatus(statudId){
	$('[name=hidPage]').val($('[name=hidPage]').val());
	$('[name=statusId]').val(statudId);
	$('[name=stateChick]').val('stateChick');
	$('#persForm').trigger('submit');
}
//页码点击
function getPage(page){
	$('[name=hidPage]').val(page);
	$('[name=statusId]').val($('[name=hidStatusId]').val());
	$('#persForm').trigger('submit');
}
//订单点击单个订单结算
function getIndentId(indentid){
	$('[name=indentId]').val(indentid);
	$('[name=action]').val('toPaying');
	$('#persForm').trigger('submit');
}
//确认收货
function getIndentIdDoYes(indentid){
	$('[name=indentId]').val(indentid);
	$('[name=action]').val('doYesShou');
	$('#persForm').trigger('submit');
}
//取消订单
function getIndentIdNoIndent(indentid){
	$('[name=indentId]').val(indentid);
	$('[name=action]').val('noIndent');
	$('#persForm').trigger('submit');
}
//完成评价
function getIndentIdDoAppraise(indentid){
	$('[name=indentId]').val(indentid);
	$('[name=action]').val('DoAppraise');
	$('#persForm').trigger('submit');
}

























