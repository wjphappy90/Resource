package dao;

import domain.User;
import org.junit.Test;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JdbcUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.RandomAccess;

/**
 * 专门操作数据库
 */
public class EmpDao {

    //创建一个JdbcTemplate对象
    private static JdbcTemplate jt = new JdbcTemplate(JdbcUtils.getDataSource());

    //查询所有
    @Test
    public void query(){
        //拼写SQL
        String sql = "select * from user";
        List<User> list = jt.query(sql, new BeanPropertyRowMapper<User>(User.class));
        /*
            建议进行判断
                判断查询返回的结果是否实现RandomAccess该接口
                如果实现,那么就推荐使用 随机遍历的方式迭代集合
                否则,就推荐使用顺序的方式迭代集合
         */
        //判断
        if(list instanceof RandomAccess) {
            //随机访问
            for (int i = 0; i < list.size(); i++) {
                User user = list.get(i);
                System.out.println(user);
            }
        }else{
            //顺序访问
            for (User user : list) {
                System.out.println(user);
            }
        }

    }















    //准备一个方法,真正的属于管理员来登录的方法
    //外界调用的时候,必须把用户名和密码传递过来
    public boolean login(String username,String password){
        try {
            //既然要操作数据库,就必须要有什么? 操作数据库工具类
            //拼写SQL
            String sql = "select * from user where username = ? and password = ?";
            //执行SQL
            //如果查询的结果只有一个对象,建议使用queryForObject
            User user = jt.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),username,password);
            //怎么就代表登陆成功了???  断言  != 一个对象就报错,就说登陆失败

            //如果登陆成功,需要把查询的结果返回给 view
            return true;
        } catch (DataAccessException e) {
            return false;   //如果有异常就说明登录失败
        }
    }
}









/*
 static{

        try {
            //为了没有多余的数据,每次项目启动的时候就摧毁两张表
            String sql = "truncate table user";
            jt.update(sql);
            //再次拼写SQL,清空emp表
            sql = "truncate table emp";
            jt.update(sql);

            //备份数据
            //创建本地流读取数据插入数据库
            BufferedReader br = new BufferedReader(new FileReader("Test\\user.txt"));
            String line;
            //再次拼写SQl
            sql = "insert into user values(null,?,?)";
            //循环读取数据
            while ((line = br.readLine()) != null){
                //老王 123
                String[] strArr = line.split(" ");
                //每次读取一行,就插入一行数据
                jt.update(sql, strArr);
            }
            //把本地流释放一下
            br.close();

            //再次备份emp
            BufferedReader br1 = new BufferedReader(new FileReader("Test\\emp.txt"));
            sql = "insert into emp values(null,?,?,?,?,?)";
            //再次定义一个字符串
            String line1;
            while ((line1 = br1.readLine()) != null){
                //李师师 18 20000 1000 2000-2-2
                String[] strArr = line1.split(" ");
                //每次读取一行,就插入一行数据
                jt.update(sql, strArr);
            }
            br1.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 */