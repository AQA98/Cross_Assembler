public class ErrorReporter {
	private int row;
	private int col;
	private String message;

	public ErrorReporter(int row, int col) {

		this.row = row;
		this.col = col;
		this.message = "There is an Error at this row " + this.row +" and at this column "+this.col;

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
