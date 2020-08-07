package com.itheima.dao;

import java.util.List;

import com.itheima.domain.BaseDict;

/**
 * 字典表的持久层接口
 * @author zhy
 *
 */
public interface IBaseDictDao {
	
	/**
	 * 根据字典类型查询字典表数据
	 * @param typeCode
	 * @return
	 */
	List<BaseDict> findBaseDictByTypeCode(String typeCode);

}
