package bibliophiles.bookstore.dao;

import java.util.List;

import bibliophiles.bookstore.domain.Order;

public interface OrderDao {
	public void updateState(String orderID, int state);
	public List<Order> findAll();
	public List<Order> findByState(int state);
	public Order findByOrderID(String orderID);
	public List<Order> findByUserID(String userID);
	public void add(Order order);
	
	
}
