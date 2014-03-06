package bibliophiles.bookstore.domain;

public class Address {
	private String addrID;
	private String street;
	private String state;
	private String country;
	private String zipcode;
	public String getAddrID() {
		return addrID;
	}
	public void setAddrID(String addrID) {
		this.addrID = addrID;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	@Override
	public String toString() {
		return "Address [addrID=" + addrID + ", street=" + street + ", state="
				+ state + ", country=" + country + ", zipcode=" + zipcode + "]";
	}
	public Address(String addrID, String street, String state, String country,
			String zipcode) {
		super();
		this.addrID = addrID;
		this.street = street;
		this.state = state;
		this.country = country;
		this.zipcode = zipcode;
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
