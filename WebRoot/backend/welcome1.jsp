<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'welcome1.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="shortcut icon" href="homeimage/favicon.ico" />
	<!-- 引入样式 -->
	<link rel="stylesheet" type="text/css" href="backcss/font.css">
	<link rel="stylesheet" type="text/css" href="backcss/xadmin.css">
	<link rel="stylesheet" type="text/css" href="lib/layui/css/layui.css">
	<!-- 引入layui -->
	<script src="lib/layui/layui.js" charset="utf-8"></script>
	<!-- 引入jquery -->
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<!-- 引入xadmin -->
	<script type="text/javascript" src="backjs/xadmin.js"></script>

  </head>
  
    <body>
        <div class="layui-fluid">
            <div class="layui-row layui-col-space15">

                <div class="layui-col-sm12 layui-col-md6" style="display: none;">
                    <div class="layui-card">
                        <div class="layui-card-header">最新一周新增用户</div>
                        <div class="layui-card-body" style="min-height: 280px;">
                            <div id="main1" class="layui-col-sm12" style="height: 300px;"></div>

                        </div>
                    </div>
                </div>
                <div class="layui-col-sm12 layui-col-md6" style="display: none;">
                    <div class="layui-card">
                        <div class="layui-card-header">最新一周PV/UV量</div>
                        <div class="layui-card-body" style="min-height: 280px;">
                            <div id="main2" class="layui-col-sm12" style="height: 300px;"></div>

                        </div>
                    </div>
                </div>
                <div class="layui-col-sm12 layui-col-md6" style="height:100%;width: 100%">
                	<input type="hidden" value="${sessionScope.admin.hUserTotal }" name="hUserTotal" id="totalHUser" />
                	<input type="hidden" value="${sessionScope.admin.indentTotal }" name="indentTotal" id="totalIndent" />
                	<input type="hidden" value="${sessionScope.admin.seriesTotal }" name="seriesTotal" id="totalSeries" />
                	<input type="hidden" value="${sessionScope.admin.categoryTotal }" name="categoryTotal" id="totalCategory" />
                	<input type="hidden" value="${sessionScope.admin.comTotal }" name="comTotal" id="totalStarc" />
                    <div class="layui-card">
                        <div class="layui-card-header">统计</div>
                        <div class="layui-card-body" style="min-height: 380px;width: 100%">
                            <div id="main3" class="layui-col-sm12" style="height: 300px;"></div>

                        </div>
                    </div>
                </div>
                <div class="layui-col-sm12 layui-col-md6" style="display: none;">
                    <div class="layui-card">
                        <div class="layui-card-header">硬盘使用量</div>
                        <div class="layui-card-body" style="min-height: 280px;">
                            <div id="main4" class="layui-col-sm12" style="height: 300px;"></div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
        </div>
    		<script>
                	window.addEventListener('load', function(e) {
                		//循环读取现在的统计记录
                		
                	});
                </script>
        <script src="https://cdn.bootcss.com/echarts/4.2.1-rc1/echarts.min.js"></script>
        <script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main1'));

        // 指定图表的配置项和数据
        var option = {
            grid: {
                top: '5%',
                right: '1%',
                left: '1%',
                bottom: '10%',
                containLabel: true
            },
            tooltip: {
                trigger: 'axis'
            },
            xAxis: {
                type: 'category',
                data: ['周一','周二','周三','周四','周五','周六','周日']
            },
            yAxis: {
                type: 'value'
            },
            series: [{
                name:'用户量',
                data: [820, 932, 901, 934, 1290, 1330, 1320],
                type: 'line',
                smooth: true
            }]
        };


        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);

        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main2'));

        // 指定图表的配置项和数据
        var option = {
            tooltip : {
                trigger: 'axis',
                axisPointer: {
                    type: 'cross',
                    label: {
                        backgroundColor: '#6a7985'
                    }
                }
            },
            grid: {
                top: '5%',
                right: '2%',
                left: '1%',
                bottom: '10%',
                containLabel: true
            },
            xAxis : [
                {
                    type : 'category',
                    boundaryGap : false,
                    data : ['周一','周二','周三','周四','周五','周六','周日']
                }
            ],
            yAxis : [
                {
                    type : 'value'
                }
            ],
            series : [
                {
                    name:'PV',
                    type:'line',
                    areaStyle: {normal: {}},
                    data:[120, 132, 101, 134, 90, 230, 210],
                    smooth: true
                },
                {
                    name:'UV',
                    type:'line',
                    areaStyle: {normal: {}},
                    data:[45, 182, 191, 234, 290, 330, 310],
                    smooth: true,

                }
            ]
        };


        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);


        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main3'));

        // 指定图表的配置项和数据
        var option = {
            tooltip : {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                orient: 'vertical',
                left: 'left',
                data: ['商品总数量','总商品种类','总商品系列','订单总数量','总用户数量']
            },
            series : [
                {
                    name: '统计',
                    type: 'pie',
                    radius : '55%',
                    center: ['50%', '60%'],
                    data:[
                        {value:$('[name=comTotal]').val(), name:'商品总数量'},
                        {value:$('[name=categoryTotal]').val(), name:'总商品种类'},
                        {value:$('[name=seriesTotal]').val(), name:'总商品系列'},
                        {value:$('[name=indentTotal]').val(), name:'订单总数量'},
                        {value:$('[name=hUserTotal]').val(), name:'总用户数量'}
                    ],
                    itemStyle: {
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };
		


        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
        
  				setInterval(function() {
          			var xhr = new XMLHttpRequest();
            		xhr.open('post', 'AdminIndexServlet.shtml?action=getAdmin', true);
            		xhr.onreadystatechange = function(){
            			if(xhr.readyState == 4){
            				if(xhr.status == 200){
            					var admin = eval('('+xhr.responseText+')');
            					document.querySelector('#totalStarc').value = admin.comTotal;
            					document.querySelector('#totalCategory').value = admin.categoryTotal;
            					document.querySelector('#totalSeries').value = admin.seriesTotal;
            					document.querySelector('#totalIndent').value = admin.indentTotal;
            					document.querySelector('#totalHUser').value = admin.hUserTotal;
            					console.log("ssssss")
            					// 基于准备好的dom，初始化echarts实例
  									 var myChart = echarts.init(document.getElementById('main3'));
            					option.series[0].data=[
		                        {value:$('[name=comTotal]').val(), name:'商品总数量'},
		                        {value:$('[name=categoryTotal]').val(), name:'总商品种类'},
		                        {value:$('[name=seriesTotal]').val(), name:'总商品系列'},
		                        {value:$('[name=indentTotal]').val(), name:'订单总数量'},
		                        {value:$('[name=hUserTotal]').val(), name:'总用户数量'}
	                    ]
            					myChart.setOption(option);
            				}
            			}
            		}
            		xhr.send(null);
          		}, 5000);

         // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main4'));

        // 指定图表的配置项和数据
        var options = {
            tooltip : {
                formatter: "{a} <br/>{b} : {c}%"
            },
            series: [
                {
                    name: '硬盘使用量',
                    type: 'gauge',
                    detail: {formatter:'{value}%'},
                    data: [{value: 88, name: '已使用'}]
                }
            ]
        };
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(options);
    </script>
    <script>
        var _hmt = _hmt || [];
        (function() {
          var hm = document.createElement("script");
          hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
          var s = document.getElementsByTagName("script")[0]; 
          s.parentNode.insertBefore(hm, s);
        })();
        </script>
    </body>
</html>
