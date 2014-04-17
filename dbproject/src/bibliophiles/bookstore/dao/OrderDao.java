package bibliophiles.bookstore.dao;

import java.util.List;

import bibliophiles.bookstore.domain.Order;

/**
 * 
 * This is the Data Access Object for creating,
 *  referring, updating and deleting the order 
 *
 * @author Team Bibliophiles
 * 
 */
public interface OrderDao {
	/**
	 * This method is to update the state of an existed
	 * order
	 * 
	 * @param orderID 
	 * the ID of an existed order
	 * 
	 * @param state
	 * There are 4 states of an order in this project:
	 * <br/>1. Order Placed
	 * <br/>2. Order Paid
	 * <br/>3. Order Sent
	 * <br/>4. Order Received
	 * 
	 * @throws SQLException if there is an exception 
	 * that provides information on a database access
	 * error or other errors.
	 */	
	public void updateState(String orderID, int state);
	
	/**
	 * This method is to look up all the orders
	 * in the database
	 * 
	 * @return all the orders in the database
	 * 
	 * @throws SQLException if there is an exception 
	 * that provides information on a database access
	 * error or other errors.
	 */
	public List<Order> findAll();
	
	/**
	 * This method is to look up all the orders
	 * in an certain state
	 * 
	 * @param state
	 * There are 4 states of an order in this project:
	 * <br/>1. Order Placed
	 * <br/>2. Order Paid
	 * <br/>3. Order Sent
	 * <br/>4. Order Received
	 * 
	 * @return all the orders in a certain state
	 */
	public List<Order> findByState(int state);
	
	
	/**
	 * This method is to find a certain order
	 * by its ID
	 * 
	 * @param orderID 
	 * 
	 * @return the order with a certain ID
	 * 
	 * @throws SQLException if there is an exception 
	 * that provides information on a database access
	 * error or other errors.
	 */	
	public Order findByOrderID(String orderID);
	
	/**
	 * This method is to find all the orders placed 
	 * by the same user
	 * 
	 * @param userID 
	 * 
	 * @return the category with a certain user
	 * 
	 * @throws SQLException if there is an exception 
	 * that provides information on a database access
	 * error or other errors.
	 */	
	public List<Order> findByUserID(String userID);
	
	/**
	 * This method is to add a new order
	 * 
	 * @param order 
	 * 
	 * @throws SQLException if there is an exception 
	 * that provides information on a database access
	 * error or other errors.
	 */	
	public void add(Order order);
	
	
}
