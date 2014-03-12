package bibliophiles.bookstore.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import jon.jdbc.utils.JdbcUtils;
import jon.utils.CommonUtils;
import bibliophiles.bookstore.dao.BookDao;
import bibliophiles.bookstore.domain.Book;
import bibliophiles.bookstore.domain.Publisher;

public class BookDaoImpl implements BookDao {

	private QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());

	public List<Book> all() {
		String sql = "SELECT * FROM book b,publisher p WHERE b.publisherID=p.publisherID;";
		try {
			List<Book> bookList = new ArrayList<Book>();
			List<Map<String, Object>> mapList = qr.query(sql,
					new MapListHandler());
			for (Map<String, Object> map : mapList) {
				Book book = CommonUtils.toBean(map, Book.class);
				Publisher publisher = CommonUtils.toBean(map, Publisher.class);
				book.setPublisher(publisher);
				bookList.add(book);
			}
			return bookList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Book> findByCategory(String category) {
		String sql = "SELECT * FROM book b,publisher p WHERE b.publisherID=p.publisherID AND category=?";
		try {
			List<Book> bookList = new ArrayList<Book>();
			List<Map<String, Object>> mapList = qr.query(sql,
					new MapListHandler(), category);
			for (Map<String, Object> map : mapList) {
				Book book = CommonUtils.toBean(map, Book.class);
				Publisher publisher = CommonUtils.toBean(map, Publisher.class);
				book.setPublisher(publisher);
				bookList.add(book);
			}
			return bookList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Book findByIsbn(String isbn) {
		String sql = "SELECT * FROM book b,publisher p WHERE b.publisherID=p.publisherID AND b.isbn=?";
		try {
			Map<String, Object> map = qr.query(sql, new MapHandler(), isbn);
			Book book = CommonUtils.toBean(map, Book.class);
			Publisher publisher = CommonUtils.toBean(map, Publisher.class);
			return book;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void mod(Book book) {
		String sql = "UPDATE book SET isbn=?,title=?,price=?,cover=?,rating=?,publisherID=?,category=?,isdel=?,reserved=?";
		try {
			qr.update(sql, book.getIsbn(), book.getTitle(), book.getPrice(),
					book.getCover(), book.getRating(), book.getPublisher()
							.getPublisherID(), book.getCategory(), book
							.isIsdel(), book.isReserved());
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
							.getPublisherID(), book.getCategory(), book
							.isIsdel(), book.isReserved());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
