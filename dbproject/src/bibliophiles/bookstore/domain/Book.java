package bibliophiles.bookstore.domain;

public class Book {
	private String isbn;
	private String title;
	private double price;
	private String cover;
	private double rating;
	private String category;
	private boolean isdel;
	private boolean reserved;
	
	private Publisher publisher;

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}



	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public boolean isIsdel() {
		return isdel;
	}

	public void setIsdel(boolean isdel) {
		this.isdel = isdel;
	}

	public boolean isReserved() {
		return reserved;
	}

	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}



	public Book(String isbn, String title, double price, String cover,
			double rating, String category, boolean isdel, boolean reserved,
			Publisher publisher) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.price = price;
		this.cover = cover;
		this.rating = rating;
		this.category = category;
		this.isdel = isdel;
		this.reserved = reserved;
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", price=" + price
				+ ", cover=" + cover + ", rating=" + rating + ", category="
				+ category + ", isdel=" + isdel + ", reserved=" + reserved
				+ ", publisher=" + publisher + "]";
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
