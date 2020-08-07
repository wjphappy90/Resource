package cn.itcast.order.pojo;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
	/** 订单号 */
	private Long orderId;
	/** 支付类型，1在线支付，2其它支付 */
	private Integer paymentType;
	/** 实付金额 */
	private String payment;
	/** 订单时间 */
	private Date orderTime;
	/** 配送时间 */
	private Date deliveryTime;
	/** 订单状态；1未支付，2已支付，3已配送 */
	private String state;
	/** 下单人 */
	private User user;
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Integer getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(Integer paymentType) {
		this.paymentType = paymentType;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public Date getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(Date deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}