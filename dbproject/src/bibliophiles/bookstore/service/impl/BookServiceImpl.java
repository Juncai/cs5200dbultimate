package bibliophiles.bookstore.service.impl;

import java.util.List;
import java.util.Map;

import bibliophiles.bookstore.dao.BookDao;
import bibliophiles.bookstore.dao.impl.BookDaoImpl;
import bibliophiles.bookstore.domain.Book;
import bibliophiles.bookstore.service.BookService;

public class BookServiceImpl implements BookService {
	private BookDao bookDao = new BookDaoImpl();
	
	public List<Book> all() {
		return bookDao.all();
	}

	public List<Book> findByCategoryID(String categoryID) {
		return bookDao.findByCategoryID(categoryID);
	}

	public Book findByIsbn(String isbn) {
		return bookDao.findByIsbn(isbn);
	}

	public void mod(Book book) {
		bookDao.mod(book);
	}

	public void del(String isbn) {
		bookDao.del(isbn);
	}

	public void add(Book book) {
		bookDao.add(book);
	}

	public List<Book> findByPublisherID(String publisherID) {
		return bookDao.findByPublisherID(publisherID);
	}

	public List<Book> searchBooks(Map<String, String> conditions) {
		return bookDao.findList(conditions);
	}

	public List<Book> findReserved() {
		return bookDao.findReserved();
	}

	public List<Book> findInStore() {
		return bookDao.findInStore();
	}

	public List<Book> findInStoreByCategoryID(String categoryID) {
		return bookDao.findInStoreByCategoryID(categoryID);
	}

	
	
}
