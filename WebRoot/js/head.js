window.addEventListener('load', function() {
	/*顶部广告*/
	document.getElementsByClassName('button-banner-close')[0].addEventListener('click', function() {
		this.parentNode.style.display = 'none';
	})
	
	/*轮播*/
	var focus = document.querySelector('.focus')
    var arrow_l = document.querySelector('.arrow-l')
    var arrow_r = document.querySelector('.arrow-r')
    var circle = document.querySelector('.circle');
    var ul = focus.querySelector('.focus-ul');
    var uliWidth = ul.children[0].offsetWidth;
	/*arrow显示*/
    arrow_l.addEventListener('mouseenter', function(e) {
    	this.style.backgroundPosition = '-240px -72px';
    });
    arrow_l.addEventListener('mouseleave', function(e) {
    	this.style.backgroundPosition = '0 -72px';
    });
    arrow_r.addEventListener('mouseenter', function(e) {
    	this.style.backgroundPosition = '-160px -72px';
    });
    arrow_r.addEventListener('mouseleave', function(e) {
    	this.style.backgroundPosition = '-80px -72px';
    });
    
    //1.鼠标移动弹出左右框
    focus.addEventListener('mouseenter',function(){
        clearInterval(timer);
        timer = null;
    });
    focus.addEventListener('mouseleave',function(){
        timer = setInterval(function(){
            arrow_r.click();
        },2000);
    });
    //2.循环添加ol内的li标签
    for(var i = 0; i < ul.children.length; i++){
        var li = document.createElement('li');

        li.className = '';
        li.setAttribute('index',i);
        circle.appendChild(li);

        var circleli = circle.querySelectorAll('li');
        li.addEventListener('click',function(){

            for(var i = 0; i < circleli.length; i++){
                circleli[i].className = '';
            }
            this.className = 'current';
            circlein = this.getAttribute('index');
            
            var left = -this.getAttribute('index') * uliWidth;
            
            animate(ul,left);
            
            numChange(this.getAttribute('index'));
            console.log();
            
        });
        circleli[0].className = 'current';
    };
    //3.复制第一个ul li
    var lii = ul.children[0].cloneNode(true);
    /*lii.style.opacity = '.1';*/
    ul.appendChild(lii);
    //4.右侧点击按钮
    var num = 0;
    var circlein = 0;
    var flag = true;
    var ulli = ul.children;
    arrow_r.addEventListener('click',function(){
        //节流阀
        if(flag){
            flag = false;

        if(num == ul.children.length - 1){//2.num为四的时候已经显示出来了，这是把它的left该为零，num=0，num++ 变成1，然后就显示了ul中的第二张图片
            ul.style.left = '0px';
            num = 0;
        }
        num++;//1.等于四4之后显示的是复制的内张图片
        console.log();
        numChange(num);
        animate(ul,-num * uliWidth,function() {
            flag = true;
        });

        circlein++;
        if(circlein >= circle.children.length){
            circlein = 0;
        }
        
        circleChange();
        }
       
   });
   //左侧
   arrow_l.addEventListener('click',function(){
        if(flag){
            flag = false;

            if(num == 0){//2.判断等于零之后
                 num = ul.children.length - 1;//3.num修改为最后的图片的num对应的值 num = 4

                 ul.style.left = -num * uliWidth + 'px';//4.这个判断显示的是最后的ul里的图片,因为这个跳动很快肉眼察觉不到所以称为无缝切换
              }
              num--;//1.同理，当num==0 ul显示的是第一张图片//5.然后num-- 
              numChange(num);
              animate(ul,-num * uliWidth,function(){//6.这时显示的是 num-- 变成了3 （-3*300）变成了ul中倒数第二张，也就是能肉眼看到的li
                  flag = true;
              });
         
              circlein--;
              if(circlein < 0){
                  circlein = circle.children.length - 1;
              }
         
              circleChange();
        }
    });
    function circleChange(){
        for(var i = 0; i < circleli.length; i++){
            circleli[i].className = 'allli';
        }
        circleli[circlein].className = 'current';
    }
    var timer = setInterval(function(){
        arrow_r.click();
    },3000);
	
	function numChange(value){
		for(var i = 0; i < ulli.length; i++){
        	ulli[i].style.zIndex = '-99';
        }
        ulli[value].style.zIndex = '0';
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
})