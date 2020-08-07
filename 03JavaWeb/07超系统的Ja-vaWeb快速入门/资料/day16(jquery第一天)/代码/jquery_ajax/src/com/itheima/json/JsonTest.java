package com.itheima.json;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.itheima.domain.Product;

public class JsonTest {

	// 将一个Project对象转换成json
	@Test
	public void test1() {

		// 1.创建一个Project对象
		Product p1 = new Product();
		p1.setId(1);
		p1.setCount(100);
		p1.setName("电视机");
		p1.setPrice(2000);
		p1.setpDate(new Date());

		// 2.使用fastjson将p1转换成json数据
		// {id:xxx,name:xxx,price:xxx,count:xxx}

		// 指定一个Filter
		// SerializeFilter filter = new PropertyFilter() {
		// public boolean apply(java.lang.Object arg0, java.lang.String arg1,
		// java.lang.Object arg2) {
		// // System.out.println(arg0); //类名
		// // System.out.println(arg1);//属性名
		// // System.out.println(arg2); //属性值
		// if ("编号".equals(arg1)) {
		//
		// return false;
		// }
		// return true;
		// }
		//
		// };
		// 上述代码操作比较麻烦，可以简化
		SerializeFilter filter = new SimplePropertyPreFilter("count", "name", "price", "pDate"); // 将需要的属性指定

		String json = JSONObject.toJSONString(p1, filter);
		System.out.println(json);

	}

	// 将List<Project>对象转换成json
	@Test
	public void test2() {
		// 1.创建一个List<Project>对象
		Product p1 = new Product();
		p1.setId(1);
		p1.setCount(100);
		p1.setName("电视机");
		p1.setPrice(2000);

		Product p2 = new Product();
		p2.setId(2);
		p2.setCount(200);
		p2.setName("洗衣机");
		p2.setPrice(1000);

		List<Product> list = new ArrayList<Product>();
		list.add(p1);
		list.add(p2);

		// 将list转换成json
		// [{id:xx,name:xx...},{id:xxx,name:xxx}]
		String json = JSONObject.toJSONString(list);
		System.out.println(json);

	}

	// fastjson将java对象转换成json时循环引用问题
	@Test
	public void test3() {
		// 1.创建一个List<Project>对象
		Product p1 = new Product();
		p1.setId(1);
		p1.setCount(100);
		p1.setName("电视机");
		p1.setPrice(2000);

		List<Product> ps = new ArrayList<Product>();
		ps.add(p1);
		ps.add(p1);
		ps.add(p1);

		// 将ps转换成json
		String json = JSONObject.toJSONString(ps, SerializerFeature.DisableCircularReferenceDetect);
		System.out.println(json);

	}
}
