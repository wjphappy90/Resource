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
public partial class Req : System.Web.UI.Page
{
    private static string p1_MerId;
    private static string keyValue;
    private string p2_Order;
    private string p3_Amt;
    private string p4_Cur;
    private string p5_Pid;
    private string p6_Pcat;

    private string p7_Pdesc;
    private string p8_Url;
    private string p9_SAF;
    private string pa_MP;
    private string pd_FrpId;
    private string pr_NeedResponse;

    public string htmlCodeGet;
    public string htmlCodePost;

    protected void Page_Load(object sender, EventArgs e)
    {
        // 设置 Response编码格式为GB2312
        Response.ContentEncoding = System.Text.Encoding.GetEncoding("gb2312");

        p1_MerId = "10000432521";                                     // 商家ID
        keyValue = "8UPp0KE8sq73zVP370vko7C39403rtK1YwX40Td6irH216036H27Eb12792t";  // 商家密钥
        
        // 设置请求地址
        Buy.NodeAuthorizationURL = @"http://tech.yeepay.com:8080/robot/debug.action"; //test
        //Buy.NodeAuthorizationURL = @"https://www.yeepay.com/app-merchant-proxy/node";   //生产

        // 商家设置用户购买商品的支付信息.
        //易宝支付平台统一使用GBK/GB2312编码方式,参数如用到中文，请注意转码

        // 商户订单号,选填.
        //若不为""，提交的订单号必须在自身账户交易中唯一;为""时，易宝支付会自动生成随机的商户订单号.
        p2_Order = Request.Form["p2_Order"];  
     
        // 支付金额,必填.
        //单位:元，精确到分.                   
        p3_Amt = Request.Form["p3_Amt"]; 
                           
        //交易币种,固定值"CNY".
        p4_Cur = "CNY";

        //商品名称
        //用于支付时显示在易宝支付网关左侧的订单产品信息.
        p5_Pid = Request.Form["p5_Pid"];
                
        //商品种类
        p6_Pcat = Request.Form["p6_Pcat"];
        
        //商品描述
        p7_Pdesc = Request.Form["p7_Pdesc"];
        
        //商户接收支付成功数据的地址,支付成功后易宝支付会向该地址发送两次成功通知.
        p8_Url = Request.Form["p8_Url"];

        //送货地址
        //为“1”: 需要用户将送货地址留在易宝支付系统;为“0”: 不需要，默认为 ”0”.
        p9_SAF = "0";

        //商户扩展信息
        //商户可以任意填写1K 的字符串,支付成功时将原样返回.	
        pa_MP = Request.Form["pa_MP"];

        //银行编码
        //默认为""，到易宝支付网关.若不需显示易宝支付的页面，直接跳转到各银行、神州行支付、骏网一卡通等支付页面，该字段可依照附录:银行列表设置参数值.
        pd_FrpId = Request.Form["pd_FrpId"]; 

        //应答机制
        //为"1": 需要应答机制;为"0": 不需要应答机制.
        pr_NeedResponse = Request.Form["pr_NeedResponse"];			
	
        //创建一个Form

        //创建GET方式的url
        htmlCodeGet = Buy.CreateBuyUrl(p1_MerId, keyValue, p2_Order, p3_Amt, p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP, pd_FrpId, pr_NeedResponse);
    }
}
