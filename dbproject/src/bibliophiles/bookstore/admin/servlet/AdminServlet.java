package bibliophiles.bookstore.admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bibliophiles.bookstore.admin.domain.Administrator;
import bibliophiles.bookstore.admin.service.AdministratorService;
import bibliophiles.bookstore.admin.service.impl.AdministratorServiceImpl;
import bibliophiles.servlet.BaseServlet;

public class AdminServlet extends BaseServlet {
	private AdministratorService adminService = new AdministratorServiceImpl();
	
	public String login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Administrator admin = adminService.login(username, password);
		if (admin == null) {
			request.setAttribute("msg", "Wrong login information.");
			return "/adminjsps/login.jsp";
		}
		request.getSession().setAttribute("admin", admin);
		
		response.sendRedirect(request.getContextPath() + "/adminjsps/admin/main.jsp");
		return null;
	}

}
