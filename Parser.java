import java.math.BigInteger;

public class Parser {

	private Token token;
	private SymbolTable symbol;
	private boolean isItAMnemonic;
	private boolean isItAnOperand;
	private boolean isItALabel;
	private boolean isItADirective;
	private String[] lineArr;
	private String mnemonicHex = "";
	private String labelName = "";

	public Parser() {
		token = Lexar.getLinkedList();
		symbol = new SymbolTable();
		checkingGrammar();
	}

	public void checkingGrammar() {
		lineArr = new String[4];
		for (int i = 0; i < token.size(); i++) {

			doesItContainAMnemonic(i);
			// doesItContainAnOperand(i);
			doesItContainALabel(i);

		}

	}

	public boolean doesItContainAMnemonic(int index) {
		isItAMnemonic = false;
		if (!(token.singleNode(index).getMne().getMnemonic().isEmpty())) { // START OF MNEMONIC IF-STATEMENT
			if (token.singleNode(index).getMne().getMnemonic().contains(".")) {
				if (symbol.immediateMnemonic.containsKey(token.singleNode(index).getMne().getMnemonic())
						|| symbol.relativeMnemonic.containsKey(token.singleNode(index).getMne().getMnemonic())) {
					isItAMnemonic = true;
					// mnemonicHex =
					// symbol.immediateToHex(token.singleNode(index).getMne().getMnemonic());

				}

			} else if (symbol.inherentMnemonic.containsKey(token.singleNode(index).getMne().getMnemonic())
					|| symbol.relativeMnemonic.containsKey(token.singleNode(index).getMne().getMnemonic())) {
				isItAMnemonic = true;

			}
		} // END OF MNEMONIC IF-STATEMENT
		if (isItAMnemonic) {
			if (symbol.immediateMnemonic.containsKey(token.singleNode(index).getMne().getMnemonic())) {
				mnemonicHex = symbol.immediateToHex(token.singleNode(index).getMne().getMnemonic());
			} else if (symbol.inherentMnemonic.containsKey(token.singleNode(index).getMne().getMnemonic())) {
				mnemonicHex = symbol.inherentToHex(token.singleNode(index).getMne().getMnemonic());
			} else {
				mnemonicHex = symbol.relativeToHex(token.singleNode(index).getMne().getMnemonic());
			}
		}

		if (isItAMnemonic) {
			ErrorReporter error = new ErrorReporter(index, 2);
			token.singleNode(index).getMne()
					.setMnemonic(token.singleNode(index).getMne().getMnemonic() + " " + error.getMessage());
		}

		return isItAMnemonic;

	}

