package com.itheima.mapper;

import com.itheima.model.OrderInfo;
import org.apache.ibatis.annotations.Insert;

/***
 *
 *
 ****/
public interface OrderInfoMapper {

    /***
     * 添加订单
     * @param orderInfo
     * @return
     */
    @Insert("insert into order_info(id,money,createtime,usernumber) values(#{id},#{money},#{createtime},#{usernumber})")
    int add(OrderInfo orderInfo);



}
