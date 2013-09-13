package codejam.Q2011;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class D_GoroSort {

	public static void main(String[] args) throws FileNotFoundException {
		
		// TODO data path
		String root = "data/Q2011";
		
		// Test
		
//		String inputFile = "D-in.txt";
//		String outputFile = "D-out.txt";
		
		// Small
		
//		String inputFile = "D-small-practice.in";
//		String outputFile = "D-small-practice.out";
		
		
		// Large
		
		String inputFile = "D-large-practice.in";
		String outputFile = "D-large-practice.out";
		
		Scanner in = new Scanner(new File(root, inputFile));
		PrintWriter out = new PrintWriter(new File(root, outputFile));
		
		// TODO N cases
		int T = in.nextInt();
		
		for(int i=0;i<T;i++){
			
			int N = in.nextInt();
			int[] n = new int[N];
			for(int j=0;j<N;j++){
				n[j] = in.nextInt();
			}
			double count = 0.0;
			for(int j=0;j<N;j++){
				
				if((n[j]-1)!=j){
					count++;
				}
			}
			
			System.out.println(count);
			out.println("Case #"+(i+1)+": "+count);
			
		}
		
		in.close();
		out.close();

	}

}
