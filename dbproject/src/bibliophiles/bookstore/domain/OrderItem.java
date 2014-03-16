package bibliophiles.bookstore.domain;

import java.util.Date;

public class OrderItem {
	private Book book;
	private Order order;
	private int count;
	private double subtotal;
	private boolean reviewed;
	private int rating;
	private String review;
	private Date reviewtime;
	
	
	public boolean isReviewed() {
		return reviewed;
	}
	public void setReviewed(boolean reviewed) {
		this.reviewed = reviewed;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public Date getReviewtime() {
		return reviewtime;
	}
	public void setReviewtime(Date reviewtime) {
		this.reviewtime = reviewtime;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	
	
	public OrderItem(Book book, Order order, int count, double subtotal,
			boolean reviewed, int rating, String review, Date reviewtime) {
		super();
		this.book = book;
		this.order = order;
		this.count = count;
		this.subtotal = subtotal;
		this.reviewed = reviewed;
		this.rating = rating;
		this.review = review;
		this.reviewtime = reviewtime;
	}
	@Override
	public String toString() {
		return "OrderItem [book=" + book + ", order=" + order + ", count="
				+ count + ", subtotal=" + subtotal + ", reviewed=" + reviewed
				+ ", rating=" + rating + ", review=" + review + ", reviewtime="
				+ reviewtime + "]";
	}
	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
