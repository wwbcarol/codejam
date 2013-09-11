package templete;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class A {

	public static void main(String[] args) throws FileNotFoundException {
		
		// TODO data path
		String root = "data/Q2009";
		
		// Test
		
		String inputFile = "A-in.txt";
		String outputFile = "A-out.txt";
		
		// Small
		
//		String inputFile = "A-small-practice.in";
//		String outputFile = "A-small-practice.out";
		
		
		// Large
		
//		String inputFile = "A-large-practice.in";
//		String outputFile = "A-large-practice.out";
		
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
