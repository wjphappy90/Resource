package cn.itcast.transaction;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

	@Value("${sms.enable}")
	private Boolean smsEnable;

	@GetMapping("/hi")
	public String hi() {
		return "hi";
	}

	@GetMapping("/sms")
	public String getSmsConfig() {
		return "smsEnable: " + smsEnable;
	}

	@Value("${rocketmq.name-server}")
	private String mqNameServer;

	@Value("${rocketmq.producer.group}")
	private String mqProducerGroup;

	@GetMapping("/mq")
	public String getRocketMQConf() {
		return mqNameServer + ": " + mqProducerGroup;
	}

	@Value("${timeout}")
	private Long timeout;

	@GetMapping("/timeout")
	public Long getTimeout() {
		return timeout;
	}
}
