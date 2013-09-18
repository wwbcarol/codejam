package codejam.Q2013;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import util.U;

public class C_NOTFINISHED {

	public static void main(String[] args) throws FileNotFoundException {
		
		String root = "data/Q2013";
		
		// Test
		
//		String inputFile = "C-in.txt";
//		String outputFile = "C-out.txt";
		
		// Small
		
//		String inputFile = "C-small-practice.in";
//		String outputFile = "C-small-practice.out";
		
		
		// Large
		
//		String inputFile = "C-large-practice-1.in";
//		String outputFile = "C-large-practice-1.out";
		

		
		String inputFile = "C-large-practice-2.in";
		String outputFile = "C-large-practice-2.out";
		
		Scanner in = new Scanner(new File(root, inputFile));
		PrintWriter out = new PrintWriter(new File(root, outputFile));
		
		int T = in.nextInt();
		
		ArrayList<Double> list = new ArrayList<Double>();
		double maxValue = 1.0E50;
		
		int c = 0;
		for(double i=1;i<=maxValue;i++){

			
			if(!isBitSmall(i)){
				
			}else{
				if(isPalindromes(i) && isPalindromes(i*i)){
					list.add(i);
					c++;
					System.out.println(i);
				}
			}
		}
		System.out.println("total number:" + c);
		for(int i=0;i<T;i++){
			
			U.PI(i);
			Double A = in.nextDouble();
			Double B = in.nextDouble();
			
			double a = Math.sqrt(A);
			double b = Math.sqrt(B);
			
			int count = 0;
			
			double min = Math.floor(a) == a?a:Math.floor(a) + 1;
			double max = Math.floor(b);
			for(int j = 0;j<list.size();j++){
				if(list.get(j)<=max&&list.get(j)>=min)
					count++;
			}
			
			System.out.println(count);
			
			out.println("Case #"+(i+1)+": "+count);
			
		}
		
		in.close();
		out.close();

	}
	
private static boolean isBitSmall(double i) {
		int bitsum = 0 ;
		while(i>1){
			if(bitsum>9||Math.floor(i%10)>3){
				return false;
			}
			else{
				bitsum += Math.floor(i%10)*Math.floor(i%10);
				i = Math.floor(i/10);
			}
		}
		return true;
	}

public static boolean isPalindromes(double n) {
	
	double index = 10.0;
	while((n / index)>1){
		index *= 10;
	}
	
	index /= 10;
	
	while(n>=1){
		
		if(Math.floor(n%10) != Math.floor(n/index))
			return false;
		else{
			n = n - index*(Math.floor(n/index));
			n = Math.floor(n / 10);
			index /= 100;
		}
	}
	
	return true;
}

}
