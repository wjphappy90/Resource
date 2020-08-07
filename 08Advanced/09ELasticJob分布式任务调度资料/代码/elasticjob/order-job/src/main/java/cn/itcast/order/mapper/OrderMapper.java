package cn.itcast.order.mapper;

import cn.itcast.order.pojo.Order;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * OrderMapper
 *
 * @author lee.siu.wah
 * @version 1.0
 * <p>File Created at 2018-05-20<p>
 */
public interface OrderMapper {

    /** 根据城市查询该分片项需要处理的订单数据 */
    @Select("SELECT o.* FROM `tb_order` as o, tb_user as u " +
            "where o.user_id = u.user_id and state = 2 and u.city = #{city}")
    List<Order> findOrderByCity(String city);

    /** 采用【订单号 % 分片总数 = 当前分片项索引号】来查询该分片需要处理的订单 */
    @Select("SELECT o.* FROM `tb_order` as o, tb_user as u " +
            "where o.user_id = u.user_id and state = 2 " +
            "and MOD(o.order_id , #{t}) = #{s}")
    List<Order> findOrderBySharding(@Param("t") int shardingTotalCount,
                                    @Param("s") int shardingItem);

    /** 修改订单的状态码(已配送) */
    @Update("update tb_order set state = #{status}, delivery_time = NOW() " +
            "where order_id = #{orderId}")
    void updateOrderStatus(@Param("status") String status,
                           @Param("orderId") Long orderId);
}
