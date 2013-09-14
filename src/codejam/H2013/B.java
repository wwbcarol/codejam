package codejam.H2013;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class B {

	public static void main(String[] args) throws FileNotFoundException {
		
		String root = "data/H2013";
		
		// Test
		
		String inputFile = "B-in.txt";
		String outputFile = "B-out.txt";
		
		// Small
		
//		String inputFile = "B-small-attempt2.in";
//		String outputFile = "B-small-attempt2.out";
		
		
		// Large
		
//		String inputFile = "B-large-practice.in";
//		String outputFile = "B-large-practice.out";
		
		Scanner in = new Scanner(new File(root, inputFile));
		PrintWriter out = new PrintWriter(new File(root, outputFile));
		
		int T = in.nextInt();
		
		for(int i=0;i<T;i++){
			
			int V = in.nextInt();
			int D = in.nextInt();
			
			double tmp = (98*D)/(10.0*V*V);
			
			double re = Math.toDegrees(Math.asin(tmp));
			
			out.print("Case #"+(i+1)+": ");
			out.printf("%.7f\n", 0.5*re);
			
		}
		
		in.close();
		out.close();

	}

}
