package com.itheima.model;

import java.io.Serializable;
import java.util.Date;

/***
 *
 *
 ****/
public class OrderInfo implements Serializable {
    private Integer id;
    private Long money;
    private Date createtime;
    private String usernumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getUsernumber() {
        return usernumber;
    }

    public void setUsernumber(String usernumber) {
        this.usernumber = usernumber;
    }
}