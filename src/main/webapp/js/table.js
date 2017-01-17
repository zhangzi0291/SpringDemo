var tableoption={
		method: 'post',
		contentType: "application/x-www-form-urlencoded",
		url:basePath+"/getpoke",
		pagination: true,
		cache: false,
		striped:true,
		pageNumber:1,
		pageSize: 10,
		pageList: [10,20],
		sidePagination:'server',//设置为服务器端分页
		queryParams: function (params) {
			return params;
		},//参数
		toolbar: '#toolbar',
		showExport: true,        	//显示导出按钮
		exportDataType: "all",	//
		showRefresh: true,		//显示刷新按钮
		clickToSelect: true,		//点击选择
// 		showFooter:true,
// 		contentType: "application/x-www-form-urlencoded",
// 		height: $(window).height() - 200,
		sortName:"", //排序
	    columns:	[  ] //需要修改
       }