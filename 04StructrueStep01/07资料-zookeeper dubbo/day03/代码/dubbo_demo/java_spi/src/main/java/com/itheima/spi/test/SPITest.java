package com.itheima.spi.test;

import com.itheima.spi.Czbk;
import org.apache.dubbo.common.extension.ExtensionLoader;

import java.util.Iterator;
import java.util.ServiceLoader;

public class SPITest {

    public static void main(String[] args) {

       // spiwithjava();

        ExtensionLoader<Czbk> extensionLoader = ExtensionLoader.getExtensionLoader(Czbk.class);
        Czbk college = extensionLoader.getExtension("shortTrain");
        college.service();
    }

    private static void spiwithjava() {
        ServiceLoader<Czbk> serviceLoader = ServiceLoader.load(Czbk.class);
        Iterator<Czbk> iterator = serviceLoader.iterator();
        while (iterator.hasNext()){
            Czbk czbk = iterator.next();
            czbk.service();
        }
    }
}
