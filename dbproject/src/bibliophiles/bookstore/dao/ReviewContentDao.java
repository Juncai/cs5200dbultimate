package bibliophiles.bookstore.dao;

import java.util.List;

import bibliophiles.bookstore.domain.ReviewContent;

public interface ReviewContentDao {
	public void add(ReviewContent reviewContent);
	public void update(ReviewContent reviewContent);
	public void del(String reviewcontentID);
	public ReviewContent findByReviewContentID(String reviewcontentID);
	public List<ReviewContent> findByBookISBN(String isbn);
	public List<ReviewContent> findByOrderID(String orderID);
}
