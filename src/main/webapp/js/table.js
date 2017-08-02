var tableOption
function getOption(option){
	var tableoption = initOption();
	if (option.url != undefined) {
		tableoption.url = option.url;
	}
	if (option.method != undefined) {
		tableoption.method = option.method;
	}
	if (option.contentType != undefined) {
		tableoption.contentType = option.contentType;
	}
	if (option.pageSize != undefined) {
		tableoption.pageSize = option.pageSize;
	}
	if (option.pageList != undefined) {
		tableoption.pageList = option.pageList;
	}
	if (option.queryParams != undefined) {
		tableoption.queryParams = option.queryParams;
	}
	if (option.showExport != undefined) {
		tableoption.showExport = option.showExport;
	}
	if (option.exportDataType != undefined) {
		tableoption.exportDataType = option.exportDataType;
	}
	if (option.showRefresh != undefined) {
		tableoption.showRefresh = option.showRefresh;
	}
	if (option.clickToSelect != undefined) {
		tableoption.clickToSelect = option.clickToSelect;
	}
	if (option.sortName != undefined) {
		tableoption.sortName = option.sortName;
	}
	if (option.columns != undefined) {
		tableoption.columns = option.columns;
	}
	if (option.onLoadSuccess != undefined) {
		tableoption.onLoadSuccess = option.onLoadSuccess;
	}
	if (option.onLoadError != undefined) {
		tableoption.onLoadError = option.onLoadError;
	}
	if (option.sidePagination != undefined) {
		tableoption.sidePagination = option.sidePagination;
	}
	if (option.search != undefined) {
		tableoption.search = option.search;
	}
	
	return tableoption
}
function initOption(){
	var tableoption={
			method: 'post',
			contentType: "application/x-www-form-urlencoded",
			url:"",//需要修改
			pagination: true,
			cache: false,
			striped:true,
			pageNumber:1,
			pageSize: 10,
			pageList: [10,20],
			sidePagination:'server',//设置为服务器端分页
			queryParams: function (params) {
				return params;
			},//查询，需要修改
			toolbar: '#toolbar',
			showExport: true,        	//显示导出按钮
			exportDataType: "all",	//
			showRefresh: true,		//显示刷新按钮
			clickToSelect: true,		//点击选择
//	 		showFooter:true,
			sortName:"", //排序
		    columns:	[  ], //需要修改
		    onLoadSuccess : function(data){//加载成功
		    	console.log(data)
		    	resizeContent();
		    },
			onLoadError: function(){  //加载失败回调
	            layer.msg("加载数据失败", {time : 1500, icon : 2});  
			},  
	   }

	return tableoption;
}
