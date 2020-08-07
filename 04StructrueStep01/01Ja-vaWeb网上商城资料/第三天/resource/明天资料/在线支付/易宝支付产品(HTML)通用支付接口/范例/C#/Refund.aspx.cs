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

public partial class Refund : System.Web.UI.Page
{
    private string p1_MerId;
    private string keyValue;
    private string pb_TrxId;
    private string p3_Amt;
    private string p5_Desc;

    protected void Page_Load(object sender, EventArgs e)
    {
        // 设置 Response编码格式为GB2312
        Response.ContentEncoding = System.Text.Encoding.GetEncoding("gb2312");

        p1_MerId = "10000432521";                                     // 商家ID
        keyValue = "8UPp0KE8sq73zVP370vko7C39403rtK1YwX40Td6irH216036H27Eb12792t";  // 商家密钥

        //Buy.NodeAuthorizationURL = @"https://www.yeepay.com/app-merchant-proxy/node";   // 设置请求地址
        Buy.NodeAuthorizationURL = @"http://tech.yeepay.com:8080/robot/debug.action"; //test


        pb_TrxId = Request.Form["pb_TrxId"];
        p3_Amt = Request.Form["p3_Amt"];
        p5_Desc = Request.Form["p5_Desc"];

        try
        {
            BuyRefundOrdResult result = Buy.RefundOrd(p1_MerId, keyValue, pb_TrxId, p3_Amt, "CNY", p5_Desc);

            if (result.R1_Code == "1")
            {
                Response.Write("退款成功");
                Response.Write("<br>退款金额:" + result.R3_Amt);
            }
            else
            {
                Response.Write("退款失败 " + result.R1_Code);
            }
        }
        catch (Exception ex)
        {
            Response.Write(ex.ToString());
        }

    }
}
