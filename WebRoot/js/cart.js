/*购物车添加*/
/*全选跟全部选*/
/*一定他妈的不要忘了加加载事件*/
window.addEventListener('load', function(e) {
	//获取用户id
	var hUserId = document.getElementsByClassName('j_cdall')[0].value;
	if(hUserId==''){
		return;
	}
	
	var j_cdalls = document.querySelectorAll('.j_cdall');
	var j_tbs = document.querySelector("#j_tb").querySelectorAll('input');
	//初始化全选按钮
	if(j_tbs.length>0){
		isAllCheck();
	}
	function isAllCheck(){
		var flagt = true;
		for(var j = 0; j < j_tbs.length; j++){
			if(!j_tbs[j].checked){
				flagt = false;
			}
		}
		for(var j = 0; j < j_cdalls.length; j++){
			j_cdalls[j].checked = flagt;
		}
	}
	//全选跟全不选
	for(var i = 0; i < j_cdalls.length; i++){
		j_cdalls[i].addEventListener('click', function(e) {
			for(var j = 0; j < j_tbs.length; j++){
				j_tbs[j].checked = this.checked;
			}
			for(var j = 0; j < j_cdalls.length; j++){
				j_cdalls[j].checked = this.checked;
			}
			if(hUserId!=''){
				checkSp(0, this.checked,this.value);
			}
		});
	}
	//一个没有选，顶部跟底部不选
	for(var i = 0; i < j_tbs.length; i++){
		j_tbs[i].addEventListener('click', function(e) {
			isAllCheck();
			//调用ajax
			if(hUserId!=''){
				checkSp(this.value, this.checked,hUserId);
			}
		});
		
	}
	//a标签全选
	document.querySelector('.all-check').addEventListener('click', function(e) {
		j_cdalls[0].click();
	});
	//ajax
	var totalPrice = document.querySelector('.totalPrice');
	var totalChecked = document.querySelector('.totalChecked');
	var youPrice = document.querySelector('.youPrice');
	function checkSp(ShoppingCartId,isChecked,hUserId){
		var xhr = new XMLHttpRequest();
		var url = "CartServlet.shtml?ShoppingCartId="+ShoppingCartId+"&checked="+isChecked+"&action=checkedOne&hidhuser="+hUserId+"";
		xhr.open('post', url , true);
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4){
				if(xhr.status == 200){
					var huser = eval('('+xhr.responseText+')');
					youPrice.innerHTML = "￥&nbsp;"+huser.youPrice+"";
					totalPrice.innerHTML = "￥&nbsp;"+huser.totalPrice+"";
					totalChecked.innerHTML = ""+huser.totalCheck+"";
				}
			}
		}
		xhr.send(null);
	}
	
	//单个删除
	var one_delete = document.querySelectorAll('.one-delete-a');
	for(var i = 0; i < one_delete.length; i++){
		one_delete[i].addEventListener('click', function(e) {
			deleteSp(null, hUserId,this.getAttribute("data-shopingcart"));
			this.parentNode.parentNode.parentNode.parentNode.remove();
		});
	}
	//删除购物车内商品
	document.querySelector('.delete-all').addEventListener('click', function(e) {
		var arr = [];
		for(var i = 0; i < j_tbs.length; i++){
			if(j_tbs[i].checked){
				arr.push(j_tbs[i].value);
				j_tbs[i].parentNode.parentNode.parentNode.remove();
			}
			
		}
		console.log(arr.length)
		if(arr.length > 0 ){
			deleteSp(arr, hUserId,0);
		}
	});
	
	function deleteSp(array,hUserId,shoppingCartId){
		var xhr = new XMLHttpRequest();
		var url = "CartServlet.shtml";
		xhr.open('post', url , true);
		xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xhr.send("array="+JSON.stringify(array)+"&action=delete&hidhuser="+hUserId+"&ShoppingCartId="+shoppingCartId+"");
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4){
				if(xhr.status == 200){
					var huser = eval('('+xhr.responseText+')');
					youPrice.innerHTML = "￥&nbsp;"+huser.youPrice+"";
					totalPrice.innerHTML = "￥&nbsp;"+huser.totalPrice+"";
					totalChecked.innerHTML = ""+huser.totalCheck+"";
				}
			}
		}
		
	}
	
	
	//减
	var num_subtracts = document.querySelectorAll('.num-com-subtract');
	for(var i = 0; i < num_subtracts.length; i++){
		num_subtracts[i].addEventListener('click', function(e) {
			subtractAndAdd(false,hUserId,this.getAttribute('data-shopingcart'),this.parentNode.children[1],this.parentNode.parentNode.parentNode.children[3].children[0]);
		});
	}
	//加
	var num_add = document.querySelectorAll('.num-com-add');
	for(var i = 0; i < num_add.length; i++){
		num_add[i].addEventListener('click', function(e) {
			subtractAndAdd(true,hUserId,this.getAttribute('data-shopingcart'),this.parentNode.children[1],this.parentNode.parentNode.parentNode.children[3].children[0]);
		});
	}
	
	function subtractAndAdd(isThat,hUserId,shoppingCartId,total,totalPrices){
		var xhr = new XMLHttpRequest();
		var url = "CartServlet.shtml";
		xhr.open('post', url , true);
		xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xhr.send("isThat="+isThat+"&action=subtractAndAdd&hidhuser="+hUserId+"&ShoppingCartId="+shoppingCartId+"");
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4){
				if(xhr.status == 200){
					
					//全部选中总价格
					var huser = eval('('+xhr.responseText+')');
					
					totalPrice.innerHTML = "￥&nbsp;"+huser[1].totalPrice+"";
					//单个商品价格
					total.innerHTML = huser[0].total;
					totalPrices.innerHTML = "￥"+huser[0].totalPrice;
					if(huser[0].total == huser[0].colorandConfigure.store){
						alert('库存不足！');
						total.parentNode.children[2].style.cursor = 'not-allowed';
					}else{
						total.parentNode.children[2].style.cursor = 'pointer';
					}
					if(huser[0].total == 1){
						total.parentNode.children[0].style.cursor = 'not-allowed';
					}else{
						total.parentNode.children[0].style.cursor = 'pointer';
					}
				}
			}
		}
	}
	//去结算
	document.querySelector('.goSettlement').addEventListener('click', function(e) {
		var xhr = new XMLHttpRequest();
		var url = "CartServlet.shtml?hidhuser="+hUserId+"&action=goSettlement";
		xhr.open('post', url , true);
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4){
				if(xhr.status == 200){
					if(xhr.responseText == 'false'){
						alert('请至少选择一件商品!');
						return;
					}else{
						$('#goConfirmForm').trigger('submit');
					}
				}
			}
		}
		xhr.send(null);
	});
	
	
	
	
});






























