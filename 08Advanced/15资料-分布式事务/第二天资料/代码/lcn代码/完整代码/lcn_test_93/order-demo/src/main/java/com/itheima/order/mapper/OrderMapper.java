package com.itheima.order.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface OrderMapper {

	@Update("update ordertable set status=#{status} where id=#{id};")
	int update(@Param("id") Integer id, @Param("status") Integer status);
}
