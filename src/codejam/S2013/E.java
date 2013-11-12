package codejam.S2013;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Stack;

public class E {

	static final String TYPE = "E";
	static String inputFile;
	static String outputFile;

	private static void Name(String s) {
		inputFile = s + ".in";
		outputFile = s + ".out";
	}

	public static void main(String[] args) throws IOException {

		String root = "data/S2013";

		// Test
		Name("E-small-attempt0");

		Scanner in = new Scanner(new File(root, inputFile));
		PrintWriter out = new PrintWriter(new File(root, outputFile));


		File f = new File(root, inputFile);
	    FileInputStream fin = new FileInputStream(f);
	    byte[] buffer = new byte[(int) f.length()];
	    new DataInputStream(fin).readFully(buffer);
	    fin.close();
	    String ss = new String(buffer, "UTF-8");
	    

			StringBuffer input = new StringBuffer(ss);

			Stack<Integer> start = new Stack<Integer>();
			
			for(int i = 0;i<input.length()-1;i++){
				if (input.charAt(i) == '/' && input.charAt(i+1) == '*'){
					start.push(i);
					i += 2;
				}
				if (input.charAt(i) == '*' && input.charAt(i+1) == '/' && (!start.isEmpty())){
					int end = ++i;
					int s = start.pop();
					input.replace(s, end+1, "");
					i = s;
				}
			}
//			System.out.println(input);
			out.println("Case #" + 1 + ":");

			out.print(input.toString());
		

		in.close();
		out.close();

	}

}
