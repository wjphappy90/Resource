package com.itheima.mapper;

import com.itheima.model.Item;
import org.apache.ibatis.annotations.Update;

/***
 *
 *
 ****/
public interface ItemMapper {

    /***
     * 修改库存数量
     * @param item
     * @return
     */
    @Update("update item set num=num-#{num} where id=#{id}")
    int update(Item item);
}
