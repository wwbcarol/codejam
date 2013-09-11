package codejam.Q2009;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class C {
	
	public static void main(String[] args) throws FileNotFoundException {
		String root = "data/Q2009";
		
		// Test
		
//		String inputFile = "C-in.txt";
//		String outputFile = "C-out.txt";
		
		// Small
		
//		String inputFile = "C-small-practice.in";
//		String outputFile = "C-small-practice.out";
		
		// Large
		
		String inputFile = "C-large-practice.in";
		String outputFile = "C-large-practice.out";
		
		Scanner in = new Scanner(new File(root, inputFile));
		PrintWriter out = new PrintWriter(new File(root, outputFile));
		
		int N = in.nextInt();

		in.nextLine();
		
		String subStr = "welcome to code jam";
		
		for(int i=0;i<N;i++){
			String str = in.nextLine();
			
			int[][] dp = new int[str.length()][subStr.length()];
			
			int count0 = 0;
			for(int j=0;j<str.length();j++){
				
				if(str.charAt(j) == subStr.charAt(0)){
					++count0;
				}
				
				dp[j][0] = count0;
			}
			
			for(int k=1;k<subStr.length();k++){
				dp[0][k] = 0;
			}
			
			for(int j=1;j<str.length();j++){
				for(int k=1;k<subStr.length();k++){
				
					if(str.charAt(j)==subStr.charAt(k)){
						dp[j][k] = (dp[j-1][k]+dp[j][k-1])%10000;
					}else{
						dp[j][k] = dp[j-1][k];
					}
					
				
				}
				
			}
			
			out.print("Case #"+(i+1)+": ");
			out.format("%04d%n", dp[str.length() - 1][subStr.length()-1]);
		}
		
		in.close();
		out.close();

	}

}
