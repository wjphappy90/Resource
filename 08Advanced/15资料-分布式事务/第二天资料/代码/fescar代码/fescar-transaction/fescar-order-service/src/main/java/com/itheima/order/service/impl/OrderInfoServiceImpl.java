package com.itheima.order.service.impl;

import com.alibaba.fescar.spring.annotation.GlobalTransactional;
import com.itheima.mapper.OrderInfoMapper;
import com.itheima.model.Account;
import com.itheima.model.Item;
import com.itheima.model.OrderInfo;
import com.itheima.service.ItemService;
import com.itheima.service.OrderInfoService;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/***
 *
 *
 ****/
@Service
public class OrderInfoServiceImpl implements OrderInfoService {

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Reference(check = false)
    private ItemService itemService;

    /****
     * 创建订单
     * 调用ItemService修改库存(调用AccountService修改余额)
     *
     * @param  usernumber:购买商品的用户
     * @param  id：购买的商品ID
     * @param  count:要减的数量
     */
    @GlobalTransactional(name="fescar-itheima-tx")
    @Override
    public int create(String usernumber, Integer id, Integer count){
        //从数据库查询商品信息
        Item item = new Item();
        item.setId(id);
        item.setNum(count);
        item.setPrice(100L);
        item.setTitle("华为荣耀4");

        //创建订单
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setId((int)(Math.random()*1000));
        orderInfo.setMoney(item.getPrice()*count);
        orderInfo.setCreatetime(new Date());
        orderInfo.setUsernumber(usernumber);
        int acount = orderInfoMapper.add(orderInfo);

        System.out.println("添加订单受影响行数："+acount);

        //制造异常
//        System.out.println("订单添加成功后,出现异常。。。。");
//        int q=10/0;

        //调用ItemService(远程调用)
        Account account = new Account();
        account.setUsernumber(usernumber);
        account.setMoney(item.getPrice()*count); //花掉的钱
        itemService.update(item,account);

        //制造异常
        System.out.println("开始报错了。。。。");
        int q=10/0;
        return  acount;
    }


}
