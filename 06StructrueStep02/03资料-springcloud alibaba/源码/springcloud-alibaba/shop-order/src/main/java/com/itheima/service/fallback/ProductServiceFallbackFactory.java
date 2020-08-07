//package com.itheima.service.fallback;
//
//import com.itheima.domain.Product;
//import com.itheima.service.ProductService;
//import feign.hystrix.FallbackFactory;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//
////这是容错类,他要求我们要是实现一个FallbackFactory<要为哪个接口产生容错类>
//@Slf4j
//@Service
//public class ProductServiceFallbackFactory implements FallbackFactory<ProductService> {
//
//    //Throwable  这就是fegin在调用过程中产生异常
//    @Override
//    public ProductService create(Throwable throwable) {
//        return new ProductService() {
//            @Override
//            public Product findByPid(Integer pid) {
//                log.error("{}",throwable);
//                Product product = new Product();
//                product.setPid(-100);
//                product.setPname("商品微服务调用出现异常了,已经进入到了容错方法中");
//                return product;
//            }
//        };
//    }
//}
