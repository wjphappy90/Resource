$(function() {

	// 1.向p2p_management发送请求来查询所有的产品信息
	$
			.getJSON(
					"/p2p_management/product?method=findAll&callback=?",
					function(data) {
						var jsonObj = eval(data);
						var html = "";

						for (var i = 0; i < jsonObj.length; i++) {
							var product = jsonObj[i]
							html += "<li><div class='col-sm-6 col-md-4'><div class='thumbnail'><div class='caption pro1'> <h4>"
									+ (product.proName)
									+ "</h4> </div><img src='img/help/m-ico_01.png' /><div class='caption'><h4>利率:"
									+ (product.annualized)
									+ "%</h4><h4>期限:"
									+ (product.proLimit)
									+ "月</h4><a href='#shopArea1' onclick='setBuyMsg("
									+ product.id
									+ ")'  data-toggle='tab' class='btn btn-info'>我要购买</a></div></div><span class='ico'></span></div></li>";
						}

						$("#row").html(html);

						$('.dowebok').liMarquee({
							direction : 'up', // 设置滚动方向
							scrollamount : '40', // 设置滚动速度
							runshort : false
						// 内容未超过容器宽度（高度），不滚动。
						});

					});

});

function setBuyMsg(pid) {
	$("#num").val("");
	$("#buyBtn").attr("disabled", "false");
	$("#interest").html("0");
	// 向服务器发送请求来获取产品信息,根据id,要使用跨域
	$.getJSON("/p2p_management/product?method=findById&callback=?", {
		"id" : pid
	}, function(data) {

		var product = eval(data);

		$("#annualized").html(product.annualized);

		// 失去焦点
		$("#num").blur(
				function() {
					// 预期收益=本金*预期收益率/100/12*limit
					var interest = $("#num").val() * product.annualized / 100
							/ 12 * product.proLimit;

					var interestStr = interest + ""; // 转换成string
					var index = interestStr.indexOf("\."); // 判断是否包含"."
					if (index != -1) {
						interest = parseFloat(interestStr.substring(0,
								index + 3)); // 截取后在转换成数值
					}

					time(product.proName, product.proLimit, product.annualized,
							interest);
				});

		// 点击购买按钮向服务器发送请求。
		$("#buyBtn").click(
				function() {
					var buyMsg = {}; // 创建javascript对象
					buyMsg.pid = product.id; // 产品id
					buyMsg.money = $("#num").val(); // 投资金额

					$.post("/p2p_home/productAccount?method=buy", buyMsg,
							function(data) {

								var jsonObj = eval("(" + data + ")");
								if (jsonObj.type == 0) {
									alert(jsonObj.error);
								} else {
									alert("投资成功");
								}

							});

				});

	});
}

function time(name, limit, annualized, interest) {
	var nu = $("#num").val();
	if (null == nu || "" == nu) {
		$(".word").html("");
	} else {
		if (nu % 100 == 0) {
			$(".word").html("");

			$("#msg").html(
					'您选择了<span class="yellow">《' + name
							+ '》</span>加入的本金为<span	class="yellow">' + nu
							+ '</span>元，投资期限为<span class="yellow">' + limit
							+ '个月</span>，预期年化收益率为<span class="yellow">'
							+ annualized
							+ '%</span>,预期收益金额为<span class="yellow">'
							+ interest + '</span>元,请确认购买。');

			$("#interest").html(interest);
			$("#buyBtn").removeAttr("disabled");

		} else {
			$(".word").html("请输入100的整数倍");
			$("#num").val("");
			$("#num").attr("placeholder", "金额需为100的整数倍");
		}
	}
};