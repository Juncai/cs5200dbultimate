package bibliophiles.bookstore.mobile.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import bibliophiles.bookstore.domain.Book;
import bibliophiles.bookstore.service.BookService;
import bibliophiles.bookstore.service.impl.BookServiceImpl;
/**
 * 
 * This is servlet is to offer the mobile part
 * with all the book infomation
 *
 * @author Team Bibliophiles
 * 
 */
public class MobileBookServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BookService bookService = new BookServiceImpl();
		List<Book> bookList = bookService.all(); 
//		System.out.println(bookList);
		System.out.println(bookList.size());
		
		JSONArray jsonList = JSONArray.fromObject(bookList);
//		System.out.println(jsonList.toString());
		response.getWriter().write(jsonList.toString());
		
		JSONArray arr = new JSONArray();
		
	}
 
}
