
import java.util.HashMap;

public class Mnemonics {
	private HashMap<String, String> binary = new HashMap<String, String>();
	private HashMap<String, String> hexInherent = new HashMap<String, String>();
	private String mnemonic;
	private int row;
	private int col;

	public Mnemonics(int row, int col, String mnemonic) {
		this.mnemonic = mnemonic.trim();
		this.col = col;
		this.row = row;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}
	
	public String getMnemonic() {
		return mnemonic;
	}

	@Override
	public String toString() {

		return "[" + "row:" + row + "|" + " column:" + col + "|" + mnemonic + "]";

	}
	
	public void setMnemonic(String mnemonic) {
		this.mnemonic = mnemonic;
	}



}
