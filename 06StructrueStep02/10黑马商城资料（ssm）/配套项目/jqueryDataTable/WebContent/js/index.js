/**
 * 从指定的数据文件加载数据:可以是".txt",".json"
 */
$(function() {
	/* Javascript代码片段 */
	var t = $('#example').DataTable(
			{
				ajax : {
					// 指定数据源
					url : "data/data.txt"//返回json格式的数据(注意:不要跨域)
				},
				// 每页显示三条数据
				pageLength : 3,
				columns : [ {//每列绑定的数据(和数据源中返回的数据对应,data:"param" param要和返回的json数据中的属性对应)
					"data" : null
				// 此列不绑定数据源，用来显示序号
				}, {
					"data" : "id"
				}, {
					"data" : "title"
				}, {
					"data" : "url"
				} ],
				"columnDefs" : [ //每列定义
						{
							"render" : function(data, type, row, meta) {
								// 渲染 把数据源中的标题和url组成超链接
								return '<a href="' + data
										+ '" target="_blank">' + row.title
										+ '</a>';
							},
							// 指定是第三列
							"targets" : 2
						} ],
				"lengthMenu": [3,10, 25, 50, 75, 100] //指定每页数量
			});

	// 前台添加序号
	t.on('order.dt search.dt', function() {
		t.column(0, {
			"search" : 'applied',
			"order" : 'applied'
		}).nodes().each(function(cell, i) {
			cell.innerHTML = i + 1;
		});
	}).draw();

	// 更换数据源（相同格式，但是数据内容不同）
	var flag=true;
	$("#redraw").click(
		function() {
			if(flag){
				var url = $('#example').DataTable().ajax.url("data/newData.txt");
				url.load();
				flag=false;
			}else{
				var url = $('#example').DataTable().ajax.url("data/data.txt");
				url.load();
				flag=true;
			}
		}
	);

});