package bibliophiles.bookstore.domain;

public class Author {
	private String authorID;
	private String lastname;
	private String firstname;
	private String middlename;
	public String getAuthorID() {
		return authorID;
	}
	public void setAuthorID(String authorID) {
		this.authorID = authorID;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getMiddlename() {
		return middlename;
	}
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}
	@Override
	public String toString() {
		return "Author [authorID=" + authorID + ", lastname=" + lastname
				+ ", firstname=" + firstname + ", middlename=" + middlename
				+ "]";
	}
	public Author(String authorID, String lastname, String firstname,
			String middlename) {
		super();
		this.authorID = authorID;
		this.lastname = lastname;
		this.firstname = firstname;
		this.middlename = middlename;
	}
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
