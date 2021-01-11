


public class Operand {
	
	private String operand;
	private int col;
	private int row;

	public Operand(String operand, int row, int col) {
		this.operand = operand;
		this.col = col;
		this.row = row;
	}

	public String getOperand() {
		return operand;
	}

	@Override
	public String toString() {
		return "[" + "opber: " + operand + "|" + "Row: " + row + "|" + "Column: " + col + "]";
	}

	public int getCol() {
		return col;
	}

	public int getRow() {
		return row;
	}
	public void setOperand(String operand) {
		this.operand = operand;
	}
	
}
