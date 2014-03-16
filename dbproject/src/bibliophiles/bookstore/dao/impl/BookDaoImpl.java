package bibliophiles.bookstore.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import bibliophiles.bookstore.dao.BookDao;
import bibliophiles.bookstore.domain.Author;
import bibliophiles.bookstore.domain.Book;
import bibliophiles.bookstore.domain.Category;
import bibliophiles.bookstore.domain.Publisher;
import bibliophiles.jdbc.utils.JdbcUtils;
import bibliophiles.utils.CommonUtils;

public class BookDaoImpl implements BookDao {

	private QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());

	public List<Book> all() {
		String sql = "SELECT * FROM book b,publisher p,category c,author a,"
				+ "bookauthor ba WHERE b.isbn=ba.isbn AND ba.authorID=a.authorID "
				+ "AND b.categoryID=c.categoryID AND b.publisherID=p.publisherID "
				+ "AND isdel=FALSE;";

		try {
			List<Book> bookList = new ArrayList<Book>();
			List<Map<String, Object>> mapList = qr.query(sql,
					new MapListHandler());
			if (mapList.size() > 0) {
				Map<String, Object> map0 = mapList.remove(0);
				Book book = CommonUtils.toBean(map0, Book.class);
				String oldISBN = book.getIsbn();
				String newISBN;
				Publisher publisher = CommonUtils.toBean(map0, Publisher.class);
				Category category = CommonUtils.toBean(map0, Category.class);
				List<Author> authorList = new ArrayList<Author>();
				Author author = CommonUtils.toBean(map0, Author.class);
				authorList.add(author);
				book.setPublisher(publisher);
				book.setCategory(category);
				
				for (Map<String, Object> map : mapList) {
					newISBN = (String) map.get("isbn");
					if (!oldISBN.equals(newISBN)) {
						book.setAuthors(authorList);
						bookList.add(book);	// add the previous book
						
						book = CommonUtils.toBean(map, Book.class);
						publisher = CommonUtils.toBean(map, Publisher.class);
						category = CommonUtils.toBean(map, Category.class);
						book.setPublisher(publisher);
						book.setCategory(category);
						authorList = new ArrayList<Author>();
						oldISBN = newISBN;
					}
					authorList.add(CommonUtils.toBean(map, Author.class));
				}
				book.setAuthors(authorList);
				bookList.add(book);	// add the last book
			}
			
			return bookList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Book> findByCategoryID(String categoryID) {
		String sql = "SELECT * FROM book b,publisher p,category c,author a,"
				+ "bookauthor ba WHERE b.isbn=ba.isbn AND ba.authorID=a.authorID "
				+ "AND b.categoryID=c.categoryID AND b.publisherID=p.publisherID "
				+ "AND isdel=FALSE AND b.categoryID=?;";

		try {
			List<Book> bookList = new ArrayList<Book>();
			List<Map<String, Object>> mapList = qr.query(sql,
					new MapListHandler(), categoryID);
			if (mapList.size() > 0) {
				Map<String, Object> map0 = mapList.remove(0);
				Book book = CommonUtils.toBean(map0, Book.class);
				String oldISBN = book.getIsbn();
				String newISBN;
				Publisher publisher = CommonUtils.toBean(map0, Publisher.class);
				Category category = CommonUtils.toBean(map0, Category.class);
				List<Author> authorList = new ArrayList<Author>();
				Author author = CommonUtils.toBean(map0, Author.class);
				authorList.add(author);
				book.setPublisher(publisher);
				book.setCategory(category);
				
				for (Map<String, Object> map : mapList) {
					newISBN = (String) map.get("isbn");
					if (!oldISBN.equals(newISBN)) {
						book.setAuthors(authorList);
						bookList.add(book);	// add the previous book
						
						book = CommonUtils.toBean(map, Book.class);
						publisher = CommonUtils.toBean(map, Publisher.class);
						category = CommonUtils.toBean(map, Category.class);
						book.setPublisher(publisher);
						book.setCategory(category);
						authorList = new ArrayList<Author>();
						oldISBN = newISBN;
					}
					authorList.add(CommonUtils.toBean(map, Author.class));
				}
				book.setAuthors(authorList);
				bookList.add(book);	// add the last book
			}
			
			return bookList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Book findByIsbn(String isbn) {
		String sql = "SELECT * FROM book b,publisher p,category c,author a,"
				+ "bookauthor ba WHERE b.isbn=ba.isbn AND ba.authorID=a.authorID "
				+ "AND b.categoryID=c.categoryID AND b.publisherID=p.publisherID "
				+ "AND isdel=FALSE AND b.isbn=?;";

		try {
			List<Map<String, Object>> mapList = qr.query(sql,
					new MapListHandler(), isbn);
			Map<String, Object> map = mapList.remove(0);
			Book book = CommonUtils.toBean(map, Book.class);
			Publisher publisher = CommonUtils.toBean(map, Publisher.class);
			Category category = CommonUtils.toBean(map, Category.class);
			List<Author> authorList = new ArrayList<Author>();
			authorList.add(CommonUtils.toBean(map, Author.class));
			for (Map<String, Object> map1 : mapList) {
				authorList.add(CommonUtils.toBean(map1, Author.class));
			}
			book.setPublisher(publisher);
			book.setCategory(category);
			book.setAuthors(authorList);
			return book;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void mod(Book book) {
		String sql = "UPDATE book SET isbn=?,title=?,price=?,cover=?,rating=?,publisherID=?,categoryID=?,isdel=?,reserved=?";
		try {
			qr.update(sql, book.getIsbn(), book.getTitle(), book.getPrice(),
					book.getCover(), book.getRating(), book.getPublisher()
							.getPublisherID(), book.getCategory()
							.getCategoryID(), book.isIsdel(), book.isReserved());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void del(String isbn) {
		String sql = "DELETE FROM book WHERE isbn=?";
		try {
			qr.update(sql, isbn);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void add(Book book) {
		String sql = "INSERT INTO book VALUES(?,?,?,?,?,?,?,?,?";
		try {
			qr.update(sql, book.getIsbn(), book.getTitle(), book.getPrice(),
					book.getCover(), book.getRating(), book.getPublisher()
							.getPublisherID(), book.getCategory()
							.getCategoryID(), book.isIsdel(), book.isReserved());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Book> findByPublisherID(String publisherID) {
		String sql = "SELECT * FROM book b,publisher p,category c,author a,"
				+ "bookauthor ba WHERE b.isbn=ba.isbn AND ba.authorID=a.authorID "
				+ "AND b.categoryID=c.categoryID AND b.publisherID=p.publisherID "
				+ "AND isdel=FALSE AND b.publisherID=?;";

		try {
			List<Book> bookList = new ArrayList<Book>();
			List<Map<String, Object>> mapList = qr.query(sql,
					new MapListHandler(), publisherID);
			if (mapList.size() > 0) {
				Map<String, Object> map0 = mapList.remove(0);
				Book book = CommonUtils.toBean(map0, Book.class);
				String oldISBN = book.getIsbn();
				String newISBN;
				Publisher publisher = CommonUtils.toBean(map0, Publisher.class);
				Category category = CommonUtils.toBean(map0, Category.class);
				List<Author> authorList = new ArrayList<Author>();
				Author author = CommonUtils.toBean(map0, Author.class);
				authorList.add(author);
				book.setPublisher(publisher);
				book.setCategory(category);
				
				for (Map<String, Object> map : mapList) {
					newISBN = (String) map.get("isbn");
					if (!oldISBN.equals(newISBN)) {
						book.setAuthors(authorList);
						bookList.add(book);	// add the previous book
						
						book = CommonUtils.toBean(map, Book.class);
						publisher = CommonUtils.toBean(map, Publisher.class);
						category = CommonUtils.toBean(map, Category.class);
						book.setPublisher(publisher);
						book.setCategory(category);
						authorList = new ArrayList<Author>();
						oldISBN = newISBN;
					}
					authorList.add(CommonUtils.toBean(map, Author.class));
				}
				book.setAuthors(authorList);
				bookList.add(book);	// add the last book
			}

			return bookList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Book> findList(Map<String, String> conditions) {
		
		String sql = "SELECT * FROM book b,publisher p,category c,author a,"
				+ "bookauthor ba WHERE b.isbn=ba.isbn AND ba.authorID=a.authorID "
				+ "AND b.categoryID=c.categoryID AND b.publisherID=p.publisherID "
				+ "AND isdel=FALSE";
		StringBuffer sb = new StringBuffer(sql);
		
		for (String condition : conditions.keySet()) {
			sb.append("," + condition + "=" + conditions.get(condition));
		}
		
		try {
			List<Book> bookList = new ArrayList<Book>();
			List<Map<String, Object>> mapList = qr.query(sql,
					new MapListHandler());
			if (mapList.size() > 0) {
				Map<String, Object> map0 = mapList.remove(0);
				Book book = CommonUtils.toBean(map0, Book.class);
				String oldISBN = book.getIsbn();
				String newISBN;
				Publisher publisher = CommonUtils.toBean(map0, Publisher.class);
				Category category = CommonUtils.toBean(map0, Category.class);
				List<Author> authorList = new ArrayList<Author>();
				Author author = CommonUtils.toBean(map0, Author.class);
				authorList.add(author);
				book.setPublisher(publisher);
				book.setCategory(category);
				
				for (Map<String, Object> map : mapList) {
					newISBN = (String) map.get("isbn");
					if (!oldISBN.equals(newISBN)) {
						book.setAuthors(authorList);
						bookList.add(book);	// add the previous book
						
						book = CommonUtils.toBean(map, Book.class);
						publisher = CommonUtils.toBean(map, Publisher.class);
						category = CommonUtils.toBean(map, Category.class);
						book.setPublisher(publisher);
						book.setCategory(category);
						authorList = new ArrayList<Author>();
						oldISBN = newISBN;
					}
					authorList.add(CommonUtils.toBean(map, Author.class));
				}
				book.setAuthors(authorList);
				bookList.add(book);	// add the last book
			}
			
			return bookList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Book findBook(String field, String value) {
		// TODO Auto-generated method stub
		return null;
	}

}
