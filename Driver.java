
import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Driver {

	public static void main(String[] args) {
		
		
		File srcFile = new File("trash.txt");
		Lexar lex = new Lexar(srcFile);
		 
		ExecutableFileCreator executableFileCreator = new ExecutableFileCreator("lst");
		
	}

}
