package connection.clientRequests;

/**
 * Login request. Tag is 0.
 * @author aliu
 *
 */
public class LoginExistUser extends ClientRequest {

	private static final long serialVersionUID = 1L;

	public LoginExistUser(String username, String password) {
		super(0, username, password);
		// 
	}
	
	public LoginExistUser(Long sessionID) {
		super(0, sessionID);
		// 
	}

}
