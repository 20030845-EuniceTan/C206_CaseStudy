/*
 * I declare that this code was written by me. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Jeslynn Koh
 * Student ID: 20047778
 * Class: E37C
 * Date/Time created: Tuesday 03-08-2021 21:41
 */

public class UserAccount {
	private String name;
	private String role;
	private String email;
	private String password;
	
	public UserAccount(String name, String role, String email, String password) {
		super();
		this.name = name;
		this.role = role;
		this.email = email;
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
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


}