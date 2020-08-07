package com.itheima.jdbc.handler.impl;

import com.itheima.jdbc.handler.ResultSetHandler;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * 封装到实体类中的结果集处理器
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
public class BeanHandler<T> implements ResultSetHandler {

    //定义封装哪个实体类的子接口
    private Class<T> requiredType;

    /**
     * 当创建BeanHandler对象时，就需要提供封装到的实体类字节码
     * @param requiredType
     */
    public BeanHandler(Class requiredType){
        this.requiredType = requiredType;
    }

    @Override
    public Object handle(ResultSet rs) {
        //1.定义返回值
        T bean = null;
        try{
            //2.判断是否有结果集
            if(rs.next()){
                //3.实例化返回值对象
                bean = requiredType.newInstance();
                //4.获取结果集的元信息
                ResultSetMetaData rsmd = rs.getMetaData();
                //5.获取结果集的列数
                int columnCount = rsmd.getColumnCount();
                //6.遍历列的个数
                for(int i=0;i<columnCount;i++){
                    //7.取出列的标题
                    String columnLabel = rsmd.getColumnLabel(i+1);
                    //8.取出当前列标题对应的数据内容
                    Object value = rs.getObject(columnLabel);
                    //9.借助java的内省机制，使用属性描述器填充
                    PropertyDescriptor pd = new PropertyDescriptor(columnLabel,requiredType);
                    //10.获取属性的写方法
                    Method method = pd.getWriteMethod();
                    //11.执行方法
                    method.invoke(bean,value);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return bean;
    }
}
