package com.itheimabk02.logmapper;

import com.itheimabk02.domain.LogInfo;
import org.apache.ibatis.annotations.Insert;

/**
 * @version 1.0
 * @Author 周洪丙
 **/
public interface LogInfoMapper {

    @Insert("insert into log_info(id,createTime,content) values(#{id},#{createTime},#{content})")
    int add(LogInfo logInfo);
}
