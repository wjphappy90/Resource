-- 手动事务


-- 开启事务
start transaction;

-- 提交事务
commit;


-- 增加回滚点
savepoint sp1;

-- 回滚到指定回滚点
rollback to sp1;