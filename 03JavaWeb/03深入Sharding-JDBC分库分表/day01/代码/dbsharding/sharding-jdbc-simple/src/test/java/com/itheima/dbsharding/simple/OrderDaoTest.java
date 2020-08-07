package com.itheima.dbsharding.simple;

import com.itheima.dbsharding.simple.dao.OrderDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ShardingJdbcSimpleBootstrap.class})
public class OrderDaoTest {

    @Autowired
    OrderDao orderDao;

    @Test
    public void testInsertOrder(){
        for(int i=1;i<20;i++){
            orderDao.insertOrder(new BigDecimal(i),1L,"SUCCESS");
        }
    }

    @Test
    public void testSelectOrderbyIds(){
        List<Long> ids = new ArrayList<>();
        ids.add(373897739357913088L);
        ids.add(373897037306920961L);

        List<Map> maps = orderDao.selectOrderbyIds(ids);
        System.out.println(maps);
    }
}
