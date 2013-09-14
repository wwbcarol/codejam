package codejam.Q2013;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class B {

	public static void main(String[] args) throws FileNotFoundException {
		
		// TODO data path
		String root = "data/Q2009";
		
		// Test
		
		String inputFile = "B-in.txt";
		String outputFile = "B-out.txt";
		
		// Small
		
//		String inputFile = "B-small-practice.in";
//		String outputFile = "B-small-practice.out";
		
		
		// Large
		
//		String inputFile = "B-large-practice.in";
//		String outputFile = "B-large-practice.out";
		
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
