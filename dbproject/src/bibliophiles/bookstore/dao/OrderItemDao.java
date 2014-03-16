package bibliophiles.bookstore.dao;

import java.util.List;

import bibliophiles.bookstore.domain.OrderItem;

public interface OrderItemDao {
	void updateReview(String orderID, String isbn, int rating, String review);
	List<OrderItem> findByIsbn(String isbn);
	OrderItem laod(String orderID, String isbn);
}
