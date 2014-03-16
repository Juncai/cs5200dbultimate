package bibliophiles.bookstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bibliophiles.bookstore.domain.Category;
import bibliophiles.bookstore.service.CategoryService;
import bibliophiles.bookstore.service.impl.CategoryServiceImpl;
import bibliophiles.servlet.BaseServlet;

public class CategoryServlet extends BaseServlet {
	private CategoryService categoryService = new CategoryServiceImpl();

	public String all(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Category> list = categoryService.all();
		request.setAttribute("list", list);
		return "/jsps/left.jsp";
	}

}
