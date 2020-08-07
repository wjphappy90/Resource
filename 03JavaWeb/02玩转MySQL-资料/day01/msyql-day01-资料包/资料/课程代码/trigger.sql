-- 创建两张表
create table my_goods(
id int primary key auto_increment,
name varchar(20) not null,
inv int
)charset utf8;

create table my_orders(
id int primary key auto_increment,
goods_id int not null,
goods_num int not null)charset utf8;

insert into my_goods values(null,'手机',1000),(null,'电脑',500),(null,'游戏机',100);

-- 创建触发器
delimiter $$
create trigger after_insert_order_t after insert on my_orders for each row
begin
	-- 更新商品库存
	update my_goods set inv = inv - 1 where id = 1;
end
$$
delimiter ;

-- 删除触发器
drop trigger after_insert_order_t;


-- 自动扣除商品库存的触发器
delimiter $$
create trigger a_i_o_t after insert on my_orders for each row
begin
	-- 更新商品库存:new代表着新增的订单
	update my_goods set inv = inv - new.goods_num where id = new.goods_id;
end
$$
delimiter ;


-- 判断库存
delimiter $$
create trigger b_i_o_t before insert on my_orders for each row
begin
	-- 取出库存数据进行判断
	select inv from my_goods where id = new.goods_id into @inv;

	-- 判断
	if @inv < new.goods_num then
		-- 中断操作：暴力解决，主动出错
		insert into XXX values('XXX');
	end if;
end 
$$
delimiter ;

