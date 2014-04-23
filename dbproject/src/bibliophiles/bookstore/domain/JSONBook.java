package bibliophiles.bookstore.domain;

import java.util.List;

public class JSONBook {
	private String isbn;
	private String title;
	private String cover;
	private List<String> categories;
	private String publisher;
	private List<String> authors;
	private String price;
	
	
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
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public List<String> getCategories() {
		return categories;
	}
	public void setCategories(List<String> categories) {
		this.categories = categories;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public List<String> getAuthors() {
		return authors;
	}
	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	
	
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "JSONBook [isbn=" + isbn + ", title=" + title + ", cover="
				+ cover + ", categories=" + categories + ", publisher="
				+ publisher + ", authors=" + authors + ", price=" + price + "]";
	}
	public JSONBook(String isbn, String title, String cover,
			List<String> categories, String publisher, List<String> authors,
			String price) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.cover = cover;
		this.categories = categories;
		this.publisher = publisher;
		this.authors = authors;
		this.price = price;
	}
	public JSONBook() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
