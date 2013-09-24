package codejam.Q2010;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class A_SnapperChain {
	
	public static void main(String[] args) throws FileNotFoundException {
		String root = "data/Q2010";
		
		// Test
		
//		String inputFile = "A-in.txt";
//		String outputFile = "A-out.txt";
		
		// Small
		
//		String inputFile = "A-small-practice.in";
//		String outputFile = "A-small-practice.out";
		
		
		// Large
		
		String inputFile = "A-large-practice.in";
		String outputFile = "A-large-practice.out";
		
		Scanner in = new Scanner(new File(root, inputFile));
		PrintWriter out = new PrintWriter(new File(root, outputFile));
		
		int T = in.nextInt();//T case
		int N,K;
		for(int i=0;i<T;i++){
			N = in.nextInt();
			K = in.nextInt();
			
			if((((1 << N) - 1) & K) == ((1 << N) - 1))
				out.println("Case #"+(i+1)+": ON");
			else
				out.println("Case #"+(i+1)+": OFF");
			
//			BitDisplay.display(N);

		}
		
		in.close();
		out.close();
		
		
		
	}
	
	

}
