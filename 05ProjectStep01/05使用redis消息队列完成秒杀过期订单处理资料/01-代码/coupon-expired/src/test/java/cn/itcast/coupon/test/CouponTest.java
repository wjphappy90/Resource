package cn.itcast.coupon.test;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.entity.Coupon;
import cn.itcast.mapper.CouponMapper;
import cn.itcast.utils.DataUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class CouponTest {

	@Autowired
	private CouponMapper couponMapper;
	
	@Test
	public void testSaveCoupon() {
		Date now = new Date();
		Coupon coupon = new Coupon("测试优惠券", BigDecimal.ONE, 
				"全品类优惠10元", now, DataUtils.addTime(now, 1),0);
		
		couponMapper.saveCoupon(coupon );
	}
	
	@Test
	public void testUpdateCoupon() {
		Coupon coupon = couponMapper.selectCouponById(1l);
		coupon.setState(1);
		couponMapper.updateCoupon(coupon);
	}
	
	@Test
	public void selectCouponById() {
		Coupon coupon = couponMapper.selectCouponById(1l);
		System.out.println(coupon);
	}
	
}
