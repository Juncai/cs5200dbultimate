package bibliophiles.bookstore.mobile.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bibliophiles.bookstore.domain.Address;
import bibliophiles.bookstore.domain.Book;
import bibliophiles.bookstore.domain.Order;
import bibliophiles.bookstore.domain.OrderItem;
import bibliophiles.bookstore.domain.User;
import bibliophiles.bookstore.service.BookService;
import bibliophiles.bookstore.service.OrderService;
import bibliophiles.bookstore.service.UserService;
import bibliophiles.bookstore.service.impl.BookServiceImpl;
import bibliophiles.bookstore.service.impl.OrderServiceImpl;
import bibliophiles.bookstore.service.impl.UserServiceImpl;

public class MobileOrderServlet extends HttpServlet {
 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String allISBN = request.getParameter("allISBN");
		System.out.println(email+allISBN);
		
		String[] ISBNs = allISBN.split("XXX");
		UserService userService = new UserServiceImpl();
		User user = userService.findByEmail(email);
		
		Order order = new Order();
		BookService bookService = new BookServiceImpl();
		Set<OrderItem> orderItemSet = new HashSet<OrderItem>();
		int totalPrice=0;
		for(String ISBN : ISBNs){
			System.out.println(ISBN);
			OrderItem orderItem = new OrderItem();
			Book book = bookService.findByIsbn(ISBN);
			System.out.println(book);
			orderItem.setBook(book);
			orderItem.setCount(1);
			orderItem.setOrder(order);
			orderItem.setRating(0);
			orderItem.setReview("");
			orderItem.setSubtotal(book.getPrice());
			totalPrice += book.getPrice();
			orderItemSet.add(orderItem);
		}
		order.setOrderItemSet(orderItemSet);
		Address address = new Address();
		address.setAddrID(UUID.randomUUID().toString().replace("-", ""));
		address.setCountry("USA");
		address.setState("MA");
		address.setStreet("Huntington");
		address.setZipcode("02115");
		order.setOrdertime(new Date());
		order.setAddress(address);
		order.setOrderID(UUID.randomUUID().toString().replace("-", ""));
		order.setOrderItemSet(orderItemSet);
		order.setState(1);
		order.setTotal(totalPrice);
		order.setUser(user);
		
//		System.out.println(order);
		
		OrderService orderService = new OrderServiceImpl();
		orderService.add(order);
		
		response.getWriter().write("Adding success!");
	}

}
