package cn.itcast.ssm.mapper;

import cn.itcast.ssm.po.Items;
import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsExample;
import cn.itcast.ssm.po.ItemsQueryVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ItemsMapperCustom {
    //商品查询列表
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)throws Exception;
}