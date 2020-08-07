package cn.itcast.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class ThirdInterceptor extends AbstractInterceptor{

	private static final long serialVersionUID = 1L;

	/**
	 * 拦截用户的请求，如果请求是来自于第三方公司，就需要改变result的值
	 */
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		//获取请求参数集合
		Map<String, Object> parameters = invocation.getInvocationContext().getParameters();
		if(parameters.get("third") != null){
			//请求来自于第三方
			invocation.getStack().setValue("result", "json");
		}
		//调用下一步
		return invocation.invoke();
	}

}
