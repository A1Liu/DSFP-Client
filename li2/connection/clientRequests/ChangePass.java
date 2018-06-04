package connection.clientRequests;

public class ChangePass extends ClientRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ChangePass(String oldPass, String newPass) {
		super(14, oldPass, newPass);
	}

}
