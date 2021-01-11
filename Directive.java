
public class Directive {
	private String directive;
	private int col;
	private int row;

	public Directive(String directive, int row, int col) {
		this.directive = directive.trim();
		this.col = col;
		this.row = row;
	}

	@Override
	public String toString() {
		return "[" + "row:" + row + "|" + " column:" + col + "|" + directive + "]";
	}

	public int getCol() {
		return col;
	}

	public int getRow() {
		return row;
	}

	public String getDirective() {
		return directive;
	}
}
