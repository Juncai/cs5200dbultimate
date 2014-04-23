package bibliophiles.bookstore.dao;

import java.util.List;
import java.util.Map;

import bibliophiles.bookstore.domain.Book;
/**
 * 
 * This is the Data Access Object for creating,
 *  referring, updating and deleting the database 
 *
 * @author Team Bibliophiles
 * 
 */
public interface BookDao {
	/**
	 * This method is to look up all the books
	 * in the database
	 * 
	 * @return all the books in the database
	 * 
	 * @throws SQLException if there is an exception 
	 * that provides information on a database access
	 * error or other errors.
	 */
	List<Book> all();
	
	/**
	 * This method is to look up all the books in 
	 * the same category.
	 * 
	 * @param categoryID 
	 * There are several categories in the application.
	 * For example, J2EE, JSP and etc.. All of them will
	 * be saved in the database. The id of these categories
	 * are generated with UUID(by Apache).
	 * 
	 * @return all the books 
	 * 
	 * @throws SQLException if there is an exception 
	 * that provides information on a database access
	 * error or other errors.
	 */
	List<Book> findByCategoryID(String categoryID);
	
	/**
	 * This method is to look up a certain book by its
	 * unique isbn.
	 * 
	 * @param isbn 
	 * the unique id of a book
	 * 
	 * @return the book with certain isbn 
	 * 
	 * @throws SQLException if there is an exception 
	 * that provides information on a database access
	 * error or other errors.
	 */
	Book findByIsbn(String isbn);
	
	/**
	 * This method is to look up all the books published
	 * by the same publisher
	 * 
	 * @param publisherID 
	 * the ID of a publisher
	 * 
	 * @return the books published by the same publisher 
	 * 
	 * @throws SQLException if there is an exception 
	 * that provides information on a database access
	 * error or other errors.
	 */
	List<Book> findByPublisherID(String publisherID);
	
	/**
	 * This method is to modify an existed book
	 * 
	 * @param book 
	 * 
	 * @throws SQLException if there is an exception 
	 * that provides information on a database access
	 * error or other errors.
	 */	
	void mod(Book book);
	
	/**
	 * This method is to delete an existed book
	 * 
	 * @param isbn 
	 * 
	 * @throws SQLException if there is an exception 
	 * that provides information on a database access
	 * error or other errors.
	 */	
	void del(String isbn);
	
	/**
	 * This method is to add a new book
	 * 
	 * @param book 
	 * 
	 * @throws SQLException if there is an exception 
	 * that provides information on a database access
	 * error or other errors.
	 */	
	void add(Book book);
	
	/**
	 * This method is not implemented and returns nothing 
	 * @deprecated
	 * @return null
	 */	
	Book findBook(String field, String value);
	
	/**
	 * This method is to find all the list with certain 
	 * conditions
	 * 
	 * @param conditions
	 * a map with key-value, in which key is the parameter
	 * name and value is the parameter value. For example,
	 * if you want to find all the book written by a certain
	 * author, you can use pass a map with("authorID", "aaa")
	 * 
	 * @return all the books with certain conditions
	 */
	List<Book> findList(Map<String, String> conditions);
	
	/**
	 * This method is to look up all the books
	 * in the database that are reserved by customers
	 * 
	 * @return all the books in the database
	 * 
	 * @throws SQLException if there is an exception 
	 * that provides information on a database access
	 * error or other errors.
	 */
	List<Book> findReserved();
	
	/**
	 * This method is to look up all the books
	 * in the database that are in store
	 * 
	 * @return all the books in the database
	 * 
	 * @throws SQLException if there is an exception 
	 * that provides information on a database access
	 * error or other errors.
	 */
	List<Book> findInStore();
	
	/**
	 * This method is to look up all the books in 
	 * the same category that are in store.
	 * 
	 * @param categoryID 
	 * There are several categories in the application.
	 * For example, J2EE, JSP and etc.. All of them will
	 * be saved in the database. The id of these categories
	 * are generated with UUID(by Apache).
	 * 
	 * @return all the books 
	 * 
	 * @throws SQLException if there is an exception 
	 * that provides information on a database access
	 * error or other errors.
	 */
	List<Book> findInStoreByCategoryID(String categoryID);
}
