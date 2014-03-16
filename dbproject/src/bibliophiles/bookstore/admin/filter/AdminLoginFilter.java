package bibliophiles.bookstore.admin.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import bibliophiles.bookstore.admin.domain.Administrator;


@WebFilter({ "/admin/*", "/adminjsps/admin/*" })
public class AdminLoginFilter implements Filter {

	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		Administrator admin = (Administrator) session.getAttribute("admin");
		if (admin == null) {
			req.setAttribute("msg", "You must sign in before go into the administration platform.");
			req.getRequestDispatcher("/adminjsps/msg.jsp").forward(req, response);
			return;
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {}

}
