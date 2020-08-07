-- 创建用户

create user 'user1'@'%' identified by '123456';

-- 简化创建用户信息
create user user2;

-- 删除用户
drop user user2;

-- 修改用户密码
set password for 'user1'@'%' = password('654321');

-- 分配权限
grant select on mydb.my_student to 'user1'@'%';

-- 回收权限
revoke all privileges on mydb.my_student from 'user1'@'%';

-- 刷新权限
flush privileges;