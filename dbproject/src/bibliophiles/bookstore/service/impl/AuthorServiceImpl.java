package bibliophiles.bookstore.service.impl;

import java.util.List;

import bibliophiles.bookstore.dao.AuthorDao;
import bibliophiles.bookstore.dao.impl.AuthorDaoImpl;
import bibliophiles.bookstore.domain.Author;
import bibliophiles.bookstore.service.AuthorService;

public class AuthorServiceImpl implements AuthorService {

	private AuthorDao authorDao = new AuthorDaoImpl();
	
	public void add(Author author) {
		authorDao.add(author);
	}

	public void mod(Author author) {
		authorDao.update(author);
	}

	public void del(String authorID) {
		authorDao.del(authorID);
	}

	public Author findByAuthorID(String authorID) {
		return authorDao.findByAuthorID(authorID);
	}

	public List<Author> all() {
		return authorDao.all();
	}

	public List<Author> findByBookISBN(String isbn) {
		return authorDao.findByBookISBN(isbn);
	}

}
