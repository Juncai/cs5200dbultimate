package bibliophiles.bookstore.dao;

import java.util.List;

import bibliophiles.bookstore.domain.Author;
/**
 * This is the Data Access Object for creating,
 *  referring, updating and deleting the database 
 * 
 * @author Team Bibliophiles
 */
public interface AuthorDao {
	public void add(Author author);
	public void update(Author author);
	public void del(String authorID);
	public Author findByAuthorID(String authorID);
	public List<Author> all();
	public List<Author> findByBookISBN(String isbn);
	public Author findByName(Author author);
}
