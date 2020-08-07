package cn.itcast.mp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

public interface MyBaseMapper<T> extends BaseMapper<T> {

    List<T> findAll();

    // 扩展其他的方法

}
