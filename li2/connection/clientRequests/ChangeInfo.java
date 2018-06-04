package connection.clientRequests;

import users.User;

public class ChangeInfo extends ClientRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ChangeInfo( User user) {
		super(19, user);
	}

}