	// Checking if the line contains operand or not
	public boolean doesItContainAnOperand(int index) {

		isItAnOperand = false;

		BigInteger notSoBig = new BigInteger("4294967295");
		BigInteger zero = new BigInteger("0");
		BigInteger notSoBig1 = new BigInteger("-2147483648");
		BigInteger notSoBig2 = new BigInteger("2147483647");
		BigInteger num = new BigInteger(token.singleNode(index).getOp().getOperand());

		if (token.singleNode(index).getOp().getOperand().isEmpty()
				&& symbol.inherentMnemonic.containsKey(token.singleNode(index).getMne().getMnemonic())) {
			return isItAnOperand = true;
		}
		// We are checking if its a label
		if (!(token.singleNode(index).getOp().getOperand().charAt(0) >= (char) 48
				&& token.singleNode(index).getOp().getOperand().charAt(0) <= (char) 57)) {
			return isItAnOperand = true;
		}

		if (token.singleNode(index).getMne().getMnemonic()
				.charAt(token.singleNode(index).getMne().getMnemonic().length() - 1) == 'i'
				&& (token.singleNode(index).getMne().getMnemonic()
						.charAt(token.singleNode(index).getMne().getMnemonic().length()) == '3')) {

			if (!(Integer.parseInt(token.singleNode(index).getOp().getOperand()) > 3
					|| Integer.parseInt(token.singleNode(index).getOp().getOperand()) < -4)) {
				return isItAnOperand = true;
			} else {

				ErrorReporter error = new ErrorReporter(index, 3);
				token.singleNode(index).getOp()
						.setOperand(token.singleNode(index).getOp().getOperand() + " " + error.getMessage());

				return isItAnOperand = false;
			}

		}

		if (token.singleNode(index).getMne().getMnemonic()
				.charAt(token.singleNode(index).getMne().getMnemonic().length() - 1) == 'u'
				&& token.singleNode(index).getMne().getMnemonic()
						.charAt(token.singleNode(index).getMne().getMnemonic().length()) == '3') {

			if (!(Integer.parseInt(token.singleNode(index).getOp().getOperand()) > 7
					|| Integer.parseInt(token.singleNode(index).getOp().getOperand()) < 0)) {

				return isItAnOperand = true;
			} else {
				ErrorReporter error = new ErrorReporter(index, 3);
				token.singleNode(index).getOp()
						.setOperand(token.singleNode(index).getOp().getOperand() + " " + error.getMessage());
				return isItAnOperand = false;
			}

		}

		if (token.singleNode(index).getMne().getMnemonic()
				.charAt(token.singleNode(index).getMne().getMnemonic().length() - 1) == 'i'
				&& token.singleNode(index).getMne().getMnemonic()
						.charAt(token.singleNode(index).getMne().getMnemonic().length()) == '4') {

			if (!(Integer.parseInt(token.singleNode(index).getOp().getOperand()) > 7
					|| Integer.parseInt(token.singleNode(index).getOp().getOperand()) < -8)) {
				return isItAnOperand = true;
			} else {
				ErrorReporter error = new ErrorReporter(index, 3);
				token.singleNode(index).getOp()
						.setOperand(token.singleNode(index).getOp().getOperand() + " " + error.getMessage());
				return isItAnOperand = false;
			}

		}

		if (token.singleNode(index).getMne().getMnemonic()
				.charAt(token.singleNode(index).getMne().getMnemonic().length() - 1) == 'u'
				&& token.singleNode(index).getMne().getMnemonic()
						.charAt(token.singleNode(index).getMne().getMnemonic().length()) == '4') {

			if (!(Integer.parseInt(token.singleNode(index).getOp().getOperand()) > 15
					|| Integer.parseInt(token.singleNode(index).getOp().getOperand()) < 0)) {
				return isItAnOperand = true;
			} else {
				ErrorReporter error = new ErrorReporter(index, 3);
				token.singleNode(index).getOp()
						.setOperand(token.singleNode(index).getOp().getOperand() + " " + error.getMessage());
				return isItAnOperand = false;
			}
		}

		if (token.singleNode(index).getMne().getMnemonic()
				.charAt(token.singleNode(index).getMne().getMnemonic().length() - 1) == 'i'
				&& token.singleNode(index).getMne().getMnemonic()
						.charAt(token.singleNode(index).getMne().getMnemonic().length()) == '5') {

			if (!(Integer.parseInt(token.singleNode(index).getOp().getOperand()) > 15
					|| Integer.parseInt(token.singleNode(index).getOp().getOperand()) < -16)) {
				return isItAnOperand = true;
			} else {
				ErrorReporter error = new ErrorReporter(index, 3);
				token.singleNode(index).getOp()
						.setOperand(token.singleNode(index).getOp().getOperand() + " " + error.getMessage());
				return isItAnOperand = false;
			}
		}

		if (token.singleNode(index).getMne().getMnemonic()
				.charAt(token.singleNode(index).getMne().getMnemonic().length() - 1) == 'u'
				&& token.singleNode(index).getMne().getMnemonic()
						.charAt(token.singleNode(index).getMne().getMnemonic().length()) == '5') {

			if (!(Integer.parseInt(token.singleNode(index).getOp().getOperand()) > 31
					|| Integer.parseInt(token.singleNode(index).getOp().getOperand()) < 0)) {
				return isItAnOperand = true;
			} else {
				ErrorReporter error = new ErrorReporter(index, 3);
				token.singleNode(index).getOp()
						.setOperand(token.singleNode(index).getOp().getOperand() + " " + error.getMessage());
				return isItAnOperand = false;
			}
		}
		if (token.singleNode(index).getMne().getMnemonic()
				.charAt(token.singleNode(index).getMne().getMnemonic().length() - 1) == 'i'
				&& token.singleNode(index).getMne().getMnemonic()
						.charAt(token.singleNode(index).getMne().getMnemonic().length()) == '8') {

			if (!(Integer.parseInt(token.singleNode(index).getOp().getOperand()) > 127
					|| Integer.parseInt(token.singleNode(index).getOp().getOperand()) < -128)) {
				return isItAnOperand = true;
			} else {
				ErrorReporter error = new ErrorReporter(index, 3);
				token.singleNode(index).getOp()
						.setOperand(token.singleNode(index).getOp().getOperand() + " " + error.getMessage());
				return isItAnOperand = false;
			}
		}

		if (token.singleNode(index).getMne().getMnemonic()
				.charAt(token.singleNode(index).getMne().getMnemonic().length() - 1) == 'u'
				&& token.singleNode(index).getMne().getMnemonic()
						.charAt(token.singleNode(index).getMne().getMnemonic().length()) == '8') {

			if (!(Integer.parseInt(token.singleNode(index).getOp().getOperand()) > 255
					|| Integer.parseInt(token.singleNode(index).getOp().getOperand()) < 0)) {
				return isItAnOperand = true;
			} else {
				ErrorReporter error = new ErrorReporter(index, 3);
				token.singleNode(index).getOp()
						.setOperand(token.singleNode(index).getOp().getOperand() + " " + error.getMessage());
				return isItAnOperand = false;
			}

		}
		if (token.singleNode(index).getMne().getMnemonic()
				.charAt(token.singleNode(index).getMne().getMnemonic().length() - 2) == 'i'
				&& token.singleNode(index).getMne().getMnemonic()
						.charAt(token.singleNode(index).getMne().getMnemonic().length() - 1) == '1'
				&& token.singleNode(index).getMne().getMnemonic()
						.charAt(token.singleNode(index).getMne().getMnemonic().length()) == '6') {

			if (!(Integer.parseInt(token.singleNode(index).getOp().getOperand()) > 32767
					|| Integer.parseInt(token.singleNode(index).getOp().getOperand()) < -32768)) {
				return isItAnOperand = true;
			} else {
				ErrorReporter error = new ErrorReporter(index, 3);
				token.singleNode(index).getOp()
						.setOperand(token.singleNode(index).getOp().getOperand() + " " + error.getMessage());
				return isItAnOperand = false;
			}

		}

		if (token.singleNode(index).getMne().getMnemonic()
				.charAt(token.singleNode(index).getMne().getMnemonic().length() - 2) == 'u'
				&& token.singleNode(index).getMne().getMnemonic()
						.charAt(token.singleNode(index).getMne().getMnemonic().length() - 1) == '1'
				&& token.singleNode(index).getMne().getMnemonic()
						.charAt(token.singleNode(index).getMne().getMnemonic().length()) == '6') {

			if (!(Integer.parseInt(token.singleNode(index).getOp().getOperand()) > 65535
					|| Integer.parseInt(token.singleNode(index).getOp().getOperand()) < 0)) {
				return isItAnOperand = true;
			} else {
				ErrorReporter error = new ErrorReporter(index, 3);
				token.singleNode(index).getOp()
						.setOperand(token.singleNode(index).getOp().getOperand() + " " + error.getMessage());
				return isItAnOperand = false;
			}

		}

		if (token.singleNode(index).getMne().getMnemonic()
				.charAt(token.singleNode(index).getMne().getMnemonic().length() - 2) == 'i'
				&& token.singleNode(index).getMne().getMnemonic()
						.charAt(token.singleNode(index).getMne().getMnemonic().length() - 1) == '3'
				&& token.singleNode(index).getMne().getMnemonic()
						.charAt(token.singleNode(index).getMne().getMnemonic().length()) == '2') {

			if (!((num.compareTo(notSoBig2)) >= 0 || (notSoBig1.compareTo(num) >= 0))) {
				return isItAnOperand = true;
			} else {
				ErrorReporter error = new ErrorReporter(index, 3);
				token.singleNode(index).getOp()
						.setOperand(token.singleNode(index).getOp().getOperand() + " " + error.getMessage());
				return isItAnOperand = false;
			}
		}

		if (token.singleNode(index).getMne().getMnemonic()
				.charAt(token.singleNode(index).getMne().getMnemonic().length() - 2) == 'u'
				&& token.singleNode(index).getMne().getMnemonic()
						.charAt(token.singleNode(index).getMne().getMnemonic().length() - 1) == '3'
				&& token.singleNode(index).getMne().getMnemonic()
						.charAt(token.singleNode(index).getMne().getMnemonic().length()) == '2') {

			if (!((num.compareTo(notSoBig)) >= 0 || (zero.compareTo(num) >= 0))) {
				return isItAnOperand = true;
			} else {
				ErrorReporter error = new ErrorReporter(index, 3);
				token.singleNode(index).getOp()
						.setOperand(token.singleNode(index).getOp().getOperand() + " " + error.getMessage());
				return isItAnOperand = false;
			}
		}
		ErrorReporter error = new ErrorReporter(index, 3);
		token.singleNode(index).getOp()
				.setOperand(token.singleNode(index).getOp().getOperand() + " " + error.getMessage());
		return isItAnOperand = false;

	}

