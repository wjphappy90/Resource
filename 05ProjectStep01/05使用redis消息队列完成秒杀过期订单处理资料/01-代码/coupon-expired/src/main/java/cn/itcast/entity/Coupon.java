package cn.itcast.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 优惠券实体类
 */
public class Coupon {

	private Long id;//主键id
	private String name;//优惠券名称
	private BigDecimal money;//优惠券金额
	private String couponDesc;//说明
	private Date createTime;//获取时间
	private Date expireTime;//失效时间
	private Integer state;//状态 0：可用 1：已失效 2：已使用
	
	public Coupon() {}
	
	public Coupon(String name, BigDecimal money, String couponDesc, Date createTime, Date expireTime,Integer state) {
		this.name = name;
		this.money = money;
		this.couponDesc = couponDesc;
		this.createTime = createTime;
		this.expireTime = expireTime;
		this.state = state;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getMoney() {
		return money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	public String getCouponDesc() {
		return couponDesc;
	}
	public void setCouponDesc(String couponDesc) {
		this.couponDesc = couponDesc;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getExpireTime() {
		return expireTime;
	}
	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Coupon [id=" + id + ", name=" + name + ", money=" + money + ", couponDesc=" + couponDesc
				+ ", createTime=" + createTime + ", expireTime=" + expireTime + ", state=" + state + "]";
	}
}
