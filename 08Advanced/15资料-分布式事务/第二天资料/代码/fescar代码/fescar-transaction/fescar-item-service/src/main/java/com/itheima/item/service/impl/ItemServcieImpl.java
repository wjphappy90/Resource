package com.itheima.item.service.impl;

import com.itheima.mapper.AccountMapper;
import com.itheima.mapper.ItemMapper;
import com.itheima.model.Account;
import com.itheima.model.Item;
import com.itheima.service.AccountService;
import com.itheima.service.ItemService;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/***
 *
 *
 ****/
@Service
public class ItemServcieImpl implements ItemService {


    @Autowired
    private ItemMapper itemMapper;

    @Reference(check = false)
    private AccountService accountService;


    /****
     * 修改商品库存，同时修改账户余额
     * @param item
     * @param account
     * @return
     */
    @Override
    public int update(Item item, Account account){
        //修改商品的库存
        int mcount = itemMapper.update(item);
        System.out.println("更新库存受影响行数："+mcount);

        //修改账户余额
        int acount = accountService.update(account);
        System.out.println("账户更新余额受影响行数:"+acount);
        return  mcount;
    }


}
