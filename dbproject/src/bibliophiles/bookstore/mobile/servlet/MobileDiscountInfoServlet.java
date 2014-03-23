package bibliophiles.bookstore.mobile.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import bibliophiles.bookstore.domain.Book;
import bibliophiles.bookstore.service.BookService;
import bibliophiles.bookstore.service.impl.BookServiceImpl;

public class MobileDiscountInfoServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	HashMap<Book,Double> map;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BookService bookService = new BookServiceImpl();
		List<Book> bookList = bookService.all(); 
		
		Set<Book> bookDiscountSet = new HashSet<Book>();
		
		if(map == null){
			map = new HashMap<Book, Double>();
			for(Book book:bookList){
				map.put(book, book.getPrice());
			}
		} else {
			for(Book book:bookList){
				Double price = map.get(book);
				System.out.println(book.getTitle()+":"+price);
				if(price > book.getPrice()){
					bookDiscountSet.add(book);
					map.remove(book);
					map.put(book, book.getPrice());
				}
			}
		}
		
		JSONArray jsonList = JSONArray.fromObject(bookDiscountSet);
		System.out.println(jsonList);
		if(bookDiscountSet.size()>0){
			response.getWriter().write(jsonList.toString());
		} else{
			response.getWriter().write("No change");
		}
	}

}
