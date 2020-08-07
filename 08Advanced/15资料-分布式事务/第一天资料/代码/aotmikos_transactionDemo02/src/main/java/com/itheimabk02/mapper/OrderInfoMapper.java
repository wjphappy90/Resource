package com.itheimabk02.mapper;

import com.itheimabk02.domain.OrderInfo;
import org.apache.ibatis.annotations.Insert;

/**
 * @version 1.0
 * @Author 周洪丙
 **/
public interface OrderInfoMapper {

    @Insert("insert into order_info(id,money,userid,address,createTime) values(#{id},#{money},#{userid},#{address},#{createTime})")
    int add(OrderInfo orderInfo);
}


