package cn.itcast;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "cn.itcast.account")
@EnableApolloConfig
public class AccountApplication {

	//-Denv=DEV -Dapollo.cacheDir=/opt/data/apollo-config -Dapollo.cluster=DEFAULT
	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}

}
