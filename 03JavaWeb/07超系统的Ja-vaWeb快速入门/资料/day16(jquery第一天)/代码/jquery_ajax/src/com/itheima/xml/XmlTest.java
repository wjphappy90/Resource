package com.itheima.xml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.itheima.domain.City;
import com.itheima.domain.Province;
import com.thoughtworks.xstream.XStream;

public class XmlTest {

	public static void main(String[] args) {
		Map<Province, List<City>> map = new HashMap<Province, List<City>>();
		// 创建省份
		Province p1 = new Province();
		p1.setId(1);
		p1.setName("黑龙江");

		City c11 = new City();
		c11.setId(1);
		c11.setName("哈尔滨");

		City c12 = new City();
		c12.setId(2);
		c12.setName("大庆");

		List<City> l1 = new ArrayList<City>();
		l1.add(c11);
		l1.add(c12);

		map.put(p1, l1);

		Province p2 = new Province();
		p2.setId(2);
		p2.setName("吉林");

		City c21 = new City();
		c21.setId(1);
		c21.setName("长春");

		City c22 = new City();
		c22.setId(2);
		c22.setName("吉林");

		List<City> l2 = new ArrayList<City>();
		l2.add(c21);
		l2.add(c22);

		map.put(p2, l2);

		Province p3 = new Province();
		p3.setId(3);
		p3.setName("辽宁");

		City c31 = new City();
		c31.setId(1);
		c31.setName("沈阳");

		City c32 = new City();
		c32.setId(2);
		c32.setName("大连");

		List<City> l3 = new ArrayList<City>();
		l3.add(c31);
		l3.add(c32);

		map.put(p3, l3);

		// 使用XStream来完成java对象转换成xml操作
		XStream xstream = new XStream();
		// 设置类或属性别名
		//xstream.alias("省份", Province.class); // 类别名
		//xstream.alias("城市", City.class);
		// xstream.alias("城市们", java.util.List.class);
		//xstream.aliasField("编号", City.class, "id"); // 属性别名
		// 忽略属性
		//xstream.omitField(Province.class, "id");
		
		//设置java类中的属性变成节点的属性
		//xstream.useAttributeFor(Province.class, "id");
		
		//开启注解扫描
		xstream.autodetectAnnotations(true);
		
		String xml = xstream.toXML(map);

		System.out.println(xml);
	}
}
