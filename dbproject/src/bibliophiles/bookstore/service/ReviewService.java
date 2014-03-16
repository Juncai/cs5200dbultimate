package bibliophiles.bookstore.service;

import java.util.List;

import bibliophiles.bookstore.domain.Review;

public interface ReviewService {
	List<Review> findByOrderID(String orderID);
	List<Review> findByISBN(String isbn);
	
}
