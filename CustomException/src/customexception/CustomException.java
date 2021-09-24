package customexception;

public class CustomException extends Exception {

	private static final long serialVersionUID = 1L;

	private int result = 0;

	public CustomException() {
		super();
	}

	public CustomException(String message, int result) {
		super(message);
		this.result = result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public int getResult() {
		return result;
	}
}
