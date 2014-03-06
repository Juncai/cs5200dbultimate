package bibliophiles.bookstore.domain;

public class Creditcard {
	private String cardnumber;
	private String holderlastname;
	private String holderfirstname;
	private Address holderaddr;
	public String getCardnumber() {
		return cardnumber;
	}
	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}
	public String getHolderlastname() {
		return holderlastname;
	}
	public void setHolderlastname(String holderlastname) {
		this.holderlastname = holderlastname;
	}
	public String getHolderfirstname() {
		return holderfirstname;
	}
	public void setHolderfirstname(String holderfirstname) {
		this.holderfirstname = holderfirstname;
	}
	public Address getHolderaddr() {
		return holderaddr;
	}
	public void setHolderaddr(Address holderaddr) {
		this.holderaddr = holderaddr;
	}
	@Override
	public String toString() {
		return "Creditcard [cardnumber=" + cardnumber + ", holderlastname="
				+ holderlastname + ", holderfirstname=" + holderfirstname
				+ ", holderaddr=" + holderaddr + "]";
	}
	public Creditcard(String cardnumber, String holderlastname,
			String holderfirstname, Address holderaddr) {
		super();
		this.cardnumber = cardnumber;
		this.holderlastname = holderlastname;
		this.holderfirstname = holderfirstname;
		this.holderaddr = holderaddr;
	}
	public Creditcard() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
