package bibliophiles.bookstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bibliophiles.bookstore.domain.Cart;
import bibliophiles.bookstore.domain.CartItem;
import bibliophiles.bookstore.domain.Order;
import bibliophiles.bookstore.domain.OrderItem;
import bibliophiles.bookstore.domain.User;
import bibliophiles.bookstore.service.OrderService;
import bibliophiles.bookstore.service.impl.OrderServiceImpl;
import bibliophiles.servlet.BaseServlet;
import bibliophiles.utils.CommonUtils;

public class OrderServlet extends BaseServlet {
	private OrderService orderService = new OrderServiceImpl();
	
	public String updateRec(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String orderID = request.getParameter("orderID");
		orderService.updateState(orderID, 4);
		request.setAttribute("msg", "The package receipt has been confirmed!");
		return "/jsps/msg.jsp";

	}
	
	public String updatePay(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String orderID = request.getParameter("orderID");
		orderService.updateState(orderID, 2);
		request.setAttribute("msg", "Thank you for your payment!");
		return "/jsps/msg.jsp";

	}
	
	public String orderDesc(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String orderID = request.getParameter("orderID");
		request.setAttribute("order", orderService.findByOrderID(orderID));
		return "/jsps/order/orderdesc.jsp";

	}
	
	public String myOrders(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		request.setAttribute("orderList", orderService.findByUserID(user.getUserID()));
		return "/jsps/order/orderlist.jsp";

	}
	
	public String add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if (cart == null) {
			request.setAttribute("msg", "The cart is empty. Please add something first.");
			return "/jsps/msg.jsp";
		}
		Order order = new Order();
		order.setOrderID(CommonUtils.uuid());
		order.setTotal(cart.getTotal());
		order.setOrdertime(new Date());
		order.setState(1);
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			request.setAttribute("msg", "Please signin first.");
			return "/jsps/msg.jsp";
		}
		order.setUser(user);
		Collection<CartItem> cartItems = cart.getCartItems();
		for (CartItem cartItem : cartItems) {
			OrderItem orderItem = new OrderItem();
			orderItem.setBook(cartItem.getBook());
			orderItem.setCount(cartItem.getCount());
			orderItem.setSubtotal(cartItem.getSubtotal());
			orderItem.setOrder(order);
			order.addOrderItem(orderItem);
		}
		orderService.add(order);
		cart.clear();
		request.setAttribute("order", order);
		
		return "/jsps/order/orderdesc.jsp";
	}

}
