<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Req.aspx.cs" Inherits="Req" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" >
<head runat="server">
    <title>在线支付测试</title>
</head>
<body>
    <h4>GET方式</h4>
	<div id="yeepayGet"><a href="<%=htmlCodeGet %>"><%=htmlCodeGet %></a></div>
	<h4>POST方式</h4>
	<div id="yeepayPost"><%=htmlCodePost %></div>
	<h5>样式1</h5>
	<div><a href="javascript:window.frmYeepay.submit();"><img src="Images/YeepayOnlineImageButton1.gif"></a></div>
	<div>易宝支付：支持国内银行卡、信用卡，安全、稳定、高速，是您可信赖的电子支付平台。（工商银行、招商银行、建设银行、农业银行、民生银行、邮政储蓄、中国银行、交通银行、广发银行、深发银行、兴业银行、中信银行、上海浦发银行、北京银行…）</div>
	<h5>样式2</h5>
	<div><a href="javascript:window.frmYeepay.submit();"><img src="Images/YeepayOnlineImageButton2.gif"></a></div>
	<div>全面支持国内各种银行卡，安全稳定、您可信赖！</div>
	<h5>样式3</h5>
	<div><a href="javascript:window.frmYeepay.submit();"><img src="Images/YeepayOnlineImageButton3.gif"></a></div>
	<div>YeePay易宝银行卡网上支付：支持国内银行卡、信用卡，安全、稳定、高速，是您可信赖的电子支付平台。（工商银行、招商银行、建设银行、农业银行、民生银行、邮政储蓄、中国银行、交通银行、广发银行、深发银行、兴业银行、中信银行、上海浦发银行、北京银行…）</div>
</body>
</html>