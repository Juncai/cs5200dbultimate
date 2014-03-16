package bibliophiles.bookstore.domain;

import java.util.Date;

public class Review {
	private String isbn;
	private String orderID;
	private int rating;
	private String content;
	private Date reviewtime;

	
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getReviewtime() {
		return reviewtime;
	}
	public void setReviewtime(Date reviewtime) {
		this.reviewtime = reviewtime;
	}

	

	public Review(int rating, String content, Date reviewtime, String isbn,
			String orderID) {
		super();
		this.rating = rating;
		this.content = content;
		this.reviewtime = reviewtime;
		this.isbn = isbn;
		this.orderID = orderID;
	}
	@Override
	public String toString() {
		return "Review [rating=" + rating + ", content=" + content
				+ ", reviewtime=" + reviewtime + ", isbn=" + isbn
				+ ", orderID=" + orderID + "]";
	}
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
