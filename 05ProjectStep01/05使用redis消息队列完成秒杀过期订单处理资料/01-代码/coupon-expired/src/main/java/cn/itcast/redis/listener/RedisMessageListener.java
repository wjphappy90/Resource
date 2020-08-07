package cn.itcast.redis.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

import cn.itcast.entity.Coupon;
import cn.itcast.mapper.CouponMapper;

public class RedisMessageListener implements MessageListener {

	@Autowired
	private CouponMapper couponMapper;
	
	//处理消息
	/**
	 * 获取的时失效key通知：
	 * 		发送的消息：key（coupon:优惠券id）
	 * 
	 *  1.接收到消息获取消息（验证是否时优惠券失效的key）
	 *  2.从消息中分离出优惠券id
	 *  3.查询数据库获取优惠券对象
	 *  4.设置失效状态，更新数据库
	 * 
	 */
	public void onMessage(Message message, byte[] pattern) {
		String key = new String (message.getBody());
		if(key.startsWith("coupon")) {
			String id = key.split(":")[1];
			Coupon coupon = couponMapper.selectCouponById(Long.parseLong(id));
			coupon.setState(1);
			couponMapper.updateCoupon(coupon);
		}
	}

}
