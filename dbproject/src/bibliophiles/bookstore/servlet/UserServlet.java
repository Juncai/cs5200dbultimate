package bibliophiles.bookstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bibliophiles.bookstore.domain.User;
import bibliophiles.bookstore.service.UserService;
import bibliophiles.bookstore.service.exception.UserException;
import bibliophiles.bookstore.service.impl.UserServiceImpl;
import bibliophiles.servlet.BaseServlet;
import bibliophiles.utils.CommonUtils;


public class UserServlet extends BaseServlet {
	private UserService userService = new UserServiceImpl();

	
	public String registPre(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return "/jsps/regist.jsp";
	}
	
	public String regist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final User user = CommonUtils.toBean(request.getParameterMap(), User.class);
		user.setUserID(CommonUtils.uuid());
		user.setState(true);
		user.setCode(CommonUtils.uuid() + CommonUtils.uuid());
		
		try {
			userService.regist(user);
		} catch (UserException e) {
			String msg = e.getMessage();
			request.setAttribute("msg", msg);
			request.setAttribute("user", user);
			return "/jsps/regist.jsp";
		}
		
//		final String url = "http://localhost:8080/bookstore/UserServlet?method=active&code="
//				+ user.getCode();
//		
//		new Thread() {
//			public void run() {
//				Mail mail = new Mail();
//				mail.setFrom("joncai2012@163.com");
//				mail.addToAddress(user.getEmail());
//				mail.setSubject("Activation mail from Bibliophiles online book store!");
//				mail.setContent("Please click <a href='" + url + "'>here</a> to complete the activation.");
//				
//				Session session = MailUtils.createSession("smtp.163.com", "joncai2012@163.com", ";lkj0987");
//				try {
//					MailUtils.send(session, mail);
//				} catch (Exception e) {
//					throw new RuntimeException(e);
//				}
//			}
//		}.start();
		
//		request.setAttribute("msg", "Signup success. An activation mail has been sent to your mailbox.");
		request.setAttribute("msg", "Signup success.");
		List<String> links = new ArrayList<String>();
		links.add("<a href='" + request.getContextPath() + "/index.jsp'>Main page</a>");
		links.add("<a href='" + request.getContextPath() + "/jsps/login.jsp'>Login</a>");
		request.setAttribute("links", links);
		return "/jsps/msg.jsp";
	}
	
	public String loginPre(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return "/jsps/login.jsp";
	}
	
	public String login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User user = userService.findByEmail(email);
		if (user == null) {
			request.setAttribute("email", email);
			request.setAttribute("msg", "The email does not exists!");
			return "/jsps/login.jsp";
		}
		if (!user.getPassword().equals(password)) {
			request.setAttribute("email", email);
			request.setAttribute("msg", "Wrong password!");
			return "/jsps/login.jsp";
		}
		if (!user.isState()) {
			request.setAttribute("email", email);
			request.setAttribute("msg", "This email address hasn't been validated!");
			return "/jsps/login.jsp";
		}
		
		request.getSession().setAttribute("user", user);
		request.setAttribute("msg", "Login success!");
		
		List<String> links = new ArrayList<String>();
		links.add("<a href='" + request.getContextPath() + "/index.jsp'>Main page</a>");
		request.setAttribute("links", links);
		return "/jsps/msg.jsp";
	}
	
	public String quit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().removeAttribute("cart");
		User user = (User) request.getSession().getAttribute("user");
		String msg = "";
		if (user == null) {
			msg = "You haven't signed in yet.";
		} else {
			msg = "Log out successfully!";
			request.getSession().removeAttribute("user");			
		}
		request.setAttribute("msg", msg);
		List<String> links = new ArrayList<String>();
		links.add("<a href='" + request.getContextPath() + "/index.jsp'>Main page</a>");
		links.add("<a href='" + request.getContextPath() + "/jsps/login.jsp'>Sign in</a>");
		request.setAttribute("links", links);
		return "/jsps/msg.jsp";
	}

}
