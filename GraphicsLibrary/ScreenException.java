package GraphicsLibrary;

/**
 * This is a custom Exception class
 *
 */
@SuppressWarnings("serial")
class ScreenException extends Exception {
	String messageException;

	public ScreenException(String messageException) {
		this.messageException = messageException;
	}

	public String getMessage() {
		return messageException;
	}
}