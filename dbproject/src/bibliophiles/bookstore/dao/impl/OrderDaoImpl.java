package bibliophiles.bookstore.dao.impl;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import bibliophiles.bookstore.dao.OrderDao;
import bibliophiles.bookstore.domain.Book;
import bibliophiles.bookstore.domain.Order;
import bibliophiles.bookstore.domain.OrderItem;
import bibliophiles.jdbc.utils.JdbcUtils;
import bibliophiles.utils.CommonUtils;

public class OrderDaoImpl implements OrderDao {
	QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
	
	public void updateState(String orderID, int state) {
		String sql = "UPDATE orders SET state=? WHERE orderID=?";
		
		try {
			qr.update(sql, state, orderID);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Order> findAll() {
		try {
			String sql = "SELECT * FROM orders ORDER BY ordertime DESC";
			List<Order> orderList = qr.query(sql, new BeanListHandler<Order>(
					Order.class));
			
			sql = "SELECT * FROM orderItem i,book b WHERE i.isbn=b.isbn AND i.orderID=?";
			for (Order order : orderList) {
				
				List<Map<String, Object>> mapList = qr.query(sql,
						new MapListHandler(),
						order.getOrderID());
				for (Map<String, Object> map : mapList) {
					OrderItem orderItem = CommonUtils.toBean(map, OrderItem.class);
					Book book = CommonUtils.toBean(map, Book.class);
					orderItem.setBook(book);
					orderItem.setOrder(order);
					order.addOrderItem(orderItem);
				}
			}
			return orderList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	public List<Order> findByState(int state) {
		try {
			String sql = "SELECT * FROM orders WHERE state=? ORDER BY ordertime DESC";
			List<Order> orderList = qr.query(sql, new BeanListHandler<Order>(
					Order.class), state);
			
			sql = "SELECT * FROM orderItem i,book b WHERE i.isbn=b.isbn AND i.orderID=?";
			for (Order order : orderList) {
				
				List<Map<String, Object>> mapList = qr.query(sql,
						new MapListHandler(),
						order.getOrderID());
				for (Map<String, Object> map : mapList) {
					OrderItem orderItem = CommonUtils.toBean(map, OrderItem.class);
					Book book = CommonUtils.toBean(map, Book.class);
					orderItem.setBook(book);
					orderItem.setOrder(order);
					order.addOrderItem(orderItem);
				}
			}
			return orderList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Order findByOrderID(String orderID) {
		
		try {
			String sql = "SELECT * FROM orders WHERE orderID=?";
			Order order = qr.query(sql, new BeanHandler<Order>(Order.class), orderID);
			
			sql = "SELECT * FROM orderItem i,book b WHERE i.isbn=b.isbn AND orderID=?";
			
			List<Map<String, Object>> mapList = qr.query(sql,
					new MapListHandler(), order.getOrderID());
			for (Map<String, Object> map : mapList) {
				OrderItem orderItem = CommonUtils.toBean(map, OrderItem.class);
				Book book = CommonUtils.toBean(map, Book.class);
				orderItem.setBook(book);
				orderItem.setOrder(order);
				order.addOrderItem(orderItem);
			}
			return order;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	public List<Order> findByUserID(String userID) {
		try {
			String sql = "SELECT * FROM orders WHERE userID=? ORDER BY ordertime DESC";
			List<Order> orderList = qr.query(sql, new BeanListHandler<Order>(
					Order.class), userID);
			
			sql = "SELECT * FROM orderItem i,book b WHERE i.isbn=b.isbn AND i.orderID=?";
			for (Order order : orderList) {
				
				List<Map<String, Object>> mapList = qr.query(sql,
						new MapListHandler(),
						order.getOrderID());
				for (Map<String, Object> map : mapList) {
					OrderItem orderItem = CommonUtils.toBean(map, OrderItem.class);
					Book book = CommonUtils.toBean(map, Book.class);
					orderItem.setBook(book);
					orderItem.setOrder(order);
					order.addOrderItem(orderItem);
				}
			}
			return orderList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void add(Order order) {
		try {
			String sql = "INSERT INTO orders (orderID,ordertime,total,userID,state) VALUES(?,?,?,?,?)";
			Timestamp ts = new Timestamp(order.getOrdertime().getTime());
			qr.update(sql,order.getOrderID(), ts, order.getTotal(), order.getUser().getUserID(), order.getState());
			sql = "INSERT INTO orderItem (orderID,isbn,count,subtotal) VALUES(?,?,?,?)";
			Set<OrderItem> itemSet = order.getOrderItemSet();
			Object[][] params = new Object[order.getOrderItemSet().size()][4];
			int i = 0;
			for (OrderItem orderItem : itemSet) {
				params[i++] = new Object[] {orderItem.getOrder().getOrderID(), orderItem.getBook().getIsbn(),
						orderItem.getCount(), orderItem.getSubtotal()};
//				params[i++] = new Object[] {orderItem.getCount(), orderItem.getSubtotal(),
//						orderItem.getBook().getIsbn(), orderItem.getOrder()
//						.getOrderID()};
			}
			qr.batch(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
