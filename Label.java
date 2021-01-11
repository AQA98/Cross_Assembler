
public class Label {
	
	private String label;
	private int col;
	private int row;

	public Label(String label, int row, int col) {
		this.label = label;
		this.col = col;
		this.row = row;
	}

	public String getlabel() {
		return label;
	}

	@Override
	public String toString() {
		return "[" + "label: " + label + "|" + "Row: " + row + "|" + "Column: " + col + "]";
	}

	public int getCol() {
		return col;
	}

	public int getRow() {
		return row;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
}
