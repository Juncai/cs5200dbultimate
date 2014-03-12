package bibliophiles.bookstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bibliophiles.bookstore.dao.impl.BookDaoImpl;
import bibliophiles.bookstore.domain.Book;
import bibliophiles.bookstore.service.BookService;
import bibliophiles.bookstore.service.impl.BookServiceImpl;
import jon.servlet.BaseServlet;

public class BookServlet extends BaseServlet {
	private BookService bookService = new BookServiceImpl();
	
	public String all(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Book> bookList = bookService.all(); 
		request.setAttribute("list", bookList);
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
		request.setAttribute("book", book);
		return "/jsps/bookdesc.jsp";
	}
}