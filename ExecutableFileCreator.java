import java.io.FileWriter; // Import the FileWriter class
import java.io.IOException; // Import the IOException class to handle errors
import java.util.*;

import org.w3c.dom.ls.LSException;

public class ExecutableFileCreator {
	private Token token;
	
	
	
	
	
	public ExecutableFileCreator(String fileExtension) {
		Parser parser = new Parser();
		this.token = parser.getTokenLinkedList();
		fileMaker(fileExtension);
	
	}	
	public void fileMaker(String fileExtension) {
		
		
		
		try {
			String fileNameString = Lexar.getFileName().replace("txt", fileExtension);
			FileWriter myWriter = new FileWriter(fileNameString);

			if (fileExtension.equals("lst")) {
				myWriter.write("Line	Addr Machine Code   Label		Assembly code     Comment\n");
				for (int i = 0; i < token.size(); i++) {
					
					
					
					if(!token.singleNode(i).getMne().getMnemonic().isEmpty() ) {
						myWriter.write( " " +(i + 1 ) + " 00"
								+ Integer.toHexString(i)
								);
					}
					
					else {
						myWriter.write( " " +(i + 1 ) + " 00"
								+ Integer.toHexString(i+1)
								);
					}
					 	
					
					
					if (!token.singleNode(i).getMne().getMnemonic().isEmpty()) {
						myWriter.write("\t  "+SymbolTable.immediateToHex(token.singleNode(i).getMne().getMnemonic())+"\t");
					}
					else {
						
						myWriter.write("\t");
					}
							
					myWriter.write(""+token.singleNode(i).getLab().getlabel().trim()+"\t"
							+ token.singleNode(i).getMne().getMnemonic().trim()+"\t"+
							token.singleNode(i).getOp().getOperand()+ "\t")	;
					if(!token.singleNode(i).getComment().getComment().isEmpty()) {
						myWriter.write(";"+token.singleNode(i).getComment().getComment().trim()+ "\n");
					}
					else {
						myWriter.write("\n");
					}
							
						
				}

				myWriter.close();
				System.out.println("Successfully wrote to the file.");

			} else {

				for (int i = 0; i < token.size(); i++) {
					System.out.println(token.singleNode(i).getMne().getMnemonic());
					myWriter.write(SymbolTable.binary(token.singleNode(i).getMne().getMnemonic()));
					
				}
				myWriter.close();
				System.out.println("Successfully wrote to the file.");
			}

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}
