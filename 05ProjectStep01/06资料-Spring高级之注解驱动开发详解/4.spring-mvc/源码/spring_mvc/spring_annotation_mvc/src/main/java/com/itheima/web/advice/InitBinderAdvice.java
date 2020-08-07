package com.itheima.web.advice;

import com.itheima.web.converters.StringToDateConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.web.bind.WebDataBinder;

/**
 * 控制器的通知
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
//@ControllerAdvice
public class InitBinderAdvice {

    @Autowired
    private StringToDateConverter stringToDateConverter;

    /**
     * 初始化数据绑定器
     * @param dataBinder
     */
//    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        //1.获取转换服务对象
        ConversionService conversionService = dataBinder.getConversionService();
        //2.判断conversionService是否为GenericConversionService类型
        if(conversionService instanceof GenericConversionService){
            //3.强转
            GenericConversionService genericConversionService = (GenericConversionService)conversionService;
            //4.添加类型转换器
            genericConversionService.addConverter(stringToDateConverter);

        }
//        dataBinder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
    }
}
