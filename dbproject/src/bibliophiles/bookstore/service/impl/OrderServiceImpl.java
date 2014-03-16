package bibliophiles.bookstore.service.impl;

import java.util.List;

import bibliophiles.bookstore.dao.OrderDao;
import bibliophiles.bookstore.dao.impl.OrderDaoImpl;
import bibliophiles.bookstore.domain.Order;
import bibliophiles.bookstore.service.OrderService;

public class OrderServiceImpl implements OrderService {
	private OrderDao orderDao = new OrderDaoImpl();
	
	public Order findByOrderID(String orderID) {
		return orderDao.findByOrderID(orderID); 
	}

	public List<Order> findByUserID(String userID) {
		return orderDao.findByUserID(userID);
	}

	public void add(Order order) {
		orderDao.add(order);
	}

	public List<Order> findAll() {
		return orderDao.findAll();
	}

	public List<Order> findByState(int state) {
		return orderDao.findByState(state);
	}

	public void updateState(String orderID, int state) {
		orderDao.updateState(orderID, state);
	}

}
