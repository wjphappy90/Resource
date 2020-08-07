package com.itheima.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

//消息事物状态记录
@Entity(name = "shop_txlog")
@Data
public class TxLog implements Serializable{
    @Id
    private String txId;
    private Date date;
}
