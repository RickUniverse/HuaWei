window.addEventListener('load', function(e) {
	/*导航栏*/
	var icond = document.getElementsByClassName('icon-dropdown');
	for(var i = 0; i < icond.length; i++){
		icond[i].addEventListener('mouseenter', function(e) {
			this.style.color = '#cb242b';
			this.parentNode.style.backgroundColor = '#ffffff';
			this.parentNode.className = 'active';
		});
		icond[i].addEventListener('mouseleave', function(e) {
			this.style.color = '#afafaf';
			this.parentNode.style.backgroundColor = '#2e2828';
		});
	}
	/*用户二级菜单*/
	var huser = document.querySelector('.huser-hid');
	if(huser != null){
		var h_children = huser.children[1];
		huser.addEventListener('mouseenter', function(e) {
			h_children.style.display = 'block';
		});
		huser.addEventListener('mouseleave', function(e) {
			h_children.style.display = 'none';
		});
	}
	/*搜索框*/
	if(search_box == null){
		return;
	}
	var search_box = document.getElementsByClassName('search-box')[0];
	search_box.addEventListener('mouseenter', function(e) {
		this.children[0].children[0].style.border = '1px solid rgba(0,0,0,.2)';
	});
	search_box.addEventListener('mouseleave', function(e) {
		this.children[0].children[0].style.border = '0';
		
	});
	var search_input = search_box.children[0].children[0];
	search_input.addEventListener('focus', function(e) {
		this.parentNode.children[2].style.display = 'none';
	});
	search_input.addEventListener('blur', function(e) {
		this.parentNode.children[2].style.display = 'block';
	});
	
});