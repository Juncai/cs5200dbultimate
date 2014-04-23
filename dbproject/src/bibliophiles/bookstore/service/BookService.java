package bibliophiles.bookstore.service;

import java.util.List;
import java.util.Map;

import bibliophiles.bookstore.domain.Book;



public interface BookService {
	List<Book> all();
	List<Book> findByCategoryID(String categoryID);
	List<Book> findByPublisherID(String publisherID);
	List<Book> searchBooks(Map<String, String> conditions);
	List<Book> findReserved();
	List<Book> findInStore();
	List<Book> findInStoreByCategoryID(String categoryID);
	Book findByIsbn(String isbn);
	void mod(Book book);
	void del(String isbn);
	void add(Book book);
}
