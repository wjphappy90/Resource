using System;
using System.Data;
using System.Configuration;
using System.Collections;
using System.Web;
using System.Web.Security;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.UI.WebControls.WebParts;
using System.Web.UI.HtmlControls;
using com.yeepay;
public partial class QueryOrderStatus : System.Web.UI.Page
{
    public string p1_MerId;
    public string keyValue;
    public string p2_Order;

    protected void Page_Load(object sender, EventArgs e)
    {
        p1_MerId = "10000432521";                                     // 商家ID
        keyValue = "8UPp0KE8sq73zVP370vko7C39403rtK1YwX40Td6irH216036H27Eb12792t";  // 商家密钥

        //Buy.NodeAuthorizationURL = @"https://www.yeepay.com/app-merchant-proxy/node";   // 设置请求地址
        Buy.NodeAuthorizationURL = @"http://tech.yeepay.com:8080/robot/debug.action"; //test

        p2_Order = Request.Form["p2_Order"];  // 商家的交易定单号

        try
        {
            BuyQueryOrdDetailResult result = Buy.QueryOrdDetail(p1_MerId, keyValue, p2_Order);	// 查询订单

            if (result.R1_Code == "1")
            {
                Response.Write("查询成功!");
                Response.Write("<br>商户订单号:" + result.R6_Order);
                Response.Write("<br>商品名称:" + result.R5_Pid);
                Response.Write("<br>支付金额:" + result.R3_Amt);
                Response.Write("<br>订单状态:" + result.Rb_PayStatus);
            }
            else
            {
                Response.Write("<br>查询失败!" + result.R1_Code);
            }
        }

        catch (Exception ex)
        {
            Response.Write(ex.Message);
        }
    }
}
