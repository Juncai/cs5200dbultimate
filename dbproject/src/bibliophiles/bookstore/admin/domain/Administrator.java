package bibliophiles.bookstore.admin.domain;

public class Administrator {
	private String adminID;
	private String username;
	private String password;
	private int grade;
	public String getAdminID() {
		return adminID;
	}
	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "Administrator [adminID=" + adminID + ", username=" + username
				+ ", password=" + password + ", grade=" + grade + "]";
	}
	public Administrator(String adminID, String username, String password,
			int grade) {
		super();
		this.adminID = adminID;
		this.username = username;
		this.password = password;
		this.grade = grade;
	}
	public Administrator() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
