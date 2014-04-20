package bibliophiles.bookstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import bibliophiles.bookstore.dao.impl.BookDaoImpl;
import bibliophiles.bookstore.domain.Book;
import bibliophiles.bookstore.domain.OrderItem;
import bibliophiles.bookstore.service.BookService;
import bibliophiles.bookstore.service.OrderItemService;
import bibliophiles.bookstore.service.impl.BookServiceImpl;
import bibliophiles.bookstore.service.impl.OrderItemServiceImpl;
import bibliophiles.servlet.BaseServlet;

public class BookServlet extends BaseServlet {
	private BookService bookService = new BookServiceImpl();
	private OrderItemService orderItemService = new OrderItemServiceImpl();
	
	public String all(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Book> bookList = bookService.all(); 
//		JSONArray jsonList = JSONArray.fromObject(bookList);
		request.setAttribute("list", bookList);
//		request.setAttribute("jsonList", jsonList.toString());
		return "/jsps/booklist.jsp";
	}
	
	public String query(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Book> bookList = bookService.findByCategoryID(request.getParameter("categoryID")); 
		request.setAttribute("list", bookList);
		return "/jsps/booklist.jsp";
	}

	public String load(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Book book = bookService.findByIsbn(request.getParameter("isbn")); 
		List<OrderItem> orderItems = orderItemService.findByIsbn(request.getParameter("isbn"));
		request.setAttribute("book", book);
		request.setAttribute("orderItems", orderItems);
		return "/jsps/bookdesc.jsp";
	}
	
	public String search(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		Map<String, String> condMap = request.getParameterMap();
		Map<String, String> condMap = new HashMap<String, String>();
		if (!request.getParameter("author").equals("")) {
			condMap.put("author", request.getParameter("author"));			
		}
		if (!request.getParameter("title").equals("")) {
			condMap.put("title", request.getParameter("title"));			
		}
		if (!request.getParameter("publisher").equals("")) {
			condMap.put("publisher", request.getParameter("publisher"));			
		}
		if (!request.getParameter("isbn").equals("")) {
			condMap.put("isbn", request.getParameter("isbn"));			
		}
		
		List<Book> bookList = bookService.searchBooks(condMap);
		if (bookList.size() == 0) {
			request.setAttribute("msg", "No results.");
		}
		request.setAttribute("list", bookList);
		return "/jsps/booksearch.jsp";
	}
}
