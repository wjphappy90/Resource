package com.itheima.pay.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface PaytableMapper {
	@Update("update paytable set ispay=#{ispay} where id=#{id};")
	int update(@Param("id") Integer id,@Param("ispay") Integer ispay);

}
