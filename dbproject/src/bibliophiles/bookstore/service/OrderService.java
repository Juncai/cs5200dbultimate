package bibliophiles.bookstore.service;

import java.util.List;

import bibliophiles.bookstore.domain.Order;

public interface OrderService {
	Order findByOrderID(String orderID);
	List<Order> findByUserID(String userID);
	void add(Order order);
	List<Order> findAll();
	List<Order> findByState(int state);
	void updateState(String orderID, int state);
}
