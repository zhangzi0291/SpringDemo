<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>${title}</title>
	<%@include file="csstool.jsp"%>
	<style type="text/css">
		#radar{
			height: 260px;
			width: 200px;
		}
		.list>div{
			margin:0; 
			height:100%; 
		}
		.list>div>span:nth-child(1){
			display:inline-block;
			text-align:right;
			width: 15%;
		}
		.list>div>span:nth-child(2){
			display:inline-block;
			width: 85%;
		}
	</style>
</head>
<body class="skin-blue fixed">
<div class="wrapper">
<jsp:include page="/jsp/header.jsp" flush="true"/>
<jsp:include page="/jsp/menu.jsp" flush="true"/>
<div class="content-wrapper">
	<section class="content">
		<div class="col-xs-12">
			<div class="box">
				<div class="box-header">
					<div class="box-title"><h2>${pro.name }</h2></div>
				</div>
				<div class="box-body">
					<div class="col-xs-6">
						<div class="col-xs-5 list">
							<div><span>名称：</span><span>${pro.name }</span></div><br>
							<div><span>HP：</span><span>${pro.hp }</span></div><br>
							<div><span>攻击：</span><span>${pro.atk }</span></div><br>
							<div><span>防御：</span><span>${pro.def }</span></div><br>
							<div><span>特攻：</span><span>${pro.spatk }</span></div><br>
							<div><span>特防：</span><span>${pro.spdef }</span></div><br>
							<div><span>速度：</span><span>${pro.speed }</span></div>
						</div>
						<div class="col-xs-7">
							<div id="radar"></div>
						</div>
					</div>
					<div class="col-xs-6">
						<c:forEach var="pp" items="${property }">
							<div><h4><c:if test="${pp.hide==1 }">隐藏特性 </c:if>${pp.property_name }:</h4><span>${pp.property_effcet }</span></div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</section>
</div>
</div>
</body>
<%@include file="jstool.jsp"%>
<script type="text/javascript">
$(function(){
	var atRadar = echarts.init($("#radar")[0]);
	var option = {
		    title: {
		        text: '属性分布'
		    },
		    tooltip: {},
		    legend: {
		        data: ['属性分布']
		    },
		    radar: {
		        // shape: 'circle',
		        indicator: [
		           { name: 'HP', max: 180},
		           { name: '攻击', max: 180},
		           { name: '防御', max: 180},
		           { name: '特攻', max: 180},
		           { name: '特防', max: 180},
		           { name: '速度', max: 180}
		        ]
		    },
		    series: [{
// 		        name: '属性分布',
		        type: 'radar',
		        // areaStyle: {normal: {}},
		        data : [
		            {
		                value : ['${pro.hp}','${pro.atk}','${pro.def}','${pro.spatk}','${pro.spdef}','${pro.speed}'],
		                name : '属性'
		            }
		        ]
		    }]
		};
	atRadar.setOption(option);
	
})
</script>
</html>