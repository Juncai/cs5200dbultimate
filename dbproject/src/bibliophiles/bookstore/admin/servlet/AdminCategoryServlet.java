package bibliophiles.bookstore.admin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bibliophiles.bookstore.domain.Category;
import bibliophiles.bookstore.service.CategoryService;
import bibliophiles.bookstore.service.exception.CategoryException;
import bibliophiles.bookstore.service.impl.CategoryServiceImpl;
import bibliophiles.servlet.BaseServlet;
import bibliophiles.utils.CommonUtils;

public class AdminCategoryServlet extends BaseServlet {
	private CategoryService categoryService = new CategoryServiceImpl();
	
	public String addPre(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return "/adminjsps/admin/category/add.jsp";
	}
	
	public String desc(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String categoryID = request.getParameter("categoryID");
		Category category = categoryService.findByCategoryID(categoryID);
		request.setAttribute("category", category);
		return "/adminjsps/admin/category/desc.jsp";
	}
	
	public String all(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Category> categoryList = categoryService.all();
		request.setAttribute("list", categoryList);
		return "/adminjsps/admin/category/all.jsp";
	}
	
	public String add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Category category = CommonUtils.toBean(request.getParameterMap(), Category.class);
		category.setCategoryID(CommonUtils.uuid());
		
		try {
			categoryService.add(category);
		} catch (CategoryException e) {
			String msg = e.getMessage();
			request.setAttribute("msg", msg);
			return "/adminjsps/admin/category/add.jsp";
		}
		request.setAttribute("msg", "Category added.");
		return "/adminjsps/admin/msg.jsp";
	}
	
	public String del(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String categoryID = request.getParameter("categoryID");
		
		try {
			categoryService.del(categoryID);
		} catch (CategoryException e) {
			String msg = e.getMessage();
			request.setAttribute("msg", msg);
			return "/adminjsps/admin/category/desc.jsp";
		}
		request.setAttribute("msg", "Category deleted.");
		return "/adminjsps/admin/category/add.jsp";
	}
	
	public String mod(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Category category = CommonUtils.toBean(request.getParameterMap(), Category.class);
		categoryService.mod(category);
		request.setAttribute("msg", "Category modified.");
		return "/adminjsps/admin/msg.jsp";
	}
}
