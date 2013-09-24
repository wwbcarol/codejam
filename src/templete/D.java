package templete;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class D {
	
	static final String TYPE = "E";
	static String inputFile;
	static String outputFile;

	private static void Name(String s){
		inputFile = s + ".in";
		outputFile = s + ".out";
	}
	public static void main(String[] args) throws FileNotFoundException {
		
		String root = "data/F2013";
		
		// Test
		Name(TYPE+"-test");
		
		Scanner in = new Scanner(new File(root, inputFile));
		PrintWriter out = new PrintWriter(new File(root, outputFile));
		
		int T = in.nextInt();
		
		for(int i=0;i<T;i++){
			
			out.print("Case #"+(i+1)+": ");
			
			
			
			
		}
		
		in.close();
		out.close();

	}

}
