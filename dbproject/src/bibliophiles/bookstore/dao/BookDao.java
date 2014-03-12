package bibliophiles.bookstore.dao;

import java.util.List;

import bibliophiles.bookstore.domain.Book;

public interface BookDao {
	List<Book> all();
	List<Book> findByCategoryID(String categoryID);
	Book findByIsbn(String isbn);
	List<Book> findByPublisherID(String publisherID);
	void mod(Book book);
	void del(String isbn);
	void add(Book book);
}
