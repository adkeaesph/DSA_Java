package customexceptions;

public class EmptyStackException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3163354092089851305L;

	public EmptyStackException(String message) {
		super(message);
	}
}
