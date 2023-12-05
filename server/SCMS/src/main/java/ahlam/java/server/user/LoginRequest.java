package ahlam.java.server.user;

public class LoginRequest {
	
    private String username;
    private String password;
    
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
    	System.out.println("password from getPassword() in LoginRequest is:"+ password);
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
