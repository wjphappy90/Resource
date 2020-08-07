package cn.itcast.order.job;

import cn.itcast.order.pojo.Order;
import cn.itcast.order.service.OrderService;
import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 订单作业类
 *
 * @author lee.siu.wah
 * @version 1.0
 * <p>File Created at 2018-05-20<p>
 */
public class OrderJob implements SimpleJob {

    @Autowired
    private OrderService orderService;

    @Override
    public void execute(ShardingContext shardingContext) {
        // 获取分片总数
        int shardingTotalCount = shardingContext.getShardingTotalCount();
        // 获取当前分片项(索引号)
        int shardingItem = shardingContext.getShardingItem();
        // 获取当前分片项的参数值(城市)
        String shardingParameter = shardingContext.getShardingParameter();

        // 定义需要处理的订单集合
        List<Order> orderList = null;

        // 判断分片项参数
        if (StringUtils.isNoneBlank(shardingParameter)){
            // 如果有分片项参数，根据城市查询该分片项需要处理的订单数据(城市)
            orderList = orderService.findOrderByCity(shardingParameter);
        }else{
            // 如果没有分片项参数，采用【订单号 % 分片总数 = 当前分片项索引号】来查询该分片需要处理的订单
            orderList = orderService.findOrderBySharding(shardingTotalCount,shardingItem);
        }

        // 处理订单
        if (orderList != null && orderList.size() > 0){
            if (StringUtils.isNoneBlank(shardingParameter)){
                System.out.println("分片项参数：【" + shardingParameter + "】正在处理中！");
            }else{
                System.out.println("分片项索引号：【" + shardingItem + "】正在处理中！");
            }

            for (Order order : orderList){
                // 模拟调用物流接口，进行配送
                System.out.println("订单号:" + order.getOrderId() + "正在处理中!");

                // 修改订单的状态码(已配送)
                orderService.updateOrderStatus("3", order.getOrderId());

                System.out.println("订单号:" + order.getOrderId() + "处理完成!");
            }


            if (StringUtils.isNoneBlank(shardingParameter)){
                System.out.println("分片项参数：【" + shardingParameter + "】处理完成！");
            }else{
                System.out.println("分片项索引号：【" + shardingItem + "】处理完成！");
            }

        }

    }
}