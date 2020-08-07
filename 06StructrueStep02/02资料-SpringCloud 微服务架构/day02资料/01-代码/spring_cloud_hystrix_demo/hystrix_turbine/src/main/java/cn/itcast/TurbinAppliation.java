package cn.itcast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
//trubin配置
@EnableTurbine
@EnableHystrixDashboard
public class TurbinAppliation {

	public static void main(String[] args) {
		SpringApplication.run(TurbinAppliation.class,args);
	}
}
