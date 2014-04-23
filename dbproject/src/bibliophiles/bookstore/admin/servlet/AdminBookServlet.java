package bibliophiles.bookstore.admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import bibliophiles.bookstore.domain.Author;
import bibliophiles.bookstore.domain.Book;
import bibliophiles.bookstore.domain.Category;
import bibliophiles.bookstore.domain.JSONBook;
import bibliophiles.bookstore.domain.Publisher;
import bibliophiles.bookstore.service.AuthorService;
import bibliophiles.bookstore.service.BookService;
import bibliophiles.bookstore.service.CategoryService;
import bibliophiles.bookstore.service.PublisherService;
import bibliophiles.bookstore.service.exception.CategoryException;
import bibliophiles.bookstore.service.impl.AuthorServiceImpl;
import bibliophiles.bookstore.service.impl.BookServiceImpl;
import bibliophiles.bookstore.service.impl.CategoryServiceImpl;
import bibliophiles.bookstore.service.impl.PublisherServiceImpl;
import bibliophiles.servlet.BaseServlet;
import bibliophiles.utils.CommonUtils;

public class AdminBookServlet extends BaseServlet {
	private BookService bookService = new BookServiceImpl();
	private CategoryService categoryService = new CategoryServiceImpl();
	private PublisherService publisherService = new PublisherServiceImpl();
	private AuthorService authorService = new AuthorServiceImpl();
	
	
	public String all(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Book> bookList = bookService.all();
		request.setAttribute("bookList", bookList);
		return "/adminjsps/admin/book/all.jsp";
	}
	
	public String reserved(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Book> bookList = bookService.findReserved();
		request.setAttribute("bookList", bookList);
		return "/adminjsps/admin/book/reserved.jsp";
	}
	
	public String addReserved(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Book book = bookService.findByIsbn(request.getParameter("isbn"));
		book.setReserved(false);
		String price = request.getParameter("price");
		if (price != null && !price.equals("")) {
			book.setPrice(Double.parseDouble(price));
		}
		bookService.mod(book);
		request.setAttribute("msg", "Book added.");
		return "/adminjsps/admin/msg.jsp";
	}

	public String desc(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String isbn = request.getParameter("isbn");
		Book book = bookService.findByIsbn(isbn);
		List<Category> categoryList = categoryService.all();
		request.setAttribute("book", book);
		request.setAttribute("categoryList", categoryList);
		return "/adminjsps/admin/book/desc.jsp";
	}
	
	public String del(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String isbn = request.getParameter("isbn");
		bookService.del(isbn);
		request.setAttribute("msg", "Book deleted.");
		return "/adminjsps/admin/msg.jsp";
	}
	
	public String mod(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Book book = bookService.findByIsbn(request.getParameter("isbn"));
		String categoryID = request.getParameter("categoryID");
		Category category = categoryService.findByCategoryID(categoryID);
		book.setCategory(category);
		String price = request.getParameter("price");
		if (price != null && !price.equals("")) {
			book.setPrice(Double.parseDouble(price));
		}
		bookService.mod(book);
		request.setAttribute("msg", "Book info modified.");
		return "/adminjsps/admin/msg.jsp";
	}
	
	public String addPre(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Category> categoryList = categoryService.all();
		request.setAttribute("categoryList", categoryList);
		return "/adminjsps/admin/book/add.jsp";
	}
	
	public String add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bookJson = request.getParameter("bookJson");
		if (bookJson == null || bookJson.equals("")) {
			request.setAttribute("msg", "Please get book info from Google Books.");
			return "/adminjsps/admin/msg.jsp";
		}
		JSONObject jo = JSONObject.fromObject(bookJson);
		JSONBook jsonBook = (JSONBook) JSONObject.toBean(jo, JSONBook.class);
		// assign attributes from JSON to Book
		Book book = bookService.findByIsbn(jsonBook.getIsbn());
		//System.out.println(book.getIsbn());
		if (book == null){
			// get info from the json string of the book
			book = new Book();
			book.setIsbn(jsonBook.getIsbn());
			book.setCover(jsonBook.getCover());
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
			
			// get price, category from the form
			String price = request.getParameter("price");
			if (price != null && !price.equals("")) {
				book.setPrice(Double.parseDouble(price));				
			} else {
				book.setPrice(0);
			}
			
			String categoryName = request.getParameter("category");
			if (categoryName == null || categoryName.equals("")) {
				categoryName = "NULL";
			}
			Category category = categoryService.findByCategory(categoryName);
			if (category == null) {
				category = new Category();
				category.setCategoryname(categoryName);
				category.setCategoryID(CommonUtils.uuid());
				try {
					categoryService.add(category);
				} catch (CategoryException e) {
					throw new RuntimeException(e);
				}
			}
			book.setCategory(category);
			
			// set other info for the book
			book.setIsdel(false);
			book.setReserved(false);
			
			bookService.add(book);
		} else {
			if(book.isReserved()){
				book.setReserved(false);
				bookService.mod(book);
			}
			if(book.isIsdel()){
				book.setIsdel(false);
				bookService.mod(book);
			}
		}
		
		request.setAttribute("msg", "Book added.");
		return "/adminjsps/admin/msg.jsp";
	}
}
