package cn.itcast.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 自定义一个全局过滤器
 *      实现 globalfilter , ordered接口
 */
//@Component
public class LoginFilter implements GlobalFilter,Ordered {

	/**
	 * 执行过滤器中的业务逻辑
	 *     对请求参数中的access-token进行判断
	 *      如果存在此参数:代表已经认证成功
	 *      如果不存在此参数 : 认证失败.
	 *  ServerWebExchange : 相当于请求和响应的上下文(zuul中的RequestContext)
	 */
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		System.out.println("执行了自定义的全局过滤器");
		//1.获取请求参数access-token
		String token = exchange.getRequest().getQueryParams().getFirst("access-token");
		//2.判断是否存在
		if(token == null) {
			//3.如果不存在 : 认证失败
			System.out.println("没有登录");
			exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
			return exchange.getResponse().setComplete(); //请求结束
		}
		//4.如果存在,继续执行
		return chain.filter(exchange); //继续向下执行
	}

	/**
	 * 指定过滤器的执行顺序 , 返回值越小,执行优先级越高
	 */
	public int getOrder() {
		return 0;
	}
}
