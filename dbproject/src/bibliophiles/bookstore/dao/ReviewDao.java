package bibliophiles.bookstore.dao;

import java.util.List;

import bibliophiles.bookstore.domain.Review;

public interface ReviewDao {
	public void add(Review review);
	public void update(Review review);
	public void del(String orderID, String isbn);
	public List<Review> findByISBN(String isbn);
	public List<Review> findByOrderID(String orderID);
	public Review verify(String orderID, String isbn);
}
