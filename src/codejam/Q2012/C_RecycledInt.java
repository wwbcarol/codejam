package codejam.Q2012;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class C_RecycledInt {

	public static void main(String[] args) throws FileNotFoundException {
		
		String root = "data/Q2012";
		
		// Test
		
		String inputFile = "C-in.txt";
		String outputFile = "C-out.txt";
		
		// Small
		
//		String inputFile = "C-small-practice.in";
//		String outputFile = "C-small-practice.out";
		
		
		// Large
		
//		String inputFile = "C-large-practice.in";
//		String outputFile = "C-large-practice.out";
		
		Scanner in = new Scanner(new File(root, inputFile));
		PrintWriter out = new PrintWriter(new File(root, outputFile));
		
		int T = in.nextInt();
		
		for(int i=0;i<T;i++){
			
			int A = in.nextInt();
			int B = in.nextInt();
			
			for(int j=A;j<B;j++){
				
				String s = Integer.toString(j);
				StringBuffer c = new StringBuffer();
				
				int start = 0;
				
//				while(<=s.length()){
//					
//					
//					
//					
//					System.out.println(s.charAt(index));
//				}
				
			}
			
			
			
			out.print("Case #"+(i+1)+": ");
			
		}
		
		in.close();
		out.close();

	}

}
