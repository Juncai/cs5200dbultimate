package bibliophiles.bookstore.admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bibliophiles.bookstore.domain.Category;
import bibliophiles.bookstore.service.CategoryService;
import bibliophiles.bookstore.service.impl.CategoryServiceImpl;

public class AdminAddBookServlet extends HttpServlet {


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CategoryService categoryService = new CategoryServiceImpl();
		List<Category> categoryList = categoryService.all();
		
		

	}

}
