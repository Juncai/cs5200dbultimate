package bibliophiles.bookstore.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import bibliophiles.bookstore.domain.Author;
import bibliophiles.bookstore.domain.Book;
import bibliophiles.bookstore.domain.Category;
import bibliophiles.bookstore.domain.JSONBook;
import bibliophiles.bookstore.domain.OrderItem;
import bibliophiles.bookstore.domain.Publisher;
import bibliophiles.bookstore.service.AuthorService;
import bibliophiles.bookstore.service.BookService;
import bibliophiles.bookstore.service.CategoryService;
import bibliophiles.bookstore.service.OrderItemService;
import bibliophiles.bookstore.service.PublisherService;
import bibliophiles.bookstore.service.exception.CategoryException;
import bibliophiles.bookstore.service.impl.AuthorServiceImpl;
import bibliophiles.bookstore.service.impl.BookServiceImpl;
import bibliophiles.bookstore.service.impl.CategoryServiceImpl;
import bibliophiles.bookstore.service.impl.OrderItemServiceImpl;
import bibliophiles.bookstore.service.impl.PublisherServiceImpl;
import bibliophiles.servlet.BaseServlet;
import bibliophiles.utils.CommonUtils;

public class BookServlet extends BaseServlet {
	private BookService bookService = new BookServiceImpl();
	private OrderItemService orderItemService = new OrderItemServiceImpl();
	private PublisherService publisherService = new PublisherServiceImpl();
	private CategoryService categoryService = new CategoryServiceImpl();
	private AuthorService authorService = new AuthorServiceImpl();
	
	public String all(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Book> bookList = bookService.findInStore(); 
//		JSONArray jsonList = JSONArray.fromObject(bookList);
		request.setAttribute("list", bookList);
//		request.setAttribute("jsonList", jsonList.toString());
		return "/jsps/booklist.jsp";
	}
	
	public String query(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Book> bookList = bookService.findByCategoryID(request.getParameter("categoryID")); 
		request.setAttribute("list", bookList);
		return "/jsps/booklist.jsp";
	}

	public String load(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Book book = bookService.findByIsbn(request.getParameter("isbn")); 
		List<OrderItem> orderItems = orderItemService.findByIsbn(request.getParameter("isbn"));
		request.setAttribute("book", book);
		request.setAttribute("orderItems", orderItems);
		return "/jsps/bookdesc.jsp";
	}
	
	public String search(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		Map<String, String> condMap = request.getParameterMap();
		Map<String, String> condMap = new HashMap<String, String>();
		if (!request.getParameter("author").equals("")) {
			condMap.put("author", request.getParameter("author"));			
		}
		if (!request.getParameter("title").equals("")) {
			condMap.put("title", request.getParameter("title"));			
		}
		if (!request.getParameter("publisher").equals("")) {
			condMap.put("publisher", request.getParameter("publisher"));			
		}
		if (!request.getParameter("isbn").equals("")) {
			condMap.put("isbn", request.getParameter("isbn"));			
		}
		
		List<Book> bookList = bookService.searchBooks(condMap);
		if (bookList.size() == 0) {
			request.setAttribute("msg", "No results.");
		}
		request.setAttribute("list", bookList);
		return "/jsps/booksearch.jsp";
	}
	
	public String reserve(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bookJson = request.getParameter("bookJson");
//		JSONObject jo = new JSONObject.fromObject(bookJson);
		JSONObject jo = JSONObject.fromObject(bookJson);
		JSONBook jsonBook = (JSONBook) JSONObject.toBean(jo, JSONBook.class);
		// assign attributes from JSON to Book
		Book book = bookService.findByIsbn(jsonBook.getIsbn());
		//System.out.println(book.getIsbn());
		if (book == null){
			book = new Book();
			book.setIsbn(jsonBook.getIsbn());
			book.setCover(jsonBook.getCover());
			if(jsonBook.getPrice() != null && !jsonBook.getPrice().equals("")){
				book.setPrice(Double.parseDouble(jsonBook.getPrice()));				
			} else {
				book.setPrice(0);
			}
			book.setIsdel(false);
			book.setReserved(true);
			book.setTitle(jsonBook.getTitle());
			
			Publisher publisher;
			if (jsonBook.getPublisher() == null) {
				publisher = publisherService.findByName("NULL");
				if(publisher == null){
					publisher = new Publisher();
					publisher.setName("NULL");
					publisher.setPublisherID(CommonUtils.uuid());
					publisherService.add(publisher);
				}
				
			} else {				
				publisher = publisherService.findByName(jsonBook.getPublisher());
				if(publisher == null){
					publisher = new Publisher();
					publisher.setName(jsonBook.getPublisher());
					publisher.setPublisherID(CommonUtils.uuid());
					publisherService.add(publisher);
				}
			}
			book.setPublisher(publisher);
			
			Category category;
			if (jsonBook.getCategories() == null) {
				category = new Category();
			} else {				
				category = categoryService.findByCategory(jsonBook.getCategories().get(0));
				if (category == null) {
					category = new Category();
					category.setCategoryname(jsonBook.getCategories().get(0));
					category.setCategoryID(CommonUtils.uuid());
					try {
						categoryService.add(category);
					} catch (CategoryException e) {
						throw new RuntimeException(e);
					}
				}
			}
			book.setCategory(category);
			
			List<Author> authors = new ArrayList<Author>();
			Author author;
			Author _author;
			for (String authorName : jsonBook.getAuthors()) {
				String names[] = authorName.split(" ");
				author = new Author();
				author.setFirstname(names[0]);
				if (names.length == 2) {
					author.setLastname(names[1]);
				} else if (names.length == 3) {
					author.setMiddlename(names[1]);
					author.setLastname(names[2]);
				}
				_author = authorService.findByName(author);
				if (_author == null) {
					author.setAuthorID(CommonUtils.uuid());
					authorService.add(author);
					_author = author;
				}
				authors.add(_author);
			}
			book.setAuthors(authors);
			bookService.add(book);
		} else {
			if(book.isIsdel()){
				book.setIsdel(false);
				book.setReserved(true);
			}
		}
		request.setAttribute("msg", "Reservation success.");
		return "/jsps/msg.jsp";
	}
	
}
