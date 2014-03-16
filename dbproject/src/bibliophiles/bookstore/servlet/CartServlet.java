package bibliophiles.bookstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bibliophiles.bookstore.domain.Book;
import bibliophiles.bookstore.domain.Cart;
import bibliophiles.bookstore.domain.CartItem;
import bibliophiles.bookstore.service.BookService;
import bibliophiles.bookstore.service.impl.BookServiceImpl;
import bibliophiles.servlet.BaseServlet;

public class CartServlet extends BaseServlet {
	private BookService bookServie = new BookServiceImpl();

	public String showCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if (cart != null) {
			Collection<CartItem> cartItems = cart.getCartItems();
			if (cartItems.size() > 0) {
				request.setAttribute("cartItems", cartItems);	
			}
		}
		return "/jsps/cart/cartlist.jsp";
	}
	
	
	
	public String add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String isbn = request.getParameter("isbn");
		int count = Integer.parseInt(request.getParameter("count"));
		Book book = bookServie.findByIsbn(isbn);
		CartItem cartItem = new CartItem();
		cartItem.setBook(book);
		cartItem.setCount(count);
		cartItem.setSubtotal(count * book.getPrice());
		
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
		}
		cart.add(cartItem);
		request.getSession().setAttribute("cart", cart);
		return "/cart/CartServlet?method=showCart";
	}
	
	
	public String del(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String isbn = request.getParameter("isbn");
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if (cart != null) {
			cart.del(isbn);
		}
		return "/cart/CartServlet?method=showCart";
	}
	
	public String clear(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if (cart != null) {
			cart.clear();
		}
		return "/cart/CartServlet?method=showCart";
	}

}
