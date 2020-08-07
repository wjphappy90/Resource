package cn.itcast.order.pojo;

import java.io.Serializable;

public class User implements Serializable {
	/** 用户编号 */
	private Long userId;
	/** 姓名 */
	private String name;
	/** 手机 */
	private String mobile;
	/** 省份 */
	private String province;
	/** 城市 */
	private String city;
	/** 地区 */
	private String district;
	/** 地址 */
	private String address;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}