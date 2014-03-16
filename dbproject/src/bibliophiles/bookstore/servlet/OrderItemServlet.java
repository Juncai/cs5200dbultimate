package bibliophiles.bookstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bibliophiles.bookstore.domain.OrderItem;
import bibliophiles.bookstore.service.OrderItemService;
import bibliophiles.bookstore.service.impl.OrderItemServiceImpl;
import bibliophiles.servlet.BaseServlet;

public class OrderItemServlet extends BaseServlet {
	private OrderItemService orderItemService = new OrderItemServiceImpl();

	public String update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String orderID = request.getParameter("orderID");
		String isbn = request.getParameter("isbn");
		OrderItem orderItem = orderItemService.load(orderID, isbn);
		request.setAttribute("orderItem", orderItem);
		return "/jsps/review.jsp";
	}

}
