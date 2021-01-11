public class Comment {

	private String comment;
	private int col;
	private int row;

	public Comment(String comment, int row, int col) {
		this.comment = comment.trim();
		this.col = col;
		this.row = row;
	}

	@Override
	public String toString() {
		return "[" + "row:" + row + "|" + " column:" + col + "|" + comment + "]";
	}

	public int getCol() {
		return col;
	}

	public int getRow() {
		return row;
	}

	public String getComment() {
		return comment;
	}

}
