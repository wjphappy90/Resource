//页面加载就会调用操作
$(function() {
	// 页面加载完成后，调用查询所有产品操作
	// findAllProduct();

	findAllProductByPage(pageNum, pageSize);
})

var pageNum = 1;
var pageSize = 3;
var totalPage = 0;
var totalCount = 0;

// 分页查询产品信息
function findAllProductByPage(pn, ps) {
	// 1.向服务器发送请求
	var url = "/p2p_management/product?method=findAllByPage"
	$
			.post(
					url,
					{
						"pageNum" : pn,
						"pageSize" : ps
					},
					function(data) {

						var json = eval(data); // 处理json数据
						var jsonObj = json.content; // 用于分页显示的数据
						totalPage = json.totalPage;
						totalCount = json.totalCount;
						pageNum = json.pageNum;
						pageSize = json.pageSize;
						var html = "";

						for (var i = 0; i < jsonObj.length; i++) {
							html += "<tr><td>"
									+ (i + 1)
									+ "</td><td>"
									+ (jsonObj[i].proNum)
									+ "</td><td>"
									+ (jsonObj[i].proName)
									+ "</td><td>"
									+ (jsonObj[i].proLimit)
									+ "</td><td>"
									+ (jsonObj[i].annualized)
									+ "%</td><td><a href='javascript:void(0)' onclick=findById("
									+ (jsonObj[i].id) + ")>编辑</a></td></tr>"
						}

						// 将转换成的html代码显示在页面上
						$("#pbody").html(html);

						// 将分页条展示
						var pageHtml = "";
						// 上一页
						if (pageNum <= 1) {
							pageHtml += "<a class='icon item'> <i class='left chevron icon'></i>";
						} else {
							pageHtml += "<a class='icon item' onclick='findAllProductByPage("
									+ (pageNum - 1)
									+ ","
									+ pageSize
									+ ")'><i class='left chevron icon'></i>";
						}
						for (var i = 0; i < totalPage; i++) {
							pageHtml += "<a class='item' onclick='findAllProductByPage("
									+ (i + 1)
									+ ","
									+ pageSize
									+ ")'>"
									+ (i + 1) + "</a>";
						}
						// 下一页
						if (pageNum >= totalPage) {
							pageHtml += "<a class='icon item'> <i class='right chevron icon'></i></a>";
						} else {
							pageHtml += "<a class='icon item' onclick='findAllProductByPage("
									+ (pageNum + 1)
									+ ","
									+ pageSize
									+ ")'> <i class='right chevron icon'></i></a>";
						}

						// 将分页条信息展示
						$("#pagination").html(pageHtml);

						// 显示总条数与当前页
						$("#totalCount").html(totalCount);
						$("#pageNum").html(pageNum);

					}, "json");
}

// 查询所有的产品信息
function findAllProduct() {
	// 1.向服务器发送请求
	var url = "/p2p_management/product?method=findAll"
	$
			.post(
					url,
					function(data) {

						var jsonObj = eval(data); // 处理json数据

						var html = "";

						for (var i = 0; i < jsonObj.length; i++) {
							html += "<tr><td>"
									+ (i + 1)
									+ "</td><td>"
									+ (jsonObj[i].proNum)
									+ "</td><td>"
									+ (jsonObj[i].proName)
									+ "</td><td>"
									+ (jsonObj[i].proLimit)
									+ "</td><td>"
									+ (jsonObj[i].annualized)
									+ "%</td><td><a href='javascript:void(0)' onclick=findById("
									+ (jsonObj[i].id) + ")>编辑</a></td></tr>"
						}

						// 将转换成的html代码显示在页面上
						$("#pbody").html(html);

					}, "json");
}

// 根据id查询产品
function findById(id) {

	// 向服务器发送请求，根据id查询产品
	var url = "/p2p_management/product?method=findById"
	$.post(url, {
		"id" : id
	}, function(data) {
		// 弹出一个窗口来显示产品信息
		$('#editModal').modal('show');
		// 回显示数据
		var jsonObj = eval("(" + data + ")");

		$("#proNum").val(jsonObj.proNum);
		$("#proName").val(jsonObj.proName);
		$("#proLimit").val(jsonObj.proLimit);
		$("#annualized").val(jsonObj.annualized);

		// 点击修改按钮进行修改
		$("#editBtn").click(
				function() {
					// 得到了表单数据
					var json = $("#editProductForm").serializeJson();
					// 注意:这时没有产品的id,服务器端进行修改时就知道根据哪一个id进行修改
					json.id = id;
					// 向服务器发送请求，进行修改操作
					$.post("/p2p_management/product?method=update", json,
							function(data) {
								// 关闭编辑窗口
								$('#editModal').modal('hide');
								// 在查询产品
								findAllProduct();
							});
				});
	});
}

// 关闭操作
function shutdown() {
	$.post("/p2p_management/user?method=shutdown", function() {
		// 将浏览器窗口关闭
		var flag = window.confirm("确认关闭窗口吗");
		if (flag) {
			// window.close(); // 它存在浏览器的兼容问题
			if (navigator.userAgent.indexOf("MSIE") > 0) {
				if (navigator.userAgent.indexOf("MSIE 6.0") > 0) {
					window.opener = null;
					window.close();
				} else {
					window.open('', '_top');
					window.top.close();
				}
			} else if (navigator.userAgent.indexOf("Firefox") > 0) {
				window.location.href = 'about:blank ';
			} else {
				window.opener = null;
				window.open('', '_self', '');
				window.close();
			}

		}
	});
};

// 添加产品
function addProduct() {
	// 显示弹窗
	$('#addModal').modal('show');
	// 点击添加按钮
	$("#addBtn").click(function() {
		// 1.获取表单数据
		var json = $("#addProductForm").serializeJson();

		// 2.向服务器发送请求
		$.post("/p2p_management/product?method=add", json, function(data) {
			// 在关闭窗口前可以清空录入的数据
			// 将弹窗关闭
			$('.ui.modal').modal('hide');
			// 在查询产品
			findAllProduct();

		});
	});

};

// 自定义的jquery函数
$.fn.extend({
	serializeJson : function() {
		var json = {}; // 就是一个javascript的对象.
		// 1.通过jquery提供的serializeArray方法得到不符合要求的json串
		var msg = this.serializeArray();
		// console.info(msg);
		// [Object { name="username", value="tom"}, Object { name="password",
		// value="123"}, Object { name="hobby", value="eat"}, Object {
		// name="hobby", value="drink"}, Object { name="hobby", value="play"}]
		$(msg).each(function() {
			if (json[this.name]) { // 在json对象中没有this.name对应的值
				// 有,需要考虑一个名称对应多个值，而这些值应该放入到数组中
				if (!json[this.name].push) { // 如果为true,代表是数组,如果为false，代表不是数组
					json[this.name] = [ json[this.name] ];
				}
				json[this.name].push(this.value || ''); // 装入到数组

			} else {
				// 没有
				json[this.name] = this.value || '';
			}
		});

		return json
	}
});
