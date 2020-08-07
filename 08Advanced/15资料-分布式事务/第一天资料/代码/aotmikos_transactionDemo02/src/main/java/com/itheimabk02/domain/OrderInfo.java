package com.itheimabk02.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @Author 周洪丙
 **/
public class OrderInfo implements Serializable {
    private Integer id;
    private Double money;
    private String userid;
    private String address;
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "id=" + id +
                ", money=" + money +
                ", userid='" + userid + '\'' +
                ", address='" + address + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
