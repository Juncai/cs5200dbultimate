package bibliophiles.bookstore.admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bibliophiles.bookstore.domain.Book;
import bibliophiles.bookstore.domain.Category;
import bibliophiles.bookstore.service.BookService;
import bibliophiles.bookstore.service.CategoryService;
import bibliophiles.bookstore.service.impl.BookServiceImpl;
import bibliophiles.bookstore.service.impl.CategoryServiceImpl;
import bibliophiles.servlet.BaseServlet;
import bibliophiles.utils.CommonUtils;

public class AdminBookServlet extends BaseServlet {
	private BookService bookService = new BookServiceImpl();
	private CategoryService categoryService = new CategoryServiceImpl();
	
	public String all(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Book> bookList = bookService.all();
		request.setAttribute("bookList", bookList);
		return "/adminjsps/admin/book/all.jsp";
	}

	public String desc(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String isbn = request.getParameter("isbn");
		Book book = bookService.findByIsbn(isbn);
		List<Category> categoryList = categoryService.all();
		request.setAttribute("book", book);
		request.setAttribute("categoryList", categoryList);
		return "/adminjsps/admin/book/desc.jsp";
	}
	
	public String del(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String isbn = request.getParameter("isbn");
		bookService.del(isbn);
		request.setAttribute("msg", "Book deleted.");
		return "/adminjsps/admin/msg.jsp";
	}
	
	public String mod(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Book book = CommonUtils.toBean(request.getParameterMap(), Book.class);
		String categoryID = request.getParameter("categoryID");
		Category category = new Category();
		category.setCategoryID(categoryID);
		book.setCategory(category);
		bookService.mod(book);
		request.setAttribute("msg", "Book info modified.");
		return "/adminjsps/admin/msg.jsp";

	}
	
	public String addPre(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Category> categoryList = categoryService.all();
		request.setAttribute("categoryList", categoryList);
		return "/adminjsps/admin/book/add.jsp";
	}
}
