package bibliophiles.bookstore.domain;

public class Category {
	private String categoryID;
	private String categoryname;
	public String getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(String categoryID) {
		this.categoryID = categoryID;
	}
	
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	@Override
	public String toString() {
		return "Category [categoryID=" + categoryID + ", categoryname=" + categoryname
				+ "]";
	}
	public Category(String categoryID, String category) {
		super();
		this.categoryID = categoryID;
		this.categoryname = category;
	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
