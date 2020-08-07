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

public partial class Callback : System.Web.UI.Page
{
    private static string p1_MerId;
    private static string keyValue;

    protected void Page_Load(object sender, EventArgs e)
    {
        if (!IsPostBack)
        {
            p1_MerId = "10000432521";                                     // 商家ID
            keyValue = "8UPp0KE8sq73zVP370vko7C39403rtK1YwX40Td6irH216036H27Eb12792t";  // 商家密钥
            //Buy.NodeAuthorizationURL = @"https://www.yeepay.com/app-merchant-proxy/node";   // 设置请求地址

            // 校验返回数据包
            BuyCallbackResult result = Buy.VerifyCallback(p1_MerId, keyValue, Buy.GetQueryString("r0_Cmd"), Buy.GetQueryString("r1_Code"), Buy.GetQueryString("r2_TrxId"),
                Buy.GetQueryString("r3_Amt"), Buy.GetQueryString("r4_Cur"), Buy.GetQueryString("r5_Pid"), Buy.GetQueryString("r6_Order"), Buy.GetQueryString("r7_Uid"),
                Buy.GetQueryString("r8_MP"), Buy.GetQueryString("r9_BType"), Buy.GetQueryString("rp_PayDate"), Buy.GetQueryString("hmac"));

            if (string.IsNullOrEmpty(result.ErrMsg))
            {
                if (result.R1_Code == "1")
                {
                    if (result.R9_BType == "1")
                    {
                        //  callback方式:浏览器重定向
                        Response.Write("支付成功!<br>商品ID:" + result.R5_Pid + "<br>商户订单号:" + result.R6_Order + "<br>支付金额:" + result.R3_Amt + "<br>易宝支付交易流水号:" + result.R2_TrxId + "<BR>");
                    }
                    else if (result.R9_BType == "2")
                    {
                        // * 如果是服务器返回或者电话支付返回(result.R9_BType==2 or result.R9_BType==3)则需要回应一个特定字符串'SUCCESS',且在'SUCCESS'之前不可以有任何其他字符输出,保证首先输出的是'SUCCESS'字符串
                        Response.Write("SUCCESS");
                    }
                    else if (result.R9_BType == "3")
                    {
                        // * 如果是服务器返回或者电话支付返回(result.R9_BType==2 or result.R9_BType==3)则需要回应一个特定字符串'SUCCESS',且在'SUCCESS'之前不可以有任何其他字符输出,保证首先输出的是'SUCCESS'字符串
                        Response.Write("SUCCESS");
                    }
                }
                else
                {
                    Response.Write("支付失败!");
                }
            }
            else
            {
                Response.Write("交易签名无效!");
            }
        }
    }
}
