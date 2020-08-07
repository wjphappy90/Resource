//注册操作
function regist() {
	// 校验客户名称 邮箱 密码 确认密码 不为空
	var flag1 = notNull($("#c_name"));
	if (!flag1) {
		// 客户名称 为空
		tip($("#c_name"), "客户名称不能为空", "red");
		return;
	}
	var flag2 = notNull($("#email"));
	if (!flag2) {
		// 客户名称 为空
		tip($("#email"), "邮箱不能为空", "red");
		return;
	}
	var flag3 = notNull($("#password"));
	if (!flag3) {
		// 客户名称 为空
		tip($("#password"), "密码不能为空", "red");
		return;
	}
	var flag4 = notNull($("#confirmPassword"));
	if (!flag4) {
		// 客户名称 为空
		tip($("#confirmPassword"), "确认密码不能为空", "red");
		return;
	}

	// 验证客户名称符合规范
	var flag5 = regex($("#c_name"), "^[a-zA-Z]{1}[a-zA-Z0-9]{2,9}$");
	if (!flag5) {
		tip($("#c_name"), "用户名必须是字母开头并且不能少于3位不能多余10位", "red");
		return;
	}

	// 验证邮箱符合规范
	var flag6 = regex($("#email"), "^(\\w)+(\\.\\w+)*@(\\w)+((\\.\\w+)+)$");
	if (!flag6) {
		tip($("#email"), "邮箱不符合规范", "red");
		return;
	}
	// 密码与确认密码是否一致
	if ($("#password").val() != $("#confirmPassword").val()) {
		tip($("#confirmPassword"), "确认密码不一致xxxxx", "red");
		return;
	}

	// 1.获取表单中数据
	var formData = $("#regform").serializeJson();

	// 2.向服务器发送请求
	$.post("/p2p_home/customer?method=regist", formData, function(data) {

		var jsonObj = eval("(" + data + ")");

		if (jsonObj.type == 0) {
			// 失败
			alert(jsonObj.error);
		} else if (jsonObj.type == 1) {
			// 成功
			alert("注册成功");
			location.href = "/p2p_home/space.html";
		}
	});

}

// 登录操作
function customerLogin() {
	// 1.得到客户名称 ，密码，图片验证码
	var json = $("#loginForm").serializeJson();
	// 2.向服务器发送请求
	$.post("/p2p_home/customer?method=login", json, function(data) {

		var jsonObj = eval("(" + data + ")");
		if (jsonObj.type == 0) {
			alert(jsonObj.error);
		} else {
			alert("登录成功");
			location.href = "/p2p_home/space.html";
		}
	});
}

// 点击切换图片验证码
function changeImg() {
	$("#imageCode").attr("src",
			"/p2p_home/imageCode?time=" + new Date().getTime());
}

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

function notNull(obj) {
	var value = $.trim(obj.val());
	if (value.length == 0) {
		return false;
	}
	return true;
}
function regex(obj, reg) {
	var regMatch = new RegExp(reg);
	if (regMatch == null || regMatch == "null") {
		return true;
	}
	var result = $.trim(obj.val());
	if (!regMatch.test(result)) {
		return false;
	}
	return true;
}

function tip(obj, msg, color) {
	var parent = obj.parent();
	var tips = parent.find("span");
	if (tips.length == 0) {
		obj.parent().append(
				"<span><font color=" + color + ">" + msg + "</font></span>");
	} else {
		tips.html("<font color=" + color + ">" + msg + "</font>");
	}
}