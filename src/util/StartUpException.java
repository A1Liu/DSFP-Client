package util;

public class StartUpException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructs a start up exception with a given message
	 * @param message
	 */
    public StartUpException(String message) {
        super(message);
    }

    /**
     * constructs a start up exception with a given root cause
     * @param cause
     */
    public StartUpException(Throwable cause) {
        super(cause);
    }

    /**
     * constructs a start up exception with a given message and root cause
     * @param message
     * @param cause
     */
    public StartUpException(String message, Throwable cause) {
        super(message, cause);
    }

}
