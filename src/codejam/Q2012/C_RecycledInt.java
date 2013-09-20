package codejam.Q2012;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class C_RecycledInt {

	public static void main(String[] args) throws FileNotFoundException {
		
		String root = "data/Q2012";
		
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
		
		int T = in.nextInt();
		
		for(int i=0;i<T;i++){
			
			int A = in.nextInt();
			int B = in.nextInt();
			out.println("Case #"+(i+1)+": "+solve(A, B));
			
		}
		
		in.close();
		out.close();

	}
	
	public static int solve(int A, int B){
		int power = 1, temp = A;
		while(temp >= 10){
			power *= 10;
			temp /= 10;
		}
		
		int result = 0;
		for(int n=A; n<=B; n++){
			temp = n;
			while(true){
				temp = (temp/10) +((temp%10)*power);
				if(temp == n)
					break;
				if(temp>n && temp<=B)
					result++;
			}
		}
		
		return result;
	}

}
