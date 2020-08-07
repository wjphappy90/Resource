package cn.itcast;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "cn.itcast.uaa")
@EnableApolloConfig
public class UAAApplication {

	public static void main(String[] args) {
		SpringApplication.run(UAAApplication.class, args);
	}


}
