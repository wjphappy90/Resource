package com.itheima.web.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.constant.Constant;
import com.itheima.domain.Cart;
import com.itheima.domain.CartItem;
import com.itheima.domain.Order;
import com.itheima.domain.OrderItem;
import com.itheima.domain.User;
import com.itheima.service.OrderService;
import com.itheima.utils.BeanFactory;
import com.itheima.utils.UUIDUtils;
import com.itheima.web.servlet.base.BaseServlet;

/**
 * 订单模块
 */
public class OrderServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 保存订单
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//-1.从session中获取user
			User user=(User) request.getSession().getAttribute("user");
			if(user == null){
				//未登录 提示
				request.setAttribute("msg", "请先登录!");
				return "/jsp/msg.jsp";
			}
			
			//0.获取购物车
			Cart cart=(Cart) request.getSession().getAttribute("cart");
			
			//1.封装订单对象
			//1.1创建对象
			Order order = new Order();
			
			//1.2设置oid 
			order.setOid(UUIDUtils.getId());
			
			//1.3设置ordertime
			order.setOrdertime(new Date());
			
			//1.4设置total 购物车中
			order.setTotal(cart.getTotal());
			
			//1.5设置state
			order.setState(Constant.ORDER_WEIFUKUAN);
			
			//1.6设置user
			order.setUser(user);
			
			//1.7设置items(订单项列表) 遍历购物项列表
			for (CartItem	ci : cart.getCartItems()) {
				//1.7.1封装成orderitem
				//a.创建orderitem
				OrderItem oi = new OrderItem();
				
				//b.设置itemid uuid
				oi.setItemid(UUIDUtils.getId());
				
				//c.设置count 从ci中获取
				oi.setCount(ci.getCount());
				
				//d.设置subtotal 从ci中获取
				oi.setSubtotal(ci.getSubtotal());
				
				//e.设置product 从ci中获取
				oi.setProduct(ci.getProduct());
				
				//f.设置order 
				oi.setOrder(order);
				
				//1.7.2 将orderitem加入order 的items中
				order.getItems().add(oi);
			}
			
			
			//2.调用orderservice完成保存操作
			OrderService os = (OrderService) BeanFactory.getBean("OrderService");
			os.save(order);
			
			//3.请求转发到 order_info.jsp
			request.setAttribute("bean", order);
		} catch (Exception e) {
		}
		return "/jsp/order_info.jsp";
	}

}
