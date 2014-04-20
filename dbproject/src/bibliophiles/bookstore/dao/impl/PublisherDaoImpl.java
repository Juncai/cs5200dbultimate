package bibliophiles.bookstore.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import bibliophiles.bookstore.dao.PublisherDao;
import bibliophiles.bookstore.domain.Publisher;
import bibliophiles.jdbc.utils.JdbcUtils;

public class PublisherDaoImpl implements PublisherDao {
	private QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());

	public void add(Publisher publisher) {
		String sql = "INSERT INTO publisher VALUES(?,?)";
		try {
			qr.update(sql, publisher.getPublisherID(), publisher.getName());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void update(Publisher publisher) {
		String sql = "UPDATE publisher SET name=? WHERE publisherID=?";
		try {
			qr.update(sql, publisher.getName(), publisher.getPublisherID());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void del(String publisherID) {
		String sql = "DELETE FROM publisher WHERE publisherID=?";
		try {
			qr.update(sql, publisherID);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Publisher findByPublisherID(String publisherID) {
		String sql = "SELECT * FROM publisher WHERE publisherID=?";
		try {
			return qr.query(sql, new BeanHandler<Publisher>(Publisher.class), publisherID);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Publisher> all() {
		String sql = "SELECT * FROM publisher";
		
		try {
//			List<Publisher> list = qr.query(sql, new BeanListHandler<Publisher>(Publisher.class));
			return qr.query(sql, new BeanListHandler<Publisher>(Publisher.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Publisher findByName(String name) {
		String sql = "SELECT * FROM publisher WHERE name=?";
		try {
			return qr.query(sql, new BeanHandler<Publisher>(Publisher.class), name);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
