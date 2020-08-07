package com.itheima.rpc.registry;

import com.sun.jndi.toolkit.url.UrlUtil;

import java.util.HashMap;
import java.util.Map;

public class NativeRegistry {


    private static Map<String, Map<URL,Class>> registCenter = new HashMap<>();


    /**
     * 注册服务
     * @param url
     * @param interfaceName
     * @param implClass
     */
    public static void regist(URL url,String interfaceName,Class implClass){

        Map<URL,Class> map = new HashMap<>();
        map.put(url,implClass);
        registCenter.put(interfaceName,map);
    }

    /**
     * 从注册中心获取服务
     * @param url
     * @param interfaceName
     * @return
     */
    public static Class get(URL url,String interfaceName){
        return registCenter.get(interfaceName).get(url);
    }


}
