import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;

public class Lexar {
	private static File srcFile = null;
	private static FileInputStream is;
	public int EOF = -1;
	int col = 0;
	int row = 1;
	ArrayList<String> LineArrayList;
	ArrayList<String> lineStatement;
	int index;
	private String comment = "";
	private String label = "";
	private String mnemonics = "";
	private String operands = "";
	private String directive = "";
	private boolean isDoubleSpace = true;
	private static Token token = new Token();

	public Lexar() {

	}

	public Lexar(File srcfile) {
		this.srcFile = srcfile;
		try {
			this.is = new FileInputStream(srcFile);
			read();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block

			System.out.println("File Not Found Exception");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IO Exception");
		}

	}

	public void read() throws IOException {
		int c = 0;
		int line = 0;

		LineArrayList = new ArrayList<String>();
		int LineNumber = 0;
		while ((c = is.read()) != EOF) {
			if (!(c == '\n')) {
				String charline = (char) c + "";
				LineArrayList.add(charline);
			}
			if ((c == '\r')) {
				getComment();	
				LineStatement();	
				token.addAtEnd(new Mnemonics(-1, -1, mnemonics), new Operand(operands, -1, -1),
						new Label(label, -1, -1), new Comment(comment, -1, -1), new Directive(directive, -1, -1));
				LineArrayList = null;

				LineArrayList = new ArrayList<String>();

				comment = "";
				label = "";
				mnemonics = "";
				operands = "";
				directive = "";
				col = 1;
			}
		}
		if (c == EOF) {
			LineArrayList.trimToSize();
			LineStatement();
			getComment();
			token.addAtEnd(new Mnemonics(-1, -1, mnemonics), new Operand(operands, -1, -1), new Label(label, -1, -1),
					new Comment(comment, -1, -1),new Directive(directive, -1, -1));
		}
		token.showListContents();


	}

	public void LineStatement() {
		String l = "";
		lineStatement = new ArrayList<String>();
		for (int i = 0; i < LineArrayList.size(); i++) {
			l = l + LineArrayList.get(i);
		}
		lineStatement.add(0, l);
		
		getLabel();
		getMnemonics();
		getOperand();
		
	
	}



	public void getComment() {
		boolean containSemicolon = false;
		for (int i = 0; i < LineArrayList.size(); i++) {
			if (LineArrayList.get(i).contentEquals(";")) {
				containSemicolon = true;
				break;
			}
		}
		if (!containSemicolon) {
			return;
		}

		for (int i = LineArrayList.indexOf(";") + 1; i < LineArrayList.size()-1;i++) {
			comment += LineArrayList.get(i);
		}

	

	}

	public void getLabel() {
			if ((lineStatement.get(0).charAt(0)==' ' || lineStatement.get(0).charAt(0)=='\t') ) {
				lineStatement.set(0,lineStatement.get(0).trim() );
				
				return;
			}	
			else {
				
				for ( int i = 0 ;i<lineStatement.get(0).indexOf(';');i++) {
					if (lineStatement.get(0).charAt(i)!= ' ') {
					label += ""+ lineStatement.get(0).charAt(i);
					}
					else {
						lineStatement.set(0,lineStatement.get(0).replace(label, " ") );
						lineStatement.set(0,lineStatement.get(0).trim() );
						
						return;
					}
				}
				
				
			}	
	}

	public void getMnemonics() {
	
		for ( int i = 0 ;i<lineStatement.get(0).indexOf(';');i++) {
			if (lineStatement.get(0).charAt(i)!= ' ') {
			mnemonics += ""+ lineStatement.get(0).charAt(i);
			}
			else {
				lineStatement.set(0,lineStatement.get(0).replace(mnemonics, " ") );
				lineStatement.set(0,lineStatement.get(0).trim() );
				return;
			}
		}
	}

	public void getOperand() {
		for ( int i = 0 ;i<lineStatement.get(0).indexOf(';');i++) {
			if (lineStatement.get(0).charAt(i)!= ' ') {
			operands += ""+ lineStatement.get(0).charAt(i);
			}
			else {
				lineStatement.set(0,lineStatement.get(0).replace(operands, " ") );
				lineStatement.set(0,lineStatement.get(0).trim() );
				
				return;
			}
		}
		

	}

	public static String getFileName() {
		return srcFile.getName();
	}

	public static Token getLinkedList() {
		return token;
	}
}
