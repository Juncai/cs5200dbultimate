package bibliophiles.bookstore.mobile.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bibliophiles.bookstore.domain.User;
import bibliophiles.bookstore.service.UserService;
import bibliophiles.bookstore.service.impl.UserServiceImpl;

public class MobileUserServlet extends HttpServlet {
	private UserService userService = new UserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
//		System.out.println("MobileUserServlet");
		
		User user = userService.findByEmail(email);
		
		if (user == null) {
			request.setAttribute("email", email);
			response.getWriter().write("The email does not exists!");
			return ;
		}

		if (!user.getPassword().equals(password)) {
			request.setAttribute("email", email);
			response.getWriter().write("Wrong password!");
			return ;
		}
		
		response.getWriter().write("Login success!");
	}
	
}
