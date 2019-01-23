package exception;

public class BankAccountException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public BankAccountException(String message) {
		super();
		this.message = message;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
