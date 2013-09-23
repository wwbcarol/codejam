package codejam.F2013;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

import util.U;

public class C {
	
	static final String TYPE = "C";
	static String inputFile;
	static String outputFile;

	private static void Name(String s){
		inputFile = s + ".in";
		outputFile = s + ".out";
	}
	public static void main(String[] args) throws FileNotFoundException {
		
		String root = "data/F2013";
		
		// Test
		Name("C-large");
		
		Scanner in = new Scanner(new File(root, inputFile));
		PrintWriter out = new PrintWriter(new File(root, outputFile));
		
		int T = in.nextInt();
		
		for(int i=0;i<T;i++){
			
			int N = in.nextInt();
			int[] num = new int[N];
			ArrayList<Integer> odd = new ArrayList<Integer>();
			ArrayList<Integer> even = new ArrayList<Integer>();
			
			for(int j=0;j<N;j++){
				
				int s = in.nextInt();
				num[j] = s;
				
				if(s%2 == 0){
					even.add(s);
				}else{
					odd.add(s);
				}
				
			}
			
			Integer[] evenSorted = new Integer[even.size()];
			evenSorted = even.toArray(evenSorted);
			Integer[] oddSorted = new Integer[odd.size()];
			oddSorted = odd.toArray(oddSorted);
			Arrays.sort(evenSorted);
			Arrays.sort(oddSorted);
			out.print("Case #"+(i+1)+": ");
			
			int t=0;
			int k=evenSorted.length-1;
			for(int j=0;j<N;j++){
				if(num[j]%2==0){
					out.print(evenSorted[k--]+" ");
				}else{
					out.print(oddSorted[t++]+" ");
				}
			}
			
			out.println("");
			
			
			
		}
		
		in.close();
		out.close();

	}

}
