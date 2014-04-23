package bibliophiles.bookstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bibliophiles.bookstore.domain.Category;
import bibliophiles.bookstore.service.BookService;
import bibliophiles.bookstore.service.CategoryService;
import bibliophiles.bookstore.service.impl.BookServiceImpl;
import bibliophiles.bookstore.service.impl.CategoryServiceImpl;
import bibliophiles.servlet.BaseServlet;

public class CategoryServlet extends BaseServlet {
	private CategoryService categoryService = new CategoryServiceImpl();
	private BookService bookService = new BookServiceImpl();

	public String all(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Category> list = categoryService.all();
		List<Category> delList = new ArrayList<Category>();
		for (Category category : list) {
			if (bookService.findInStoreByCategoryID(category.getCategoryID()).size() == 0) {
				delList.add(category);
			}
		}
		for (Category category : delList) {
			list.remove(category);
		}
		request.setAttribute("list", list);
		return "/jsps/left.jsp";
	}

}
