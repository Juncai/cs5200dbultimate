package bibliophiles.bookstore.domain;

public class Publisher {
	private String publisherID;
	private String name;
	public String getPublisherID() {
		return publisherID;
	}
	public void setPublisherID(String publisherID) {
		this.publisherID = publisherID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Publisher [publisherID=" + publisherID + ", name=" + name + "]";
	}
	public Publisher(String publisherID, String name) {
		super();
		this.publisherID = publisherID;
		this.name = name;
	}
	public Publisher() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
