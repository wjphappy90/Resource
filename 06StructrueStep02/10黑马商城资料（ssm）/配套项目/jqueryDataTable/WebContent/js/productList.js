$(function() {
	/*Javascript代码片段*/
	var t = $('#sample-table').DataTable(
			{
				ajax : {
					//指定数据源
					url : "/jqueryDataTable/product/findProductList.do"
				},
				//每页显示三条数据
				pageLength : 3,
				columns : [ {
					"data" : null //此列不绑定数据源，用来显示序号
				}, {
					"data" : "id"
				}, {
					"data" : "name"
				}, {
					"data" : "price"
				}],
				"columnDefs" : [{//每列定义
					"orderable": false,
					"targets": [0,2]//第0,2列不排序
				},
				{//自定义第"3"列内容(注意:列下标从"0"开始)
					"targets": 3,
					"render" : function(data, type, row, meta) {
						//渲染 把数据源中的标题和url组成超链接
						return '<td>'+data+'</td>';
					}
				}]
			});
	//前台添加序号
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
				var url = $('#sample-table').DataTable().ajax.url("data/test-data.json");
				url.load();
				flag=false;
			}else{
				var url = $('#sample-table').DataTable().ajax.url("/jqueryDataTable/product/findProductList.do");
				url.load();
				flag=true;
			}
		}
	);
});