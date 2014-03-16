package bibliophiles.bookstore.service.impl;

import java.util.List;

import bibliophiles.bookstore.dao.OrderItemDao;
import bibliophiles.bookstore.dao.impl.OrderItemDaoImpl;
import bibliophiles.bookstore.domain.OrderItem;
import bibliophiles.bookstore.service.OrderItemService;

public class OrderItemServiceImpl implements OrderItemService {
	private OrderItemDao orderItemDao = new OrderItemDaoImpl();
	public void updateReview(String orderID, String isbn, int rating,
			String review) {
		orderItemDao.updateReview(orderID, isbn, rating, review);
	}

	public List<OrderItem> findByIsbn(String isbn) {
		return orderItemDao.findByIsbn(isbn);
	}

	public OrderItem load(String orderID, String isbn) {
		return orderItemDao.laod(orderID, isbn);
	}

}
