package cn.itcast.mapper;

import cn.itcast.entity.Coupon;

public interface CouponMapper {

	//保存优惠券信息
	public void saveCoupon(Coupon coupon);
	
	//根据id更新优惠券信息
	public void updateCoupon(Coupon coupon);
	
	//根据id查询优惠券信息
	public Coupon selectCouponById(long id);
	 
}
