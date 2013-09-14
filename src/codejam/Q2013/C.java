package codejam.Q2013;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class C {

	public static void main(String[] args) throws FileNotFoundException {
		
		// TODO data path
		String root = "data/Q2009";
		
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
		
		// TODO N cases
		int N = in.nextInt();
		
		for(int i=0;i<N;i++){
			
			
			
			
			out.print("Case #"+(i+1)+": ");
			
		}
		
		in.close();
		out.close();

	}

}
