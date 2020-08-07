//页面加载就会调用操作
$(function() {
	// 页面加载完成后，调用查询所有产品操作
	findAllProduct();
})

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
// 关闭操作
function shutdown() {
	// 将浏览器窗口关闭
	var flag = window.confirm("确认关闭窗口吗");
	if (flag) {
		$.post("/p2p_management/user?method=shutdown", function() {

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

		});
	}
};

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
		
		$("#editBtn").unbind("click");

		// 点击修改按钮进行修改
		$("#editBtn").bind(
				"click",
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

// 添加产品
function addProduct() {
	// 显示弹窗
	$('#addModal').modal('show');

	// 在添加事件前先进行事件解绑操作，以保证当前按钮只绑定一次。
	$("#addBtn").unbind("click");

	// 点击添加按钮
	$("#addBtn").bind("click", function() {
		// 1.获取表单数据
		var json = $("#addProductForm").serializeJson();

		// 2.向服务器发送请求
		$.post("/p2p_management/product?method=add", json, function(data) {
			// 在关闭窗口前可以清空录入的数据
			// 将弹窗关闭
			$('.ui.modal').modal('hide');
			$("#addBtn").unbind("click");
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