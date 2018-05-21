package gui;

public class GraphicsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Constructs a GraphicsException with the given detail message.
     * @param message The detail message of the GraphicsException.
     */
    public GraphicsException(String message) {
        super(message);
    }

    /**
     * Constructs a GraphicsException with the given root cause.
     * @param cause The root cause of the GraphicsException.
     */
    public GraphicsException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a GraphicsException with the given detail message and root cause.
     * @param message The detail message of the GraphicsException.
     * @param cause The root cause of the GraphicsException.
     */
    public GraphicsException(String message, Throwable cause) {
        super(message, cause);
    }
}
