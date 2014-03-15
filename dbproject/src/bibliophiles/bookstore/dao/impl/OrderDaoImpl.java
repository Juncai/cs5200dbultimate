package bibliophiles.bookstore.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.enterprise.inject.New;

import jon.jdbc.utils.JdbcUtils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import bibliophiles.bookstore.dao.OrderDao;
import bibliophiles.bookstore.domain.Order;

public class OrderDaoImpl implements OrderDao {
	QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
	
	public void updateState(String orderID, int state) {
		String sql = "UPDATE order SET state=? WHERE orderID=?";
		
		try {
			qr.update(sql, state, orderID);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Order> findAll() {
		String sql = "SELECT * FROM order o,orderItem i WHERE o.orderID=i.orderID";
		
		try {
			List<Order> orderList = new ArrayList<Order>();
			List<Map<String, Object>> mapList = qr.query(sql, new MapListHandler());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	public List<Order> findByState(int state) {
		// TODO Auto-generated method stub
		return null;
	}

	public Order findByOrderID(String orderID) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Order> findByUserID(String uiserID) {
		// TODO Auto-generated method stub
		return null;
	}

	public void add(Order order) {
		// TODO Auto-generated method stub

	}

}
