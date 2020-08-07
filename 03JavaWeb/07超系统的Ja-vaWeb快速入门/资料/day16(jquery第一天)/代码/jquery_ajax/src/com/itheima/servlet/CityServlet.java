package com.itheima.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.itheima.domain.City;
import com.itheima.domain.Province;
import com.thoughtworks.xstream.XStream;

public class CityServlet extends HttpServlet {

	private Map<Province, List<City>> map;

	@Override
	public void init() throws ServletException {
		map = new HashMap<Province, List<City>>();
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

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 处理中文乱码
		response.setCharacterEncoding("utf-8");// 响应乱码
		request.setCharacterEncoding("utf-8"); // 请求中文乱码，只对post请求有效

		String method = request.getParameter("method");
		// 判断是获取省份信息，还是获取城市信息
		if ("pro".equals(method)) {
			// 获取省份信息
			Set<Province> ps = map.keySet();

			// 将ps转换成json
			String json = JSONObject.toJSONString(ps);
			response.getWriter().write(json);

		}
		// 要获取城市信息
		if ("city".equals(method)) {
			// 获取省份名称
			String pname = request.getParameter("pname");

			// 遍历map,根据省份名称来获取对应的List<City>
			for (Province p : map.keySet()) {
				if (pname.equals(p.getName())) {

					List<City> citys = map.get(p);
					// 将citys转换成json响应到浏览器
					String json = JSONObject.toJSONString(citys);

					response.getWriter().write(json);
					break;
				}
			}

		}
		
		//返回xml数据
		if("xml".equals(method)){
			XStream xstream = new XStream();
			xstream.autodetectAnnotations(true);
			String xml=xstream.toXML(map);
			response.getWriter().write(xml);
		}

		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
