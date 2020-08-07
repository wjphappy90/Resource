package cn.itcast.listener;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

/**
 * 配置redis消息的监听器：
 * 		获取redis中的消息并进行处理
 */
public class RedisMessageListener implements MessageListener {
	
	/**
	 * onMessage : 处理消息
	 * 		message：完整的消息（频道的信息，以及消息的具体内容）
	 * 		pattern：获取的频道信息
	 */
	public void onMessage(Message message, byte[] pattern) {
		System.out.println("从channel为："+new String(message.getChannel())+"获取了一条新的消息，消息内容为："+
				new String(message.getBody()));
	}

}
