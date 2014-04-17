package bibliophiles.bookstore.dao;

import java.util.List;

import bibliophiles.bookstore.domain.OrderItem;
/**
 * 
 * This is the Data Access Object for creating,
 *  referring, updating and deleting the item
 *  in the order 
 *
 * @author Team Bibliophiles
 * 
 */
public interface OrderItemDao {
	
	/**
	 * This method is to update the review of a certain
	 * order and a certain book with a rating(1-5) and
	 * a review(comment)
	 * 
	 * @param orderID
	 * @param isbn
	 * @param rating
	 * ta
	 * @param review
	 * 
	 * @throws SQLException if there is an exception 
	 * that provides information on a database access
	 * error or other errors.
	 */	
	void updateReview(String orderID, String isbn, int rating, String review);
	
	/**
	 * This method is to look up all the orderItem of 
	 * a certain book
	 * 
	 * @return all the orderitems of a certain book
	 * 
	 * @throws SQLException if there is an exception 
	 * that provides information on a database access
	 * error or other errors.
	 */
	List<OrderItem> findByIsbn(String isbn);
	
	/**
	 * This method is to look up a certain order item
	 * of a certain orderID and a certain book
	 * in the database
	 * 
	 * @return a certain orderitem with a certain orderID
	 * and book ISBN
	 * 
	 * @throws SQLException if there is an exception 
	 * that provides information on a database access
	 * error or other errors.
	 */
	OrderItem load(String orderID, String isbn);
}
