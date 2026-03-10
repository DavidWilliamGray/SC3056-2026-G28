package model;

public class User {
	private String username; //email address
	private String password;
	private String first_name;
    private String last_name;
    private String mobile_number;
    
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
		/* TODO 4 - Intentional insertion of defect in getter
		return username;
		*/
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getMobile_number() {
		return mobile_number;
	}
	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
		/* TODO 4 - Intentional insertion of defect in setter
		this.mobile_number = this.username;
		*/
	}
	public User(String username, String password, String first_name, String last_name, String mobile_number) {
		super();
		this.username = username;
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.mobile_number = mobile_number;
		/* TODO 4 - Intentional insertion of defect in user constructor
		this.last_name = mobile_number;
		this.mobile_number = last_name;
		*/
	}
	/* TODO 4 - Intentionally wrong comparison for replication (== compares references)
	public User(String username, String password, String first_name, String last_name, String mobile_number) {
	    super();

	    // Force new String objects (same text, different references)
	    this.username = new String(username);
	    this.password = new String(password);
	    this.first_name = new String(first_name);
	    this.last_name = new String(last_name);
	    this.mobile_number = new String(mobile_number);
	}
	*/
	/*public String toString() {
		return username + ", " + password + ", " + first_name + ", " + last_name + ", " + mobile_number;
	}*/
	// Improvement so that elements print in line with header elements when using SimpleBankingApp.java
	public String toString() {
		return String.format("%-25s| %-15s| %-15s| %-15s| %-15s",
				username, password, first_name, last_name, mobile_number);
	}
}
