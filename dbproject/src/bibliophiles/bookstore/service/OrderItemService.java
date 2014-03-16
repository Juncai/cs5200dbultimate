package bibliophiles.bookstore.service;

import java.util.List;

import bibliophiles.bookstore.domain.OrderItem;

public interface OrderItemService {
	void updateReview(String orderID, String isbn, int rating, String review);
	List<OrderItem> findByIsbn(String isbn);
	OrderItem load(String orderID, String isbn);
}
