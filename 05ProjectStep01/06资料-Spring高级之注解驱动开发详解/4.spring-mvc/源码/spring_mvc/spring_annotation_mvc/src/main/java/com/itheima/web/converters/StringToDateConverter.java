package com.itheima.web.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自定义类型转换器
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
@Component
public class StringToDateConverter implements Converter<String,Date>{

    @Override
    public Date convert(String source) {
        //1.判断来源是否有值
        if (StringUtils.isEmpty(source)) {
            throw new NullPointerException("Source can not be null!");
        }
        try{
            //2.定义转换器
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            //3.转换并返回
            return format.parse(source);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
