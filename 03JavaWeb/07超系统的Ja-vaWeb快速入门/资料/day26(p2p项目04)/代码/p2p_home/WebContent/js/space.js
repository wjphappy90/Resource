//页面加载完成后，会调用
$(function() {
	// 向服务器发送请求，来获取当前客户的帐户信息
	$.post("/p2p_home/account?method=findByCustomer", function(data) {
		var jsonObj = eval("(" + data + ")");
		if (jsonObj.type == 0) {
			alert(jsonObj.error);
			location.href = "/p2p_home/login.html";
		} else {
			// 将帐户信息进行处理

			$("#total").html(jsonObj.content.total);
			$("#balance").html(jsonObj.content.balance);
			$("#interest").html(jsonObj.content.interest);

			// 得到客户信息，处理认证显示问题
			if (jsonObj.content.c.email_status == 1) {
				$("#emailStatus").html("已认证");
				$("#emailStatus").attr("class", "yes");
				$("#emailIcon").attr("class", "glyphicon glyphicon-ok-circle");
			}
		}
	});
});

// 显示邮箱认证弹出窗口
function showMailModal() {

	// 向服务器发送请求，获取当前用户的邮箱信息
	$.post("/p2p_home/customer?method=findCustomer", function(data) {
		var jsonObj = eval("(" + data + ")");
		if (jsonObj.type == 0) {
			alert(jsonObj.error);
		} else {
			// 没有认证,将客户的邮箱显示在文本框中
			$("#emailAddr").val(jsonObj.content.email);
			// 弹出窗口
			$('#emailModal').modal('show');

			$("#emailSendBtn").click(function() {
				// 向服务器发送请求，发送邮件
				$.post("/p2p_home/customer?method=sendEmail", {
					"email" : $("#emailAddr").val()
				}, function(data) {
					var jsonObj = eval("(" + data + ")");
					if (jsonObj.type == 0) {
						alert(jsonObj.error);
					} else {
						alert("邮件发送成功，请查阅邮件，尽快认证");
					}
				});
			});

		}
	})

};
// 邮箱认证操作
function emailRz() {
	// 1.获取邮箱地址与录入的验证码
	var emailAddr = $("#emailAddr").val();
	var emailCode = $("#emailCheckCode").val();
	alert(emailAddr + "   " + emailCode);
	// 2.向服务器发送请求
	$.post("/p2p_home/customer?method=checkEmail", {
		"email" : emailAddr,
		"emailCode" : emailCode
	}, function(data) {
		var jsonObj = eval("(" + data + ")");
		if (jsonObj.type == 0) {
			alert(jsonObj.error);
		} else {
			// 成功
			alert("邮箱认证成功");
			$("#emailStatus").html("已认证");
			$("#emailStatus").attr("class", "yes");
			$("#emailIcon").attr("class", "glyphicon glyphicon-ok-circle");
			$('#emailModal').modal('hide');
		}
	});
};

// 查询投资信息
function findProductAccount() {

	$.post("/p2p_home/productAccount?method=findByCustomer", function(data) {

		var jsonObj = eval("(" + data + ")");

		if (jsonObj.type == 0) {
			alert(jsonObj.error);
		} else {
			// 显示帐户信息
			$("#totalMoney").html(jsonObj.content.account.total);
			$("#balanceMoney").html(jsonObj.content.account.balance);
			$("#interestMoney").html(jsonObj.content.account.interest);

			// 展示购买理财产品信息
			var html = "";
			var reinterest = 0;
			for (var i = 0; i < jsonObj.content.productAccount.length; i++) {
				var pa = jsonObj.content.productAccount[i]; // 当前一条购买的理财产品信息
				html += "<tr><td>" + (pa.pa_num) + "</td><td>" + (pa.p.proName)
						+ "</td><td>" + (pa.p.proLimit) + "月</td><td>"
						+ (pa.p.annualized) + "%</td><td>" + (pa.interest)
						+ "</td><td>" + (pa.c.c_name) + "</td><td>"
						+ (new Date(pa.pa_date).toLocaleDateString())
						+ "</td><td>" + (pa.money) + "元</td><td>"
						+ (pa.status == 0 ? "否" : "是") + "</td></tr>";

				if (pa.status == 0) {
					reinterest += pa.interest;
				}
				;

			}

			$("#reinterestMoney").html(reinterest); // 待收益
			$("#pabody").html(html);
		}

	});
}
