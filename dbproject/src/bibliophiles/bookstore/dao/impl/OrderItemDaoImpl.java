package bibliophiles.bookstore.dao.impl;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;



import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import bibliophiles.bookstore.dao.OrderItemDao;
import bibliophiles.bookstore.domain.OrderItem;
import bibliophiles.jdbc.utils.JdbcUtils;

public class OrderItemDaoImpl implements OrderItemDao {
	private QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
	
	public void updateReview(String orderID, String isbn, int rating,
			String review) {
		String sql = "UPDATE orderItem SET reviewed=?,rating=?,review=?,reviewtime=? WHERE orderID=?,isbn=?";
		Timestamp ts = new Timestamp(new Date().getTime());
		try {
			qr.update(sql, true, rating, review, ts, orderID, isbn);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<OrderItem> findByIsbn(String isbn) {
		String sql = "SELECT * FROM orderItem WHERE isbn=? AND reviewed=TRUE";
		try {
			return qr.query(sql, new BeanListHandler<OrderItem>(OrderItem.class), isbn);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public OrderItem laod(String orderID, String isbn) {
		String sql = "SELECT * FROM orderItem WHERE orderID=?,isbn=?";
		try {
			return qr.query(sql, new BeanHandler<OrderItem>(OrderItem.class), orderID, isbn);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
}
