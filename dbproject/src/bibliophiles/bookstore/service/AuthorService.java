package bibliophiles.bookstore.service;

import java.util.List;

import bibliophiles.bookstore.domain.Author;

public interface AuthorService {
	public void add(Author author);
	public void mod(Author author);
	public void del(String authorID);
	public Author findByAuthorID(String authorID);
	public List<Author> all();
	public List<Author> findByBookISBN(String isbn);
}
