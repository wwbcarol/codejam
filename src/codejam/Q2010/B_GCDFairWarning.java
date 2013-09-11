package codejam.Q2010;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class B_GCDFairWarning {
public static void main(String[] args) throws FileNotFoundException {

		String root = "data/Q2010";
		
		// Test
		
//		String inputFile = "B-in.txt";
//		String outputFile = "B-out.txt";
		
		// Small
		
//		String inputFile = "B-small-practice.in";
//		String outputFile = "B-small-practice.out";
		
		// Large
		
		String inputFile = "B-large-practice.in";
		String outputFile = "B-large-practice.out";
		
		Scanner in = new Scanner(new File(root, inputFile));
		PrintWriter out = new PrintWriter(new File(root, outputFile));

		int C = in.nextInt();
		
		for(int i=0;i<C;i++){
			
			int N = in.nextInt();
			
			BigInteger[] nums = new BigInteger[N]; 
			
			for(int j=0;j<N;j++){
				nums[j] = in.nextBigInteger();
			}
			
			Arrays.sort(nums);
			
			BigInteger curD = nums[1].subtract(nums[0]);
			for(int j=0;j<N-1;j++){
				curD = nums[j+1].subtract(nums[j]).gcd(curD);
			}
			
			
//			System.out.println(curD.subtract(nums[0].mod(curD)).mod(curD));
		
			
			
			out.println("Case #"+(i+1)+": "+curD.subtract(nums[0].mod(curD)).mod(curD));
			
		}
		
		in.close();
		out.close();

	}
}