	public boolean doesItContainALabel(int index) {
		isItALabel = false;
		if ((symbol.immediateMnemonic.containsKey(token.singleNode(index).getLab().getlabel())
				|| symbol.relativeMnemonic.containsKey(token.singleNode(index).getLab().getlabel()))
				|| symbol.inherentMnemonic.containsKey(token.singleNode(index).getLab().getlabel())) {
			return isItALabel;
		}
		if ((token.singleNode(index).getLab().getlabel().isEmpty())) {
			labelName = token.singleNode(index).getLab().getlabel();
			return isItALabel = true;
		} else {

			if (token.singleNode(index).getLab().getlabel().charAt(0) >= (char) 48
					&& token.singleNode(index).getLab().getlabel().charAt(0) <= (char) 57) {

				ErrorReporter error = new ErrorReporter(index, 1);
				token.singleNode(index).getLab()
						.setLabel(token.singleNode(index).getLab().getlabel() + " " + error.getMessage());

				return isItALabel = false;
			}
			labelName = token.singleNode(index).getLab().getlabel();
			return isItALabel = true;
		}

	}

	public boolean doesItContainADirective(int index) {

		if (token.singleNode(index).getDir().getDirective().contains("\\")) {
			return isItADirective = false;
		} else {
			return isItADirective = true;
		}

	}

	public Token getTokenLinkedList() {
		return token;
	}

}
