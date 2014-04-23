package bibliophiles.bookstore.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import bibliophiles.bookstore.dao.AuthorDao;
import bibliophiles.bookstore.domain.Author;
import bibliophiles.bookstore.domain.Publisher;
import bibliophiles.jdbc.utils.JdbcUtils;

public class AuthorDaoImpl implements AuthorDao {
	private QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
	
	public void add(Author author) {
		String sql = "INSERT INTO author VALUES(?,?,?,?)";
		try {
			qr.update(sql, author.getAuthorID(), author.getFirstname(), author.getLastname(), author.getMiddlename());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void update(Author author) {
		String sql = "UPDATE auther SET firstname=?,lastname=?,middlename=? WHERE authorID=?";
		try {
			qr.update(sql, author.getFirstname(), author.getLastname(), author.getMiddlename(), author.getAuthorID());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void del(String authorID) {
		String sql = "DELETE FROM author WHERE authorID=?";
		try {
			qr.update(sql, authorID);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Author findByAuthorID(String authorID) {
		String sql = "SELECT * FROM author WHERE authorID=?";
		try {
			return qr.query(sql, new BeanHandler<Author>(Author.class), authorID);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Author> all() {
		String sql = "SELECT * FROM author";
		
		try {
//			List<Publisher> list = qr.query(sql, new BeanListHandler<Publisher>(Publisher.class));
			return qr.query(sql, new BeanListHandler<Author>(Author.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Author> findByBookISBN(String isbn) {
		String sql = "SELECT * FROM author a,bookauthor ba WHERE a.authorID=ba.authorID AND ba.isbn=?";
		
		try {
//			List<Publisher> list = qr.query(sql, new BeanListHandler<Publisher>(Publisher.class));
			return qr.query(sql, new BeanListHandler<Author>(Author.class), isbn);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Author findByName(Author author){
		String sql = "SELECT * FROM author WHERE firstname=? AND lastname=?";
		try {
			return qr.query(sql, new BeanHandler<Author>(Author.class), author.getFirstname(), author.getLastname());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
