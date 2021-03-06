package bibliophiles.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * This is servlet is the parent servlet of all the 
 * children servelt that need to forward somewhere.
 * This class refer the thought of Structs 1.0
 * 
 * In this class, we invoke the children method to
 * get the forward path and forward in the service 
 * method of the parent class
 *
 * @author Team Bibliophiles
 * 
 */
public class BaseServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		

		String methodName = request.getParameter("method");
		if(methodName == null || methodName.isEmpty()) {
			throw new ServletException("The method parameter is missing.");
		}
		
		Class[] types = {HttpServletRequest.class, HttpServletResponse.class};
		
		Method method;
		try {
			method = this.getClass().getMethod(methodName, types);
		} catch (Exception e) {
			String msg = "Can't find method named: " + methodName 
					+ "with request and response parameters and return type is String.";
			throw new RuntimeException(e);
		}
		
		try {
			String path = (String)method.invoke(this, request, response);
			
			if(path == null || path.isEmpty()) {
				return;
			}
			
			request.getRequestDispatcher(path).forward(request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

