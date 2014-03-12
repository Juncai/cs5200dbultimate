package bibliophiles.bookstore.service;

import java.util.List;

import bibliophiles.bookstore.domain.Book;



public interface BookService {
	List<Book> all();
	List<Book> findByCategory(String category);
	Book findByIsbn(String isbn);
	void mod(Book book);
	void del(String isbn);
	void add(Book book);
}
