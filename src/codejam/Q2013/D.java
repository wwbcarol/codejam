package codejam.Q2013;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class D {
	
	static final String TYPE = "D";
	static String inputFile;
	static String outputFile;

	private static void Name(String s){
		inputFile = s + ".in";
		outputFile = s + ".out";
	}
	public static void main(String[] args) throws FileNotFoundException {
		
		String root = "data/Q2013";
		
		// Test
		Name(TYPE+"-test");
		// Small
//		Name(TYPE+"-small-practice");
		// Large
//		Name(TYPE+"-large-practice");
		
//		Name(TYPE+"--small-1-attempt0");
		
		Scanner in = new Scanner(new File(root, inputFile));
		PrintWriter out = new PrintWriter(new File(root, outputFile));
		
		int T = in.nextInt();
		
		for(int i=0;i<T;i++){
			
			int K = in.nextInt();// number of keys
//			int N = in.nextInt();// number of chests
			
			int[] keys = new int[K];
			for(int j=0;j<K;j++){
				keys[j] = in.nextInt();
			}
			
			
			
			
			out.print("Case #"+(i+1)+": ");
			
		}
		
		in.close();
		out.close();

	}

}
