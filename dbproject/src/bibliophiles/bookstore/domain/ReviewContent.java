package bibliophiles.bookstore.domain;

import java.util.Date;

public class ReviewContent {
	private String reviewcontentID;
	private int rating;
	private String content;
	private Date reviewtime;
	public String getReviewcontentID() {
		return reviewcontentID;
	}
	public void setReviewcontentID(String reviewcontentID) {
		this.reviewcontentID = reviewcontentID;
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
	public ReviewContent(String reviewcontentID, int rating, String content,
			Date reviewtime) {
		super();
		this.reviewcontentID = reviewcontentID;
		this.rating = rating;
		this.content = content;
		this.reviewtime = reviewtime;
	}
	@Override
	public String toString() {
		return "ReviewContent [reviewcontentID=" + reviewcontentID
				+ ", rating=" + rating + ", content=" + content
				+ ", reviewtime=" + reviewtime + "]";
	}
	public ReviewContent() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
