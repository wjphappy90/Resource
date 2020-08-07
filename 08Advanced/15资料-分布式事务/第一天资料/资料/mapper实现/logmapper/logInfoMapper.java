package com.itheimabk02.logmapper;

import com.itheimabk02.domain.LogInfo;
import org.apache.ibatis.annotations.Insert;

/**
 * @version 1.0
 * @Author 周洪丙
 **/
public interface logInfoMapper {

    @Insert()
    int add(LogInfo logInfo);
}
