package cn.itcast.gateway;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Configuration
public class KeyResolverConfiguration {

	/**
	 * 编写基于请求路径的限流规则
	 *  //abc
	 *  //基于请求ip 127.0.0.1
	 *  //基于参数
	 */
	//@Bean
	public KeyResolver pathKeyResolver() {
		//自定义的KeyResolver
		return new KeyResolver() {
			/**
			 * ServerWebExchange :
			 *      上下文参数
			 */
			public Mono<String> resolve(ServerWebExchange exchange) {
				return Mono.just( exchange.getRequest().getPath().toString());
			}
		};
	}

	/**
	 * 基于请求参数的限流
	 *
	 *  请求 abc ? userId=1
	 */
	@Bean
	public KeyResolver userKeyResolver() {



		return exchange -> Mono.just(
				exchange.getRequest().getQueryParams().getFirst("userId")
				//exchange.getRequest().getHeaders().getFirst("X-Forwarded-For") 基于请求ip的限流
		);
	}
}
