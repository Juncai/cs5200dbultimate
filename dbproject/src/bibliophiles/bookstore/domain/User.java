package bibliophiles.bookstore.domain;

public class User {
	private String userID;
	private String email;
	private String password;
	private String lastname;
	private String firstname;
	private String middlename;
	private String gender;
	private String cellphone;
	private String code;
	private boolean state;
	
	private Creditcard creditcard;

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public Creditcard getCreditcard() {
		return creditcard;
	}

	public void setCreditcard(Creditcard creditcard) {
		this.creditcard = creditcard;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", email=" + email + ", password="
				+ password + ", lastname=" + lastname + ", firstname="
				+ firstname + ", middlename=" + middlename + ", gender="
				+ gender + ", cellphone=" + cellphone + ", code=" + code
				+ ", state=" + state + ", creditcard=" + creditcard + "]";
	}

	public User(String userID, String email, String password, String lastname,
			String firstname, String middlename, String gender,
			String cellphone, String code, boolean state, Creditcard creditcard) {
		super();
		this.userID = userID;
		this.email = email;
		this.password = password;
		this.lastname = lastname;
		this.firstname = firstname;
		this.middlename = middlename;
		this.gender = gender;
		this.cellphone = cellphone;
		this.code = code;
		this.state = state;
		this.creditcard = creditcard;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
