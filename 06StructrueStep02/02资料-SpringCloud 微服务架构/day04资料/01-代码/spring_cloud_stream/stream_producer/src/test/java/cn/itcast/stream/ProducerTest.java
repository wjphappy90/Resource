package cn.itcast.stream;

import cn.itcast.stream.producer.MessageSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProducerTest {

	@Autowired
	private MessageSender messageSender;

	@Test
	public void testSend() {
		for (int i = 0; i <5 ; i++) {
			messageSender.send("1");
		}
	}
}
