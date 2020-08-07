首先欢迎您们选择易宝支付提供的支付接入服务。此目录下面的例子是用C#的写成，您可以直接把所有文件放在VS应用的目录下，进行测试运行。
1）文件列表说明
	|-----------------------------------------------------
	|----Index.html:提供给商户测试用的首页:测试用的支付输入页面,提交后商户输入的参数会提交到易宝支付或相应银行网关;订单查询输入页面;订单退款请求输入页面.)
	|----Req.aspx:(支付请求文件，通过此文件发起支付请求，商家可以在此文件中写入自己的订单信息等，然后把请求提交给易宝支付）
	|----Callback.aspx:(支付结果返回文件，通过此文件商家判断对应订单的支付成功状态，并且根据结果修改自己数据库中的订单状态）
	|----QueryOrderStatus.aspx:(订单查询文件，通过此文件商家查询订单的支付状态）
	|----Refund.aspx:(订单退款文件，通过此文件商家提交订单退款请求）
 	|----Web.config: 配置文件主用来设置编码方式  <globalization   requestEncoding="gb2312"   responseEncoding="gb2312"   /> 
	|----[Bin]
			|----com.yeepay.dll:易宝支付封装dll,需要在应用中添加对此dll的引用。
			API函数说明：（命名空间com.yeepay）
			
			|----通用接口支付请求
				方法1（创建From）：Buy.CreateForm(p1_MerId, keyValue, p2_Order, p3_Amt, p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP, pd_FrpId, pr_NeedResponse)
				方法2（创建Url）：Buy.CreateBuyUrl(p1_MerId, keyValue, p2_Order, p3_Amt, p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP, pd_FrpId, pr_NeedResponse)
				返回类型：string
				参数说明：
					p1_MerId		商家编号
					keyValue		商家密钥
					p2_Order		商户订单号
					p3_Amt			支付金额
					p4_Cur			交易币种
					p5_Pid			商品名称
					p6_Pcat			商品种类
					p7_Pdesc		商品描述
					p8_Url			商户接收支付成功数据的地址
					p9_SAF			送货地址
					pa_MP				商户扩展信息
					pd_FrpId		银行编码
					pr_NeedResponse	应答机制
					
			|----通用接口支付结果返回 校验返回数据包
				方法：Buy.VerifyCallback(p1_MerId, keyValue, r0_Cmd, r1_Code, r2_TrxId, r3_Amt, r4_Cur, r5_Pid, r6_Order, r7_Uid, r8_MP, r9_BType, hmac)
				返回类型：bool
				参数说明：
					p1_MerId		商家编号
					keyValue		商家密钥
					r0_Cmd			业务类型
					r1_Code			返回代码
					r2_TrxId		易宝支付交易流水号
					r3_Amt			支付金额
					r4_Cur			交易币种
					r5_Pid			商品名称
					r6_Order		商户订单号
					r7_Uid			易宝支付会员ID
					r8_MP				商户扩展信息
					r9_BType		交易结果返回类型
					hmac				签名数据
					
			|----查询订单明细
				方法：Buy.QueryOrdDetail(p1_MerId, keyValue, p2_Order)
				返回类型：BuyQueryOrdDetailResult
				参数说明：
					p1_MerId		商家编号
					keyValue		商家密钥
					p2_Order		商户订单号
				返回参数：
					r0_Cmd			业务类型
					r1_Code			查询结果
					r2_TrxId		易宝支付交易流水号
					r3_Amt			支付金额
					r4_Cur			交易币种
					r5_Pid			商品名称
					r6_Order		商户订单号
					r8_MP				商户扩展信息
					rb_PayStatus		支付状态
					rc_RefundCount	已退款次数
					rd_RefundAmt		已退款金额
					hmac				签名数据

					
			|----订单退款明细
				方法：Buy.RefundOrd(p1_MerId, keyValue, pb_TrxId, p3_Amt, "CNY", p5_Desc)
				返回类型：BuyRefundOrdResult
				参数说明：
					p1_MerId		商家编号
					keyValue		商家密钥
					pb_TrxId		易宝支付交易流水号
					p3_Amt			退款金额
					p4_Cur			交易币种
					p5_Pdesc		退款说明
				返回参数：
					r0_Cmd			业务类型
					r1_Code			查询结果
					r2_TrxId		易宝交易流水号
					r3_Amt			退款金额
					r4_Cur			交易币种
					hmac				签名数据


					
2）商家测试可以先用易宝支付的测试商家测试成功再在文件中修改成自己的商户编号和密钥信息。测试帐号如下:
  p1_MerId = "10000432521";
	keyValue = "8UPp0KE8sq73zVP370vko7C39403rtK1YwX40Td6irH216036H27Eb12792t";
	商户编号和密钥需要同时修改才有效！

3）请在Req.aspx文件中修改请求地址,使用测试环境进行测试后再换上生产环境正式使用支付接口。
  // 设置请求地址
  Buy.NodeAuthorizationURL = @"http://tech.yeepay.com:8080/robot/debug.action"; //测试环境
  Buy.NodeAuthorizationURL = @"https://www.yeepay.com/app-merchant-proxy/node";   //生产环境
	
4）易宝支付支持在商家选择银行和在易宝支付网关选择银行的两种方式。
	可以通过设定Req.aspx中pd_FrpId的值来进行调整。
	如：pd_FrpId=""   					到易宝支付支付网关再选择银行
			pd_FrpId="1000000-NET"	直接进行易宝支付会员支付
			pd_FrpId="ICBC-NET"			直接进行中国工商银行在线支付
			pd_FrpId="SZX-NET"					直接进行神州行卡在线支付
	其它银行编号请参考易宝支付的文档说明。