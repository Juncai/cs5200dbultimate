package bibliophiles.bookstore.admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bibliophiles.bookstore.domain.Order;
import bibliophiles.bookstore.service.OrderService;
import bibliophiles.bookstore.service.impl.OrderServiceImpl;
import bibliophiles.servlet.BaseServlet;

public class AdminOrderServlet extends BaseServlet {
	private OrderService orderService = new OrderServiceImpl();

	public String all(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Order> orderList = orderService.findAll();
		request.setAttribute("orderList", orderList);
		return "/adminjsps/admin/order/orderlist.jsp";
	}

	public String findByState(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int state = Integer.parseInt(request.getParameter("state"));
		List<Order> orderList = orderService.findByState(state);
		request.setAttribute("orderList", orderList);
		return "/adminjsps/admin/order/orderlist.jsp";
	}
	
	public String updateDeliver(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String orderID = request.getParameter("orderID");
		orderService.updateState(orderID, 3);
		request.setAttribute("msg", "The books have been sent out for shipping.");
		return "/adminjsps/admin/msg.jsp";
	}
}
