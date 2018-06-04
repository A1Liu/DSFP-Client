package connection.clientRequests;

import users.User;

public class LoginNewUser extends ClientRequest {

	private static final long serialVersionUID = 1L;

	public LoginNewUser(User user, String password) {
		this(user.getUsername(), user.getEmail(), user.getName(), password);
	}
	
	public LoginNewUser(String username, String email, String name, String password) {
		super(3,username, email, name, password);
	}

}
